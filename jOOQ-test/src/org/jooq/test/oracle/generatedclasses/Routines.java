/**
 * This class is generated by jOOQ
 */
package org.jooq.test.oracle.generatedclasses;

/**
 * This class is generated by jOOQ.
 *
 * Convenience access to all stored procedures and functions in TEST
 */
@javax.annotation.Generated(value    = {"http://www.jooq.org", "2.0.0"},
                            comments = "This class is generated by jOOQ")
public final class Routines {

	/**
	 * Invoke F_ARRAYS1
	 *
	 * @param inArray
	 * @throws org.jooq.exception.DataAccessException if something went wrong executing the query
	 */
	public static org.jooq.test.oracle.generatedclasses.udt.records.UNumberArrayRecord fArrays1(org.jooq.Configuration configuration, org.jooq.test.oracle.generatedclasses.udt.records.UNumberArrayRecord inArray) {
		org.jooq.test.oracle.generatedclasses.routines.FArrays1 f = new org.jooq.test.oracle.generatedclasses.routines.FArrays1();
		f.setInArray(inArray);

		f.execute(configuration);
		return f.getReturnValue();
	}

	/**
	 * Get F_ARRAYS1 as a field
	 *
	 * @param inArray
	 */
	public static org.jooq.Field<org.jooq.test.oracle.generatedclasses.udt.records.UNumberArrayRecord> fArrays1(org.jooq.test.oracle.generatedclasses.udt.records.UNumberArrayRecord inArray) {
		org.jooq.test.oracle.generatedclasses.routines.FArrays1 f = new org.jooq.test.oracle.generatedclasses.routines.FArrays1();
		f.setInArray(inArray);

		return f.asField();
	}

	/**
	 * Get F_ARRAYS1 as a field
	 *
	 * @param inArray
	 */
	public static org.jooq.Field<org.jooq.test.oracle.generatedclasses.udt.records.UNumberArrayRecord> fArrays1(org.jooq.Field<org.jooq.test.oracle.generatedclasses.udt.records.UNumberArrayRecord> inArray) {
		org.jooq.test.oracle.generatedclasses.routines.FArrays1 f = new org.jooq.test.oracle.generatedclasses.routines.FArrays1();
		f.setInArray(inArray);

		return f.asField();
	}

	/**
	 * Invoke F_ARRAYS2
	 *
	 * @param inArray
	 * @throws org.jooq.exception.DataAccessException if something went wrong executing the query
	 */
	public static org.jooq.test.oracle.generatedclasses.udt.records.UNumberLongArrayRecord fArrays2(org.jooq.Configuration configuration, org.jooq.test.oracle.generatedclasses.udt.records.UNumberLongArrayRecord inArray) {
		org.jooq.test.oracle.generatedclasses.routines.FArrays2 f = new org.jooq.test.oracle.generatedclasses.routines.FArrays2();
		f.setInArray(inArray);

		f.execute(configuration);
		return f.getReturnValue();
	}

	/**
	 * Get F_ARRAYS2 as a field
	 *
	 * @param inArray
	 */
	public static org.jooq.Field<org.jooq.test.oracle.generatedclasses.udt.records.UNumberLongArrayRecord> fArrays2(org.jooq.test.oracle.generatedclasses.udt.records.UNumberLongArrayRecord inArray) {
		org.jooq.test.oracle.generatedclasses.routines.FArrays2 f = new org.jooq.test.oracle.generatedclasses.routines.FArrays2();
		f.setInArray(inArray);

		return f.asField();
	}

	/**
	 * Get F_ARRAYS2 as a field
	 *
	 * @param inArray
	 */
	public static org.jooq.Field<org.jooq.test.oracle.generatedclasses.udt.records.UNumberLongArrayRecord> fArrays2(org.jooq.Field<org.jooq.test.oracle.generatedclasses.udt.records.UNumberLongArrayRecord> inArray) {
		org.jooq.test.oracle.generatedclasses.routines.FArrays2 f = new org.jooq.test.oracle.generatedclasses.routines.FArrays2();
		f.setInArray(inArray);

		return f.asField();
	}

	/**
	 * Invoke F_ARRAYS3
	 *
	 * @param inArray
	 * @throws org.jooq.exception.DataAccessException if something went wrong executing the query
	 */
	public static org.jooq.test.oracle.generatedclasses.udt.records.UStringArrayRecord fArrays3(org.jooq.Configuration configuration, org.jooq.test.oracle.generatedclasses.udt.records.UStringArrayRecord inArray) {
		org.jooq.test.oracle.generatedclasses.routines.FArrays3 f = new org.jooq.test.oracle.generatedclasses.routines.FArrays3();
		f.setInArray(inArray);

		f.execute(configuration);
		return f.getReturnValue();
	}

	/**
	 * Get F_ARRAYS3 as a field
	 *
	 * @param inArray
	 */
	public static org.jooq.Field<org.jooq.test.oracle.generatedclasses.udt.records.UStringArrayRecord> fArrays3(org.jooq.test.oracle.generatedclasses.udt.records.UStringArrayRecord inArray) {
		org.jooq.test.oracle.generatedclasses.routines.FArrays3 f = new org.jooq.test.oracle.generatedclasses.routines.FArrays3();
		f.setInArray(inArray);

		return f.asField();
	}

	/**
	 * Get F_ARRAYS3 as a field
	 *
	 * @param inArray
	 */
	public static org.jooq.Field<org.jooq.test.oracle.generatedclasses.udt.records.UStringArrayRecord> fArrays3(org.jooq.Field<org.jooq.test.oracle.generatedclasses.udt.records.UStringArrayRecord> inArray) {
		org.jooq.test.oracle.generatedclasses.routines.FArrays3 f = new org.jooq.test.oracle.generatedclasses.routines.FArrays3();
		f.setInArray(inArray);

		return f.asField();
	}

	/**
	 * Invoke F_AUTHOR_EXISTS
	 *
	 * @param authorName
	 * @throws org.jooq.exception.DataAccessException if something went wrong executing the query
	 */
	public static java.math.BigDecimal fAuthorExists(org.jooq.Configuration configuration, java.lang.String authorName) {
		org.jooq.test.oracle.generatedclasses.routines.FAuthorExists f = new org.jooq.test.oracle.generatedclasses.routines.FAuthorExists();
		f.setAuthorName(authorName);

		f.execute(configuration);
		return f.getReturnValue();
	}

	/**
	 * Get F_AUTHOR_EXISTS as a field
	 *
	 * @param authorName
	 */
	public static org.jooq.Field<java.math.BigDecimal> fAuthorExists(java.lang.String authorName) {
		org.jooq.test.oracle.generatedclasses.routines.FAuthorExists f = new org.jooq.test.oracle.generatedclasses.routines.FAuthorExists();
		f.setAuthorName(authorName);

		return f.asField();
	}

	/**
	 * Get F_AUTHOR_EXISTS as a field
	 *
	 * @param authorName
	 */
	public static org.jooq.Field<java.math.BigDecimal> fAuthorExists(org.jooq.Field<java.lang.String> authorName) {
		org.jooq.test.oracle.generatedclasses.routines.FAuthorExists f = new org.jooq.test.oracle.generatedclasses.routines.FAuthorExists();
		f.setAuthorName(authorName);

		return f.asField();
	}

	/**
	 * Invoke F_GET_ONE_CURSOR
	 *
	 * @param bookIds
	 * @throws org.jooq.exception.DataAccessException if something went wrong executing the query
	 */
	public static org.jooq.Result<org.jooq.Record> fGetOneCursor(org.jooq.Configuration configuration, org.jooq.test.oracle.generatedclasses.udt.records.UNumberArrayRecord bookIds) {
		org.jooq.test.oracle.generatedclasses.routines.FGetOneCursor f = new org.jooq.test.oracle.generatedclasses.routines.FGetOneCursor();
		f.setBookIds(bookIds);

		f.execute(configuration);
		return f.getReturnValue();
	}

	/**
	 * Get F_GET_ONE_CURSOR as a field
	 *
	 * @param bookIds
	 */
	public static org.jooq.Field<org.jooq.Result<org.jooq.Record>> fGetOneCursor(org.jooq.test.oracle.generatedclasses.udt.records.UNumberArrayRecord bookIds) {
		org.jooq.test.oracle.generatedclasses.routines.FGetOneCursor f = new org.jooq.test.oracle.generatedclasses.routines.FGetOneCursor();
		f.setBookIds(bookIds);

		return f.asField();
	}

	/**
	 * Get F_GET_ONE_CURSOR as a field
	 *
	 * @param bookIds
	 */
	public static org.jooq.Field<org.jooq.Result<org.jooq.Record>> fGetOneCursor(org.jooq.Field<org.jooq.test.oracle.generatedclasses.udt.records.UNumberArrayRecord> bookIds) {
		org.jooq.test.oracle.generatedclasses.routines.FGetOneCursor f = new org.jooq.test.oracle.generatedclasses.routines.FGetOneCursor();
		f.setBookIds(bookIds);

		return f.asField();
	}

	/**
	 * Invoke F_NUMBER
	 *
	 * @param n
	 * @throws org.jooq.exception.DataAccessException if something went wrong executing the query
	 */
	public static java.math.BigDecimal fNumber(org.jooq.Configuration configuration, java.lang.Number n) {
		org.jooq.test.oracle.generatedclasses.routines.FNumber f = new org.jooq.test.oracle.generatedclasses.routines.FNumber();
		f.setN(n);

		f.execute(configuration);
		return f.getReturnValue();
	}

	/**
	 * Get F_NUMBER as a field
	 *
	 * @param n
	 */
	public static org.jooq.Field<java.math.BigDecimal> fNumber(java.lang.Number n) {
		org.jooq.test.oracle.generatedclasses.routines.FNumber f = new org.jooq.test.oracle.generatedclasses.routines.FNumber();
		f.setN(n);

		return f.asField();
	}

	/**
	 * Get F_NUMBER as a field
	 *
	 * @param n
	 */
	public static org.jooq.Field<java.math.BigDecimal> fNumber(org.jooq.Field<? extends java.lang.Number> n) {
		org.jooq.test.oracle.generatedclasses.routines.FNumber f = new org.jooq.test.oracle.generatedclasses.routines.FNumber();
		f.setN(n);

		return f.asField();
	}

	/**
	 * Invoke F_ONE
	 *
	 * @throws org.jooq.exception.DataAccessException if something went wrong executing the query
	 */
	public static java.math.BigDecimal fOne(org.jooq.Configuration configuration) {
		org.jooq.test.oracle.generatedclasses.routines.FOne f = new org.jooq.test.oracle.generatedclasses.routines.FOne();

		f.execute(configuration);
		return f.getReturnValue();
	}

	/**
	 * Get F_ONE as a field
	 *
	 */
	public static org.jooq.Field<java.math.BigDecimal> fOne() {
		org.jooq.test.oracle.generatedclasses.routines.FOne f = new org.jooq.test.oracle.generatedclasses.routines.FOne();

		return f.asField();
	}

	/**
	 * Invoke F317
	 *
	 * @param p1
	 * @param p2
	 * @param p3
	 * @param p4
	 * @throws org.jooq.exception.DataAccessException if something went wrong executing the query
	 */
	public static java.math.BigDecimal f317(org.jooq.Configuration configuration, java.lang.Number p1, java.lang.Number p2, java.lang.Number p3, java.lang.Number p4) {
		org.jooq.test.oracle.generatedclasses.routines.F317 f = new org.jooq.test.oracle.generatedclasses.routines.F317();
		f.setP1(p1);
		f.setP2(p2);
		f.setP3(p3);
		f.setP4(p4);

		f.execute(configuration);
		return f.getReturnValue();
	}

	/**
	 * Get F317 as a field
	 *
	 * @param p1
	 * @param p2
	 * @param p3
	 * @param p4
	 */
	public static org.jooq.Field<java.math.BigDecimal> f317(java.lang.Number p1, java.lang.Number p2, java.lang.Number p3, java.lang.Number p4) {
		org.jooq.test.oracle.generatedclasses.routines.F317 f = new org.jooq.test.oracle.generatedclasses.routines.F317();
		f.setP1(p1);
		f.setP2(p2);
		f.setP3(p3);
		f.setP4(p4);

		return f.asField();
	}

	/**
	 * Get F317 as a field
	 *
	 * @param p1
	 * @param p2
	 * @param p3
	 * @param p4
	 */
	public static org.jooq.Field<java.math.BigDecimal> f317(org.jooq.Field<? extends java.lang.Number> p1, org.jooq.Field<? extends java.lang.Number> p2, org.jooq.Field<? extends java.lang.Number> p3, org.jooq.Field<? extends java.lang.Number> p4) {
		org.jooq.test.oracle.generatedclasses.routines.F317 f = new org.jooq.test.oracle.generatedclasses.routines.F317();
		f.setP1(p1);
		f.setP2(p2);
		f.setP3(p3);
		f.setP4(p4);

		return f.asField();
	}

	/**
	 * Invoke F377
	 *
	 * @throws org.jooq.exception.DataAccessException if something went wrong executing the query
	 */
	public static void f377(org.jooq.Configuration configuration) {
		org.jooq.test.oracle.generatedclasses.routines.F377 p = new org.jooq.test.oracle.generatedclasses.routines.F377();

		p.execute(configuration);
	}

	/**
	 * Invoke F378
	 *
	 * @param returnValue OUT parameter
	 * @param i IN parameter
	 * @param io IN OUT parameter
	 * @param o OUT parameter
	 * @throws org.jooq.exception.DataAccessException if something went wrong executing the query
	 */
	public static org.jooq.test.oracle.generatedclasses.routines.F378 f378(org.jooq.Configuration configuration, java.lang.Number i, java.lang.Number io) {
		org.jooq.test.oracle.generatedclasses.routines.F378 p = new org.jooq.test.oracle.generatedclasses.routines.F378();
		p.setI(i);
		p.setIo(io);

		p.execute(configuration);
		return p;
	}

	/**
	 * Invoke P_ARRAYS1
	 *
	 * @param inArray IN parameter
	 * @param outArray OUT parameter
	 * @throws org.jooq.exception.DataAccessException if something went wrong executing the query
	 */
	public static org.jooq.test.oracle.generatedclasses.udt.records.UNumberArrayRecord pArrays1(org.jooq.Configuration configuration, org.jooq.test.oracle.generatedclasses.udt.records.UNumberArrayRecord inArray) {
		org.jooq.test.oracle.generatedclasses.routines.PArrays1 p = new org.jooq.test.oracle.generatedclasses.routines.PArrays1();
		p.setInArray(inArray);

		p.execute(configuration);
		return p.getOutArray();
	}

	/**
	 * Invoke P_ARRAYS2
	 *
	 * @param inArray IN parameter
	 * @param outArray OUT parameter
	 * @throws org.jooq.exception.DataAccessException if something went wrong executing the query
	 */
	public static org.jooq.test.oracle.generatedclasses.udt.records.UNumberLongArrayRecord pArrays2(org.jooq.Configuration configuration, org.jooq.test.oracle.generatedclasses.udt.records.UNumberLongArrayRecord inArray) {
		org.jooq.test.oracle.generatedclasses.routines.PArrays2 p = new org.jooq.test.oracle.generatedclasses.routines.PArrays2();
		p.setInArray(inArray);

		p.execute(configuration);
		return p.getOutArray();
	}

	/**
	 * Invoke P_ARRAYS3
	 *
	 * @param inArray IN parameter
	 * @param outArray OUT parameter
	 * @throws org.jooq.exception.DataAccessException if something went wrong executing the query
	 */
	public static org.jooq.test.oracle.generatedclasses.udt.records.UStringArrayRecord pArrays3(org.jooq.Configuration configuration, org.jooq.test.oracle.generatedclasses.udt.records.UStringArrayRecord inArray) {
		org.jooq.test.oracle.generatedclasses.routines.PArrays3 p = new org.jooq.test.oracle.generatedclasses.routines.PArrays3();
		p.setInArray(inArray);

		p.execute(configuration);
		return p.getOutArray();
	}

	/**
	 * Invoke P_AUTHOR_EXISTS
	 *
	 * @param authorName IN parameter
	 * @param result OUT parameter
	 * @throws org.jooq.exception.DataAccessException if something went wrong executing the query
	 */
	public static java.math.BigDecimal pAuthorExists(org.jooq.Configuration configuration, java.lang.String authorName) {
		org.jooq.test.oracle.generatedclasses.routines.PAuthorExists p = new org.jooq.test.oracle.generatedclasses.routines.PAuthorExists();
		p.setAuthorName(authorName);

		p.execute(configuration);
		return p.getResult();
	}

	/**
	 * Invoke P_CREATE_AUTHOR
	 *
	 * @throws org.jooq.exception.DataAccessException if something went wrong executing the query
	 */
	public static void pCreateAuthor(org.jooq.Configuration configuration) {
		org.jooq.test.oracle.generatedclasses.routines.PCreateAuthor p = new org.jooq.test.oracle.generatedclasses.routines.PCreateAuthor();

		p.execute(configuration);
	}

	/**
	 * Invoke P_CREATE_AUTHOR_BY_NAME
	 *
	 * @param firstName IN parameter
	 * @param lastName IN parameter
	 * @throws org.jooq.exception.DataAccessException if something went wrong executing the query
	 */
	public static void pCreateAuthorByName(org.jooq.Configuration configuration, java.lang.String firstName, java.lang.String lastName) {
		org.jooq.test.oracle.generatedclasses.routines.PCreateAuthorByName p = new org.jooq.test.oracle.generatedclasses.routines.PCreateAuthorByName();
		p.setFirstName(firstName);
		p.setLastName(lastName);

		p.execute(configuration);
	}

	/**
	 * Invoke P_ENHANCE_ADDRESS1
	 *
	 * @param address IN parameter
	 * @param no OUT parameter
	 * @throws org.jooq.exception.DataAccessException if something went wrong executing the query
	 */
	public static java.lang.String pEnhanceAddress1(org.jooq.Configuration configuration, org.jooq.test.oracle.generatedclasses.udt.records.UAddressTypeRecord address) {
		org.jooq.test.oracle.generatedclasses.routines.PEnhanceAddress1 p = new org.jooq.test.oracle.generatedclasses.routines.PEnhanceAddress1();
		p.setAddress(address);

		p.execute(configuration);
		return p.getNo();
	}

	/**
	 * Invoke P_ENHANCE_ADDRESS2
	 *
	 * @param address OUT parameter
	 * @throws org.jooq.exception.DataAccessException if something went wrong executing the query
	 */
	public static org.jooq.test.oracle.generatedclasses.udt.records.UAddressTypeRecord pEnhanceAddress2(org.jooq.Configuration configuration) {
		org.jooq.test.oracle.generatedclasses.routines.PEnhanceAddress2 p = new org.jooq.test.oracle.generatedclasses.routines.PEnhanceAddress2();

		p.execute(configuration);
		return p.getAddress();
	}

	/**
	 * Invoke P_ENHANCE_ADDRESS3
	 *
	 * @param address IN OUT parameter
	 * @throws org.jooq.exception.DataAccessException if something went wrong executing the query
	 */
	public static org.jooq.test.oracle.generatedclasses.udt.records.UAddressTypeRecord pEnhanceAddress3(org.jooq.Configuration configuration, org.jooq.test.oracle.generatedclasses.udt.records.UAddressTypeRecord address) {
		org.jooq.test.oracle.generatedclasses.routines.PEnhanceAddress3 p = new org.jooq.test.oracle.generatedclasses.routines.PEnhanceAddress3();
		p.setAddress(address);

		p.execute(configuration);
		return p.getAddress();
	}

	/**
	 * Invoke P_GET_ONE_CURSOR
	 *
	 * @param total OUT parameter
	 * @param books OUT parameter
	 * @param bookIds IN parameter
	 * @throws org.jooq.exception.DataAccessException if something went wrong executing the query
	 */
	public static org.jooq.test.oracle.generatedclasses.routines.PGetOneCursor pGetOneCursor(org.jooq.Configuration configuration, org.jooq.test.oracle.generatedclasses.udt.records.UNumberArrayRecord bookIds) {
		org.jooq.test.oracle.generatedclasses.routines.PGetOneCursor p = new org.jooq.test.oracle.generatedclasses.routines.PGetOneCursor();
		p.setBookIds(bookIds);

		p.execute(configuration);
		return p;
	}

	/**
	 * Invoke P_GET_TWO_CURSORS
	 *
	 * @param books OUT parameter
	 * @param authors OUT parameter
	 * @throws org.jooq.exception.DataAccessException if something went wrong executing the query
	 */
	public static org.jooq.test.oracle.generatedclasses.routines.PGetTwoCursors pGetTwoCursors(org.jooq.Configuration configuration) {
		org.jooq.test.oracle.generatedclasses.routines.PGetTwoCursors p = new org.jooq.test.oracle.generatedclasses.routines.PGetTwoCursors();

		p.execute(configuration);
		return p;
	}

	/**
	 * Invoke P_UNUSED
	 *
	 * @param in1 IN parameter
	 * @param out1 OUT parameter
	 * @param out2 IN OUT parameter
	 * @throws org.jooq.exception.DataAccessException if something went wrong executing the query
	 */
	public static org.jooq.test.oracle.generatedclasses.routines.PUnused pUnused(org.jooq.Configuration configuration, java.lang.String in1, java.lang.Number out2) {
		org.jooq.test.oracle.generatedclasses.routines.PUnused p = new org.jooq.test.oracle.generatedclasses.routines.PUnused();
		p.setIn1(in1);
		p.setOut2(out2);

		p.execute(configuration);
		return p;
	}

	/**
	 * Invoke P377
	 *
	 * @throws org.jooq.exception.DataAccessException if something went wrong executing the query
	 */
	public static void p377(org.jooq.Configuration configuration) {
		org.jooq.test.oracle.generatedclasses.routines.P377 p = new org.jooq.test.oracle.generatedclasses.routines.P377();

		p.execute(configuration);
	}

	/**
	 * Invoke P391
	 *
	 * @param i1 IN parameter
	 * @param io1 IN OUT parameter
	 * @param o1 OUT parameter
	 * @param o2 OUT parameter
	 * @param io2 IN OUT parameter
	 * @param i2 IN parameter
	 * @throws org.jooq.exception.DataAccessException if something went wrong executing the query
	 */
	public static org.jooq.test.oracle.generatedclasses.routines.P391 p391(org.jooq.Configuration configuration, java.lang.Number i1, java.lang.Number io1, java.lang.Number io2, java.lang.Number i2) {
		org.jooq.test.oracle.generatedclasses.routines.P391 p = new org.jooq.test.oracle.generatedclasses.routines.P391();
		p.setI1(i1);
		p.setIo1(io1);
		p.setIo2(io2);
		p.setI2(i2);

		p.execute(configuration);
		return p;
	}

	/**
	 * No instances
	 */
	private Routines() {}
}
