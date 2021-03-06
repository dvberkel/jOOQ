/**
 * This class is generated by jOOQ
 */
package org.jooq.util.mysql.mysql.tables.records;

/**
 * This class is generated by jOOQ.
 *
 * Procedure privileges
 */
@javax.annotation.Generated(value    = {"http://www.jooq.org", "2.0.0"},
                            comments = "This class is generated by jOOQ")
public class ProcsPrivRecord extends org.jooq.impl.TableRecordImpl<org.jooq.util.mysql.mysql.tables.records.ProcsPrivRecord> {

	private static final long serialVersionUID = 2060837023;

	/**
	 * An uncommented item
	 * 
	 * PRIMARY KEY
	 */
	public void setHost(java.lang.String value) {
		setValue(org.jooq.util.mysql.mysql.tables.ProcsPriv.HOST, value);
	}

	/**
	 * An uncommented item
	 * 
	 * PRIMARY KEY
	 */
	public java.lang.String getHost() {
		return getValue(org.jooq.util.mysql.mysql.tables.ProcsPriv.HOST);
	}

	/**
	 * An uncommented item
	 * 
	 * PRIMARY KEY
	 */
	public void setDb(java.lang.String value) {
		setValue(org.jooq.util.mysql.mysql.tables.ProcsPriv.DB, value);
	}

	/**
	 * An uncommented item
	 * 
	 * PRIMARY KEY
	 */
	public java.lang.String getDb() {
		return getValue(org.jooq.util.mysql.mysql.tables.ProcsPriv.DB);
	}

	/**
	 * An uncommented item
	 * 
	 * PRIMARY KEY
	 */
	public void setUser(java.lang.String value) {
		setValue(org.jooq.util.mysql.mysql.tables.ProcsPriv.USER, value);
	}

	/**
	 * An uncommented item
	 * 
	 * PRIMARY KEY
	 */
	public java.lang.String getUser() {
		return getValue(org.jooq.util.mysql.mysql.tables.ProcsPriv.USER);
	}

	/**
	 * An uncommented item
	 * 
	 * PRIMARY KEY
	 */
	public void setRoutineName(java.lang.String value) {
		setValue(org.jooq.util.mysql.mysql.tables.ProcsPriv.ROUTINE_NAME, value);
	}

	/**
	 * An uncommented item
	 * 
	 * PRIMARY KEY
	 */
	public java.lang.String getRoutineName() {
		return getValue(org.jooq.util.mysql.mysql.tables.ProcsPriv.ROUTINE_NAME);
	}

	/**
	 * An uncommented item
	 * 
	 * PRIMARY KEY
	 */
	public void setRoutineType(org.jooq.util.mysql.mysql.enums.ProcsPrivRoutineType value) {
		setValue(org.jooq.util.mysql.mysql.tables.ProcsPriv.ROUTINE_TYPE, value);
	}

	/**
	 * An uncommented item
	 * 
	 * PRIMARY KEY
	 */
	public org.jooq.util.mysql.mysql.enums.ProcsPrivRoutineType getRoutineType() {
		return getValue(org.jooq.util.mysql.mysql.tables.ProcsPriv.ROUTINE_TYPE);
	}

	/**
	 * An uncommented item
	 */
	public void setGrantor(java.lang.String value) {
		setValue(org.jooq.util.mysql.mysql.tables.ProcsPriv.GRANTOR, value);
	}

	/**
	 * An uncommented item
	 */
	public java.lang.String getGrantor() {
		return getValue(org.jooq.util.mysql.mysql.tables.ProcsPriv.GRANTOR);
	}

	/**
	 * An uncommented item
	 */
	public void setProcPriv(java.lang.String value) {
		setValue(org.jooq.util.mysql.mysql.tables.ProcsPriv.PROC_PRIV, value);
	}

	/**
	 * An uncommented item
	 */
	public java.lang.String getProcPriv() {
		return getValue(org.jooq.util.mysql.mysql.tables.ProcsPriv.PROC_PRIV);
	}

	/**
	 * An uncommented item
	 */
	public void setTimestamp(java.sql.Timestamp value) {
		setValue(org.jooq.util.mysql.mysql.tables.ProcsPriv.TIMESTAMP, value);
	}

	/**
	 * An uncommented item
	 */
	public java.sql.Timestamp getTimestamp() {
		return getValue(org.jooq.util.mysql.mysql.tables.ProcsPriv.TIMESTAMP);
	}

	/**
	 * Create a detached ProcsPrivRecord
	 */
	public ProcsPrivRecord() {
		super(org.jooq.util.mysql.mysql.tables.ProcsPriv.PROCS_PRIV);
	}
}
