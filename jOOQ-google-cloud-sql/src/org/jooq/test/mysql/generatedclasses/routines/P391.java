/**
 * This class is generated by jOOQ
 */
package org.jooq.test.mysql.generatedclasses.routines;

/**
 * This class is generated by jOOQ.
 *
 * Integration tests for #391
 */
@javax.annotation.Generated(value    = {"http://www.jooq.org", "1.6.8"},
                            comments = "This class is generated by jOOQ")
public class P391 extends org.jooq.impl.AbstractRoutine<java.lang.Void> {

	private static final long serialVersionUID = 1338463768;


	/**
	 * An uncommented item
	 */
	public static final org.jooq.Parameter<java.lang.Integer> I1 = new org.jooq.impl.ParameterImpl<java.lang.Integer>("i1", org.jooq.impl.SQLDataType.INTEGER);

	/**
	 * An uncommented item
	 */
	public static final org.jooq.Parameter<java.lang.Integer> IO1 = new org.jooq.impl.ParameterImpl<java.lang.Integer>("io1", org.jooq.impl.SQLDataType.INTEGER);

	/**
	 * An uncommented item
	 */
	public static final org.jooq.Parameter<java.lang.Integer> O1 = new org.jooq.impl.ParameterImpl<java.lang.Integer>("o1", org.jooq.impl.SQLDataType.INTEGER);

	/**
	 * An uncommented item
	 */
	public static final org.jooq.Parameter<java.lang.Integer> O2 = new org.jooq.impl.ParameterImpl<java.lang.Integer>("o2", org.jooq.impl.SQLDataType.INTEGER);

	/**
	 * An uncommented item
	 */
	public static final org.jooq.Parameter<java.lang.Integer> IO2 = new org.jooq.impl.ParameterImpl<java.lang.Integer>("io2", org.jooq.impl.SQLDataType.INTEGER);

	/**
	 * An uncommented item
	 */
	public static final org.jooq.Parameter<java.lang.Integer> I2 = new org.jooq.impl.ParameterImpl<java.lang.Integer>("i2", org.jooq.impl.SQLDataType.INTEGER);

	/**
	 * Create a new routine call instance
	 */
	public P391() {
		super(org.jooq.SQLDialect.MYSQL, "p391", org.jooq.test.mysql.generatedclasses.Test.TEST);

		addInParameter(I1);
		addInOutParameter(IO1);
		addOutParameter(O1);
		addOutParameter(O2);
		addInOutParameter(IO2);
		addInParameter(I2);
	}

	/**
	 * Set the <code>i1</code> parameter to the routine
	 */
	public void setI1(java.lang.Integer value) {
		setValue(I1, value);
	}

	/**
	 * Set the <code>io1</code> parameter to the routine
	 */
	public void setIo1(java.lang.Integer value) {
		setValue(IO1, value);
	}

	/**
	 * Set the <code>io2</code> parameter to the routine
	 */
	public void setIo2(java.lang.Integer value) {
		setValue(IO2, value);
	}

	/**
	 * Set the <code>i2</code> parameter to the routine
	 */
	public void setI2(java.lang.Integer value) {
		setValue(I2, value);
	}

	public java.lang.Integer getIo1() {
		return getValue(IO1);
	}

	public java.lang.Integer getO1() {
		return getValue(O1);
	}

	public java.lang.Integer getO2() {
		return getValue(O2);
	}

	public java.lang.Integer getIo2() {
		return getValue(IO2);
	}
}
