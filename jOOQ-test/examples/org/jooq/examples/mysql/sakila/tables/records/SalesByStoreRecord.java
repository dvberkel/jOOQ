/**
 * This class is generated by jOOQ
 */
package org.jooq.examples.mysql.sakila.tables.records;

/**
 * This class is generated by jOOQ.
 *
 * VIEW
 */
@javax.annotation.Generated(value    = {"http://www.jooq.org", "2.0.0"},
                            comments = "This class is generated by jOOQ")
public class SalesByStoreRecord extends org.jooq.impl.TableRecordImpl<org.jooq.examples.mysql.sakila.tables.records.SalesByStoreRecord> {

	private static final long serialVersionUID = 363408142;

	/**
	 * An uncommented item
	 */
	public void setStore(java.lang.String value) {
		setValue(org.jooq.examples.mysql.sakila.tables.SalesByStore.SALES_BY_STORE.STORE, value);
	}

	/**
	 * An uncommented item
	 */
	public java.lang.String getStore() {
		return getValue(org.jooq.examples.mysql.sakila.tables.SalesByStore.SALES_BY_STORE.STORE);
	}

	/**
	 * An uncommented item
	 */
	public void setManager(java.lang.String value) {
		setValue(org.jooq.examples.mysql.sakila.tables.SalesByStore.SALES_BY_STORE.MANAGER, value);
	}

	/**
	 * An uncommented item
	 */
	public java.lang.String getManager() {
		return getValue(org.jooq.examples.mysql.sakila.tables.SalesByStore.SALES_BY_STORE.MANAGER);
	}

	/**
	 * An uncommented item
	 */
	public void setTotalSales(java.math.BigDecimal value) {
		setValue(org.jooq.examples.mysql.sakila.tables.SalesByStore.SALES_BY_STORE.TOTAL_SALES, value);
	}

	/**
	 * An uncommented item
	 */
	public java.math.BigDecimal getTotalSales() {
		return getValue(org.jooq.examples.mysql.sakila.tables.SalesByStore.SALES_BY_STORE.TOTAL_SALES);
	}

	/**
	 * Create a detached SalesByStoreRecord
	 */
	public SalesByStoreRecord() {
		super(org.jooq.examples.mysql.sakila.tables.SalesByStore.SALES_BY_STORE);
	}
}
