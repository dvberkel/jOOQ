/**
 * This class is generated by jOOQ
 */
package org.jooq.util.oracle.sys.tables;

/**
 * This class is generated by jOOQ.
 *
 * Description of all procedures available to the user
 */
@javax.annotation.Generated(value    = {"http://www.jooq.org", "2.0.0"},
                            comments = "This class is generated by jOOQ")
public class AllProcedures extends org.jooq.impl.TableImpl<org.jooq.util.oracle.sys.tables.records.AllProceduresRecord> {

	private static final long serialVersionUID = 1440603040;

	/**
	 * The singleton instance of ALL_PROCEDURES
	 */
	public static final org.jooq.util.oracle.sys.tables.AllProcedures ALL_PROCEDURES = new org.jooq.util.oracle.sys.tables.AllProcedures();

	/**
	 * The class holding records for this type
	 */
	private static final java.lang.Class<org.jooq.util.oracle.sys.tables.records.AllProceduresRecord> __RECORD_TYPE = org.jooq.util.oracle.sys.tables.records.AllProceduresRecord.class;

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<org.jooq.util.oracle.sys.tables.records.AllProceduresRecord> getRecordType() {
		return __RECORD_TYPE;
	}

	/**
	 * An uncommented item
	 */
	public final org.jooq.TableField<org.jooq.util.oracle.sys.tables.records.AllProceduresRecord, java.lang.String> OWNER = createField("OWNER", org.jooq.impl.SQLDataType.VARCHAR, this);

	/**
	 * Name of the object : top level function/procedure/package name
	 */
	public final org.jooq.TableField<org.jooq.util.oracle.sys.tables.records.AllProceduresRecord, java.lang.String> OBJECT_NAME = createField("OBJECT_NAME", org.jooq.impl.SQLDataType.VARCHAR, this);

	/**
	 * Name of the procedure
	 */
	public final org.jooq.TableField<org.jooq.util.oracle.sys.tables.records.AllProceduresRecord, java.lang.String> PROCEDURE_NAME = createField("PROCEDURE_NAME", org.jooq.impl.SQLDataType.VARCHAR, this);

	/**
	 * Is it an aggregate function ?
	 */
	public final org.jooq.TableField<org.jooq.util.oracle.sys.tables.records.AllProceduresRecord, java.lang.String> AGGREGATE = createField("AGGREGATE", org.jooq.impl.SQLDataType.VARCHAR, this);

	/**
	 * Is it a pipelined table function ?
	 */
	public final org.jooq.TableField<org.jooq.util.oracle.sys.tables.records.AllProceduresRecord, java.lang.String> PIPELINED = createField("PIPELINED", org.jooq.impl.SQLDataType.VARCHAR, this);

	/**
	 * Name of the owner of the implementation type (if any)
	 */
	public final org.jooq.TableField<org.jooq.util.oracle.sys.tables.records.AllProceduresRecord, java.lang.String> IMPLTYPEOWNER = createField("IMPLTYPEOWNER", org.jooq.impl.SQLDataType.VARCHAR, this);

	/**
	 * Name of the implementation type (if any)
	 */
	public final org.jooq.TableField<org.jooq.util.oracle.sys.tables.records.AllProceduresRecord, java.lang.String> IMPLTYPENAME = createField("IMPLTYPENAME", org.jooq.impl.SQLDataType.VARCHAR, this);

	/**
	 * Is the procedure parallel enabled ?
	 */
	public final org.jooq.TableField<org.jooq.util.oracle.sys.tables.records.AllProceduresRecord, java.lang.String> PARALLEL = createField("PARALLEL", org.jooq.impl.SQLDataType.VARCHAR, this);

	/**
	 * An uncommented item
	 */
	public final org.jooq.TableField<org.jooq.util.oracle.sys.tables.records.AllProceduresRecord, java.lang.String> INTERFACE = createField("INTERFACE", org.jooq.impl.SQLDataType.VARCHAR, this);

	/**
	 * An uncommented item
	 */
	public final org.jooq.TableField<org.jooq.util.oracle.sys.tables.records.AllProceduresRecord, java.lang.String> DETERMINISTIC = createField("DETERMINISTIC", org.jooq.impl.SQLDataType.VARCHAR, this);

	/**
	 * An uncommented item
	 */
	public final org.jooq.TableField<org.jooq.util.oracle.sys.tables.records.AllProceduresRecord, java.lang.String> AUTHID = createField("AUTHID", org.jooq.impl.SQLDataType.VARCHAR, this);

	/**
	 * No further instances allowed
	 */
	private AllProcedures() {
		super("ALL_PROCEDURES", org.jooq.util.oracle.sys.Sys.SYS);
	}

	/**
	 * No further instances allowed
	 */
	private AllProcedures(java.lang.String alias) {
		super(alias, org.jooq.util.oracle.sys.Sys.SYS, org.jooq.util.oracle.sys.tables.AllProcedures.ALL_PROCEDURES);
	}

	@Override
	public org.jooq.util.oracle.sys.tables.AllProcedures as(java.lang.String alias) {
		return new org.jooq.util.oracle.sys.tables.AllProcedures(alias);
	}
}
