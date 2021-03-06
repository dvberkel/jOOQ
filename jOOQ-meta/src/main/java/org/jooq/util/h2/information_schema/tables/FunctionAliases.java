/**
 * This class is generated by jOOQ
 */
package org.jooq.util.h2.information_schema.tables;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = {"http://www.jooq.org", "2.0.0"},
                            comments = "This class is generated by jOOQ")
public class FunctionAliases extends org.jooq.impl.TableImpl<org.jooq.util.h2.information_schema.tables.records.FunctionAliasesRecord> {

	private static final long serialVersionUID = 635440995;

	/**
	 * The singleton instance of FUNCTION_ALIASES
	 */
	public static final org.jooq.util.h2.information_schema.tables.FunctionAliases FUNCTION_ALIASES = new org.jooq.util.h2.information_schema.tables.FunctionAliases();

	/**
	 * The class holding records for this type
	 */
	private static final java.lang.Class<org.jooq.util.h2.information_schema.tables.records.FunctionAliasesRecord> __RECORD_TYPE = org.jooq.util.h2.information_schema.tables.records.FunctionAliasesRecord.class;

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<org.jooq.util.h2.information_schema.tables.records.FunctionAliasesRecord> getRecordType() {
		return __RECORD_TYPE;
	}

	/**
	 * An uncommented item
	 */
	public static final org.jooq.TableField<org.jooq.util.h2.information_schema.tables.records.FunctionAliasesRecord, java.lang.String> ALIAS_CATALOG = createField("ALIAS_CATALOG", org.jooq.impl.SQLDataType.VARCHAR, FUNCTION_ALIASES);

	/**
	 * An uncommented item
	 */
	public static final org.jooq.TableField<org.jooq.util.h2.information_schema.tables.records.FunctionAliasesRecord, java.lang.String> ALIAS_SCHEMA = createField("ALIAS_SCHEMA", org.jooq.impl.SQLDataType.VARCHAR, FUNCTION_ALIASES);

	/**
	 * An uncommented item
	 */
	public static final org.jooq.TableField<org.jooq.util.h2.information_schema.tables.records.FunctionAliasesRecord, java.lang.String> ALIAS_NAME = createField("ALIAS_NAME", org.jooq.impl.SQLDataType.VARCHAR, FUNCTION_ALIASES);

	/**
	 * An uncommented item
	 */
	public static final org.jooq.TableField<org.jooq.util.h2.information_schema.tables.records.FunctionAliasesRecord, java.lang.String> JAVA_CLASS = createField("JAVA_CLASS", org.jooq.impl.SQLDataType.VARCHAR, FUNCTION_ALIASES);

	/**
	 * An uncommented item
	 */
	public static final org.jooq.TableField<org.jooq.util.h2.information_schema.tables.records.FunctionAliasesRecord, java.lang.String> JAVA_METHOD = createField("JAVA_METHOD", org.jooq.impl.SQLDataType.VARCHAR, FUNCTION_ALIASES);

	/**
	 * An uncommented item
	 */
	public static final org.jooq.TableField<org.jooq.util.h2.information_schema.tables.records.FunctionAliasesRecord, java.lang.Integer> DATA_TYPE = createField("DATA_TYPE", org.jooq.impl.SQLDataType.INTEGER, FUNCTION_ALIASES);

	/**
	 * An uncommented item
	 */
	public static final org.jooq.TableField<org.jooq.util.h2.information_schema.tables.records.FunctionAliasesRecord, java.lang.Integer> COLUMN_COUNT = createField("COLUMN_COUNT", org.jooq.impl.SQLDataType.INTEGER, FUNCTION_ALIASES);

	/**
	 * An uncommented item
	 */
	public static final org.jooq.TableField<org.jooq.util.h2.information_schema.tables.records.FunctionAliasesRecord, java.lang.Short> RETURNS_RESULT = createField("RETURNS_RESULT", org.jooq.impl.SQLDataType.SMALLINT, FUNCTION_ALIASES);

	/**
	 * An uncommented item
	 */
	public static final org.jooq.TableField<org.jooq.util.h2.information_schema.tables.records.FunctionAliasesRecord, java.lang.String> REMARKS = createField("REMARKS", org.jooq.impl.SQLDataType.VARCHAR, FUNCTION_ALIASES);

	/**
	 * An uncommented item
	 */
	public static final org.jooq.TableField<org.jooq.util.h2.information_schema.tables.records.FunctionAliasesRecord, java.lang.Integer> ID = createField("ID", org.jooq.impl.SQLDataType.INTEGER, FUNCTION_ALIASES);

	/**
	 * An uncommented item
	 */
	public static final org.jooq.TableField<org.jooq.util.h2.information_schema.tables.records.FunctionAliasesRecord, java.lang.String> SOURCE = createField("SOURCE", org.jooq.impl.SQLDataType.VARCHAR, FUNCTION_ALIASES);

	/**
	 * No further instances allowed
	 */
	private FunctionAliases() {
		super("FUNCTION_ALIASES", org.jooq.util.h2.information_schema.InformationSchema.INFORMATION_SCHEMA);
	}
}
