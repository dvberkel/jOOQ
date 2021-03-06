/**
 * This class is generated by jOOQ
 */
package org.jooq.util.oracle.sys.tables;

/**
 * This class is generated by jOOQ.
 *
 * Arguments in object accessible to the user
 */
@javax.annotation.Generated(value    = {"http://www.jooq.org", "2.0.0"},
                            comments = "This class is generated by jOOQ")
public class AllArguments extends org.jooq.impl.TableImpl<org.jooq.util.oracle.sys.tables.records.AllArgumentsRecord> {

	private static final long serialVersionUID = -1001772229;

	/**
	 * The singleton instance of ALL_ARGUMENTS
	 */
	public static final org.jooq.util.oracle.sys.tables.AllArguments ALL_ARGUMENTS = new org.jooq.util.oracle.sys.tables.AllArguments();

	/**
	 * The class holding records for this type
	 */
	private static final java.lang.Class<org.jooq.util.oracle.sys.tables.records.AllArgumentsRecord> __RECORD_TYPE = org.jooq.util.oracle.sys.tables.records.AllArgumentsRecord.class;

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<org.jooq.util.oracle.sys.tables.records.AllArgumentsRecord> getRecordType() {
		return __RECORD_TYPE;
	}

	/**
	 * Username of the owner of the object
	 */
	public final org.jooq.TableField<org.jooq.util.oracle.sys.tables.records.AllArgumentsRecord, java.lang.String> OWNER = createField("OWNER", org.jooq.impl.SQLDataType.VARCHAR, this);

	/**
	 * Procedure or function name
	 */
	public final org.jooq.TableField<org.jooq.util.oracle.sys.tables.records.AllArgumentsRecord, java.lang.String> OBJECT_NAME = createField("OBJECT_NAME", org.jooq.impl.SQLDataType.VARCHAR, this);

	/**
	 * Package name
	 */
	public final org.jooq.TableField<org.jooq.util.oracle.sys.tables.records.AllArgumentsRecord, java.lang.String> PACKAGE_NAME = createField("PACKAGE_NAME", org.jooq.impl.SQLDataType.VARCHAR, this);

	/**
	 * Object number of the object
	 */
	public final org.jooq.TableField<org.jooq.util.oracle.sys.tables.records.AllArgumentsRecord, java.math.BigDecimal> OBJECT_ID = createField("OBJECT_ID", org.jooq.impl.SQLDataType.NUMERIC, this);

	/**
	 * Overload unique identifier
	 */
	public final org.jooq.TableField<org.jooq.util.oracle.sys.tables.records.AllArgumentsRecord, java.lang.String> OVERLOAD = createField("OVERLOAD", org.jooq.impl.SQLDataType.VARCHAR, this);

	/**
	 * Argument name
	 */
	public final org.jooq.TableField<org.jooq.util.oracle.sys.tables.records.AllArgumentsRecord, java.lang.String> ARGUMENT_NAME = createField("ARGUMENT_NAME", org.jooq.impl.SQLDataType.VARCHAR, this);

	/**
	 * Position in argument list, or null for function return value
	 */
	public final org.jooq.TableField<org.jooq.util.oracle.sys.tables.records.AllArgumentsRecord, java.math.BigDecimal> POSITION = createField("POSITION", org.jooq.impl.SQLDataType.NUMERIC, this);

	/**
	 * Argument sequence, including all nesting levels
	 */
	public final org.jooq.TableField<org.jooq.util.oracle.sys.tables.records.AllArgumentsRecord, java.math.BigDecimal> SEQUENCE = createField("SEQUENCE", org.jooq.impl.SQLDataType.NUMERIC, this);

	/**
	 * Nesting depth of argument for composite types
	 */
	public final org.jooq.TableField<org.jooq.util.oracle.sys.tables.records.AllArgumentsRecord, java.math.BigDecimal> DATA_LEVEL = createField("DATA_LEVEL", org.jooq.impl.SQLDataType.NUMERIC, this);

	/**
	 * Datatype of the argument
	 */
	public final org.jooq.TableField<org.jooq.util.oracle.sys.tables.records.AllArgumentsRecord, java.lang.String> DATA_TYPE = createField("DATA_TYPE", org.jooq.impl.SQLDataType.VARCHAR, this);

	/**
	 * Default value for the argument
	 */
	public final org.jooq.TableField<org.jooq.util.oracle.sys.tables.records.AllArgumentsRecord, java.lang.String> DEFAULT_VALUE = createField("DEFAULT_VALUE", org.jooq.impl.SQLDataType.CLOB, this);

	/**
	 * Length of default value for the argument
	 */
	public final org.jooq.TableField<org.jooq.util.oracle.sys.tables.records.AllArgumentsRecord, java.math.BigDecimal> DEFAULT_LENGTH = createField("DEFAULT_LENGTH", org.jooq.impl.SQLDataType.NUMERIC, this);

	/**
	 * Argument direction (IN, OUT, or IN/OUT)
	 */
	public final org.jooq.TableField<org.jooq.util.oracle.sys.tables.records.AllArgumentsRecord, java.lang.String> IN_OUT = createField("IN_OUT", org.jooq.impl.SQLDataType.VARCHAR, this);

	/**
	 * Length of the column in bytes
	 */
	public final org.jooq.TableField<org.jooq.util.oracle.sys.tables.records.AllArgumentsRecord, java.math.BigDecimal> DATA_LENGTH = createField("DATA_LENGTH", org.jooq.impl.SQLDataType.NUMERIC, this);

	/**
	 * Length: decimal digits (NUMBER) or binary digits (FLOAT)
	 */
	public final org.jooq.TableField<org.jooq.util.oracle.sys.tables.records.AllArgumentsRecord, java.math.BigDecimal> DATA_PRECISION = createField("DATA_PRECISION", org.jooq.impl.SQLDataType.NUMERIC, this);

	/**
	 * Digits to right of decimal point in a number
	 */
	public final org.jooq.TableField<org.jooq.util.oracle.sys.tables.records.AllArgumentsRecord, java.math.BigDecimal> DATA_SCALE = createField("DATA_SCALE", org.jooq.impl.SQLDataType.NUMERIC, this);

	/**
	 * Argument radix for a number
	 */
	public final org.jooq.TableField<org.jooq.util.oracle.sys.tables.records.AllArgumentsRecord, java.math.BigDecimal> RADIX = createField("RADIX", org.jooq.impl.SQLDataType.NUMERIC, this);

	/**
	 * Character set name for the argument
	 */
	public final org.jooq.TableField<org.jooq.util.oracle.sys.tables.records.AllArgumentsRecord, java.lang.String> CHARACTER_SET_NAME = createField("CHARACTER_SET_NAME", org.jooq.impl.SQLDataType.VARCHAR, this);

	/**
	 * Owner name for the argument type in case of object types
	 */
	public final org.jooq.TableField<org.jooq.util.oracle.sys.tables.records.AllArgumentsRecord, java.lang.String> TYPE_OWNER = createField("TYPE_OWNER", org.jooq.impl.SQLDataType.VARCHAR, this);

	/**
	 * Object name for the argument type in case of object types
	 */
	public final org.jooq.TableField<org.jooq.util.oracle.sys.tables.records.AllArgumentsRecord, java.lang.String> TYPE_NAME = createField("TYPE_NAME", org.jooq.impl.SQLDataType.VARCHAR, this);

	/**
	 * Subordinate object name for the argument type in case of object types
	 */
	public final org.jooq.TableField<org.jooq.util.oracle.sys.tables.records.AllArgumentsRecord, java.lang.String> TYPE_SUBNAME = createField("TYPE_SUBNAME", org.jooq.impl.SQLDataType.VARCHAR, this);

	/**
	 * Database link name for the argument type in case of object types
	 */
	public final org.jooq.TableField<org.jooq.util.oracle.sys.tables.records.AllArgumentsRecord, java.lang.String> TYPE_LINK = createField("TYPE_LINK", org.jooq.impl.SQLDataType.VARCHAR, this);

	/**
	 * PL/SQL type name for numeric arguments
	 */
	public final org.jooq.TableField<org.jooq.util.oracle.sys.tables.records.AllArgumentsRecord, java.lang.String> PLS_TYPE = createField("PLS_TYPE", org.jooq.impl.SQLDataType.VARCHAR, this);

	/**
	 * Character limit for string datatypes
	 */
	public final org.jooq.TableField<org.jooq.util.oracle.sys.tables.records.AllArgumentsRecord, java.math.BigDecimal> CHAR_LENGTH = createField("CHAR_LENGTH", org.jooq.impl.SQLDataType.NUMERIC, this);

	/**
	 * Is the byte limit (B) or char limit (C) official for this string?
	 */
	public final org.jooq.TableField<org.jooq.util.oracle.sys.tables.records.AllArgumentsRecord, java.lang.String> CHAR_USED = createField("CHAR_USED", org.jooq.impl.SQLDataType.VARCHAR, this);

	/**
	 * No further instances allowed
	 */
	private AllArguments() {
		super("ALL_ARGUMENTS", org.jooq.util.oracle.sys.Sys.SYS);
	}

	/**
	 * No further instances allowed
	 */
	private AllArguments(java.lang.String alias) {
		super(alias, org.jooq.util.oracle.sys.Sys.SYS, org.jooq.util.oracle.sys.tables.AllArguments.ALL_ARGUMENTS);
	}

	@Override
	public org.jooq.util.oracle.sys.tables.AllArguments as(java.lang.String alias) {
		return new org.jooq.util.oracle.sys.tables.AllArguments(alias);
	}
}
