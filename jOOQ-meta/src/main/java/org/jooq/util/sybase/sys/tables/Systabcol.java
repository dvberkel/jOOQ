/**
 * This class is generated by jOOQ
 */
package org.jooq.util.sybase.sys.tables;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = {"http://www.jooq.org", "2.0.0"},
                            comments = "This class is generated by jOOQ")
public class Systabcol extends org.jooq.impl.TableImpl<org.jooq.util.sybase.sys.tables.records.SystabcolRecord> {

	private static final long serialVersionUID = -201201098;

	/**
	 * The singleton instance of SYSTABCOL
	 */
	public static final org.jooq.util.sybase.sys.tables.Systabcol SYSTABCOL = new org.jooq.util.sybase.sys.tables.Systabcol();

	/**
	 * The class holding records for this type
	 */
	private static final java.lang.Class<org.jooq.util.sybase.sys.tables.records.SystabcolRecord> __RECORD_TYPE = org.jooq.util.sybase.sys.tables.records.SystabcolRecord.class;

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<org.jooq.util.sybase.sys.tables.records.SystabcolRecord> getRecordType() {
		return __RECORD_TYPE;
	}

	/**
	 * An uncommented item
	 */
	public final org.jooq.TableField<org.jooq.util.sybase.sys.tables.records.SystabcolRecord, java.lang.Integer> TABLE_ID = createField("table_id", org.jooq.impl.SQLDataType.INTEGER, this);

	/**
	 * An uncommented item
	 */
	public final org.jooq.TableField<org.jooq.util.sybase.sys.tables.records.SystabcolRecord, java.lang.Integer> COLUMN_ID = createField("column_id", org.jooq.impl.SQLDataType.INTEGER, this);

	/**
	 * An uncommented item
	 */
	public final org.jooq.TableField<org.jooq.util.sybase.sys.tables.records.SystabcolRecord, java.lang.Short> DOMAIN_ID = createField("domain_id", org.jooq.impl.SQLDataType.SMALLINT, this);

	/**
	 * An uncommented item
	 */
	public final org.jooq.TableField<org.jooq.util.sybase.sys.tables.records.SystabcolRecord, java.lang.String> NULLS = createField("nulls", org.jooq.impl.SQLDataType.CHAR, this);

	/**
	 * An uncommented item
	 */
	public final org.jooq.TableField<org.jooq.util.sybase.sys.tables.records.SystabcolRecord, java.lang.Long> WIDTH = createField("width", org.jooq.impl.SQLDataType.BIGINT, this);

	/**
	 * An uncommented item
	 */
	public final org.jooq.TableField<org.jooq.util.sybase.sys.tables.records.SystabcolRecord, java.lang.Short> SCALE = createField("scale", org.jooq.impl.SQLDataType.SMALLINT, this);

	/**
	 * An uncommented item
	 */
	public final org.jooq.TableField<org.jooq.util.sybase.sys.tables.records.SystabcolRecord, java.lang.Long> OBJECT_ID = createField("object_id", org.jooq.impl.SQLDataType.BIGINT, this);

	/**
	 * An uncommented item
	 */
	public final org.jooq.TableField<org.jooq.util.sybase.sys.tables.records.SystabcolRecord, java.lang.Long> MAX_IDENTITY = createField("max_identity", org.jooq.impl.SQLDataType.BIGINT, this);

	/**
	 * An uncommented item
	 */
	public final org.jooq.TableField<org.jooq.util.sybase.sys.tables.records.SystabcolRecord, java.lang.String> COLUMN_NAME = createField("column_name", org.jooq.impl.SQLDataType.CHAR, this);

	/**
	 * An uncommented item
	 */
	public final org.jooq.TableField<org.jooq.util.sybase.sys.tables.records.SystabcolRecord, java.lang.String> DEFAULT = createField("default", org.jooq.impl.SQLDataType.LONGVARCHAR, this);

	/**
	 * An uncommented item
	 */
	public final org.jooq.TableField<org.jooq.util.sybase.sys.tables.records.SystabcolRecord, java.lang.Short> USER_TYPE = createField("user_type", org.jooq.impl.SQLDataType.SMALLINT, this);

	/**
	 * An uncommented item
	 */
	public final org.jooq.TableField<org.jooq.util.sybase.sys.tables.records.SystabcolRecord, java.lang.String> COLUMN_TYPE = createField("column_type", org.jooq.impl.SQLDataType.CHAR, this);

	/**
	 * An uncommented item
	 */
	public final org.jooq.TableField<org.jooq.util.sybase.sys.tables.records.SystabcolRecord, java.lang.Byte> COMPRESSED = createField("compressed", org.jooq.impl.SQLDataType.TINYINT, this);

	/**
	 * An uncommented item
	 */
	public final org.jooq.TableField<org.jooq.util.sybase.sys.tables.records.SystabcolRecord, java.lang.Byte> COLLECT_STATS = createField("collect_stats", org.jooq.impl.SQLDataType.TINYINT, this);

	/**
	 * An uncommented item
	 */
	public final org.jooq.TableField<org.jooq.util.sybase.sys.tables.records.SystabcolRecord, java.lang.Short> INLINE_MAX = createField("inline_max", org.jooq.impl.SQLDataType.SMALLINT, this);

	/**
	 * An uncommented item
	 */
	public final org.jooq.TableField<org.jooq.util.sybase.sys.tables.records.SystabcolRecord, java.lang.Short> INLINE_LONG = createField("inline_long", org.jooq.impl.SQLDataType.SMALLINT, this);

	/**
	 * An uncommented item
	 */
	public final org.jooq.TableField<org.jooq.util.sybase.sys.tables.records.SystabcolRecord, java.lang.Byte> LOB_INDEX = createField("lob_index", org.jooq.impl.SQLDataType.TINYINT, this);

	/**
	 * An uncommented item
	 */
	public final org.jooq.TableField<org.jooq.util.sybase.sys.tables.records.SystabcolRecord, java.lang.String> BASE_TYPE_STR = createField("base_type_str", org.jooq.impl.SQLDataType.VARCHAR, this);

	/**
	 * No further instances allowed
	 */
	private Systabcol() {
		super("SYSTABCOL", org.jooq.util.sybase.sys.Sys.SYS);
	}

	/**
	 * No further instances allowed
	 */
	private Systabcol(java.lang.String alias) {
		super(alias, org.jooq.util.sybase.sys.Sys.SYS, org.jooq.util.sybase.sys.tables.Systabcol.SYSTABCOL);
	}

	@Override
	public org.jooq.util.sybase.sys.tables.Systabcol as(java.lang.String alias) {
		return new org.jooq.util.sybase.sys.tables.Systabcol(alias);
	}
}
