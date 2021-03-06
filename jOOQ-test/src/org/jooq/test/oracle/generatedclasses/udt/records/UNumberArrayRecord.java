/**
 * This class is generated by jOOQ
 */
package org.jooq.test.oracle.generatedclasses.udt.records;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = {"http://www.jooq.org", "2.0.0"},
                            comments = "This class is generated by jOOQ")
public class UNumberArrayRecord extends org.jooq.impl.ArrayRecordImpl<java.lang.Integer> {

	private static final long serialVersionUID = 566593496;

	public UNumberArrayRecord(org.jooq.Configuration configuration) {
		super("TEST.U_NUMBER_ARRAY", org.jooq.impl.SQLDataType.INTEGER, configuration);
	}

	public UNumberArrayRecord(org.jooq.Configuration configuration, java.lang.Integer... array) {
		this(configuration);
		set(array);
	}

	public UNumberArrayRecord(org.jooq.Configuration configuration, java.util.List<? extends java.lang.Integer> list) {
		this(configuration);
		setList(list);
	}
}
