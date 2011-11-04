/**
 * This class is generated by jOOQ
 */
package org.jooq.test.hsqldb.generatedclasses.tables;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = {"http://www.jooq.org", "2.0.0"},
                            comments = "This class is generated by jOOQ")
public class VBook extends org.jooq.impl.TableImpl<org.jooq.test.hsqldb.generatedclasses.tables.records.VBookRecord> {

	private static final long serialVersionUID = 491021662;

	/**
	 * The singleton instance of V_BOOK
	 */
	public static final org.jooq.test.hsqldb.generatedclasses.tables.VBook V_BOOK = new org.jooq.test.hsqldb.generatedclasses.tables.VBook();

	/**
	 * The class holding records for this type
	 */
	private static final java.lang.Class<org.jooq.test.hsqldb.generatedclasses.tables.records.VBookRecord> __RECORD_TYPE = org.jooq.test.hsqldb.generatedclasses.tables.records.VBookRecord.class;

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<org.jooq.test.hsqldb.generatedclasses.tables.records.VBookRecord> getRecordType() {
		return __RECORD_TYPE;
	}

	/**
	 * An uncommented item
	 */
	public static final org.jooq.TableField<org.jooq.test.hsqldb.generatedclasses.tables.records.VBookRecord, java.lang.Integer> ID = new org.jooq.impl.TableFieldImpl<org.jooq.test.hsqldb.generatedclasses.tables.records.VBookRecord, java.lang.Integer>("ID", org.jooq.impl.SQLDataType.INTEGER, V_BOOK);

	/**
	 * An uncommented item
	 */
	public static final org.jooq.TableField<org.jooq.test.hsqldb.generatedclasses.tables.records.VBookRecord, java.lang.Integer> AUTHOR_ID = new org.jooq.impl.TableFieldImpl<org.jooq.test.hsqldb.generatedclasses.tables.records.VBookRecord, java.lang.Integer>("AUTHOR_ID", org.jooq.impl.SQLDataType.INTEGER, V_BOOK);

	/**
	 * An uncommented item
	 */
	public static final org.jooq.TableField<org.jooq.test.hsqldb.generatedclasses.tables.records.VBookRecord, java.lang.Integer> CO_AUTHOR_ID = new org.jooq.impl.TableFieldImpl<org.jooq.test.hsqldb.generatedclasses.tables.records.VBookRecord, java.lang.Integer>("CO_AUTHOR_ID", org.jooq.impl.SQLDataType.INTEGER, V_BOOK);

	/**
	 * An uncommented item
	 */
	public static final org.jooq.TableField<org.jooq.test.hsqldb.generatedclasses.tables.records.VBookRecord, java.lang.Integer> DETAILS_ID = new org.jooq.impl.TableFieldImpl<org.jooq.test.hsqldb.generatedclasses.tables.records.VBookRecord, java.lang.Integer>("DETAILS_ID", org.jooq.impl.SQLDataType.INTEGER, V_BOOK);

	/**
	 * An uncommented item
	 */
	public static final org.jooq.TableField<org.jooq.test.hsqldb.generatedclasses.tables.records.VBookRecord, java.lang.String> TITLE = new org.jooq.impl.TableFieldImpl<org.jooq.test.hsqldb.generatedclasses.tables.records.VBookRecord, java.lang.String>("TITLE", org.jooq.impl.SQLDataType.VARCHAR, V_BOOK);

	/**
	 * An uncommented item
	 */
	public static final org.jooq.TableField<org.jooq.test.hsqldb.generatedclasses.tables.records.VBookRecord, java.lang.Integer> PUBLISHED_IN = new org.jooq.impl.TableFieldImpl<org.jooq.test.hsqldb.generatedclasses.tables.records.VBookRecord, java.lang.Integer>("PUBLISHED_IN", org.jooq.impl.SQLDataType.INTEGER, V_BOOK);

	/**
	 * An uncommented item
	 */
	public static final org.jooq.TableField<org.jooq.test.hsqldb.generatedclasses.tables.records.VBookRecord, java.lang.Integer> LANGUAGE_ID = new org.jooq.impl.TableFieldImpl<org.jooq.test.hsqldb.generatedclasses.tables.records.VBookRecord, java.lang.Integer>("LANGUAGE_ID", org.jooq.impl.SQLDataType.INTEGER, V_BOOK);

	/**
	 * An uncommented item
	 */
	public static final org.jooq.TableField<org.jooq.test.hsqldb.generatedclasses.tables.records.VBookRecord, java.lang.String> CONTENT_TEXT = new org.jooq.impl.TableFieldImpl<org.jooq.test.hsqldb.generatedclasses.tables.records.VBookRecord, java.lang.String>("CONTENT_TEXT", org.jooq.impl.SQLDataType.VARCHAR, V_BOOK);

	/**
	 * An uncommented item
	 */
	public static final org.jooq.TableField<org.jooq.test.hsqldb.generatedclasses.tables.records.VBookRecord, byte[]> CONTENT_PDF = new org.jooq.impl.TableFieldImpl<org.jooq.test.hsqldb.generatedclasses.tables.records.VBookRecord, byte[]>("CONTENT_PDF", org.jooq.impl.SQLDataType.VARBINARY, V_BOOK);

	/**
	 * No further instances allowed
	 */
	private VBook() {
		super("V_BOOK", org.jooq.test.hsqldb.generatedclasses.Public.PUBLIC);
	}
}
