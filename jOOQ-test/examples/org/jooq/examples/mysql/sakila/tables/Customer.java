/**
 * This class is generated by jOOQ
 */
package org.jooq.examples.mysql.sakila.tables;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = {"http://www.jooq.org", "2.0.0"},
                            comments = "This class is generated by jOOQ")
public class Customer extends org.jooq.impl.UpdatableTableImpl<org.jooq.examples.mysql.sakila.tables.records.CustomerRecord> {

	private static final long serialVersionUID = 1839370797;

	/**
	 * The singleton instance of customer
	 */
	public static final org.jooq.examples.mysql.sakila.tables.Customer CUSTOMER = new org.jooq.examples.mysql.sakila.tables.Customer();

	/**
	 * The class holding records for this type
	 */
	private static final java.lang.Class<org.jooq.examples.mysql.sakila.tables.records.CustomerRecord> __RECORD_TYPE = org.jooq.examples.mysql.sakila.tables.records.CustomerRecord.class;

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<org.jooq.examples.mysql.sakila.tables.records.CustomerRecord> getRecordType() {
		return __RECORD_TYPE;
	}

	/**
	 * An uncommented item
	 * 
	 * PRIMARY KEY
	 */
	public static final org.jooq.TableField<org.jooq.examples.mysql.sakila.tables.records.CustomerRecord, java.lang.Short> CUSTOMER_ID = new org.jooq.impl.TableFieldImpl<org.jooq.examples.mysql.sakila.tables.records.CustomerRecord, java.lang.Short>("customer_id", org.jooq.impl.SQLDataType.SMALLINT, CUSTOMER);

	/**
	 * An uncommented item
	 * <p>
	 * <code><pre>
	 * FOREIGN KEY [sakila.customer.store_id]
	 * REFERENCES store [sakila.store.store_id]
	 * </pre></code>
	 */
	public static final org.jooq.TableField<org.jooq.examples.mysql.sakila.tables.records.CustomerRecord, java.lang.Byte> STORE_ID = new org.jooq.impl.TableFieldImpl<org.jooq.examples.mysql.sakila.tables.records.CustomerRecord, java.lang.Byte>("store_id", org.jooq.impl.SQLDataType.TINYINT, CUSTOMER);

	/**
	 * An uncommented item
	 */
	public static final org.jooq.TableField<org.jooq.examples.mysql.sakila.tables.records.CustomerRecord, java.lang.String> FIRST_NAME = new org.jooq.impl.TableFieldImpl<org.jooq.examples.mysql.sakila.tables.records.CustomerRecord, java.lang.String>("first_name", org.jooq.impl.SQLDataType.VARCHAR, CUSTOMER);

	/**
	 * An uncommented item
	 */
	public static final org.jooq.TableField<org.jooq.examples.mysql.sakila.tables.records.CustomerRecord, java.lang.String> LAST_NAME = new org.jooq.impl.TableFieldImpl<org.jooq.examples.mysql.sakila.tables.records.CustomerRecord, java.lang.String>("last_name", org.jooq.impl.SQLDataType.VARCHAR, CUSTOMER);

	/**
	 * An uncommented item
	 */
	public static final org.jooq.TableField<org.jooq.examples.mysql.sakila.tables.records.CustomerRecord, java.lang.String> EMAIL = new org.jooq.impl.TableFieldImpl<org.jooq.examples.mysql.sakila.tables.records.CustomerRecord, java.lang.String>("email", org.jooq.impl.SQLDataType.VARCHAR, CUSTOMER);

	/**
	 * An uncommented item
	 * <p>
	 * <code><pre>
	 * FOREIGN KEY [sakila.customer.address_id]
	 * REFERENCES address [sakila.address.address_id]
	 * </pre></code>
	 */
	public static final org.jooq.TableField<org.jooq.examples.mysql.sakila.tables.records.CustomerRecord, java.lang.Short> ADDRESS_ID = new org.jooq.impl.TableFieldImpl<org.jooq.examples.mysql.sakila.tables.records.CustomerRecord, java.lang.Short>("address_id", org.jooq.impl.SQLDataType.SMALLINT, CUSTOMER);

	/**
	 * An uncommented item
	 */
	public static final org.jooq.TableField<org.jooq.examples.mysql.sakila.tables.records.CustomerRecord, java.lang.Byte> ACTIVE = new org.jooq.impl.TableFieldImpl<org.jooq.examples.mysql.sakila.tables.records.CustomerRecord, java.lang.Byte>("active", org.jooq.impl.SQLDataType.TINYINT, CUSTOMER);

	/**
	 * An uncommented item
	 */
	public static final org.jooq.TableField<org.jooq.examples.mysql.sakila.tables.records.CustomerRecord, java.sql.Timestamp> CREATE_DATE = new org.jooq.impl.TableFieldImpl<org.jooq.examples.mysql.sakila.tables.records.CustomerRecord, java.sql.Timestamp>("create_date", org.jooq.impl.SQLDataType.TIMESTAMP, CUSTOMER);

	/**
	 * An uncommented item
	 */
	public static final org.jooq.TableField<org.jooq.examples.mysql.sakila.tables.records.CustomerRecord, java.sql.Timestamp> LAST_UPDATE = new org.jooq.impl.TableFieldImpl<org.jooq.examples.mysql.sakila.tables.records.CustomerRecord, java.sql.Timestamp>("last_update", org.jooq.impl.SQLDataType.TIMESTAMP, CUSTOMER);

	/**
	 * No further instances allowed
	 */
	private Customer() {
		super("customer", org.jooq.examples.mysql.sakila.Sakila.SAKILA);
	}

	@Override
	public org.jooq.Identity<org.jooq.examples.mysql.sakila.tables.records.CustomerRecord, java.lang.Short> getIdentity() {
		return org.jooq.examples.mysql.sakila.Keys.IDENTITY_customer;
	}

	@Override
	public org.jooq.UniqueKey<org.jooq.examples.mysql.sakila.tables.records.CustomerRecord> getMainKey() {
		return org.jooq.examples.mysql.sakila.Keys.KEY_customer_PRIMARY;
	}

	@Override
	@SuppressWarnings("unchecked")
	public java.util.List<org.jooq.UniqueKey<org.jooq.examples.mysql.sakila.tables.records.CustomerRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<org.jooq.examples.mysql.sakila.tables.records.CustomerRecord>>asList(org.jooq.examples.mysql.sakila.Keys.KEY_customer_PRIMARY);
	}

	@Override
	@SuppressWarnings("unchecked")
	public java.util.List<org.jooq.ForeignKey<org.jooq.examples.mysql.sakila.tables.records.CustomerRecord, ?>> getReferences() {
		return java.util.Arrays.<org.jooq.ForeignKey<org.jooq.examples.mysql.sakila.tables.records.CustomerRecord, ?>>asList(org.jooq.examples.mysql.sakila.Keys.fk_customer_store, org.jooq.examples.mysql.sakila.Keys.fk_customer_address);
	}
}
