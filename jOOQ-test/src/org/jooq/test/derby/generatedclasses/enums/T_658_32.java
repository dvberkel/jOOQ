/**
 * This class is generated by jOOQ
 */
package org.jooq.test.derby.generatedclasses.enums;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = {"http://www.jooq.org", "2.0.0"},
                            comments = "This class is generated by jOOQ")
public enum T_658_32 implements org.jooq.MasterDataType<java.lang.Long> {

	/**
	 * 1
	 */
	_1(1L, 1L),

	/**
	 * 2
	 */
	_2(2L, 2L),

	/**
	 * 3
	 */
	_3(3L, 3L),
	;

	private final java.lang.Long id;
	private final java.lang.Long cd;

	private T_658_32(java.lang.Long id, java.lang.Long cd) {
		this.id = id;
		this.cd = cd;
	}

	@Override
	public java.lang.Long getPrimaryKey() {
		return id;
	}

	/**
	 * An uncommented item
	 * 
	 * PRIMARY KEY
	 */
	public final java.lang.Long getId() {
		return id;
	}

	/**
	 * An uncommented item
	 */
	public final java.lang.Long getCd() {
		return cd;
	}
}
