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

package org.jooq.test;

import static junit.framework.Assert.assertEquals;
import static org.jooq.JoinType.LEFT_OUTER_JOIN;
import static org.jooq.test.Data.FIELD_DATE1;
import static org.jooq.test.Data.FIELD_ID1;
import static org.jooq.test.Data.FIELD_ID2;
import static org.jooq.test.Data.FIELD_ID3;
import static org.jooq.test.Data.FIELD_NAME1;
import static org.jooq.test.Data.TABLE1;
import static org.jooq.test.Data.TABLE2;
import static org.jooq.test.Data.TABLE3;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jooq.BindContext;
import org.jooq.Case;
import org.jooq.CaseConditionStep;
import org.jooq.CaseValueStep;
import org.jooq.CaseWhenStep;
import org.jooq.Condition;
import org.jooq.DeleteQuery;
import org.jooq.Field;
import org.jooq.Insert;
import org.jooq.InsertQuery;
import org.jooq.Merge;
import org.jooq.Operator;
import org.jooq.RenderContext;
import org.jooq.Select;
import org.jooq.SelectFinalStep;
import org.jooq.SelectQuery;
import org.jooq.SimpleSelectQuery;
import org.jooq.Table;
import org.jooq.Truncate;
import org.jooq.UpdateQuery;
import org.jooq.impl.CustomCondition;
import org.jooq.impl.CustomField;
import org.jooq.impl.Factory;
import org.jooq.test.Data.Table1Record;
import org.jooq.util.oracle.OracleDataType;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * A test suite for basic jOOQ functionality
 *
 * @author Lukas Eder
 */
public class jOOQTest {

    private Mockery context;
    private PreparedStatement statement;
    private Factory create;

    @BeforeClass
    public static void init() throws Exception {

        // [#650] Due to a lacking data type registry, the types need to be
        // loaded statically
        Class.forName(OracleDataType.class.getName());
    }

    @Before
    public void setUp() throws Exception {
        context = new Mockery();
        statement = context.mock(PreparedStatement.class);
        create = new Factory((Connection) null, Data.DIALECT);
    }

    @After
    public void tearDown() throws Exception {
        statement = null;
        context = null;
    }

    protected final BindContext b_ref() {
        return create.bindContext(statement);
    }

    protected final BindContext b_dec() {
        return b_ref().declareFields(true).declareTables(true);
    }

    protected final BindContext b_decF() {
        return b_ref().declareFields(true);
    }

    protected final BindContext b_decT() {
        return b_ref().declareTables(true);
    }

    protected final RenderContext r_ref() {
        return create.renderContext();
    }

    protected final RenderContext r_dec() {
        return r_ref().declareFields(true).declareTables(true);
    }

    protected final RenderContext r_decF() {
        return r_ref().declareFields(true);
    }

    protected final RenderContext r_decT() {
        return r_ref().declareTables(true);
    }

    protected final RenderContext r_refI() {
        return r_ref().inline(true);
    }

    protected final RenderContext r_decI() {
        return r_dec().inline(true);
    }

    protected final RenderContext r_decIF() {
        return r_decF().inline(true);
    }

    protected final RenderContext r_decIT() {
        return r_decT().inline(true);
    }

    @Test
    public final void testTruncate() throws Exception {
        Truncate t = create.truncate(TABLE1);

        assertEquals("truncate table \"TABLE1\"", r_dec().render(t));
        assertEquals("truncate table \"TABLE1\"", r_ref().render(t));
    }

    @Test
    public final void testAliasing() throws Exception {
        assertEquals("\"TABLE1\"", r_decT().render(TABLE1));
        assertEquals("\"TABLE1\"", r_decF().render(TABLE1));
        assertEquals("\"TABLE1\"", r_ref().render(TABLE1));

        assertEquals("\"TABLE1\" \"t1\"", r_decT().render(TABLE1.as("t1")));
        assertEquals("\"t1\"",            r_decF().render(TABLE1.as("t1")));
        assertEquals("\"t1\"",            r_ref().render(TABLE1.as("t1")));

        assertEquals("\"TABLE1\".\"ID1\"", r_decF().render(TABLE1.getField(FIELD_ID1)));
        assertEquals("\"TABLE1\".\"ID1\"", r_decT().render(TABLE1.getField(FIELD_ID1)));
        assertEquals("\"TABLE1\".\"ID1\"", r_ref().render(TABLE1.getField(FIELD_ID1)));

        assertEquals("\"TABLE1\".\"ID1\" \"f1\"", r_decF().render(TABLE1.getField(FIELD_ID1).as("f1")));
        assertEquals("\"f1\"",                    r_decT().render(TABLE1.getField(FIELD_ID1).as("f1")));
        assertEquals("\"f1\"",                    r_ref().render(TABLE1.getField(FIELD_ID1).as("f1")));

        assertEquals("\"t1\".\"ID1\"", r_decF().render(TABLE1.as("t1").getField(FIELD_ID1)));
        assertEquals("\"t1\".\"ID1\"", r_decT().render(TABLE1.as("t1").getField(FIELD_ID1)));
        assertEquals("\"t1\".\"ID1\"", r_ref().render(TABLE1.as("t1").getField(FIELD_ID1)));

        assertEquals("\"t1\".\"ID1\" \"f1\"", r_decF().render(TABLE1.as("t1").getField(FIELD_ID1).as("f1")));
        assertEquals("\"f1\"",                r_decT().render(TABLE1.as("t1").getField(FIELD_ID1).as("f1")));
        assertEquals("\"f1\"",                r_ref().render(TABLE1.as("t1").getField(FIELD_ID1).as("f1")));

        context.checking(new Expectations() {{
            oneOf(statement).setInt(1, 2);
            oneOf(statement).setInt(1, 4);
        }});

        int f1 = b_ref().bind(create.val(1).as("c1")).peekIndex();
        int f2 = b_decF().bind(create.val(2).as("c2")).peekIndex();
        int f3 = b_decT().bind(create.val(2).as("c2")).peekIndex();
        int t1 = b_ref().bind(create.select(create.val(3)).asTable("t1")).peekIndex();
        int t2 = b_decF().bind(create.select(create.val(4)).asTable("t2")).peekIndex();
        int t3 = b_decT().bind(create.select(create.val(4)).asTable("t2")).peekIndex();

        assertEquals(1, f1);
        assertEquals(2, f2);
        assertEquals(1, f3);

        assertEquals(1, t1);
        assertEquals(1, t2);
        assertEquals(2, t3);

        context.assertIsSatisfied();
    }

    @Test
    public final void testMultipleCombinedCondition() throws Exception {
        Condition c1 = FIELD_ID1.equal(10);
        Condition c2 = FIELD_ID2.equal(20);
        Condition c3 = FIELD_ID1.equal(30);
        Condition c4 = FIELD_ID2.equal(40);

        Condition c = c1.and(c2).or(c3.and(c4));
        assertEquals("((\"TABLE1\".\"ID1\" = 10 and \"TABLE2\".\"ID2\" = 20) or (\"TABLE1\".\"ID1\" = 30 and \"TABLE2\".\"ID2\" = 40))", r_refI().render(c));
        assertEquals("((\"TABLE1\".\"ID1\" = ? and \"TABLE2\".\"ID2\" = ?) or (\"TABLE1\".\"ID1\" = ? and \"TABLE2\".\"ID2\" = ?))", r_ref().render(c));

        c = c1.and(c2).or(c3).and(c4);
        assertEquals("(((\"TABLE1\".\"ID1\" = 10 and \"TABLE2\".\"ID2\" = 20) or \"TABLE1\".\"ID1\" = 30) and \"TABLE2\".\"ID2\" = 40)", r_refI().render(c));
        assertEquals("(((\"TABLE1\".\"ID1\" = ? and \"TABLE2\".\"ID2\" = ?) or \"TABLE1\".\"ID1\" = ?) and \"TABLE2\".\"ID2\" = ?)", r_ref().render(c));

        c = c1.and(c2).and(c3).or(c4);
        assertEquals("((\"TABLE1\".\"ID1\" = 10 and \"TABLE2\".\"ID2\" = 20 and \"TABLE1\".\"ID1\" = 30) or \"TABLE2\".\"ID2\" = 40)", r_refI().render(c));
        assertEquals("((\"TABLE1\".\"ID1\" = ? and \"TABLE2\".\"ID2\" = ? and \"TABLE1\".\"ID1\" = ?) or \"TABLE2\".\"ID2\" = ?)", r_ref().render(c));

        c = c1.and(c2).and(c3).and(c4);
        assertEquals("(\"TABLE1\".\"ID1\" = 10 and \"TABLE2\".\"ID2\" = 20 and \"TABLE1\".\"ID1\" = 30 and \"TABLE2\".\"ID2\" = 40)", r_refI().render(c));
        assertEquals("(\"TABLE1\".\"ID1\" = ? and \"TABLE2\".\"ID2\" = ? and \"TABLE1\".\"ID1\" = ? and \"TABLE2\".\"ID2\" = ?)", r_ref().render(c));

        context.checking(new Expectations() {{
            oneOf(statement).setInt(1, 10);
            oneOf(statement).setInt(2, 20);
            oneOf(statement).setInt(3, 30);
            oneOf(statement).setInt(4, 40);
        }});

        int i = b_ref().bind(c).peekIndex();
        assertEquals(5, i);

        context.assertIsSatisfied();
    }

    @Test
    public final void testBetweenCondition() throws Exception {
        Condition c = FIELD_ID1.between(1, 10);
        assertEquals("\"TABLE1\".\"ID1\" between 1 and 10", r_refI().render(c));
        assertEquals("\"TABLE1\".\"ID1\" between ? and ?", r_ref().render(c));

        context.checking(new Expectations() {{
            oneOf(statement).setInt(1, 1);
            oneOf(statement).setInt(2, 10);
        }});

        int i = b_ref().bind(c).peekIndex();
        assertEquals(3, i);

        context.assertIsSatisfied();
    }

    @Test
    public final void testInCondition() throws Exception {
        Condition c = FIELD_ID1.in(new Integer[0]);
        assertEquals(create.falseCondition(), c);

        c = FIELD_ID1.notIn(new Integer[0]);
        assertEquals(create.trueCondition(), c);

        c = FIELD_ID1.in(1, 10);
        assertEquals("\"TABLE1\".\"ID1\" in (1, 10)", r_refI().render(c));
        assertEquals("\"TABLE1\".\"ID1\" in (?, ?)", r_ref().render(c));

        context.checking(new Expectations() {{
            oneOf(statement).setInt(1, 1);
            oneOf(statement).setInt(2, 10);
        }});

        int i = b_ref().bind(c).peekIndex();
        assertEquals(3, i);

        context.assertIsSatisfied();
    }

    @Test
    public final void testInSelectCondition() throws Exception {
        Condition c = FIELD_ID1.in(create.selectFrom(TABLE1).where(FIELD_NAME1.equal("x")));
        assertEquals("\"TABLE1\".\"ID1\" in (select \"TABLE1\".\"ID1\", \"TABLE1\".\"NAME1\", \"TABLE1\".\"DATE1\" from \"TABLE1\" where \"TABLE1\".\"NAME1\" = 'x')", r_refI().render(c));
        assertEquals("\"TABLE1\".\"ID1\" in (select \"TABLE1\".\"ID1\", \"TABLE1\".\"NAME1\", \"TABLE1\".\"DATE1\" from \"TABLE1\" where \"TABLE1\".\"NAME1\" = ?)", r_ref().render(c));

        c = FIELD_ID1.notIn(create.selectFrom(TABLE1).where(FIELD_NAME1.equal("x")));
        assertEquals("\"TABLE1\".\"ID1\" not in (select \"TABLE1\".\"ID1\", \"TABLE1\".\"NAME1\", \"TABLE1\".\"DATE1\" from \"TABLE1\" where \"TABLE1\".\"NAME1\" = 'x')", r_refI().render(c));
        assertEquals("\"TABLE1\".\"ID1\" not in (select \"TABLE1\".\"ID1\", \"TABLE1\".\"NAME1\", \"TABLE1\".\"DATE1\" from \"TABLE1\" where \"TABLE1\".\"NAME1\" = ?)", r_ref().render(c));

        context.checking(new Expectations() {{
            oneOf(statement).setString(1, "x");
        }});

        int i = b_ref().bind(c).peekIndex();
        assertEquals(2, i);

        context.assertIsSatisfied();
    }

    @Test
    public final void testCompareCondition() throws Exception {
        Condition c = FIELD_ID1.equal(10);
        assertEquals("\"TABLE1\".\"ID1\" = 10", r_refI().render(c));
        assertEquals("\"TABLE1\".\"ID1\" = ?", r_ref().render(c));

        context.checking(new Expectations() {{
            oneOf(statement).setInt(1, 10);
        }});

        int i = b_ref().bind(c).peekIndex();
        assertEquals(2, i);

        context.assertIsSatisfied();
    }

    @Test
    public final void testNotCondition() throws Exception {
        Condition c = FIELD_ID1.equal(10).not();
        assertEquals("not(\"TABLE1\".\"ID1\" = 10)", r_refI().render(c));
        assertEquals("not(\"TABLE1\".\"ID1\" = ?)", r_ref().render(c));

        assertEquals("not(not(\"TABLE1\".\"ID1\" = 10))", r_refI().render(c.not()));
        assertEquals("not(not(\"TABLE1\".\"ID1\" = ?))", r_ref().render(c.not()));

        context.checking(new Expectations() {{
            oneOf(statement).setInt(1, 10);
        }});

        int i = b_ref().bind(c).peekIndex();
        assertEquals(2, i);

        context.assertIsSatisfied();
    }

    @Test
    public final void testPlainSQLCondition() throws Exception {
        Condition c1 = create.condition("TABLE1.ID = 10");
        Condition c2 = create.condition("TABLE1.ID = ? and TABLE2.ID = ?", 10, "20");

        assertEquals("(TABLE1.ID = 10)", r_refI().render(c1));
        assertEquals("(TABLE1.ID = 10)", r_ref().render(c1));

        assertEquals("(TABLE1.ID = 10 and TABLE2.ID = '20')", r_refI().render(c2));
        assertEquals("(TABLE1.ID = ? and TABLE2.ID = ?)", r_ref().render(c2));

        context.checking(new Expectations() {{
            oneOf(statement).setInt(1, 10);
            oneOf(statement).setString(2, "20");
        }});

        int i = b_ref().bind(c2).peekIndex();
        assertEquals(3, i);

        context.assertIsSatisfied();
    }

    @Test
    public final void testCustomCondition() throws Exception {
        Condition c = new CustomCondition() {
            private static final long serialVersionUID = 6302350477408137757L;

            @Override
            public void toSQL(RenderContext ctx) {
                if (ctx.inline()) {
                    ctx.sql("1 = 1");
                } else {
                    ctx.sql("? = ?");
                }
            }

            @Override
            public void bind(BindContext ctx) throws SQLException {
                ctx.statement().setInt(ctx.nextIndex(), 1);
                ctx.bindValues(1);
            }
        };

        assertEquals("1 = 1", r_refI().render(c));
        assertEquals("? = ?", r_ref().render(c));

        context.checking(new Expectations() {{
            oneOf(statement).setInt(1, 1);
            oneOf(statement).setInt(2, 1);
        }});

        int i = b_ref().bind(c).peekIndex();
        assertEquals(3, i);

        context.assertIsSatisfied();
    }

    @Test
    public final void testPlainSQLField() throws Exception {
        Field<?> f1 = create.field("DECODE(TABLE1.ID, 1, 'a', 'b')");
        Field<?> f2 = create.field("DECODE(TABLE1.ID, 1, ?, ?)", "a", "b");

        assertEquals("DECODE(TABLE1.ID, 1, 'a', 'b')", r_refI().render(f1));
        assertEquals("DECODE(TABLE1.ID, 1, 'a', 'b')", r_ref().render(f1));

        assertEquals("DECODE(TABLE1.ID, 1, 'a', 'b')", r_refI().render(f2));
        assertEquals("DECODE(TABLE1.ID, 1, ?, ?)", r_ref().render(f2));

        context.checking(new Expectations() {{
            oneOf(statement).setString(1, "a");
            oneOf(statement).setString(2, "b");
        }});

        int i = b_ref().bind(f2).peekIndex();
        assertEquals(3, i);

        context.assertIsSatisfied();
    }

    @Test
    public final void testCustomField() throws Exception {
        Field<?> f = new CustomField<Integer>("test", Data.INTEGER_TYPE) {
            private static final long serialVersionUID = 1L;

            @Override
            public void toSQL(RenderContext ctx) {
                if (ctx.inline()) {
                    ctx.sql("1");
                } else {
                    ctx.sql("?");
                }
            }

            @Override
            public void bind(BindContext ctx) throws SQLException {
                ctx.bindValues(1);
            }
        };

        assertEquals("1", r_refI().render(f));
        assertEquals("?", r_ref().render(f));

        context.checking(new Expectations() {{
            oneOf(statement).setInt(1, 1);
        }});

        int i = b_ref().bind(f).peekIndex();
        assertEquals(2, i);

        context.assertIsSatisfied();
    }

    @Test
    public final void testIsNullCondition() throws Exception {
        Condition c1 = FIELD_ID1.isNull();
        assertEquals("\"TABLE1\".\"ID1\" is null", r_refI().render(c1));
        assertEquals("\"TABLE1\".\"ID1\" is null", r_ref().render(c1));

        Condition c2 = FIELD_ID1.isNotNull();
        assertEquals("\"TABLE1\".\"ID1\" is not null", r_refI().render(c2));
        assertEquals("\"TABLE1\".\"ID1\" is not null", r_ref().render(c2));

        int i = b_ref().bind(c1).peekIndex();
        assertEquals(1, i);

        int j = b_ref().bind(c2).peekIndex();
        assertEquals(1, j);
    }

    @Test
    public final void testCaseValueFunction() throws Exception {
        Case decode = create.decode();
        CaseValueStep<Integer> value = decode.value(FIELD_ID1);
        CaseWhenStep<Integer, String> c = value.when(1, "one");

        assertEquals("case \"TABLE1\".\"ID1\" when 1 then 'one' end", r_refI().render(c));
        assertEquals("case \"TABLE1\".\"ID1\" when ? then ? end", r_ref().render(c));
        assertEquals("case \"TABLE1\".\"ID1\" when 1 then 'one' end", r_decI().render(c));
        assertEquals("case \"TABLE1\".\"ID1\" when ? then ? end", r_dec().render(c));

        c.otherwise("nothing");
        assertEquals("case \"TABLE1\".\"ID1\" when 1 then 'one' else 'nothing' end", r_refI().render(c));
        assertEquals("case \"TABLE1\".\"ID1\" when ? then ? else ? end", r_ref().render(c));
        assertEquals("case \"TABLE1\".\"ID1\" when 1 then 'one' else 'nothing' end", r_decI().render(c));
        assertEquals("case \"TABLE1\".\"ID1\" when ? then ? else ? end", r_dec().render(c));

        c.when(2, "two").when(3, "three");
        assertEquals("case \"TABLE1\".\"ID1\" when 1 then 'one' when 2 then 'two' when 3 then 'three' else 'nothing' end", r_refI().render(c));
        assertEquals("case \"TABLE1\".\"ID1\" when ? then ? when ? then ? when ? then ? else ? end", r_ref().render(c));
        assertEquals("case \"TABLE1\".\"ID1\" when 1 then 'one' when 2 then 'two' when 3 then 'three' else 'nothing' end", r_decI().render(c));
        assertEquals("case \"TABLE1\".\"ID1\" when ? then ? when ? then ? when ? then ? else ? end", r_dec().render(c));

        context.checking(new Expectations() {{
            oneOf(statement).setInt(1, 1);
            oneOf(statement).setString(2, "one");
            oneOf(statement).setInt(3, 2);
            oneOf(statement).setString(4, "two");
            oneOf(statement).setInt(5, 3);
            oneOf(statement).setString(6, "three");
            oneOf(statement).setString(7, "nothing");
        }});

        int i = b_ref().bind(c).peekIndex();
        assertEquals(8, i);

        context.assertIsSatisfied();
    }

    @Test
    public final void testCaseConditionFunction() throws Exception {
        Case decode = create.decode();
        CaseConditionStep<String> c = decode.when(FIELD_ID1.equal(1), "one");

        assertEquals("case when \"TABLE1\".\"ID1\" = 1 then 'one' end", r_refI().render(c));
        assertEquals("case when \"TABLE1\".\"ID1\" = ? then ? end", r_ref().render(c));
        assertEquals("case when \"TABLE1\".\"ID1\" = 1 then 'one' end", r_decI().render(c));
        assertEquals("case when \"TABLE1\".\"ID1\" = ? then ? end", r_dec().render(c));

        c.otherwise("nothing");
        assertEquals("case when \"TABLE1\".\"ID1\" = 1 then 'one' else 'nothing' end", r_refI().render(c));
        assertEquals("case when \"TABLE1\".\"ID1\" = ? then ? else ? end", r_ref().render(c));
        assertEquals("case when \"TABLE1\".\"ID1\" = 1 then 'one' else 'nothing' end", r_decI().render(c));
        assertEquals("case when \"TABLE1\".\"ID1\" = ? then ? else ? end", r_dec().render(c));

        c.when(FIELD_ID1.equal(2), "two").when(FIELD_ID1.equal(3), "three");
        assertEquals("case when \"TABLE1\".\"ID1\" = 1 then 'one' when \"TABLE1\".\"ID1\" = 2 then 'two' when \"TABLE1\".\"ID1\" = 3 then 'three' else 'nothing' end", r_refI().render(c));
        assertEquals("case when \"TABLE1\".\"ID1\" = ? then ? when \"TABLE1\".\"ID1\" = ? then ? when \"TABLE1\".\"ID1\" = ? then ? else ? end", r_ref().render(c));
        assertEquals("case when \"TABLE1\".\"ID1\" = 1 then 'one' when \"TABLE1\".\"ID1\" = 2 then 'two' when \"TABLE1\".\"ID1\" = 3 then 'three' else 'nothing' end", r_decI().render(c));
        assertEquals("case when \"TABLE1\".\"ID1\" = ? then ? when \"TABLE1\".\"ID1\" = ? then ? when \"TABLE1\".\"ID1\" = ? then ? else ? end", r_dec().render(c));

        context.checking(new Expectations() {{
            oneOf(statement).setInt(1, 1);
            oneOf(statement).setString(2, "one");
            oneOf(statement).setInt(3, 2);
            oneOf(statement).setString(4, "two");
            oneOf(statement).setInt(5, 3);
            oneOf(statement).setString(6, "three");
            oneOf(statement).setString(7, "nothing");
        }});

        int i = b_ref().bind(c).peekIndex();
        assertEquals(8, i);

        context.assertIsSatisfied();
    }

    @Test
    public final void testNullFunction() throws Exception {
        Field<?> f = create.val((Object) null);
        assertEquals("null", r_refI().render(f));
        assertEquals("null", r_ref().render(f));

        int i = b_ref().bind(f).peekIndex();
        assertEquals(1, i);
    }

    @Test
    public final void testConstantFunction() throws Exception {
        Field<Integer> f1 = create.val(Integer.valueOf(1));
        assertEquals(Integer.class, f1.getType());
        assertEquals("1", r_refI().render(f1));
        assertEquals("?", r_ref().render(f1));
        assertEquals("1", r_decI().render(f1));
        assertEquals("?", r_dec().render(f1));

        Field<String> f2 = create.val("test's");
        assertEquals(String.class, f2.getType());
        assertEquals("'test''s'", r_refI().render(f2));
        assertEquals("?", r_ref().render(f2));
        assertEquals("'test''s'", r_decI().render(f2));
        assertEquals("?", r_dec().render(f2));

        Field<Integer> f3 = create.val(Integer.valueOf(1)).as("value");
        assertEquals(Integer.class, f3.getType());
        assertEquals("\"value\"", r_refI().render(f3));
        assertEquals("\"value\"", r_ref().render(f3));
        assertEquals("1 \"value\"", r_decI().render(f3));
        assertEquals("? \"value\"", r_dec().render(f3));

        context.checking(new Expectations() {{
            oneOf(statement).setInt(1, 1);
            oneOf(statement).setString(1, "test's");
            oneOf(statement).setInt(1, 1);
        }});

        int i = b_decF().bind(f1).peekIndex();
        int j = b_decF().bind(f2).peekIndex();
        int k = b_decF().bind(f3).peekIndex();

        assertEquals(2, i);
        assertEquals(2, j);
        assertEquals(2, k);

        context.assertIsSatisfied();
    }

    @Test
    public final void testArithmeticSumExpressions() throws Exception {
        Field<Integer> sum1 = FIELD_ID1.add(FIELD_ID1).add(1).add(2);
        assertEquals(Integer.class, sum1.getType());
        assertEquals("(\"TABLE1\".\"ID1\" + \"TABLE1\".\"ID1\" + 1 + 2)", r_refI().render(sum1));
        assertEquals("(\"TABLE1\".\"ID1\" + \"TABLE1\".\"ID1\" + ? + ?)", r_ref().render(sum1));
        assertEquals("(\"TABLE1\".\"ID1\" + \"TABLE1\".\"ID1\" + 1 + 2)", r_decI().render(sum1));
        assertEquals("(\"TABLE1\".\"ID1\" + \"TABLE1\".\"ID1\" + ? + ?)", r_dec().render(sum1));

        Field<Integer> sum2 = sum1.as("s");
        assertEquals(Integer.class, sum2.getType());
        assertEquals("\"s\"", r_refI().render(sum2));
        assertEquals("\"s\"", r_ref().render(sum2));

        assertEquals("(\"TABLE1\".\"ID1\" + \"TABLE1\".\"ID1\" + 1 + 2) \"s\"", r_decI().render(sum2));
        assertEquals("(\"TABLE1\".\"ID1\" + \"TABLE1\".\"ID1\" + ? + ?) \"s\"", r_dec().render(sum2));

        context.checking(new Expectations() {{
            oneOf(statement).setInt(1, 1);
            oneOf(statement).setInt(2, 2);
        }});

        int i = b_decF().bind(sum2).peekIndex();
        assertEquals(3, i);

        context.assertIsSatisfied();
    }

    @Test
    public final void testArithmeticDifferenceExpressions() throws Exception {
        Field<Integer> difference1 = FIELD_ID1.sub(FIELD_ID1).sub(1).sub(2);
        assertEquals(Integer.class, difference1.getType());
        assertEquals("(((\"TABLE1\".\"ID1\" - \"TABLE1\".\"ID1\") - 1) - 2)", r_refI().render(difference1));
        assertEquals("(((\"TABLE1\".\"ID1\" - \"TABLE1\".\"ID1\") - ?) - ?)", r_ref().render(difference1));
        assertEquals("(((\"TABLE1\".\"ID1\" - \"TABLE1\".\"ID1\") - 1) - 2)", r_decI().render(difference1));
        assertEquals("(((\"TABLE1\".\"ID1\" - \"TABLE1\".\"ID1\") - ?) - ?)", r_dec().render(difference1));

        Field<Integer> difference2 = difference1.as("d");
        assertEquals(Integer.class, difference2.getType());
        assertEquals("\"d\"", r_refI().render(difference2));
        assertEquals("\"d\"", r_ref().render(difference2));
        assertEquals("(((\"TABLE1\".\"ID1\" - \"TABLE1\".\"ID1\") - 1) - 2) \"d\"", r_decI().render(difference2));
        assertEquals("(((\"TABLE1\".\"ID1\" - \"TABLE1\".\"ID1\") - ?) - ?) \"d\"", r_dec().render(difference2));


        context.checking(new Expectations() {{
            oneOf(statement).setInt(1, 1);
            oneOf(statement).setInt(2, 2);
        }});

        int i = b_decF().bind(difference2).peekIndex();
        assertEquals(3, i);

        context.assertIsSatisfied();
    }

    @Test
    public final void testArithmeticProductExpressions() throws Exception {
        Field<Integer> product1 = FIELD_ID1.mul(FIELD_ID1).mul(1).mul(2);
        assertEquals(Integer.class, product1.getType());
        assertEquals("(\"TABLE1\".\"ID1\" * \"TABLE1\".\"ID1\" * 1 * 2)", r_refI().render(product1));
        assertEquals("(\"TABLE1\".\"ID1\" * \"TABLE1\".\"ID1\" * ? * ?)", r_ref().render(product1));
        assertEquals("(\"TABLE1\".\"ID1\" * \"TABLE1\".\"ID1\" * 1 * 2)", r_decI().render(product1));
        assertEquals("(\"TABLE1\".\"ID1\" * \"TABLE1\".\"ID1\" * ? * ?)", r_dec().render(product1));

        Field<Integer> product2 = product1.as("p");
        assertEquals(Integer.class, product2.getType());
        assertEquals("\"p\"", r_refI().render(product2));
        assertEquals("\"p\"", r_ref().render(product2));
        assertEquals("(\"TABLE1\".\"ID1\" * \"TABLE1\".\"ID1\" * 1 * 2) \"p\"", r_decI().render(product2));
        assertEquals("(\"TABLE1\".\"ID1\" * \"TABLE1\".\"ID1\" * ? * ?) \"p\"", r_dec().render(product2));


        context.checking(new Expectations() {{
            oneOf(statement).setInt(1, 1);
            oneOf(statement).setInt(2, 2);
        }});

        int i = b_decF().bind(product2).peekIndex();
        assertEquals(3, i);

        context.assertIsSatisfied();
    }

    @Test
    public final void testArithmeticDivisionExpressions() throws Exception {
        Field<Integer> division1 = FIELD_ID1.div(FIELD_ID1).div(1).div(2);
        assertEquals(Integer.class, division1.getType());
        assertEquals("(((\"TABLE1\".\"ID1\" / \"TABLE1\".\"ID1\") / 1) / 2)", r_refI().render(division1));
        assertEquals("(((\"TABLE1\".\"ID1\" / \"TABLE1\".\"ID1\") / ?) / ?)", r_ref().render(division1));
        assertEquals("(((\"TABLE1\".\"ID1\" / \"TABLE1\".\"ID1\") / 1) / 2)", r_decI().render(division1));
        assertEquals("(((\"TABLE1\".\"ID1\" / \"TABLE1\".\"ID1\") / ?) / ?)", r_dec().render(division1));

        Field<Integer> division2 = division1.as("d");
        assertEquals(Integer.class, division2.getType());
        assertEquals("\"d\"", r_refI().render(division2));
        assertEquals("\"d\"", r_ref().render(division2));
        assertEquals("(((\"TABLE1\".\"ID1\" / \"TABLE1\".\"ID1\") / 1) / 2) \"d\"", r_decI().render(division2));
        assertEquals("(((\"TABLE1\".\"ID1\" / \"TABLE1\".\"ID1\") / ?) / ?) \"d\"", r_dec().render(division2));


        context.checking(new Expectations() {{
            oneOf(statement).setInt(1, 1);
            oneOf(statement).setInt(2, 2);
        }});

        int i = b_decF().bind(division2).peekIndex();
        assertEquals(3, i);

        context.assertIsSatisfied();
    }

    @Test
    public final void testFunctions() {
        Field<String> f = FIELD_NAME1.replace("a", "b");
        assertEquals("replace(\"TABLE1\".\"NAME1\", 'a', 'b')", r_refI().render(f));
        assertEquals("replace(\"TABLE1\".\"NAME1\", ?, ?)", r_ref().render(f));
    }

    @Test
    public final void testArithmeticExpressions() {
        Field<? extends Number> f;

        f = FIELD_ID1.add(1).sub(2).add(3);
        assertEquals("(((\"TABLE1\".\"ID1\" + 1) - 2) + 3)", r_refI().render(f));
        assertEquals("(((\"TABLE1\".\"ID1\" + ?) - ?) + ?)", r_ref().render(f));

        f = FIELD_ID1.add(1).add(2).sub(3);
        assertEquals("((\"TABLE1\".\"ID1\" + 1 + 2) - 3)", r_refI().render(f));
        assertEquals("((\"TABLE1\".\"ID1\" + ? + ?) - ?)", r_ref().render(f));

        f = FIELD_ID1.add(1).sub(create.val(2).add(3));
        assertEquals("((\"TABLE1\".\"ID1\" + 1) - (2 + 3))", r_refI().render(f));
        assertEquals("((\"TABLE1\".\"ID1\" + ?) - (? + ?))", r_ref().render(f));

        f = FIELD_ID1.mul(1).div(2).mul(3);
        assertEquals("(((\"TABLE1\".\"ID1\" * 1) / 2) * 3)", r_refI().render(f));
        assertEquals("(((\"TABLE1\".\"ID1\" * ?) / ?) * ?)", r_ref().render(f));

        f = FIELD_ID1.mul(1).mul(2).div(3);
        assertEquals("((\"TABLE1\".\"ID1\" * 1 * 2) / 3)", r_refI().render(f));
        assertEquals("((\"TABLE1\".\"ID1\" * ? * ?) / ?)", r_ref().render(f));

        f = FIELD_ID1.mul(1).div(create.val(2).mul(3));
        assertEquals("((\"TABLE1\".\"ID1\" * 1) / (2 * 3))", r_refI().render(f));
        assertEquals("((\"TABLE1\".\"ID1\" * ?) / (? * ?))", r_ref().render(f));
    }

    @Test
    public final void testArithmeticFunctions() throws Exception {
        Field<BigDecimal> sum1 = FIELD_ID1.sum();
        assertEquals(BigDecimal.class, sum1.getType());
        assertEquals("sum(\"TABLE1\".\"ID1\")", r_refI().render(sum1));
        assertEquals("sum(\"TABLE1\".\"ID1\")", r_ref().render(sum1));
        assertEquals("sum(\"TABLE1\".\"ID1\")", r_decI().render(sum1));
        assertEquals("sum(\"TABLE1\".\"ID1\")", r_dec().render(sum1));
        assertEquals(1, b_ref().bind(sum1).peekIndex());

        Field<BigDecimal> sum2 = FIELD_ID1.sum().as("value");
        assertEquals(BigDecimal.class, sum2.getType());
        assertEquals("\"value\"", r_refI().render(sum2));
        assertEquals("\"value\"", r_ref().render(sum2));
        assertEquals("sum(\"TABLE1\".\"ID1\") \"value\"", r_decI().render(sum2));
        assertEquals("sum(\"TABLE1\".\"ID1\") \"value\"", r_dec().render(sum2));
        assertEquals(1, b_ref().bind(sum2).peekIndex());

        Field<BigDecimal> avg1 = FIELD_ID1.avg();
        assertEquals(BigDecimal.class, avg1.getType());
        assertEquals("avg(\"TABLE1\".\"ID1\")", r_refI().render(avg1));
        assertEquals("avg(\"TABLE1\".\"ID1\")", r_ref().render(avg1));
        assertEquals("avg(\"TABLE1\".\"ID1\")", r_decI().render(avg1));
        assertEquals("avg(\"TABLE1\".\"ID1\")", r_dec().render(avg1));
        assertEquals(1, b_ref().bind(avg1).peekIndex());

        Field<BigDecimal> avg2 = FIELD_ID1.avg().as("value");
        assertEquals(BigDecimal.class, avg2.getType());
        assertEquals("\"value\"", r_refI().render(avg2));
        assertEquals("\"value\"", r_ref().render(avg2));
        assertEquals("avg(\"TABLE1\".\"ID1\") \"value\"", r_decI().render(avg2));
        assertEquals("avg(\"TABLE1\".\"ID1\") \"value\"", r_dec().render(avg2));
        assertEquals(1, b_ref().bind(avg2).peekIndex());

        Field<Integer> min1 = FIELD_ID1.min();
        assertEquals(Integer.class, min1.getType());
        assertEquals("min(\"TABLE1\".\"ID1\")", r_refI().render(min1));
        assertEquals("min(\"TABLE1\".\"ID1\")", r_ref().render(min1));
        assertEquals("min(\"TABLE1\".\"ID1\")", r_decI().render(min1));
        assertEquals("min(\"TABLE1\".\"ID1\")", r_dec().render(min1));
        assertEquals(1, b_ref().bind(min1).peekIndex());

        Field<Integer> min2 = FIELD_ID1.min().as("value");
        assertEquals(Integer.class, min2.getType());
        assertEquals("\"value\"", r_refI().render(min2));
        assertEquals("\"value\"", r_ref().render(min2));
        assertEquals("min(\"TABLE1\".\"ID1\") \"value\"", r_decI().render(min2));
        assertEquals("min(\"TABLE1\".\"ID1\") \"value\"", r_dec().render(min2));
        assertEquals(1, b_ref().bind(min2).peekIndex());

        Field<Integer> max1 = FIELD_ID1.max();
        assertEquals(Integer.class, max1.getType());
        assertEquals("max(\"TABLE1\".\"ID1\")", r_refI().render(max1));
        assertEquals("max(\"TABLE1\".\"ID1\")", r_ref().render(max1));
        assertEquals("max(\"TABLE1\".\"ID1\")", r_decI().render(max1));
        assertEquals("max(\"TABLE1\".\"ID1\")", r_dec().render(max1));
        assertEquals(1, b_ref().bind(max1).peekIndex());

        Field<Integer> max2 = FIELD_ID1.max().as("value");
        assertEquals(Integer.class, max2.getType());
        assertEquals("\"value\"", r_refI().render(max2));
        assertEquals("\"value\"", r_ref().render(max2));
        assertEquals("max(\"TABLE1\".\"ID1\") \"value\"", r_decI().render(max2));
        assertEquals("max(\"TABLE1\".\"ID1\") \"value\"", r_dec().render(max2));
        assertEquals(1, b_ref().bind(max2).peekIndex());

        Field<Integer> count1 = create.count();
        assertEquals(Integer.class, count1.getType());
        assertEquals("count(*)", r_refI().render(count1));
        assertEquals("count(*)", r_ref().render(count1));
        assertEquals("count(*)", r_decI().render(count1));
        assertEquals("count(*)", r_dec().render(count1));
        assertEquals(1, b_ref().bind(count1).peekIndex());

        Field<Integer> count1a = create.count().as("cnt");
        assertEquals(Integer.class, count1a.getType());
        assertEquals("\"cnt\"", r_refI().render(count1a));
        assertEquals("\"cnt\"", r_ref().render(count1a));
        assertEquals("count(*) \"cnt\"", r_decI().render(count1a));
        assertEquals("count(*) \"cnt\"", r_dec().render(count1a));
        assertEquals(1, b_ref().bind(count1a).peekIndex());

        Field<Integer> count2 = FIELD_ID1.count();
        assertEquals(Integer.class, count2.getType());
        assertEquals("count(\"TABLE1\".\"ID1\")", r_refI().render(count2));
        assertEquals("count(\"TABLE1\".\"ID1\")", r_ref().render(count2));
        assertEquals("count(\"TABLE1\".\"ID1\")", r_decI().render(count2));
        assertEquals("count(\"TABLE1\".\"ID1\")", r_dec().render(count2));
        assertEquals(1, b_ref().bind(count2).peekIndex());

        Field<Integer> count2a = FIELD_ID1.count().as("cnt");
        assertEquals(Integer.class, count2a.getType());
        assertEquals("\"cnt\"", r_refI().render(count2a));
        assertEquals("\"cnt\"", r_ref().render(count2a));
        assertEquals("count(\"TABLE1\".\"ID1\") \"cnt\"", r_decI().render(count2a));
        assertEquals("count(\"TABLE1\".\"ID1\") \"cnt\"", r_dec().render(count2a));
        assertEquals(1, b_ref().bind(count2a).peekIndex());

        Field<Integer> count3 = FIELD_ID1.countDistinct();
        assertEquals(Integer.class, count3.getType());
        assertEquals("count(distinct \"TABLE1\".\"ID1\")", r_refI().render(count3));
        assertEquals("count(distinct \"TABLE1\".\"ID1\")", r_ref().render(count3));
        assertEquals("count(distinct \"TABLE1\".\"ID1\")", r_decI().render(count3));
        assertEquals("count(distinct \"TABLE1\".\"ID1\")", r_dec().render(count3));
        assertEquals(1, b_ref().bind(count3).peekIndex());

        Field<Integer> count3a = FIELD_ID1.countDistinct().as("cnt");
        assertEquals(Integer.class, count3a.getType());
        assertEquals("\"cnt\"", r_refI().render(count3a));
        assertEquals("\"cnt\"", r_ref().render(count3a));
        assertEquals("count(distinct \"TABLE1\".\"ID1\") \"cnt\"", r_decI().render(count3a));
        assertEquals("count(distinct \"TABLE1\".\"ID1\") \"cnt\"", r_dec().render(count3a));
        assertEquals(1, b_ref().bind(count3a).peekIndex());
    }

    @Test
    public final void testInsertQuery1() throws Exception {
        InsertQuery<Table1Record> q = create.insertQuery(TABLE1);

        q.addValue(FIELD_ID1, 10);
        assertEquals("insert into \"TABLE1\" (\"ID1\") values (10)", r_refI().render(q));
        assertEquals("insert into \"TABLE1\" (\"ID1\") values (?)", r_ref().render(q));
        assertEquals(q, create.insertInto(TABLE1, FIELD_ID1).values(10));
        assertEquals(q, create.insertInto(TABLE1).set(FIELD_ID1, 10));

        context.checking(new Expectations() {{
            oneOf(statement).setInt(1, 10);
        }});

        int i = b_ref().bind(q).peekIndex();
        assertEquals(2, i);

        context.assertIsSatisfied();
    }

    @Test
    public final void testInsertQuery2() throws Exception {
        InsertQuery<Table1Record> q = create.insertQuery(TABLE1);

        q.addValue(FIELD_ID1, 10);
        q.addValue(FIELD_NAME1, "ABC");
        q.addValue(FIELD_DATE1, new Date(0));
        assertEquals("insert into \"TABLE1\" (\"ID1\", \"NAME1\", \"DATE1\") values (10, 'ABC', '1970-01-01')", r_refI().render(q));
        assertEquals("insert into \"TABLE1\" (\"ID1\", \"NAME1\", \"DATE1\") values (?, ?, ?)", r_ref().render(q));
        assertEquals(q, create.insertInto(TABLE1, FIELD_ID1, FIELD_NAME1, FIELD_DATE1).values(10, "ABC", new Date(0)));
        assertEquals(q, create.insertInto(TABLE1).set(FIELD_ID1, 10).set(FIELD_NAME1, "ABC").set(FIELD_DATE1, new Date(0)));

        context.checking(new Expectations() {{
            oneOf(statement).setInt(1, 10);
            oneOf(statement).setString(2, "ABC");
            oneOf(statement).setDate(3, new Date(0));
        }});

        int i = b_ref().bind(q).peekIndex();
        assertEquals(4, i);

        context.assertIsSatisfied();
    }

    @Test
    public final void testInsertSelect1() throws Exception {
        InsertQuery<Table1Record> q = create.insertQuery(TABLE1);

        q.addValue(FIELD_ID1, create.val(10).round());
        q.addValue(FIELD_NAME1, create.select(FIELD_NAME1).from(TABLE1).where(FIELD_ID1.equal(1)).<String> asField());
        assertEquals("insert into \"TABLE1\" (\"ID1\", \"NAME1\") values (round(10), (select \"TABLE1\".\"NAME1\" from \"TABLE1\" where \"TABLE1\".\"ID1\" = 1))", r_refI().render(q));
        assertEquals("insert into \"TABLE1\" (\"ID1\", \"NAME1\") values (round(?), (select \"TABLE1\".\"NAME1\" from \"TABLE1\" where \"TABLE1\".\"ID1\" = ?))", r_ref().render(q));

        context.checking(new Expectations() {{
            oneOf(statement).setInt(1, 10);
            oneOf(statement).setInt(2, 1);
        }});

        int i = b_ref().bind(q).peekIndex();
        assertEquals(3, i);

        context.assertIsSatisfied();
    }

    @Test
    public final void testInsertSelect2() throws Exception {
        Insert q = create.insertInto(TABLE1, create.selectQuery());

        assertEquals("insert into \"TABLE1\" (\"ID1\", \"NAME1\", \"DATE1\") select 1 from dual", r_refI().render(q));
        assertEquals("insert into \"TABLE1\" (\"ID1\", \"NAME1\", \"DATE1\") select 1 from dual", r_ref().render(q));

        q = create.insertInto(TABLE1, create.select(create.val(1), FIELD_NAME1).from(TABLE1).where(FIELD_NAME1.equal("abc")));

        assertEquals("insert into \"TABLE1\" (\"ID1\", \"NAME1\", \"DATE1\") select 1, \"TABLE1\".\"NAME1\" from \"TABLE1\" where \"TABLE1\".\"NAME1\" = 'abc'", r_refI().render(q));
        assertEquals("insert into \"TABLE1\" (\"ID1\", \"NAME1\", \"DATE1\") select ?, \"TABLE1\".\"NAME1\" from \"TABLE1\" where \"TABLE1\".\"NAME1\" = ?", r_ref().render(q));

        context.checking(new Expectations() {{
            oneOf(statement).setInt(1, 1);
            oneOf(statement).setString(2, "abc");
        }});

        int i = b_ref().bind(q).peekIndex();
        assertEquals(3, i);

        context.assertIsSatisfied();
    }

    @Test
    public final void testUpdateQuery1() throws Exception {
        UpdateQuery<Table1Record> q = create.updateQuery(TABLE1);

        q.addValue(FIELD_ID1, 10);
        assertEquals("update \"TABLE1\" set \"ID1\" = 10", r_refI().render(q));
        assertEquals("update \"TABLE1\" set \"ID1\" = ?", r_ref().render(q));
        assertEquals(q, create.update(TABLE1).set(FIELD_ID1, 10));

        context.checking(new Expectations() {{
            oneOf(statement).setInt(1, 10);
        }});

        int i = b_ref().bind(q).peekIndex();
        assertEquals(2, i);

        context.assertIsSatisfied();
    }

    @Test
    public final void testUpdateQuery2() throws Exception {
        UpdateQuery<Table1Record> q = create.updateQuery(TABLE1);

        q.addValue(FIELD_ID1, 10);
        q.addValue(FIELD_NAME1, "ABC");
        assertEquals("update \"TABLE1\" set \"ID1\" = 10, \"NAME1\" = 'ABC'", r_refI().render(q));
        assertEquals("update \"TABLE1\" set \"ID1\" = ?, \"NAME1\" = ?", r_ref().render(q));
        assertEquals(q, create.update(TABLE1).set(FIELD_ID1, 10).set(FIELD_NAME1, "ABC"));

        context.checking(new Expectations() {{
            oneOf(statement).setInt(1, 10);
            oneOf(statement).setString(2, "ABC");
        }});

        int i = b_ref().bind(q).peekIndex();
        assertEquals(3, i);

        context.assertIsSatisfied();
    }

    @Test
    public final void testUpdateQuery3() throws Exception {
        UpdateQuery<Table1Record> q = create.updateQuery(TABLE1);
        Condition c = FIELD_ID1.equal(10);

        q.addValue(FIELD_ID1, 10);
        q.addValue(FIELD_NAME1, "ABC");
        q.addConditions(c);
        assertEquals("update \"TABLE1\" set \"ID1\" = 10, \"NAME1\" = 'ABC' where \"TABLE1\".\"ID1\" = 10", r_refI().render(q));
        assertEquals("update \"TABLE1\" set \"ID1\" = ?, \"NAME1\" = ? where \"TABLE1\".\"ID1\" = ?", r_ref().render(q));
        assertEquals(q, create.update(TABLE1).set(FIELD_ID1, 10).set(FIELD_NAME1, "ABC").where(c));

        context.checking(new Expectations() {{
            oneOf(statement).setInt(1, 10);
            oneOf(statement).setString(2, "ABC");
            oneOf(statement).setInt(3, 10);
        }});

        int i = b_ref().bind(q).peekIndex();
        assertEquals(4, i);

        context.assertIsSatisfied();
    }

    @Test
    public final void testUpdateQuery4() throws Exception {
        UpdateQuery<Table1Record> q = create.updateQuery(TABLE1);
        Condition c1 = FIELD_ID1.equal(10);
        Condition c2 = FIELD_ID1.equal(20);

        q.addValue(FIELD_ID1, 10);
        q.addValue(FIELD_NAME1, "ABC");
        q.addConditions(c1);
        q.addConditions(c2);
        assertEquals("update \"TABLE1\" set \"ID1\" = 10, \"NAME1\" = 'ABC' where (\"TABLE1\".\"ID1\" = 10 and \"TABLE1\".\"ID1\" = 20)", r_refI().render(q));
        assertEquals("update \"TABLE1\" set \"ID1\" = ?, \"NAME1\" = ? where (\"TABLE1\".\"ID1\" = ? and \"TABLE1\".\"ID1\" = ?)", r_ref().render(q));
        assertEquals(q, create.update(TABLE1).set(FIELD_ID1, 10).set(FIELD_NAME1, "ABC").where(c1, c2));

        context.checking(new Expectations() {{
            oneOf(statement).setInt(1, 10);
            oneOf(statement).setString(2, "ABC");
            oneOf(statement).setInt(3, 10);
            oneOf(statement).setInt(4, 20);
        }});

        int i = b_ref().bind(q).peekIndex();
        assertEquals(5, i);

        context.assertIsSatisfied();
    }

    @Test
    public final void testUpdateQuery5() throws Exception {
        UpdateQuery<Table1Record> q = create.updateQuery(TABLE1);
        Condition c1 = FIELD_ID1.equal(10);
        Condition c2 = FIELD_ID1.equal(20);

        q.addValue(FIELD_ID1, 10);
        q.addValue(FIELD_NAME1, "ABC");
        q.addConditions(c1);
        q.addConditions(c2);
        q.addConditions(c2, c1);
        assertEquals("update \"TABLE1\" set \"ID1\" = 10, \"NAME1\" = 'ABC' where (\"TABLE1\".\"ID1\" = 10 and \"TABLE1\".\"ID1\" = 20 and \"TABLE1\".\"ID1\" = 20 and \"TABLE1\".\"ID1\" = 10)", r_refI().render(q));
        assertEquals("update \"TABLE1\" set \"ID1\" = ?, \"NAME1\" = ? where (\"TABLE1\".\"ID1\" = ? and \"TABLE1\".\"ID1\" = ? and \"TABLE1\".\"ID1\" = ? and \"TABLE1\".\"ID1\" = ?)", r_ref().render(q));
        assertEquals(q, create.update(TABLE1).set(FIELD_ID1, 10).set(FIELD_NAME1, "ABC").where(c1).and(c2).and(c2).and(c1));

        context.checking(new Expectations() {{
            oneOf(statement).setInt(1, 10);
            oneOf(statement).setString(2, "ABC");
            oneOf(statement).setInt(3, 10);
            oneOf(statement).setInt(4, 20);
            oneOf(statement).setInt(5, 20);
            oneOf(statement).setInt(6, 10);
        }});

        int i = b_ref().bind(q).peekIndex();
        assertEquals(7, i);

        context.assertIsSatisfied();
    }

    @Test
    public final void testMergeQuery() throws Exception {
        Merge q =
        create.mergeInto(TABLE1)
              .using(create.select(FIELD_ID2).from(TABLE2))
              .on(FIELD_ID2.equal(FIELD_ID1))
              .and(FIELD_ID1.equal(1))
              .or(FIELD_ID2.equal(2))
              .whenMatchedThenUpdate()
              .set(FIELD_NAME1, "name")
              .set(FIELD_DATE1, new Date(0))
              .whenNotMatchedThenInsert(FIELD_ID1, FIELD_NAME1, FIELD_DATE1)
              .values(1, "name", new Date(0));

        assertEquals("merge into \"TABLE1\" using (select \"TABLE2\".\"ID2\" from \"TABLE2\") on ((\"TABLE2\".\"ID2\" = \"TABLE1\".\"ID1\" and \"TABLE1\".\"ID1\" = 1) or \"TABLE2\".\"ID2\" = 2) when matched then update set \"NAME1\" = 'name', \"DATE1\" = '1970-01-01' when not matched then insert (\"ID1\", \"NAME1\", \"DATE1\") values (1, 'name', '1970-01-01')", r_refI().render(q));
        assertEquals("merge into \"TABLE1\" using (select \"TABLE2\".\"ID2\" from \"TABLE2\") on ((\"TABLE2\".\"ID2\" = \"TABLE1\".\"ID1\" and \"TABLE1\".\"ID1\" = ?) or \"TABLE2\".\"ID2\" = ?) when matched then update set \"NAME1\" = ?, \"DATE1\" = ? when not matched then insert (\"ID1\", \"NAME1\", \"DATE1\") values (?, ?, ?)", r_ref().render(q));

        context.checking(new Expectations() {{
            oneOf(statement).setInt(1, 1);
            oneOf(statement).setInt(2, 2);
            oneOf(statement).setString(3, "name");
            oneOf(statement).setDate(4, new Date(0));
            oneOf(statement).setInt(5, 1);
            oneOf(statement).setString(6, "name");
            oneOf(statement).setDate(7, new Date(0));
        }});

        int i = b_ref().bind(q).peekIndex();
        assertEquals(8, i);

        context.assertIsSatisfied();
    }

    @Test
    public final void testDeleteQuery1() throws Exception {
        DeleteQuery<Table1Record> q = create.deleteQuery(TABLE1);

        assertEquals("delete from \"TABLE1\"", r_refI().render(q));
        assertEquals("delete from \"TABLE1\"", r_ref().render(q));
        assertEquals(q, create.delete(TABLE1));
    }

    @Test
    public final void testDeleteQuery2() throws Exception {
        DeleteQuery<Table1Record> q = create.deleteQuery(TABLE1);

        q.addConditions(create.falseCondition());
        assertEquals("delete from \"TABLE1\" where 1 = 0", r_refI().render(q));
        assertEquals("delete from \"TABLE1\" where 1 = 0", r_ref().render(q));
        assertEquals(q, create.delete(TABLE1).where(create.falseCondition()));
    }

    @Test
    public final void testDeleteQuery3() throws Exception {
        DeleteQuery<Table1Record> q = create.deleteQuery(TABLE1);
        Condition c1 = FIELD_ID1.equal(10);
        Condition c2 = FIELD_ID1.equal(20);

        q.addConditions(c1);
        q.addConditions(c2);
        assertEquals("delete from \"TABLE1\" where (\"TABLE1\".\"ID1\" = 10 and \"TABLE1\".\"ID1\" = 20)", r_refI().render(q));
        assertEquals("delete from \"TABLE1\" where (\"TABLE1\".\"ID1\" = ? and \"TABLE1\".\"ID1\" = ?)", r_ref().render(q));
        assertEquals(q, create.delete(TABLE1).where(c1, c2));

        context.checking(new Expectations() {{
            oneOf(statement).setInt(1, 10);
            oneOf(statement).setInt(2, 20);
        }});

        int i = b_ref().bind(q).peekIndex();
        assertEquals(3, i);

        context.assertIsSatisfied();
    }

    @Test
    public final void testDeleteQuery4() throws Exception {
        DeleteQuery<Table1Record> q = create.deleteQuery(TABLE1);
        Condition c1 = FIELD_ID1.equal(10);
        Condition c2 = FIELD_ID1.equal(20);

        q.addConditions(c1);
        q.addConditions(c2);
        q.addConditions(c2, c1);
        assertEquals("delete from \"TABLE1\" where (\"TABLE1\".\"ID1\" = 10 and \"TABLE1\".\"ID1\" = 20 and \"TABLE1\".\"ID1\" = 20 and \"TABLE1\".\"ID1\" = 10)", r_refI().render(q));
        assertEquals("delete from \"TABLE1\" where (\"TABLE1\".\"ID1\" = ? and \"TABLE1\".\"ID1\" = ? and \"TABLE1\".\"ID1\" = ? and \"TABLE1\".\"ID1\" = ?)", r_ref().render(q));
        assertEquals(q, create.delete(TABLE1).where(c1, c2).and(c2).and(c1));

        context.checking(new Expectations() {{
            oneOf(statement).setInt(1, 10);
            oneOf(statement).setInt(2, 20);
            oneOf(statement).setInt(3, 20);
            oneOf(statement).setInt(4, 10);
        }});

        int i = b_ref().bind(q).peekIndex();
        assertEquals(5, i);

        context.assertIsSatisfied();
    }

    @Test
    public final void testConditionalSelectQuery1() throws Exception {
        Select<?> q = create.selectQuery();
        Select<?> s = create.select();

        assertEquals("select 1 from dual", r_refI().render(q));
        assertEquals("select 1 from dual", r_ref().render(q));
        assertEquals(q, s);
    }

    @Test
    public final void testConditionalSelectQuery2() throws Exception {
        SelectQuery q = create.selectQuery();

        q.addConditions(create.falseCondition());
        assertEquals("select 1 from dual where 1 = 0", r_refI().render(q));
        assertEquals("select 1 from dual where 1 = 0", r_ref().render(q));
        assertEquals(q, create.select().where(create.falseCondition()));
    }

    @Test
    public final void testConditionalSelectQuery3() throws Exception {
        SelectQuery q = create.selectQuery();

        q.addConditions(create.falseCondition());
        q.addConditions(create.trueCondition());
        assertEquals("select 1 from dual where (1 = 0 and 1 = 1)", r_refI().render(q));
        assertEquals("select 1 from dual where (1 = 0 and 1 = 1)", r_ref().render(q));
        assertEquals(q, create.select().where(create.falseCondition().and(create.trueCondition())));
    }

    @Test
    public final void testConditionalSelectQuery4() throws Exception {
        SelectQuery q = create.selectQuery();
        Condition c1 = FIELD_ID1.equal(10);
        Condition c2 = FIELD_ID1.equal(20);

        q.addConditions(c1);
        q.addConditions(c2);
        q.addConditions(c2, c1);
        assertEquals("select 1 from dual where (\"TABLE1\".\"ID1\" = 10 and \"TABLE1\".\"ID1\" = 20 and \"TABLE1\".\"ID1\" = 20 and \"TABLE1\".\"ID1\" = 10)", r_refI().render(q));
        assertEquals("select 1 from dual where (\"TABLE1\".\"ID1\" = ? and \"TABLE1\".\"ID1\" = ? and \"TABLE1\".\"ID1\" = ? and \"TABLE1\".\"ID1\" = ?)", r_ref().render(q));
        assertEquals(q, create.select().where(c1.and(c2).and(c2.and(c1))));

        context.checking(new Expectations() {{
            oneOf(statement).setInt(1, 10);
            oneOf(statement).setInt(2, 20);
            oneOf(statement).setInt(3, 20);
            oneOf(statement).setInt(4, 10);
        }});

        int i = b_ref().bind(q).peekIndex();
        assertEquals(5, i);

        context.assertIsSatisfied();
    }

    @Test
    public final void testConditionalSelectQuery5() throws Exception {
        SelectQuery q = create.selectQuery();
        Condition c1 = create.condition("\"TABLE1\".\"ID1\" = ?", "10");
        Condition c2 = create.condition("\"TABLE2\".\"ID2\" = 20 or \"TABLE2\".\"ID2\" = ?", 30);

        q.addConditions(c1);
        q.addConditions(c2);
        assertEquals("select 1 from dual where ((\"TABLE1\".\"ID1\" = '10') and (\"TABLE2\".\"ID2\" = 20 or \"TABLE2\".\"ID2\" = 30))", r_refI().render(q));
        assertEquals("select 1 from dual where ((\"TABLE1\".\"ID1\" = ?) and (\"TABLE2\".\"ID2\" = 20 or \"TABLE2\".\"ID2\" = ?))", r_ref().render(q));
        assertEquals(q, create.select().where(c1, c2));

        context.checking(new Expectations() {{
            oneOf(statement).setString(1, "10");
            oneOf(statement).setInt(2, 30);
        }});

        int i = b_ref().bind(q).peekIndex();
        assertEquals(3, i);

        context.assertIsSatisfied();
    }

    @Test
    public final void testDistinctSelectQuery() throws Exception {
        SelectQuery q = create.selectQuery();
        q.addSelect(FIELD_ID1, FIELD_ID2);
        q.setDistinct(true);

        assertEquals("select distinct \"TABLE1\".\"ID1\", \"TABLE2\".\"ID2\" from dual", r_refI().render(q));
        assertEquals("select distinct \"TABLE1\".\"ID1\", \"TABLE2\".\"ID2\" from dual", r_ref().render(q));
        assertEquals(q, create.selectDistinct(FIELD_ID1, FIELD_ID2));

        int i = b_ref().bind(q).peekIndex();
        assertEquals(1, i);
    }

    @Test
    public final void testProductSelectQuery() throws Exception {
        SelectQuery q = create.selectQuery();

        q.addFrom(TABLE1);
        q.addFrom(TABLE2);
        q.addFrom(TABLE3);
        assertEquals("select \"TABLE1\".\"ID1\", \"TABLE1\".\"NAME1\", \"TABLE1\".\"DATE1\", \"TABLE2\".\"ID2\", \"TABLE2\".\"NAME2\", \"TABLE2\".\"DATE2\", \"TABLE3\".\"ID3\", \"TABLE3\".\"NAME3\", \"TABLE3\".\"DATE3\" from \"TABLE1\", \"TABLE2\", \"TABLE3\"", r_refI().render(q));
        assertEquals("select \"TABLE1\".\"ID1\", \"TABLE1\".\"NAME1\", \"TABLE1\".\"DATE1\", \"TABLE2\".\"ID2\", \"TABLE2\".\"NAME2\", \"TABLE2\".\"DATE2\", \"TABLE3\".\"ID3\", \"TABLE3\".\"NAME3\", \"TABLE3\".\"DATE3\" from \"TABLE1\", \"TABLE2\", \"TABLE3\"", r_ref().render(q));
        assertEquals(q, create.select().from(TABLE1, TABLE2, TABLE3));

        int i = b_ref().bind(q).peekIndex();
        assertEquals(1, i);
    }

    @Test
    public final void testJoinSelectQuery() throws Exception {
        SelectQuery q = create.selectQuery();

        q.addFrom(TABLE1);
        q.addJoin(TABLE2);
        assertEquals("select \"TABLE1\".\"ID1\", \"TABLE1\".\"NAME1\", \"TABLE1\".\"DATE1\", \"TABLE2\".\"ID2\", \"TABLE2\".\"NAME2\", \"TABLE2\".\"DATE2\" from \"TABLE1\" join \"TABLE2\" on 1 = 1", r_refI().render(q));
        assertEquals("select \"TABLE1\".\"ID1\", \"TABLE1\".\"NAME1\", \"TABLE1\".\"DATE1\", \"TABLE2\".\"ID2\", \"TABLE2\".\"NAME2\", \"TABLE2\".\"DATE2\" from \"TABLE1\" join \"TABLE2\" on 1 = 1", r_ref().render(q));
        assertEquals(q, create.select().from(TABLE1).join(TABLE2).on());

        int i = b_ref().bind(q).peekIndex();
        assertEquals(1, i);
    }

    @Test
    public final void testJoinOnConditionSelectQuery() throws Exception {
        SelectQuery q = create.selectQuery();
        q.addFrom(TABLE1);
        q.addJoin(TABLE2, FIELD_ID1.equal(FIELD_ID2));

        assertEquals("select \"TABLE1\".\"ID1\", \"TABLE1\".\"NAME1\", \"TABLE1\".\"DATE1\", \"TABLE2\".\"ID2\", \"TABLE2\".\"NAME2\", \"TABLE2\".\"DATE2\" from \"TABLE1\" join \"TABLE2\" on \"TABLE1\".\"ID1\" = \"TABLE2\".\"ID2\"", r_refI().render(q));
        assertEquals("select \"TABLE1\".\"ID1\", \"TABLE1\".\"NAME1\", \"TABLE1\".\"DATE1\", \"TABLE2\".\"ID2\", \"TABLE2\".\"NAME2\", \"TABLE2\".\"DATE2\" from \"TABLE1\" join \"TABLE2\" on \"TABLE1\".\"ID1\" = \"TABLE2\".\"ID2\"", r_ref().render(q));
        assertEquals(q, create.select().from(TABLE1).join(TABLE2).on(FIELD_ID1.equal(FIELD_ID2)));

        q.addJoin(TABLE3, FIELD_ID2.equal(FIELD_ID3));
        assertEquals("select \"TABLE1\".\"ID1\", \"TABLE1\".\"NAME1\", \"TABLE1\".\"DATE1\", \"TABLE2\".\"ID2\", \"TABLE2\".\"NAME2\", \"TABLE2\".\"DATE2\", \"TABLE3\".\"ID3\", \"TABLE3\".\"NAME3\", \"TABLE3\".\"DATE3\" from \"TABLE1\" join \"TABLE2\" on \"TABLE1\".\"ID1\" = \"TABLE2\".\"ID2\" join \"TABLE3\" on \"TABLE2\".\"ID2\" = \"TABLE3\".\"ID3\"", r_refI().render(q));
        assertEquals("select \"TABLE1\".\"ID1\", \"TABLE1\".\"NAME1\", \"TABLE1\".\"DATE1\", \"TABLE2\".\"ID2\", \"TABLE2\".\"NAME2\", \"TABLE2\".\"DATE2\", \"TABLE3\".\"ID3\", \"TABLE3\".\"NAME3\", \"TABLE3\".\"DATE3\" from \"TABLE1\" join \"TABLE2\" on \"TABLE1\".\"ID1\" = \"TABLE2\".\"ID2\" join \"TABLE3\" on \"TABLE2\".\"ID2\" = \"TABLE3\".\"ID3\"", r_ref().render(q));
        assertEquals(q, create.select().from(TABLE1)
                                      .join(TABLE2).on(FIELD_ID1.equal(FIELD_ID2))
                                      .join(TABLE3).on(FIELD_ID2.equal(FIELD_ID3)));

        int i = b_ref().bind(q).peekIndex();
        assertEquals(1, i);
    }

    @Test
    public final void testJoinComplexSelectQuery() throws Exception {
        SelectQuery q = create.selectQuery();

        q.addFrom(TABLE1);
        q.addJoin(TABLE2,
                FIELD_ID1.equal(FIELD_ID2),
                FIELD_ID1.equal(1),
                FIELD_ID2.in(1, 2, 3));
        q.addConditions(FIELD_ID1.equal(5));

        assertEquals("select \"TABLE1\".\"ID1\", \"TABLE1\".\"NAME1\", \"TABLE1\".\"DATE1\", \"TABLE2\".\"ID2\", \"TABLE2\".\"NAME2\", \"TABLE2\".\"DATE2\" from \"TABLE1\" join \"TABLE2\" on (\"TABLE1\".\"ID1\" = \"TABLE2\".\"ID2\" and \"TABLE1\".\"ID1\" = 1 and \"TABLE2\".\"ID2\" in (1, 2, 3)) where \"TABLE1\".\"ID1\" = 5", r_refI().render(q));
        assertEquals("select \"TABLE1\".\"ID1\", \"TABLE1\".\"NAME1\", \"TABLE1\".\"DATE1\", \"TABLE2\".\"ID2\", \"TABLE2\".\"NAME2\", \"TABLE2\".\"DATE2\" from \"TABLE1\" join \"TABLE2\" on (\"TABLE1\".\"ID1\" = \"TABLE2\".\"ID2\" and \"TABLE1\".\"ID1\" = ? and \"TABLE2\".\"ID2\" in (?, ?, ?)) where \"TABLE1\".\"ID1\" = ?", r_ref().render(q));

        // Join using a single condition
        assertEquals(q, create.select().from(TABLE1)
                                       .join(TABLE2)
                                       .on(FIELD_ID1.equal(FIELD_ID2)
                                       .and(FIELD_ID1.equal(1))
                                       .and(FIELD_ID2.in(1, 2, 3)))
                                       .where(FIELD_ID1.equal(5)));

        // Join using several conditions
        assertEquals(q, create.select().from(TABLE1)
                                       .join(TABLE2)
                                       .on(FIELD_ID1.equal(FIELD_ID2))
                                       .and(FIELD_ID1.equal(1))
                                       .and(FIELD_ID2.in(1, 2, 3))
                                       .where(FIELD_ID1.equal(5)));

        q.addJoin(TABLE3, FIELD_ID2.equal(FIELD_ID3));
        assertEquals("select \"TABLE1\".\"ID1\", \"TABLE1\".\"NAME1\", \"TABLE1\".\"DATE1\", \"TABLE2\".\"ID2\", \"TABLE2\".\"NAME2\", \"TABLE2\".\"DATE2\", \"TABLE3\".\"ID3\", \"TABLE3\".\"NAME3\", \"TABLE3\".\"DATE3\" from \"TABLE1\" join \"TABLE2\" on (\"TABLE1\".\"ID1\" = \"TABLE2\".\"ID2\" and \"TABLE1\".\"ID1\" = 1 and \"TABLE2\".\"ID2\" in (1, 2, 3)) join \"TABLE3\" on \"TABLE2\".\"ID2\" = \"TABLE3\".\"ID3\" where \"TABLE1\".\"ID1\" = 5", r_refI().render(q));
        assertEquals("select \"TABLE1\".\"ID1\", \"TABLE1\".\"NAME1\", \"TABLE1\".\"DATE1\", \"TABLE2\".\"ID2\", \"TABLE2\".\"NAME2\", \"TABLE2\".\"DATE2\", \"TABLE3\".\"ID3\", \"TABLE3\".\"NAME3\", \"TABLE3\".\"DATE3\" from \"TABLE1\" join \"TABLE2\" on (\"TABLE1\".\"ID1\" = \"TABLE2\".\"ID2\" and \"TABLE1\".\"ID1\" = ? and \"TABLE2\".\"ID2\" in (?, ?, ?)) join \"TABLE3\" on \"TABLE2\".\"ID2\" = \"TABLE3\".\"ID3\" where \"TABLE1\".\"ID1\" = ?", r_ref().render(q));
        assertEquals(q, create.select().from(TABLE1)
                                .join(TABLE2).on(FIELD_ID1.equal(FIELD_ID2)
                                            .and(FIELD_ID1.equal(1))
                                            .and(FIELD_ID2.in(1, 2, 3)))
                                .join(TABLE3).on(FIELD_ID2.equal(FIELD_ID3))
                                .where(FIELD_ID1.equal(5)));

        context.checking(new Expectations() {{
            oneOf(statement).setInt(1, 1);
            oneOf(statement).setInt(2, 1);
            oneOf(statement).setInt(3, 2);
            oneOf(statement).setInt(4, 3);
            oneOf(statement).setInt(5, 5);
        }});

        int i = b_ref().bind(q).peekIndex();
        assertEquals(6, i);

        context.assertIsSatisfied();
    }

    @Test
    public final void testJoinSelf() throws Exception {
        Table<Table1Record> t1 = TABLE1.as("t1");
        Table<Table1Record> t2 = TABLE1.as("t2");

        SelectQuery q = create.selectQuery();
        q.addFrom(t1);
        q.addJoin(t2, t1.getField(FIELD_ID1).equal(t2.getField(FIELD_ID1)));

        assertEquals("select \"t1\".\"ID1\", \"t1\".\"NAME1\", \"t1\".\"DATE1\", \"t2\".\"ID1\", \"t2\".\"NAME1\", \"t2\".\"DATE1\" from \"TABLE1\" \"t1\" join \"TABLE1\" \"t2\" on \"t1\".\"ID1\" = \"t2\".\"ID1\"", r_refI().render(q));
        assertEquals("select \"t1\".\"ID1\", \"t1\".\"NAME1\", \"t1\".\"DATE1\", \"t2\".\"ID1\", \"t2\".\"NAME1\", \"t2\".\"DATE1\" from \"TABLE1\" \"t1\" join \"TABLE1\" \"t2\" on \"t1\".\"ID1\" = \"t2\".\"ID1\"", r_ref().render(q));
        assertEquals(q, create.select().from(t1)
                                .join(t2).on(t1.getField(FIELD_ID1).equal(
                                             t2.getField(FIELD_ID1))));

        int i = b_ref().bind(q).peekIndex();
        assertEquals(1, i);
    }

    @Test
    public final void testJoinTypeSelectQuery() throws Exception {
        SelectQuery q = create.selectQuery();
        q.addFrom(TABLE1);
        q.addJoin(TABLE2, LEFT_OUTER_JOIN, FIELD_ID1.equal(FIELD_ID2));
        assertEquals("select \"TABLE1\".\"ID1\", \"TABLE1\".\"NAME1\", \"TABLE1\".\"DATE1\", \"TABLE2\".\"ID2\", \"TABLE2\".\"NAME2\", \"TABLE2\".\"DATE2\" from \"TABLE1\" left outer join \"TABLE2\" on \"TABLE1\".\"ID1\" = \"TABLE2\".\"ID2\"", r_refI().render(q));
        assertEquals("select \"TABLE1\".\"ID1\", \"TABLE1\".\"NAME1\", \"TABLE1\".\"DATE1\", \"TABLE2\".\"ID2\", \"TABLE2\".\"NAME2\", \"TABLE2\".\"DATE2\" from \"TABLE1\" left outer join \"TABLE2\" on \"TABLE1\".\"ID1\" = \"TABLE2\".\"ID2\"", r_ref().render(q));
        assertEquals(q, create.select().from(TABLE1).leftOuterJoin(TABLE2).on(FIELD_ID1.equal(FIELD_ID2)));

        int i = b_ref().bind(q).peekIndex();
        assertEquals(1, i);
    }

    @Test
    public final void testGroupSelectQuery() throws Exception {
        SelectQuery q = create.selectQuery();
        q.addFrom(TABLE1);

        q.addGroupBy(FIELD_ID1);
        assertEquals("select \"TABLE1\".\"ID1\", \"TABLE1\".\"NAME1\", \"TABLE1\".\"DATE1\" from \"TABLE1\" group by \"TABLE1\".\"ID1\"", r_refI().render(q));
        assertEquals("select \"TABLE1\".\"ID1\", \"TABLE1\".\"NAME1\", \"TABLE1\".\"DATE1\" from \"TABLE1\" group by \"TABLE1\".\"ID1\"", r_ref().render(q));
        assertEquals(q, create.select().from(TABLE1).groupBy(FIELD_ID1));

        q.addGroupBy(FIELD_ID2, FIELD_ID3);
        assertEquals("select \"TABLE1\".\"ID1\", \"TABLE1\".\"NAME1\", \"TABLE1\".\"DATE1\" from \"TABLE1\" group by \"TABLE1\".\"ID1\", \"TABLE2\".\"ID2\", \"TABLE3\".\"ID3\"", r_refI().render(q));
        assertEquals("select \"TABLE1\".\"ID1\", \"TABLE1\".\"NAME1\", \"TABLE1\".\"DATE1\" from \"TABLE1\" group by \"TABLE1\".\"ID1\", \"TABLE2\".\"ID2\", \"TABLE3\".\"ID3\"", r_ref().render(q));
        assertEquals(q, create.select().from(TABLE1).groupBy(FIELD_ID1, FIELD_ID2, FIELD_ID3));

        q.addHaving(FIELD_ID1.equal(1));
        assertEquals("select \"TABLE1\".\"ID1\", \"TABLE1\".\"NAME1\", \"TABLE1\".\"DATE1\" from \"TABLE1\" group by \"TABLE1\".\"ID1\", \"TABLE2\".\"ID2\", \"TABLE3\".\"ID3\" having \"TABLE1\".\"ID1\" = 1", r_refI().render(q));
        assertEquals("select \"TABLE1\".\"ID1\", \"TABLE1\".\"NAME1\", \"TABLE1\".\"DATE1\" from \"TABLE1\" group by \"TABLE1\".\"ID1\", \"TABLE2\".\"ID2\", \"TABLE3\".\"ID3\" having \"TABLE1\".\"ID1\" = ?", r_ref().render(q));
        assertEquals(q, create.select().from(TABLE1)
                                  .groupBy(FIELD_ID1, FIELD_ID2, FIELD_ID3)
                                  .having(FIELD_ID1.equal(1)));

        q.addHaving(Operator.OR, FIELD_ID1.equal(2));
        assertEquals("select \"TABLE1\".\"ID1\", \"TABLE1\".\"NAME1\", \"TABLE1\".\"DATE1\" from \"TABLE1\" group by \"TABLE1\".\"ID1\", \"TABLE2\".\"ID2\", \"TABLE3\".\"ID3\" having (\"TABLE1\".\"ID1\" = 1 or \"TABLE1\".\"ID1\" = 2)", r_refI().render(q));
        assertEquals("select \"TABLE1\".\"ID1\", \"TABLE1\".\"NAME1\", \"TABLE1\".\"DATE1\" from \"TABLE1\" group by \"TABLE1\".\"ID1\", \"TABLE2\".\"ID2\", \"TABLE3\".\"ID3\" having (\"TABLE1\".\"ID1\" = ? or \"TABLE1\".\"ID1\" = ?)", r_ref().render(q));
        assertEquals(q, create.select().from(TABLE1)
                                  .groupBy(FIELD_ID1, FIELD_ID2, FIELD_ID3)
                                  .having(FIELD_ID1.equal(1))
                                  .or(FIELD_ID1.equal(2)));

        q.addHaving(Operator.OR, FIELD_ID1.equal(3));
        assertEquals("select \"TABLE1\".\"ID1\", \"TABLE1\".\"NAME1\", \"TABLE1\".\"DATE1\" from \"TABLE1\" group by \"TABLE1\".\"ID1\", \"TABLE2\".\"ID2\", \"TABLE3\".\"ID3\" having (\"TABLE1\".\"ID1\" = 1 or \"TABLE1\".\"ID1\" = 2 or \"TABLE1\".\"ID1\" = 3)", r_refI().render(q));
        assertEquals("select \"TABLE1\".\"ID1\", \"TABLE1\".\"NAME1\", \"TABLE1\".\"DATE1\" from \"TABLE1\" group by \"TABLE1\".\"ID1\", \"TABLE2\".\"ID2\", \"TABLE3\".\"ID3\" having (\"TABLE1\".\"ID1\" = ? or \"TABLE1\".\"ID1\" = ? or \"TABLE1\".\"ID1\" = ?)", r_ref().render(q));
        assertEquals(q, create.select().from(TABLE1)
                                  .groupBy(FIELD_ID1, FIELD_ID2, FIELD_ID3)
                                  .having(FIELD_ID1.equal(1))
                                  .or(FIELD_ID1.equal(2))
                                  .or(FIELD_ID1.equal(3)));

        q.addHaving(FIELD_ID1.in(1, 2, 3));
        assertEquals("select \"TABLE1\".\"ID1\", \"TABLE1\".\"NAME1\", \"TABLE1\".\"DATE1\" from \"TABLE1\" group by \"TABLE1\".\"ID1\", \"TABLE2\".\"ID2\", \"TABLE3\".\"ID3\" having ((\"TABLE1\".\"ID1\" = 1 or \"TABLE1\".\"ID1\" = 2 or \"TABLE1\".\"ID1\" = 3) and \"TABLE1\".\"ID1\" in (1, 2, 3))", r_refI().render(q));
        assertEquals("select \"TABLE1\".\"ID1\", \"TABLE1\".\"NAME1\", \"TABLE1\".\"DATE1\" from \"TABLE1\" group by \"TABLE1\".\"ID1\", \"TABLE2\".\"ID2\", \"TABLE3\".\"ID3\" having ((\"TABLE1\".\"ID1\" = ? or \"TABLE1\".\"ID1\" = ? or \"TABLE1\".\"ID1\" = ?) and \"TABLE1\".\"ID1\" in (?, ?, ?))", r_ref().render(q));
        assertEquals(q, create.select().from(TABLE1)
                                  .groupBy(FIELD_ID1, FIELD_ID2, FIELD_ID3)
                                  .having(FIELD_ID1.equal(1))
                                  .or(FIELD_ID1.equal(2))
                                  .or(FIELD_ID1.equal(3))
                                  .and(FIELD_ID1.in(1, 2, 3)));

        context.checking(new Expectations() {{
            oneOf(statement).setInt(1, 1);
            oneOf(statement).setInt(2, 2);
            oneOf(statement).setInt(3, 3);
            oneOf(statement).setInt(4, 1);
            oneOf(statement).setInt(5, 2);
            oneOf(statement).setInt(6, 3);
        }});

        int i = b_ref().bind(q).peekIndex();
        assertEquals(7, i);

        context.assertIsSatisfied();
    }

    @Test
    public final void testOrderSelectQuery() throws Exception {
        SimpleSelectQuery<Table1Record> q = create.selectQuery(TABLE1);

        q.addOrderBy(FIELD_ID1);
        assertEquals("select \"TABLE1\".\"ID1\", \"TABLE1\".\"NAME1\", \"TABLE1\".\"DATE1\" from \"TABLE1\" order by \"TABLE1\".\"ID1\" asc", r_refI().render(q));
        assertEquals("select \"TABLE1\".\"ID1\", \"TABLE1\".\"NAME1\", \"TABLE1\".\"DATE1\" from \"TABLE1\" order by \"TABLE1\".\"ID1\" asc", r_ref().render(q));
        assertEquals(q, create.selectFrom(TABLE1).orderBy(FIELD_ID1));

        q.addOrderBy(FIELD_ID2.desc());
        assertEquals("select \"TABLE1\".\"ID1\", \"TABLE1\".\"NAME1\", \"TABLE1\".\"DATE1\" from \"TABLE1\" order by \"TABLE1\".\"ID1\" asc, \"TABLE2\".\"ID2\" desc", r_refI().render(q));
        assertEquals("select \"TABLE1\".\"ID1\", \"TABLE1\".\"NAME1\", \"TABLE1\".\"DATE1\" from \"TABLE1\" order by \"TABLE1\".\"ID1\" asc, \"TABLE2\".\"ID2\" desc", r_ref().render(q));
        assertEquals(q, create.selectFrom(TABLE1).orderBy(
                                    FIELD_ID1.asc(),
                                    FIELD_ID2.desc()));

        int i = b_ref().bind(q).peekIndex();
        assertEquals(1, i);
    }

    @Test
    public final void testCompleteSelectQuery() throws Exception {
        SelectQuery q = create.selectQuery();
        q.addFrom(TABLE1);
        q.addJoin(TABLE2, FIELD_ID1.equal(FIELD_ID2));
        q.addSelect(FIELD_ID1, FIELD_ID2);
        q.addGroupBy(FIELD_ID1, FIELD_ID2);
        q.addHaving(FIELD_ID1.equal(1));
        q.addOrderBy(FIELD_ID1.asc());
        q.addOrderBy(FIELD_ID2.desc());

        assertEquals("select \"TABLE1\".\"ID1\", \"TABLE2\".\"ID2\" from \"TABLE1\" join \"TABLE2\" on \"TABLE1\".\"ID1\" = \"TABLE2\".\"ID2\" group by \"TABLE1\".\"ID1\", \"TABLE2\".\"ID2\" having \"TABLE1\".\"ID1\" = 1 order by \"TABLE1\".\"ID1\" asc, \"TABLE2\".\"ID2\" desc", r_refI().render(q));
        assertEquals("select \"TABLE1\".\"ID1\", \"TABLE2\".\"ID2\" from \"TABLE1\" join \"TABLE2\" on \"TABLE1\".\"ID1\" = \"TABLE2\".\"ID2\" group by \"TABLE1\".\"ID1\", \"TABLE2\".\"ID2\" having \"TABLE1\".\"ID1\" = ? order by \"TABLE1\".\"ID1\" asc, \"TABLE2\".\"ID2\" desc", r_ref().render(q));
        assertEquals(q, create.select(FIELD_ID1, FIELD_ID2)
                          .from(TABLE1)
                          .join(TABLE2).on(FIELD_ID1.equal(FIELD_ID2))
                          .groupBy(FIELD_ID1, FIELD_ID2)
                          .having(FIELD_ID1.equal(1))
                          .orderBy(
                              FIELD_ID1.asc(),
                              FIELD_ID2.desc()));

        context.checking(new Expectations() {{
            oneOf(statement).setInt(1, 1);
        }});

        int i = b_ref().bind(q).peekIndex();
        assertEquals(2, i);

        context.assertIsSatisfied();
    }

    @Test
    public final void testCombinedSelectQuery() throws Exception {
        Select<?> combine = createCombinedSelectQuery();

        assertEquals("(select \"TABLE1\".\"ID1\", \"TABLE1\".\"NAME1\", \"TABLE1\".\"DATE1\" from \"TABLE1\" where \"TABLE1\".\"ID1\" = 1) union (select \"TABLE1\".\"ID1\", \"TABLE1\".\"NAME1\", \"TABLE1\".\"DATE1\" from \"TABLE1\" where \"TABLE1\".\"ID1\" = 2)", r_refI().render(combine));
        assertEquals("(select \"TABLE1\".\"ID1\", \"TABLE1\".\"NAME1\", \"TABLE1\".\"DATE1\" from \"TABLE1\" where \"TABLE1\".\"ID1\" = ?) union (select \"TABLE1\".\"ID1\", \"TABLE1\".\"NAME1\", \"TABLE1\".\"DATE1\" from \"TABLE1\" where \"TABLE1\".\"ID1\" = ?)", r_ref().render(combine));
        assertEquals(combine, createCombinedSelect());

        combine = create
            .select(createCombinedSelectQuery().getField(FIELD_ID1))
            .from(createCombinedSelectQuery())
            .orderBy(FIELD_ID1);

        Pattern p = Pattern.compile("\"alias_\\d+\"");
        Matcher m = p.matcher(r_ref().render(combine));
        m.find();
        String match = m.group();

        assertEquals("select " + match + ".\"ID1\" from ((select \"TABLE1\".\"ID1\", \"TABLE1\".\"NAME1\", \"TABLE1\".\"DATE1\" from \"TABLE1\" where \"TABLE1\".\"ID1\" = 1) union (select \"TABLE1\".\"ID1\", \"TABLE1\".\"NAME1\", \"TABLE1\".\"DATE1\" from \"TABLE1\" where \"TABLE1\".\"ID1\" = 2)) " + match + " order by \"TABLE1\".\"ID1\" asc", r_refI().render(combine));
        assertEquals("select " + match + ".\"ID1\" from ((select \"TABLE1\".\"ID1\", \"TABLE1\".\"NAME1\", \"TABLE1\".\"DATE1\" from \"TABLE1\" where \"TABLE1\".\"ID1\" = ?) union (select \"TABLE1\".\"ID1\", \"TABLE1\".\"NAME1\", \"TABLE1\".\"DATE1\" from \"TABLE1\" where \"TABLE1\".\"ID1\" = ?)) " + match + " order by \"TABLE1\".\"ID1\" asc", r_ref().render(combine));

        combine = createCombinedSelectQuery();
        combine = create.select()
            .from(createCombinedSelectQuery())
            .join(TABLE2).on(FIELD_ID1.equal(FIELD_ID2))
            .orderBy(FIELD_ID1);
        assertEquals("select " + match + ".\"ID1\", " + match + ".\"NAME1\", " + match + ".\"DATE1\", \"TABLE2\".\"ID2\", \"TABLE2\".\"NAME2\", \"TABLE2\".\"DATE2\" from ((select \"TABLE1\".\"ID1\", \"TABLE1\".\"NAME1\", \"TABLE1\".\"DATE1\" from \"TABLE1\" where \"TABLE1\".\"ID1\" = 1) union (select \"TABLE1\".\"ID1\", \"TABLE1\".\"NAME1\", \"TABLE1\".\"DATE1\" from \"TABLE1\" where \"TABLE1\".\"ID1\" = 2)) " + match + " join \"TABLE2\" on \"TABLE1\".\"ID1\" = \"TABLE2\".\"ID2\" order by \"TABLE1\".\"ID1\" asc", r_refI().render(combine));
        assertEquals("select " + match + ".\"ID1\", " + match + ".\"NAME1\", " + match + ".\"DATE1\", \"TABLE2\".\"ID2\", \"TABLE2\".\"NAME2\", \"TABLE2\".\"DATE2\" from ((select \"TABLE1\".\"ID1\", \"TABLE1\".\"NAME1\", \"TABLE1\".\"DATE1\" from \"TABLE1\" where \"TABLE1\".\"ID1\" = ?) union (select \"TABLE1\".\"ID1\", \"TABLE1\".\"NAME1\", \"TABLE1\".\"DATE1\" from \"TABLE1\" where \"TABLE1\".\"ID1\" = ?)) " + match + " join \"TABLE2\" on \"TABLE1\".\"ID1\" = \"TABLE2\".\"ID2\" order by \"TABLE1\".\"ID1\" asc", r_ref().render(combine));

        context.checking(new Expectations() {{
            oneOf(statement).setInt(1, 1);
            oneOf(statement).setInt(2, 2);
        }});

        int i = b_ref().bind(combine).peekIndex();
        assertEquals(3, i);

        context.assertIsSatisfied();
    }

    private Select<?> createCombinedSelectQuery() {
        SelectQuery q1 = create.selectQuery();
        SelectQuery q2 = create.selectQuery();

        q1.addFrom(TABLE1);
        q2.addFrom(TABLE1);

        q1.addConditions(FIELD_ID1.equal(1));
        q2.addConditions(FIELD_ID1.equal(2));

        return q1.union(q2);
    }

    private Select<?> createCombinedSelect() {
        SelectFinalStep q1 = create.select().from(TABLE1).where(FIELD_ID1.equal(1));
        SelectFinalStep q2 = create.select().from(TABLE1).where(FIELD_ID1.equal(2));

        return q1.union(q2);
    }

    @Test
    public final void testInnerSelect1() throws Exception {
        SimpleSelectQuery<Table1Record> q1 = create.selectQuery(TABLE1);
        SimpleSelectQuery<Table1Record> q2 = create.selectQuery(q1.asTable().as("inner_temp_table"));
        SimpleSelectQuery<Table1Record> q3 = create.selectQuery(q2.asTable().as("outer_temp_table"));

        assertEquals("select \"inner_temp_table\".\"ID1\", \"inner_temp_table\".\"NAME1\", \"inner_temp_table\".\"DATE1\" from (select \"TABLE1\".\"ID1\", \"TABLE1\".\"NAME1\", \"TABLE1\".\"DATE1\" from \"TABLE1\") \"inner_temp_table\"", r_refI().render(q2));
        assertEquals("select \"inner_temp_table\".\"ID1\", \"inner_temp_table\".\"NAME1\", \"inner_temp_table\".\"DATE1\" from (select \"TABLE1\".\"ID1\", \"TABLE1\".\"NAME1\", \"TABLE1\".\"DATE1\" from \"TABLE1\") \"inner_temp_table\"", r_ref().render(q2));

        assertEquals("select \"outer_temp_table\".\"ID1\", \"outer_temp_table\".\"NAME1\", \"outer_temp_table\".\"DATE1\" from (select \"inner_temp_table\".\"ID1\", \"inner_temp_table\".\"NAME1\", \"inner_temp_table\".\"DATE1\" from (select \"TABLE1\".\"ID1\", \"TABLE1\".\"NAME1\", \"TABLE1\".\"DATE1\" from \"TABLE1\") \"inner_temp_table\") \"outer_temp_table\"", r_refI().render(q3));
        assertEquals("select \"outer_temp_table\".\"ID1\", \"outer_temp_table\".\"NAME1\", \"outer_temp_table\".\"DATE1\" from (select \"inner_temp_table\".\"ID1\", \"inner_temp_table\".\"NAME1\", \"inner_temp_table\".\"DATE1\" from (select \"TABLE1\".\"ID1\", \"TABLE1\".\"NAME1\", \"TABLE1\".\"DATE1\" from \"TABLE1\") \"inner_temp_table\") \"outer_temp_table\"", r_ref().render(q3));
    }

    @Test
    public final void testInnerSelect2() throws Exception {
        SelectQuery q1 = create.selectQuery();
        SelectQuery q2 = create.selectQuery();

        q1.addFrom(TABLE1);
        q2.addFrom(TABLE2);

        q1.addSelect(FIELD_ID1.as("inner_id1"));
        q2.addSelect(FIELD_ID2.as("outer_id2"));
        q2.addSelect(q1.asField().as("outer_id1"));

        assertEquals("select \"TABLE2\".\"ID2\" \"outer_id2\", (select \"TABLE1\".\"ID1\" \"inner_id1\" from \"TABLE1\") \"outer_id1\" from \"TABLE2\"", r_refI().render(q2));
        assertEquals("select \"TABLE2\".\"ID2\" \"outer_id2\", (select \"TABLE1\".\"ID1\" \"inner_id1\" from \"TABLE1\") \"outer_id1\" from \"TABLE2\"", r_ref().render(q2));
    }

    @Test
    public final void testInnerSelect3() throws Exception {
        SelectQuery q1 = create.selectQuery();
        SelectQuery q2 = create.selectQuery();

        q1.addFrom(TABLE1);
        q2.addFrom(TABLE2);

        q2.addSelect(FIELD_ID2);
        q1.addConditions(FIELD_ID1.in(q2));

        assertEquals("select \"TABLE1\".\"ID1\", \"TABLE1\".\"NAME1\", \"TABLE1\".\"DATE1\" from \"TABLE1\" where \"TABLE1\".\"ID1\" in (select \"TABLE2\".\"ID2\" from \"TABLE2\")", r_refI().render(q1));
        assertEquals("select \"TABLE1\".\"ID1\", \"TABLE1\".\"NAME1\", \"TABLE1\".\"DATE1\" from \"TABLE1\" where \"TABLE1\".\"ID1\" in (select \"TABLE2\".\"ID2\" from \"TABLE2\")", r_ref().render(q1));
    }

    @Test
    public final void testInnerSelect4() throws Exception {
        SelectQuery q1 = create.selectQuery();
        SelectQuery q2 = create.selectQuery();

        q1.addFrom(TABLE1);
        q2.addFrom(TABLE2);

        q2.addSelect(FIELD_ID2);
        q1.addConditions(FIELD_ID1.equal(q2));

        assertEquals("select \"TABLE1\".\"ID1\", \"TABLE1\".\"NAME1\", \"TABLE1\".\"DATE1\" from \"TABLE1\" where \"TABLE1\".\"ID1\" = (select \"TABLE2\".\"ID2\" from \"TABLE2\")", r_refI().render(q1));
        assertEquals("select \"TABLE1\".\"ID1\", \"TABLE1\".\"NAME1\", \"TABLE1\".\"DATE1\" from \"TABLE1\" where \"TABLE1\".\"ID1\" = (select \"TABLE2\".\"ID2\" from \"TABLE2\")", r_ref().render(q1));
    }

    @Test
    public final void testInnerSelect5() throws Exception {
        SelectQuery q1 = create.selectQuery();
        SelectQuery q2 = create.selectQuery();

        q1.addFrom(TABLE1);
        q2.addFrom(TABLE2);

        q2.addSelect(FIELD_ID2);
        q1.addConditions(FIELD_ID1.greaterThanAny(q2));

        assertEquals("select \"TABLE1\".\"ID1\", \"TABLE1\".\"NAME1\", \"TABLE1\".\"DATE1\" from \"TABLE1\" where \"TABLE1\".\"ID1\" > any (select \"TABLE2\".\"ID2\" from \"TABLE2\")", r_refI().render(q1));
        assertEquals("select \"TABLE1\".\"ID1\", \"TABLE1\".\"NAME1\", \"TABLE1\".\"DATE1\" from \"TABLE1\" where \"TABLE1\".\"ID1\" > any (select \"TABLE2\".\"ID2\" from \"TABLE2\")", r_ref().render(q1));
    }

    @Test
    public final void testInnerSelect6() throws Exception {
        SelectQuery q1 = create.selectQuery();
        SelectQuery q2 = create.selectQuery();

        q1.addFrom(TABLE1);
        q2.addFrom(TABLE2);

        q2.addSelect(FIELD_ID2);
        q1.addConditions(create.exists(q2));

        assertEquals("select \"TABLE1\".\"ID1\", \"TABLE1\".\"NAME1\", \"TABLE1\".\"DATE1\" from \"TABLE1\" where exists (select \"TABLE2\".\"ID2\" from \"TABLE2\")", r_refI().render(q1));
        assertEquals("select \"TABLE1\".\"ID1\", \"TABLE1\".\"NAME1\", \"TABLE1\".\"DATE1\" from \"TABLE1\" where exists (select \"TABLE2\".\"ID2\" from \"TABLE2\")", r_ref().render(q1));
    }
}
