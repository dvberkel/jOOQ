/**
 * This class is generated by jOOQ
 */
package org.jooq.util.sybase.sys.tables.records;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = {"http://www.jooq.org", "2.0.0"},
                            comments = "This class is generated by jOOQ")
public class SysviewRecord extends org.jooq.impl.TableRecordImpl<org.jooq.util.sybase.sys.tables.records.SysviewRecord> {

	private static final long serialVersionUID = -442766547;

	/**
	 * An uncommented item
	 */
	public void setViewObjectId(java.lang.Long value) {
		setValue(org.jooq.util.sybase.sys.tables.Sysview.SYSVIEW.VIEW_OBJECT_ID, value);
	}

	/**
	 * An uncommented item
	 */
	public java.lang.Long getViewObjectId() {
		return getValue(org.jooq.util.sybase.sys.tables.Sysview.SYSVIEW.VIEW_OBJECT_ID);
	}

	/**
	 * An uncommented item
	 */
	public void setViewDef(java.lang.String value) {
		setValue(org.jooq.util.sybase.sys.tables.Sysview.SYSVIEW.VIEW_DEF, value);
	}

	/**
	 * An uncommented item
	 */
	public java.lang.String getViewDef() {
		return getValue(org.jooq.util.sybase.sys.tables.Sysview.SYSVIEW.VIEW_DEF);
	}

	/**
	 * An uncommented item
	 */
	public void setMvBuildType(java.lang.Byte value) {
		setValue(org.jooq.util.sybase.sys.tables.Sysview.SYSVIEW.MV_BUILD_TYPE, value);
	}

	/**
	 * An uncommented item
	 */
	public java.lang.Byte getMvBuildType() {
		return getValue(org.jooq.util.sybase.sys.tables.Sysview.SYSVIEW.MV_BUILD_TYPE);
	}

	/**
	 * An uncommented item
	 */
	public void setMvRefreshType(java.lang.Byte value) {
		setValue(org.jooq.util.sybase.sys.tables.Sysview.SYSVIEW.MV_REFRESH_TYPE, value);
	}

	/**
	 * An uncommented item
	 */
	public java.lang.Byte getMvRefreshType() {
		return getValue(org.jooq.util.sybase.sys.tables.Sysview.SYSVIEW.MV_REFRESH_TYPE);
	}

	/**
	 * An uncommented item
	 */
	public void setMvUseInOptimization(java.lang.Byte value) {
		setValue(org.jooq.util.sybase.sys.tables.Sysview.SYSVIEW.MV_USE_IN_OPTIMIZATION, value);
	}

	/**
	 * An uncommented item
	 */
	public java.lang.Byte getMvUseInOptimization() {
		return getValue(org.jooq.util.sybase.sys.tables.Sysview.SYSVIEW.MV_USE_IN_OPTIMIZATION);
	}

	/**
	 * An uncommented item
	 */
	public void setMvLastRefreshedAt(java.sql.Timestamp value) {
		setValue(org.jooq.util.sybase.sys.tables.Sysview.SYSVIEW.MV_LAST_REFRESHED_AT, value);
	}

	/**
	 * An uncommented item
	 */
	public java.sql.Timestamp getMvLastRefreshedAt() {
		return getValue(org.jooq.util.sybase.sys.tables.Sysview.SYSVIEW.MV_LAST_REFRESHED_AT);
	}

	/**
	 * An uncommented item
	 */
	public void setMvKnownStaleAt(java.sql.Timestamp value) {
		setValue(org.jooq.util.sybase.sys.tables.Sysview.SYSVIEW.MV_KNOWN_STALE_AT, value);
	}

	/**
	 * An uncommented item
	 */
	public java.sql.Timestamp getMvKnownStaleAt() {
		return getValue(org.jooq.util.sybase.sys.tables.Sysview.SYSVIEW.MV_KNOWN_STALE_AT);
	}

	/**
	 * An uncommented item
	 */
	public void setMvLastRefreshedTsn(java.lang.Long value) {
		setValue(org.jooq.util.sybase.sys.tables.Sysview.SYSVIEW.MV_LAST_REFRESHED_TSN, value);
	}

	/**
	 * An uncommented item
	 */
	public java.lang.Long getMvLastRefreshedTsn() {
		return getValue(org.jooq.util.sybase.sys.tables.Sysview.SYSVIEW.MV_LAST_REFRESHED_TSN);
	}

	/**
	 * Create a detached SysviewRecord
	 */
	public SysviewRecord() {
		super(org.jooq.util.sybase.sys.tables.Sysview.SYSVIEW);
	}
}
