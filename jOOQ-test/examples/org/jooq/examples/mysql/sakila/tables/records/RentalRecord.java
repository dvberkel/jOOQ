/**
 * This class is generated by jOOQ
 */
package org.jooq.examples.mysql.sakila.tables.records;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = {"http://www.jooq.org", "2.0.0"},
                            comments = "This class is generated by jOOQ")
public class RentalRecord extends org.jooq.impl.UpdatableRecordImpl<org.jooq.examples.mysql.sakila.tables.records.RentalRecord> {

	private static final long serialVersionUID = 1079713184;

	/**
	 * An uncommented item
	 * 
	 * PRIMARY KEY
	 */
	public void setRentalId(java.lang.Integer value) {
		setValue(org.jooq.examples.mysql.sakila.tables.Rental.RENTAL.RENTAL_ID, value);
	}

	/**
	 * An uncommented item
	 * 
	 * PRIMARY KEY
	 */
	public java.lang.Integer getRentalId() {
		return getValue(org.jooq.examples.mysql.sakila.tables.Rental.RENTAL.RENTAL_ID);
	}

	/**
	 * An uncommented item
	 * 
	 * PRIMARY KEY
	 */
	public java.util.List<org.jooq.examples.mysql.sakila.tables.records.PaymentRecord> fetchPaymentList() {
		return create()
			.selectFrom(org.jooq.examples.mysql.sakila.tables.Payment.PAYMENT)
			.where(org.jooq.examples.mysql.sakila.tables.Payment.PAYMENT.RENTAL_ID.equal(getValue(org.jooq.examples.mysql.sakila.tables.Rental.RENTAL.RENTAL_ID)))
			.fetch();
	}

	/**
	 * An uncommented item
	 */
	public void setRentalDate(java.sql.Timestamp value) {
		setValue(org.jooq.examples.mysql.sakila.tables.Rental.RENTAL.RENTAL_DATE, value);
	}

	/**
	 * An uncommented item
	 */
	public java.sql.Timestamp getRentalDate() {
		return getValue(org.jooq.examples.mysql.sakila.tables.Rental.RENTAL.RENTAL_DATE);
	}

	/**
	 * An uncommented item
	 * <p>
	 * <code><pre>
	 * FOREIGN KEY [sakila.rental.inventory_id]
	 * REFERENCES inventory [sakila.inventory.inventory_id]
	 * </pre></code>
	 */
	public void setInventoryId(java.lang.Integer value) {
		setValue(org.jooq.examples.mysql.sakila.tables.Rental.RENTAL.INVENTORY_ID, value);
	}

	/**
	 * An uncommented item
	 * <p>
	 * <code><pre>
	 * FOREIGN KEY [sakila.rental.inventory_id]
	 * REFERENCES inventory [sakila.inventory.inventory_id]
	 * </pre></code>
	 */
	public java.lang.Integer getInventoryId() {
		return getValue(org.jooq.examples.mysql.sakila.tables.Rental.RENTAL.INVENTORY_ID);
	}

	/**
	 * An uncommented item
	 * <p>
	 * <code><pre>
	 * FOREIGN KEY [sakila.rental.inventory_id]
	 * REFERENCES inventory [sakila.inventory.inventory_id]
	 * </pre></code>
	 */
	public org.jooq.examples.mysql.sakila.tables.records.InventoryRecord fetchInventory() {
		return create()
			.selectFrom(org.jooq.examples.mysql.sakila.tables.Inventory.INVENTORY)
			.where(org.jooq.examples.mysql.sakila.tables.Inventory.INVENTORY.INVENTORY_ID.equal(getValue(org.jooq.examples.mysql.sakila.tables.Rental.RENTAL.INVENTORY_ID)))
			.fetchOne();
	}

	/**
	 * An uncommented item
	 * <p>
	 * <code><pre>
	 * FOREIGN KEY [sakila.rental.customer_id]
	 * REFERENCES customer [sakila.customer.customer_id]
	 * </pre></code>
	 */
	public void setCustomerId(java.lang.Short value) {
		setValue(org.jooq.examples.mysql.sakila.tables.Rental.RENTAL.CUSTOMER_ID, value);
	}

	/**
	 * An uncommented item
	 * <p>
	 * <code><pre>
	 * FOREIGN KEY [sakila.rental.customer_id]
	 * REFERENCES customer [sakila.customer.customer_id]
	 * </pre></code>
	 */
	public java.lang.Short getCustomerId() {
		return getValue(org.jooq.examples.mysql.sakila.tables.Rental.RENTAL.CUSTOMER_ID);
	}

	/**
	 * An uncommented item
	 * <p>
	 * <code><pre>
	 * FOREIGN KEY [sakila.rental.customer_id]
	 * REFERENCES customer [sakila.customer.customer_id]
	 * </pre></code>
	 */
	public org.jooq.examples.mysql.sakila.tables.records.CustomerRecord fetchCustomer() {
		return create()
			.selectFrom(org.jooq.examples.mysql.sakila.tables.Customer.CUSTOMER)
			.where(org.jooq.examples.mysql.sakila.tables.Customer.CUSTOMER.CUSTOMER_ID.equal(getValue(org.jooq.examples.mysql.sakila.tables.Rental.RENTAL.CUSTOMER_ID)))
			.fetchOne();
	}

	/**
	 * An uncommented item
	 */
	public void setReturnDate(java.sql.Timestamp value) {
		setValue(org.jooq.examples.mysql.sakila.tables.Rental.RENTAL.RETURN_DATE, value);
	}

	/**
	 * An uncommented item
	 */
	public java.sql.Timestamp getReturnDate() {
		return getValue(org.jooq.examples.mysql.sakila.tables.Rental.RENTAL.RETURN_DATE);
	}

	/**
	 * An uncommented item
	 * <p>
	 * <code><pre>
	 * FOREIGN KEY [sakila.rental.staff_id]
	 * REFERENCES staff [sakila.staff.staff_id]
	 * </pre></code>
	 */
	public void setStaffId(java.lang.Byte value) {
		setValue(org.jooq.examples.mysql.sakila.tables.Rental.RENTAL.STAFF_ID, value);
	}

	/**
	 * An uncommented item
	 * <p>
	 * <code><pre>
	 * FOREIGN KEY [sakila.rental.staff_id]
	 * REFERENCES staff [sakila.staff.staff_id]
	 * </pre></code>
	 */
	public java.lang.Byte getStaffId() {
		return getValue(org.jooq.examples.mysql.sakila.tables.Rental.RENTAL.STAFF_ID);
	}

	/**
	 * An uncommented item
	 * <p>
	 * <code><pre>
	 * FOREIGN KEY [sakila.rental.staff_id]
	 * REFERENCES staff [sakila.staff.staff_id]
	 * </pre></code>
	 */
	public org.jooq.examples.mysql.sakila.tables.records.StaffRecord fetchStaff() {
		return create()
			.selectFrom(org.jooq.examples.mysql.sakila.tables.Staff.STAFF)
			.where(org.jooq.examples.mysql.sakila.tables.Staff.STAFF.STAFF_ID.equal(getValue(org.jooq.examples.mysql.sakila.tables.Rental.RENTAL.STAFF_ID)))
			.fetchOne();
	}

	/**
	 * An uncommented item
	 */
	public void setLastUpdate(java.sql.Timestamp value) {
		setValue(org.jooq.examples.mysql.sakila.tables.Rental.RENTAL.LAST_UPDATE, value);
	}

	/**
	 * An uncommented item
	 */
	public java.sql.Timestamp getLastUpdate() {
		return getValue(org.jooq.examples.mysql.sakila.tables.Rental.RENTAL.LAST_UPDATE);
	}

	/**
	 * Create a detached RentalRecord
	 */
	public RentalRecord() {
		super(org.jooq.examples.mysql.sakila.tables.Rental.RENTAL);
	}
}
