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
package org.jooq;

/**
 * The render context is used for rendering {@link QueryPart}'s to SQL. A new
 * render context is instanciated every time a <code>QueryPart</code> is
 * rendered (or when it renders its component <code>QueryPart</code>'s).
 * <p>
 * This interface is for JOOQ INTERNAL USE only. Do not reference directly
 *
 * @author Lukas Eder
 */
public interface RenderContext extends Configuration {

    /**
     * Render the context's underlying SQL statement
     */
    String render();

    /**
     * Render a query part in a new context derived from this one. The rendered
     * SQL will not be appended to this context.
     */
    String render(QueryPart part);

    /**
     * Append some SQL to the context's contained {@link StringBuilder}
     */
    RenderContext sql(String sql);

    /**
     * Append some SQL to the context's contained {@link StringBuilder}
     */
    RenderContext sql(char sql);

    /**
     * Append some SQL to the context's contained {@link StringBuilder}
     */
    RenderContext sql(int sql);

    /**
     * Append some (quoted) literal to the context's contained {@link StringBuilder}
     */
    RenderContext literal(String literal);

    /**
     * Recurse rendering
     */
    RenderContext sql(QueryPart part);

    /**
     * Whether bind variables should be inlined, rather than rendered as
     * <code>'?'</code>
     */
    boolean inline();

    /**
     * Set the new context value for {@link #inline()}
     */
    RenderContext inline(boolean inline);

    /**
     * Whether the current context is rendering a SQL field declaration (e.g. a
     * {@link Field} in the <code>SELECT</code> clause of the query).
     */
    boolean declareFields();

    /**
     * Set the new context value for {@link #declareFields()}
     */
    RenderContext declareFields(boolean declareFields);

    /**
     * Whether the current context is rendering a SQL table declaration (e.g. a
     * {@link Table} in the <code>FROM</code> or <code>JOIN</code> clause of the
     * query).
     */
    boolean declareTables();

    /**
     * Set the new context value for {@link #declareTables()}
     */
    RenderContext declareTables(boolean declareTables);
}
