/**
 * This class is generated by jOOQ
 */
package org.jooq.test.hsqldb.generatedclasses.tables.records;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = {"http://www.jooq.org", "2.0.0"},
                            comments = "This class is generated by jOOQ")
public class LongRecord extends org.jooq.impl.TableRecordImpl<org.jooq.test.hsqldb.generatedclasses.tables.records.LongRecord> {

	private static final long serialVersionUID = -528268570;

	/**
	 * An uncommented item
	 */
	public void setId(java.lang.Integer value) {
		setValue(org.jooq.test.hsqldb.generatedclasses.tables.Long.LONG.ID, value);
	}

	/**
	 * An uncommented item
	 */
	public java.lang.Integer getId() {
		return getValue(org.jooq.test.hsqldb.generatedclasses.tables.Long.LONG.ID);
	}

	/**
	 * An uncommented item
	 */
	public void setOther(java.lang.Long value) {
		setValue(org.jooq.test.hsqldb.generatedclasses.tables.Long.LONG.OTHER, value);
	}

	/**
	 * An uncommented item
	 */
	public java.lang.Long getOther() {
		return getValue(org.jooq.test.hsqldb.generatedclasses.tables.Long.LONG.OTHER);
	}

	/**
	 * Create a detached LongRecord
	 */
	public LongRecord() {
		super(org.jooq.test.hsqldb.generatedclasses.tables.Long.LONG);
	}
}
