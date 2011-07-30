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

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import org.jooq.Attachable;
import org.jooq.Configuration;
import org.jooq.RenderContext;
import org.jooq.SQLDialectNotSupportedException;

/**
 * @author Lukas Eder
 */
class Limit extends AbstractQueryPart {

    /**
     * Generated UID
     */
    private static final long serialVersionUID = 2053741242981425602L;
    private int               offset;
    private int               numberOfRows;

    Limit() {
        offset = 0;
        numberOfRows = Integer.MAX_VALUE;
    }

    @Override
    public final List<Attachable> getAttachables() {
        return Collections.emptyList();
    }

    @Override
    public final void toSQL(RenderContext context) {
        switch (context.getDialect()) {

            // True LIMIT / OFFSET support provided by the following dialects
            // -----------------------------------------------------------------
            case MYSQL: {
                if (context.inline()) {
                    context.sql("limit ")
                           .sql(getOffset())
                           .sql(", ")
                           .sql(getNumberOfRows());
                }
                else {
                    context.sql("limit ?, ?");
                }

                break;
            }

            case H2:       // No break
            case HSQLDB:   // No break
            case POSTGRES: // No break
            case SQLITE: {
                if (context.inline()) {
                    context.sql("limit ")
                           .sql(getNumberOfRows())
                           .sql(" offset ")
                           .sql(getOffset());
                }
                else {
                    context.sql("limit ? offset ?");
                }

                break;
            }

            case DERBY: {
                if (context.inline()) {
                    context.sql("offset ")
                           .sql(getOffset())
                           .sql(" rows fetch next ")
                           .sql(getNumberOfRows())
                           .sql(" rows only");
                }
                else {
                    context.sql("offset ? rows fetch next ? rows only");
                }

                break;
            }

            case INGRES: {

                // INGRES doesn't allow bind variables in the
                // OFFSET m FETCH FIRST n ROWS ONLY clause
                context.sql("offset ")
                       .sql(getOffset())
                       .sql(" fetch first ")
                       .sql(getNumberOfRows())
                       .sql(" rows only");

                break;
            }

            // Only "TOP" support provided by the following dialects.
            // "OFFSET" support is simulated in AbstractResultProviderSelectQuery
            // -----------------------------------------------------------------
            case DB2: {
                if (getOffset() != 0) {
                    throw new SQLDialectNotSupportedException("DB2 does not support offsets in FETCH FIRST ROWS ONLY clause");
                }

                // DB2 doesn't allow bind variables in the
                // FETCH FIRST n ROWS ONLY clause
                context.sql("fetch first ")
                       .sql(getNumberOfRows())
                       .sql(" rows only");

                break;
            }

            case SQLSERVER:
            case SYBASE: {
                if (getOffset() != 0) {
                    throw new SQLDialectNotSupportedException("Offsets in TOP clause not supported");
                }

                // SQL Server and Sybase don't allow bind variables in the TOP n clause
                context.sql("top ").sql(getNumberOfRows());
                break;
            }

            // A default implementation is necessary for hashCode() and toString()
            default: {
                if (context.inline()) {
                    context.sql("limit ")
                           .sql(getNumberOfRows())
                           .sql(" offset ")
                           .sql(getOffset());
                }
                else {
                    context.sql("limit ? offset ?");
                }

                break;
            }
        }
    }

    @Override
    public final int bindReference(Configuration configuration, PreparedStatement stmt, int initialIndex) throws SQLException {
        int result = initialIndex;

        switch (configuration.getDialect()) {
            // True LIMIT / OFFSET support provided by the following dialects
            // -----------------------------------------------------------------
            case MYSQL:    // No break
            case DERBY:
                result = internal(val(getOffset())).bindReference(configuration, stmt, result);
                result = internal(val(getNumberOfRows())).bindReference(configuration, stmt, result);
                break;

            case HSQLDB:   // No break
            case H2:       // No break
            case POSTGRES: // No break
            case SQLITE:
                result = internal(val(getNumberOfRows())).bindReference(configuration, stmt, result);
                result = internal(val(getOffset())).bindReference(configuration, stmt, result);
                break;

            // These dialects don't allow bind variables in their TOP clauses
            // -----------------------------------------------------------------
            case DB2:
            case SQLSERVER:
            case SYBASE:

                // TOP clauses without bind variables
                if (offset == 0) {
                    break;
                }

                // With simulated OFFSETs, no break
                else {
                }

            // Oracle knows no TOP clause, limits are always bound
            // Also, with simulated OFFSETs, the previous dialects fall through
            // -----------------------------------------------------------------
            case ORACLE:
                result = internal(val(getLowerRownum())).bindReference(configuration, stmt, result);
                result = internal(val(getUpperRownum())).bindReference(configuration, stmt, result);
                break;
        }

        return result;
    }

    /**
     * The limit's OFFSET (first record to be returned)
     */
    public final int getOffset() {
        return offset;
    }

    /**
     * The limit's LIMIT (number of records to be returned)
     */
    public final int getNumberOfRows() {
        return numberOfRows;
    }

    /**
     * The lower bound, such that ROW_NUMBER() >= getLowerRownum()
     */
    public final int getLowerRownum() {
        return offset + 1;
    }

    /**
     * The upper bound, such that ROW_NUMBER() < getUpperRownum()
     */
    public final int getUpperRownum() {
        return offset + 1 + numberOfRows;
    }

    /**
     * Whether this LIMIT clause is applicable. If <code>false</code>, then no
     * LIMIT clause should be rendered.
     */
    public final boolean isApplicable() {
        return getOffset() != 0 || getNumberOfRows() != Integer.MAX_VALUE;
    }

    void setOffset(int offset) {
        this.offset = offset;
    }

    void setNumberOfRows(int numberOfRows) {
        this.numberOfRows = numberOfRows;
    }
}
