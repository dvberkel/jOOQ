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

import static org.jooq.impl.Factory.exp;
import static org.jooq.impl.Factory.function;
import static org.jooq.impl.Factory.ln;

import java.math.BigDecimal;

import org.jooq.Configuration;
import org.jooq.Field;

/**
 * @author Lukas Eder
 */
class Power extends AbstractFunction<BigDecimal> {

    /**
     * Generated UID
     */
    private static final long             serialVersionUID = -7273879239726265322L;

    private final Field<? extends Number> arg1;
    private final Field<? extends Number> arg2;

    Power(Field<? extends Number> arg1, Field<? extends Number> arg2) {
        super("ceil", SQLDataType.NUMERIC, arg1, arg2);

        this.arg1 = arg1;
        this.arg2 = arg2;
    }

    @Override
    final Field<BigDecimal> getFunction0(Configuration configuration) {
        switch (configuration.getDialect()) {
            case DERBY:
            case SQLITE:
                return exp(ln(arg1).mul(arg2));

            default:
                return function("power", SQLDataType.NUMERIC, getArguments());
        }
    }
}
