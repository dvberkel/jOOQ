/**
 * This class is generated by jOOQ
 */
package org.jooq.test.postgres.generatedclasses.routines;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = {"http://www.jooq.org", "2.0.0"},
                            comments = "This class is generated by jOOQ")
public class FArrays1 extends org.jooq.impl.AbstractRoutine<java.lang.Integer[]> {

	private static final long serialVersionUID = 1870456302;


	/**
	 * An uncommented item
	 */
	public static final org.jooq.Parameter<java.lang.Integer[]> RETURN_VALUE = new org.jooq.impl.ParameterImpl<java.lang.Integer[]>("RETURN_VALUE", org.jooq.impl.SQLDataType.INTEGER.getArrayDataType());

	/**
	 * An uncommented item
	 */
	public static final org.jooq.Parameter<java.lang.Integer[]> IN_ARRAY = new org.jooq.impl.ParameterImpl<java.lang.Integer[]>("in_array", org.jooq.impl.SQLDataType.INTEGER.getArrayDataType());

	/**
	 * Create a new routine call instance
	 */
	public FArrays1() {
		super(org.jooq.SQLDialect.POSTGRES, "f_arrays", org.jooq.test.postgres.generatedclasses.Public.PUBLIC, org.jooq.impl.SQLDataType.INTEGER.getArrayDataType());

		setReturnParameter(RETURN_VALUE);
		addInParameter(IN_ARRAY);
		setOverloaded(true);
	}

	/**
	 * Set the <code>in_array</code> parameter to the routine
	 */
	public void setInArray(java.lang.Integer[] value) {
		setValue(IN_ARRAY, value);
	}

	/**
	 * Set the <code>in_array</code> parameter to the function
	 * <p>
	 * Use this method only, if the function is called as a {@link org.jooq.Field} in a {@link org.jooq.Select} statement!
	 */
	public void setInArray(org.jooq.Field<java.lang.Integer[]> field) {
		setField(IN_ARRAY, field);
	}
}
