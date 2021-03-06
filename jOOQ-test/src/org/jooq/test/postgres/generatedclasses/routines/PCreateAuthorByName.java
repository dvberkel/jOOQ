/**
 * This class is generated by jOOQ
 */
package org.jooq.test.postgres.generatedclasses.routines;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = {"http://www.jooq.org", "2.0.0"},
                            comments = "This class is generated by jOOQ")
public class PCreateAuthorByName extends org.jooq.impl.AbstractRoutine<java.lang.Void> {

	private static final long serialVersionUID = 1620749729;


	/**
	 * An uncommented item
	 */
	public static final org.jooq.Parameter<java.lang.String> FIRST_NAME = createParameter("first_name", org.jooq.impl.SQLDataType.VARCHAR);

	/**
	 * An uncommented item
	 */
	public static final org.jooq.Parameter<java.lang.String> LAST_NAME = createParameter("last_name", org.jooq.impl.SQLDataType.VARCHAR);

	/**
	 * Create a new routine call instance
	 */
	public PCreateAuthorByName() {
		super(org.jooq.SQLDialect.POSTGRES, "p_create_author_by_name", org.jooq.test.postgres.generatedclasses.Public.PUBLIC);

		addInParameter(FIRST_NAME);
		addInParameter(LAST_NAME);
	}

	/**
	 * Set the <code>first_name</code> parameter to the routine
	 */
	public void setFirstName(java.lang.String value) {
		setValue(FIRST_NAME, value);
	}

	/**
	 * Set the <code>last_name</code> parameter to the routine
	 */
	public void setLastName(java.lang.String value) {
		setValue(LAST_NAME, value);
	}
}
