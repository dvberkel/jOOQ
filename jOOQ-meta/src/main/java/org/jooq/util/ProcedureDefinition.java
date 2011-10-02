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

package org.jooq.util;

import java.util.List;

/**
 * An interface defining a stored procedure in a database.
 *
 * @author Lukas Eder
 * @deprecated - 1.6.8 [#852] - The stored procedure / stored function
 *             distinction has been reviewed in jOOQ. The 12 currently supported
 *             RDBMS have such a distinct idea of what is a procedure and what
 *             is a function that it makes no longer sense to distinguish them
 *             generally, in jOOQ. See <a
 *             href="https://sourceforge.net/apps/trac/jooq/ticket/852"
 *             >https://sourceforge.net/apps/trac/jooq/ticket/852</a> for more
 *             details.
 */
@Deprecated
public interface ProcedureDefinition extends CallableDefinition {

    /**
     * A list of IN or INOUT parameter column definitions
     */
    List<ParameterDefinition> getInParameters();

    /**
     * A list of OUT or INOUT parameter column definitions
     */
    List<ParameterDefinition> getOutParameters();

    /**
     * The return value if this is actually a stored function with OUT
     * parameters
     */
    ParameterDefinition getReturnValue();

    /**
     * A list of all IN, OUT, and INOUT parameter column definitions
     */
    List<ParameterDefinition> getAllParameters();
}
