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
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.jooq.Attachable;
import org.jooq.Condition;
import org.jooq.Configuration;
import org.jooq.Field;
import org.jooq.Operator;
import org.jooq.RenderContext;
import org.jooq.Select;
import org.jooq.Table;
import org.jooq.TableRecord;
import org.jooq.UpdateConditionStep;
import org.jooq.UpdateQuery;
import org.jooq.UpdateSetMoreStep;
import org.jooq.exception.DetachedException;

/**
 * A wrapper for an {@link UpdateQuery}
 *
 * @author Lukas Eder
 */
final class UpdateImpl<R extends TableRecord<R>> extends AbstractQueryPart implements

    // Cascading interface implementations for Update behaviour
    UpdateSetMoreStep,
    UpdateConditionStep {

    /**
     * Generated UID
     */
    private static final long    serialVersionUID = -2444876472650065331L;

    private final UpdateQuery<R> delegate;

    UpdateImpl(Configuration configuration, Table<R> table) {
        delegate = new UpdateQueryImpl<R>(configuration, table);
    }

    @Override
    public final int execute() throws SQLException, DetachedException {
        return delegate.execute();
    }

    @Override
    public final void toSQL(RenderContext context) {
        context.sql(delegate);
    }

    @Override
    public final int bindReference(Configuration configuration, PreparedStatement stmt, int initialIndex) throws SQLException {
        return internal(delegate).bindReference(configuration, stmt, initialIndex);
    }

    @Override
    public final List<Attachable> getAttachables() {
        return getAttachables(delegate);
    }

    @Override
    public final UpdateSetMoreStep set(Field<?> field, Object value) {
        delegate.addValue(field, value);
        return this;
    }

    @Override
    public final UpdateSetMoreStep set(Field<?> field, Field<?> value) {
        delegate.addValue(field, value);
        return this;
    }

    @Override
    public final UpdateSetMoreStep set(Map<? extends Field<?>, ?> map) {
        delegate.addValues(map);
        return this;
    }

    @Override
    public final UpdateImpl<R> where(Condition... conditions) {
        delegate.addConditions(conditions);
        return this;
    }

    @Override
    public final UpdateImpl<R> where(Collection<Condition> conditions) {
        delegate.addConditions(conditions);
        return this;
    }

    @Override
    public final UpdateImpl<R> where(String sql) {
        return where(create().condition(sql));
    }

    @Override
    public final UpdateImpl<R> where(String sql, Object... bindings) {
        return where(create().condition(sql, bindings));
    }

    @Override
    public final UpdateImpl<R> whereExists(Select<?> select) {
        return andExists(select);
    }

    @Override
    public final UpdateImpl<R> whereNotExists(Select<?> select) {
        return andNotExists(select);
    }

    @Override
    public final UpdateImpl<R> and(Condition condition) {
        delegate.addConditions(condition);
        return this;
    }

    @Override
    public final UpdateImpl<R> and(String sql) {
        return and(create().condition(sql));
    }

    @Override
    public final UpdateImpl<R> and(String sql, Object... bindings) {
        return and(create().condition(sql, bindings));
    }

    @Override
    public final UpdateImpl<R> andNot(Condition condition) {
        return and(condition.not());
    }

    @Override
    public final UpdateImpl<R> andExists(Select<?> select) {
        return and(create().exists(select));
    }

    @Override
    public final UpdateImpl<R> andNotExists(Select<?> select) {
        return and(create().notExists(select));
    }

    @Override
    public final UpdateImpl<R> or(Condition condition) {
        delegate.addConditions(Operator.OR, condition);
        return this;
    }

    @Override
    public final UpdateImpl<R> or(String sql) {
        return or(create().condition(sql));
    }

    @Override
    public final UpdateImpl<R> or(String sql, Object... bindings) {
        return or(create().condition(sql, bindings));
    }

    @Override
    public final UpdateImpl<R> orNot(Condition condition) {
        return or(condition.not());
    }

    @Override
    public final UpdateImpl<R> orExists(Select<?> select) {
        return or(create().exists(select));
    }

    @Override
    public final UpdateImpl<R> orNotExists(Select<?> select) {
        return or(create().notExists(select));
    }
}
