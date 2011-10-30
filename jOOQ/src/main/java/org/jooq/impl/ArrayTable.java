/**
 * Copyright (c) 2009-2011, Lukas Eder, lukas.eder@gmail.com
 * All rights reserved.
 *
 * This software is licensed to you under the Apache License, Version 2.0
 * (the "License"); You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * . Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 *
 * . Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * . Neither the name "jOOQ" nor the names of its contributors may be
 *   used to endorse or promote products derived from this software without
 *   specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package org.jooq.impl;

import static org.jooq.impl.Factory.field;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import org.jooq.Attachable;
import org.jooq.BindContext;
import org.jooq.Field;
import org.jooq.Record;
import org.jooq.RenderContext;
import org.jooq.SQLDialectNotSupportedException;
import org.jooq.Table;
import org.jooq.util.h2.H2DataType;

/**
 * @author Lukas Eder
 */
class ArrayTable<R extends Record> extends AbstractTable<R> {

    /**
     * Generated UID
     */
    private static final long    serialVersionUID = 2380426377794577041L;

    private final Field<?>       array;
    private final FieldList      field;
    private final String         alias;

    ArrayTable(Field<?> array) {
        this(array, "array_table(COLUMN_VALUE)");
    }

    ArrayTable(Field<?> array, String alias) {
        super("array_table");

        Class<?> arrayType;
        if (array.getDataType().getType().isArray()) {
            arrayType = array.getDataType().getType().getComponentType();
        }
        else {
            // [#523] TODO use ArrayRecord meta data instead
            arrayType = Object.class;
        }

        this.array = array;
        this.alias = alias;
        this.field = new FieldList();
        this.field.add(field("COLUMN_VALUE", arrayType));
    }

    @SuppressWarnings({ "unchecked", "deprecation" })
    @Override
    public final Class<? extends R> getRecordType() {
        return (Class<? extends R>) RecordImpl.class;
    }

    @Override
    public final Table<R> as(String as) {
        return new TableAlias<R>(new ArrayTable<R>(array, ""), as);
    }

    @Override
    public final void toSQL(RenderContext context) {
        switch (context.getDialect()) {
            case ORACLE: {
                context.sql("table(").sql(array).sql(")");
                break;
            }

            case H2: {
                context.sql("table(COLUMN_VALUE ");

                // If the array type is unknown (e.g. because it's returned from a stored function
                // Then the best choice for arbitrary types is varchar
                if (array.getDataType().getType() == Object[].class) {
                    context.sql(H2DataType.VARCHAR.getTypeName());
                }
                else {
                    context.sql(array.getDataType().getTypeName());
                }

                context.sql(" = ").sql(array).sql(")");
                break;
            }

            // [#756] These dialects need special care when aliasing unnested
            // arrays
            case HSQLDB:
            case POSTGRES: {
                context.sql("unnest(").sql(array).sql(")");

                if (!StringUtils.isBlank(alias)) {
                    context.sql(" as ").sql(alias);
                }

                break;
            }

            default:
                throw new SQLDialectNotSupportedException("ARRAY TABLE is not supported for " + context.getDialect());
        }
    }

    @Override
    public final void bind(BindContext context) throws SQLException {
        switch (context.getDialect()) {
            case ORACLE:
            case H2:
            case HSQLDB:
            case POSTGRES:
                context.bind(array);
                break;

            default:
                throw new SQLDialectNotSupportedException("ARRAY TABLE is not supported for " + context.getDialect());
        }
    }

    @Override
    protected final FieldList getFieldList() {
        return field;
    }

    @Override
    protected final List<Attachable> getAttachables0() {
        return Collections.emptyList();
    }
}
