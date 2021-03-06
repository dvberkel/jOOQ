/**
 * This class is generated by jOOQ
 */
package org.jooq.test.sybase.generatedclasses.tables;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = {"http://www.jooq.org", "2.0.0"},
                            comments = "This class is generated by jOOQ")
public class XTestCase_71 extends org.jooq.impl.UpdatableTableImpl<org.jooq.test.sybase.generatedclasses.tables.records.XTestCase_71Record> {

	private static final long serialVersionUID = 1069097553;

	/**
	 * The singleton instance of x_test_case_71
	 */
	public static final org.jooq.test.sybase.generatedclasses.tables.XTestCase_71 X_TEST_CASE_71 = new org.jooq.test.sybase.generatedclasses.tables.XTestCase_71();

	/**
	 * The class holding records for this type
	 */
	private static final java.lang.Class<org.jooq.test.sybase.generatedclasses.tables.records.XTestCase_71Record> __RECORD_TYPE = org.jooq.test.sybase.generatedclasses.tables.records.XTestCase_71Record.class;

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<org.jooq.test.sybase.generatedclasses.tables.records.XTestCase_71Record> getRecordType() {
		return __RECORD_TYPE;
	}

	/**
	 * An uncommented item
	 * 
	 * PRIMARY KEY
	 */
	public final org.jooq.TableField<org.jooq.test.sybase.generatedclasses.tables.records.XTestCase_71Record, java.lang.Integer> ID = createField("ID", org.jooq.impl.SQLDataType.INTEGER, this);

	/**
	 * An uncommented item
	 * <p>
	 * <code><pre>
	 * FOREIGN KEY [dba.x_test_case_71.TEST_CASE_64_69_ID]
	 * REFERENCES x_test_case_64_69 [dba.x_test_case_64_69.ID]
	 * </pre></code>
	 */
	public final org.jooq.TableField<org.jooq.test.sybase.generatedclasses.tables.records.XTestCase_71Record, java.lang.Integer> TEST_CASE_64_69_ID = createField("TEST_CASE_64_69_ID", org.jooq.impl.SQLDataType.INTEGER, this);

	/**
	 * No further instances allowed
	 */
	private XTestCase_71() {
		super("x_test_case_71", org.jooq.test.sybase.generatedclasses.Dba.DBA);
	}

	/**
	 * No further instances allowed
	 */
	private XTestCase_71(java.lang.String alias) {
		super(alias, org.jooq.test.sybase.generatedclasses.Dba.DBA, org.jooq.test.sybase.generatedclasses.tables.XTestCase_71.X_TEST_CASE_71);
	}

	@Override
	public org.jooq.UniqueKey<org.jooq.test.sybase.generatedclasses.tables.records.XTestCase_71Record> getMainKey() {
		return org.jooq.test.sybase.generatedclasses.Keys.x_test_case_71_pk_x_test_case_71;
	}

	@Override
	@SuppressWarnings("unchecked")
	public java.util.List<org.jooq.UniqueKey<org.jooq.test.sybase.generatedclasses.tables.records.XTestCase_71Record>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<org.jooq.test.sybase.generatedclasses.tables.records.XTestCase_71Record>>asList(org.jooq.test.sybase.generatedclasses.Keys.x_test_case_71_pk_x_test_case_71);
	}

	@Override
	@SuppressWarnings("unchecked")
	public java.util.List<org.jooq.ForeignKey<org.jooq.test.sybase.generatedclasses.tables.records.XTestCase_71Record, ?>> getReferences() {
		return java.util.Arrays.<org.jooq.ForeignKey<org.jooq.test.sybase.generatedclasses.tables.records.XTestCase_71Record, ?>>asList(org.jooq.test.sybase.generatedclasses.Keys.x_test_case_71_fk_x_test_case_71);
	}

	@Override
	public org.jooq.test.sybase.generatedclasses.tables.XTestCase_71 as(java.lang.String alias) {
		return new org.jooq.test.sybase.generatedclasses.tables.XTestCase_71(alias);
	}
}
