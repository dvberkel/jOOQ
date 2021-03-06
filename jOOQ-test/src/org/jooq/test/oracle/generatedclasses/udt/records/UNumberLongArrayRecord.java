/**
 * This class is generated by jOOQ
 */
package org.jooq.test.oracle.generatedclasses.udt.records;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = {"http://www.jooq.org", "2.0.0"},
                            comments = "This class is generated by jOOQ")
public class UNumberLongArrayRecord extends org.jooq.impl.ArrayRecordImpl<java.lang.Long> {

	private static final long serialVersionUID = 255684752;

	public UNumberLongArrayRecord(org.jooq.Configuration configuration) {
		super("TEST.U_NUMBER_LONG_ARRAY", org.jooq.impl.SQLDataType.BIGINT, configuration);
	}

	public UNumberLongArrayRecord(org.jooq.Configuration configuration, java.lang.Long... array) {
		this(configuration);
		set(array);
	}

	public UNumberLongArrayRecord(org.jooq.Configuration configuration, java.util.List<? extends java.lang.Long> list) {
		this(configuration);
		setList(list);
	}
}
