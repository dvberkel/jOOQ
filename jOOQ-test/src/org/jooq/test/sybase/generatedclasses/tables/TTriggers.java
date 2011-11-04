/**
 * This class is generated by jOOQ
 */
package org.jooq.test.sybase.generatedclasses.tables;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = {"http://www.jooq.org", "2.0.0"},
                            comments = "This class is generated by jOOQ")
public class TTriggers extends org.jooq.impl.UpdatableTableImpl<org.jooq.test.sybase.generatedclasses.tables.records.TTriggersRecord> {

	private static final long serialVersionUID = 971593878;

	/**
	 * The singleton instance of t_triggers
	 */
	public static final org.jooq.test.sybase.generatedclasses.tables.TTriggers T_TRIGGERS = new org.jooq.test.sybase.generatedclasses.tables.TTriggers();

	/**
	 * The class holding records for this type
	 */
	private static final java.lang.Class<org.jooq.test.sybase.generatedclasses.tables.records.TTriggersRecord> __RECORD_TYPE = org.jooq.test.sybase.generatedclasses.tables.records.TTriggersRecord.class;

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<org.jooq.test.sybase.generatedclasses.tables.records.TTriggersRecord> getRecordType() {
		return __RECORD_TYPE;
	}

	/**
	 * An uncommented item
	 * 
	 * PRIMARY KEY
	 */
	public static final org.jooq.TableField<org.jooq.test.sybase.generatedclasses.tables.records.TTriggersRecord, java.lang.Integer> ID_GENERATED = new org.jooq.impl.TableFieldImpl<org.jooq.test.sybase.generatedclasses.tables.records.TTriggersRecord, java.lang.Integer>("id_generated", org.jooq.impl.SQLDataType.INTEGER, T_TRIGGERS);

	/**
	 * An uncommented item
	 */
	public static final org.jooq.TableField<org.jooq.test.sybase.generatedclasses.tables.records.TTriggersRecord, java.lang.Integer> ID = new org.jooq.impl.TableFieldImpl<org.jooq.test.sybase.generatedclasses.tables.records.TTriggersRecord, java.lang.Integer>("id", org.jooq.impl.SQLDataType.INTEGER, T_TRIGGERS);

	/**
	 * An uncommented item
	 */
	public static final org.jooq.TableField<org.jooq.test.sybase.generatedclasses.tables.records.TTriggersRecord, java.lang.Integer> COUNTER = new org.jooq.impl.TableFieldImpl<org.jooq.test.sybase.generatedclasses.tables.records.TTriggersRecord, java.lang.Integer>("counter", org.jooq.impl.SQLDataType.INTEGER, T_TRIGGERS);

	/**
	 * No further instances allowed
	 */
	private TTriggers() {
		super("t_triggers", org.jooq.test.sybase.generatedclasses.Dba.DBA);
	}

	@Override
	public org.jooq.Identity<org.jooq.test.sybase.generatedclasses.tables.records.TTriggersRecord, java.lang.Integer> getIdentity() {
		return org.jooq.test.sybase.generatedclasses.Keys.IDENTITY_t_triggers;
	}

	@Override
	public org.jooq.UniqueKey<org.jooq.test.sybase.generatedclasses.tables.records.TTriggersRecord> getMainKey() {
		return org.jooq.test.sybase.generatedclasses.Keys.t_triggers_pk_t_triggers;
	}

	@Override
	@SuppressWarnings("unchecked")
	public java.util.List<org.jooq.UniqueKey<org.jooq.test.sybase.generatedclasses.tables.records.TTriggersRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<org.jooq.test.sybase.generatedclasses.tables.records.TTriggersRecord>>asList(org.jooq.test.sybase.generatedclasses.Keys.t_triggers_pk_t_triggers);
	}
}
