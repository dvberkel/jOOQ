/**
 * This class is generated by jOOQ
 */
package org.jooq.test.hsqldb.generatedclasses.tables;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = {"http://www.jooq.org", "2.0.0"},
                            comments = "This class is generated by jOOQ")
public class XTestCase_85 extends org.jooq.impl.UpdatableTableImpl<org.jooq.test.hsqldb.generatedclasses.tables.records.XTestCase_85Record> {

	private static final long serialVersionUID = -777129614;

	/**
	 * The singleton instance of X_TEST_CASE_85
	 */
	public static final org.jooq.test.hsqldb.generatedclasses.tables.XTestCase_85 X_TEST_CASE_85 = new org.jooq.test.hsqldb.generatedclasses.tables.XTestCase_85();

	/**
	 * The class holding records for this type
	 */
	private static final java.lang.Class<org.jooq.test.hsqldb.generatedclasses.tables.records.XTestCase_85Record> __RECORD_TYPE = org.jooq.test.hsqldb.generatedclasses.tables.records.XTestCase_85Record.class;

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<org.jooq.test.hsqldb.generatedclasses.tables.records.XTestCase_85Record> getRecordType() {
		return __RECORD_TYPE;
	}

	/**
	 * An uncommented item
	 * 
	 * PRIMARY KEY
	 */
	public final org.jooq.TableField<org.jooq.test.hsqldb.generatedclasses.tables.records.XTestCase_85Record, java.lang.Integer> ID = createField("ID", org.jooq.impl.SQLDataType.INTEGER, this);

	/**
	 * An uncommented item
	 * <p>
	 * <code><pre>
	 * FOREIGN KEY [PUBLIC.X_TEST_CASE_85.X_UNUSED_ID, PUBLIC.X_TEST_CASE_85.X_UNUSED_NAME]
	 * REFERENCES X_UNUSED [PUBLIC.X_UNUSED.ID, PUBLIC.X_UNUSED.NAME]
	 * </pre></code>
	 */
	public final org.jooq.TableField<org.jooq.test.hsqldb.generatedclasses.tables.records.XTestCase_85Record, java.lang.Integer> X_UNUSED_ID = createField("X_UNUSED_ID", org.jooq.impl.SQLDataType.INTEGER, this);

	/**
	 * An uncommented item
	 * <p>
	 * <code><pre>
	 * FOREIGN KEY [PUBLIC.X_TEST_CASE_85.X_UNUSED_ID, PUBLIC.X_TEST_CASE_85.X_UNUSED_NAME]
	 * REFERENCES X_UNUSED [PUBLIC.X_UNUSED.ID, PUBLIC.X_UNUSED.NAME]
	 * </pre></code>
	 */
	public final org.jooq.TableField<org.jooq.test.hsqldb.generatedclasses.tables.records.XTestCase_85Record, java.lang.String> X_UNUSED_NAME = createField("X_UNUSED_NAME", org.jooq.impl.SQLDataType.VARCHAR, this);

	/**
	 * No further instances allowed
	 */
	private XTestCase_85() {
		super("X_TEST_CASE_85", org.jooq.test.hsqldb.generatedclasses.Public.PUBLIC);
	}

	/**
	 * No further instances allowed
	 */
	private XTestCase_85(java.lang.String alias) {
		super(alias, org.jooq.test.hsqldb.generatedclasses.Public.PUBLIC, org.jooq.test.hsqldb.generatedclasses.tables.XTestCase_85.X_TEST_CASE_85);
	}

	@Override
	public org.jooq.UniqueKey<org.jooq.test.hsqldb.generatedclasses.tables.records.XTestCase_85Record> getMainKey() {
		return org.jooq.test.hsqldb.generatedclasses.Keys.PK_X_TEST_CASE_85;
	}

	@Override
	@SuppressWarnings("unchecked")
	public java.util.List<org.jooq.UniqueKey<org.jooq.test.hsqldb.generatedclasses.tables.records.XTestCase_85Record>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<org.jooq.test.hsqldb.generatedclasses.tables.records.XTestCase_85Record>>asList(org.jooq.test.hsqldb.generatedclasses.Keys.PK_X_TEST_CASE_85);
	}

	@Override
	@SuppressWarnings("unchecked")
	public java.util.List<org.jooq.ForeignKey<org.jooq.test.hsqldb.generatedclasses.tables.records.XTestCase_85Record, ?>> getReferences() {
		return java.util.Arrays.<org.jooq.ForeignKey<org.jooq.test.hsqldb.generatedclasses.tables.records.XTestCase_85Record, ?>>asList(org.jooq.test.hsqldb.generatedclasses.Keys.FK_X_TEST_CASE_85);
	}

	@Override
	public org.jooq.test.hsqldb.generatedclasses.tables.XTestCase_85 as(java.lang.String alias) {
		return new org.jooq.test.hsqldb.generatedclasses.tables.XTestCase_85(alias);
	}
}
