/**
 * This class is generated by jOOQ
 */
package org.jooq.test.ase.generatedclasses;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = "http://jooq.sourceforge.net",
                            comments = "This class is generated by jOOQ")
public class Dbo extends org.jooq.impl.SchemaImpl {

	private static final long serialVersionUID = 1618151917;

	/**
	 * The singleton instance of dbo
	 */
	public static final Dbo DBO = new Dbo();

	/**
	 * No further instances allowed
	 */
	private Dbo() {
		super("dbo");
	}

	@Override
	public final java.util.List<org.jooq.Table<?>> getTables() {
		return java.util.Arrays.<org.jooq.Table<?>>asList(
			org.jooq.test.ase.generatedclasses.tables.VAuthor.V_AUTHOR,
			org.jooq.test.ase.generatedclasses.tables.VBook.V_BOOK,
			org.jooq.test.ase.generatedclasses.tables.VLibrary.V_LIBRARY,
			org.jooq.test.ase.generatedclasses.tables.T_639NumbersTable.T_639_NUMBERS_TABLE,
			org.jooq.test.ase.generatedclasses.tables.T_658Ref.T_658_REF,
			org.jooq.test.ase.generatedclasses.tables.T_725LobTest.T_725_LOB_TEST,
			org.jooq.test.ase.generatedclasses.tables.T_785.T_785,
			org.jooq.test.ase.generatedclasses.tables.TAuthor.T_AUTHOR,
			org.jooq.test.ase.generatedclasses.tables.TBook.T_BOOK,
			org.jooq.test.ase.generatedclasses.tables.TBookStore.T_BOOK_STORE,
			org.jooq.test.ase.generatedclasses.tables.TBookToBookStore.T_BOOK_TO_BOOK_STORE,
			org.jooq.test.ase.generatedclasses.tables.TTriggers.T_TRIGGERS,
			org.jooq.test.ase.generatedclasses.tables.XTestCase_64_69.X_TEST_CASE_64_69,
			org.jooq.test.ase.generatedclasses.tables.XTestCase_71.X_TEST_CASE_71,
			org.jooq.test.ase.generatedclasses.tables.XTestCase_85.X_TEST_CASE_85,
			org.jooq.test.ase.generatedclasses.tables.XUnused.X_UNUSED);
	}
}