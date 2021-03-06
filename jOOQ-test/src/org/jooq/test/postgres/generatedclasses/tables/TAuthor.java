/**
 * This class is generated by jOOQ
 */
package org.jooq.test.postgres.generatedclasses.tables;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = {"http://www.jooq.org", "2.0.0"},
                            comments = "This class is generated by jOOQ")
public class TAuthor extends org.jooq.impl.UpdatableTableImpl<org.jooq.test.postgres.generatedclasses.tables.records.TAuthorRecord> {

	private static final long serialVersionUID = -1190688160;

	/**
	 * The singleton instance of t_author
	 */
	public static final org.jooq.test.postgres.generatedclasses.tables.TAuthor T_AUTHOR = new org.jooq.test.postgres.generatedclasses.tables.TAuthor();

	/**
	 * The class holding records for this type
	 */
	private static final java.lang.Class<org.jooq.test.postgres.generatedclasses.tables.records.TAuthorRecord> __RECORD_TYPE = org.jooq.test.postgres.generatedclasses.tables.records.TAuthorRecord.class;

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<org.jooq.test.postgres.generatedclasses.tables.records.TAuthorRecord> getRecordType() {
		return __RECORD_TYPE;
	}

	/**
	 * An uncommented item
	 * 
	 * PRIMARY KEY
	 */
	public final org.jooq.TableField<org.jooq.test.postgres.generatedclasses.tables.records.TAuthorRecord, java.lang.Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER, this);

	/**
	 * An uncommented item
	 */
	public final org.jooq.TableField<org.jooq.test.postgres.generatedclasses.tables.records.TAuthorRecord, java.lang.String> FIRST_NAME = createField("first_name", org.jooq.impl.SQLDataType.VARCHAR, this);

	/**
	 * An uncommented item
	 */
	public final org.jooq.TableField<org.jooq.test.postgres.generatedclasses.tables.records.TAuthorRecord, java.lang.String> LAST_NAME = createField("last_name", org.jooq.impl.SQLDataType.VARCHAR, this);

	/**
	 * An uncommented item
	 */
	public final org.jooq.TableField<org.jooq.test.postgres.generatedclasses.tables.records.TAuthorRecord, java.sql.Date> DATE_OF_BIRTH = createField("date_of_birth", org.jooq.impl.SQLDataType.DATE, this);

	/**
	 * An uncommented item
	 */
	public final org.jooq.TableField<org.jooq.test.postgres.generatedclasses.tables.records.TAuthorRecord, java.lang.Integer> YEAR_OF_BIRTH = createField("year_of_birth", org.jooq.impl.SQLDataType.INTEGER, this);

	/**
	 * An uncommented item
	 */
	public final org.jooq.TableField<org.jooq.test.postgres.generatedclasses.tables.records.TAuthorRecord, org.jooq.test.postgres.generatedclasses.udt.records.UAddressTypeRecord> ADDRESS = createField("address", org.jooq.test.postgres.generatedclasses.udt.UAddressType.U_ADDRESS_TYPE.getDataType(), this);

	/**
	 * No further instances allowed
	 */
	private TAuthor() {
		super("t_author", org.jooq.test.postgres.generatedclasses.Public.PUBLIC);
	}

	/**
	 * No further instances allowed
	 */
	private TAuthor(java.lang.String alias) {
		super(alias, org.jooq.test.postgres.generatedclasses.Public.PUBLIC, org.jooq.test.postgres.generatedclasses.tables.TAuthor.T_AUTHOR);
	}

	@Override
	public org.jooq.UniqueKey<org.jooq.test.postgres.generatedclasses.tables.records.TAuthorRecord> getMainKey() {
		return org.jooq.test.postgres.generatedclasses.Keys.pk_t_author;
	}

	@Override
	@SuppressWarnings("unchecked")
	public java.util.List<org.jooq.UniqueKey<org.jooq.test.postgres.generatedclasses.tables.records.TAuthorRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<org.jooq.test.postgres.generatedclasses.tables.records.TAuthorRecord>>asList(org.jooq.test.postgres.generatedclasses.Keys.pk_t_author);
	}

	@Override
	public org.jooq.test.postgres.generatedclasses.tables.TAuthor as(java.lang.String alias) {
		return new org.jooq.test.postgres.generatedclasses.tables.TAuthor(alias);
	}
}
