
<?php 
// The following content has been XSL transformed from manual.xml using html-pages.xsl
// Please do not edit this content manually
require '../../../frame.php';
function printH1() {
    print "The Query and its various subtypes";
}
function getSlogan() {
	return "
							The Query type hierarchy is what you use to execute queries. It has the
							following subtypes for each kind of operation
						";
}
function printContent() {
    global $root;
?>
<table cellpadding="0" cellspacing="0" border="0" width="100%">
<tr>
<td align="left" valign="top"><a href="<?=$root?>/manual/">The jOOQ User Manual</a> : <a href="<?=$root?>/manual/JOOQ/">jOOQ classes and their usage</a> : <a href="<?=$root?>/manual/JOOQ/Query/">The Query and its various subtypes</a></td><td align="right" valign="top" style="white-space: nowrap"><a href="<?=$root?>/manual/JOOQ/UpdatableRecord/" title="Previous section: Updatable Records">previous</a> : <a href="<?=$root?>/manual/JOOQ/ResultQuery/" title="Next section: ResultQuery and various ways of fetching data">next</a></td>
</tr>
</table>
							<h2>SELECT statements</h2>
							<p>
								There are essentially two ways of creating SELECT statements in jOOQ.
								For historical reasons, you can create 
								<a href="https://github.com/lukaseder/jOOQ/blob/master/jOOQ/src/main/java/org/jooq/SimpleSelectQuery.java" title="Internal API reference: org.jooq.SimpleSelectQuery">org.jooq.SimpleSelectQuery</a> or 
								<a href="https://github.com/lukaseder/jOOQ/blob/master/jOOQ/src/main/java/org/jooq/SelectQuery.java" title="Internal API reference: org.jooq.SelectQuery">org.jooq.SelectQuery</a>
								objects and add additional query clauses, such as 
								<a href="https://github.com/lukaseder/jOOQ/blob/master/jOOQ/src/main/java/org/jooq/Condition.java" title="Internal API reference: org.jooq.Condition">Conditions</a> or
								<a href="https://github.com/lukaseder/jOOQ/blob/master/jOOQ/src/main/java/org/jooq/SortField.java" title="Internal API reference: org.jooq.SortField">SortFields</a> to it. 
								Since jOOQ 1.3, there is also the possibility to
								create SELECT statements using jOOQ's 
								<a href="<?=$root?>/manual/DSL/" title="jOOQ Manual reference: DSL or fluent API. Where SQL meets Java">DSL API</a> in a much more intuitive
								and SQL-like way. 
							</p>
							<p>Use the DSL API when: </p>
							<ul>
								
<li>You want your code to look like SQL</li>
								
<li>You want your IDE to help you with auto-completion (you will not be able to write select .. order by .. where .. join or any of that stuff) </li>
							
</ul>
							<p>Use the regular API when: </p>
							<ul>
								
<li>You want to create your query step-by-step, creating query parts one-by-one</li>
							    
<li>You need to assemble your query from various places, passing the query around, adding new conditions and joins on the way </li>
							
</ul>
							<p>In any case, all API's will construct the same underlying
								implementation object, and in many cases, you can combine the two
								approaches. Let's check out the various SELECT statement types: </p>
								
							<ul>
								
<li>
<a href="https://github.com/lukaseder/jOOQ/blob/master/jOOQ/src/main/java/org/jooq/Select.java" title="Internal API reference: org.jooq.Select">org.jooq.Select</a>: 
								    This Query subtype stands for a general type of SELECT statement. 
								    It is also the main Select type for the 
								    <a href="<?=$root?>/manual/DSL/" title="jOOQ Manual reference: DSL or fluent API. Where SQL meets Java">DSL API</a>. When executed, this object 
								    will hold a <a href="<?=$root?>/manual/JOOQ/Result/" title="jOOQ Manual reference: Results and Records">Result containing the resulting Records</a>. 
								    This type is further subtyped for the various uses of a SELECT statement as such:</li> 
								
<li>
<a href="https://github.com/lukaseder/jOOQ/blob/master/jOOQ/src/main/java/org/jooq/SimpleSelectQuery.java" title="Internal API reference: org.jooq.SimpleSelectQuery">org.jooq.SimpleSelectQuery</a>:
									This Query will allow for selecting from single physical Tables only.
									It therefore has access to the Table's generic type parameter 
									&lt;R extends Record&gt; and will provide a matching Result&lt;R&gt;. 
									This is especially useful if &lt;R&gt; is a subtype of 
									<a href="<?=$root?>/manual/JOOQ/UpdatableRecord/" title="jOOQ Manual reference: Updatable Records">UpdatableRecord</a>.
									Then you will be able to perform updates on your result set immediately.</li>
								
<li>
<a href="https://github.com/lukaseder/jOOQ/blob/master/jOOQ/src/main/java/org/jooq/SelectQuery.java" title="Internal API reference: org.jooq.SelectQuery">org.jooq.SelectQuery</a>:
									This Query will allow for selecting a subset of Fields from several 
									Tables. Because the results of such a query are considered of an anonymous
									or ad-hoc type, this Query will bind &lt;R&gt; to the general type Record 
									itself. The purpose of this Query type is to allow for full SQL support, 
									including SELECT, JOIN and GROUP BY clauses. </li>
							
</ul>
							
							<h3>Example: SQL query and DSL query</h3>
							<table width="100%" cellpadding="0" cellspacing="0">
<tr>
<td width="50%" class="left">
<pre class="prettyprint lang-sql">
-- Select all books by authors born after 1920, named "Paulo" 
-- from a catalogue consisting of authors and books:


SELECT * 
  FROM t_author a 
  JOIN t_book b 
    ON a.id = b.author_id 
 WHERE a.year_of_birth &gt; 1920 
   AND a.first_name = 'Paulo'
 ORDER BY b.title</pre>
</td><td width="50%" class="right">
<pre class="prettyprint lang-java">
// Instanciate your factory using a JDBC connection.
Factory create = new Factory(connection, SQLDialect.ORACLE);

// Execute the query "on a single line"
Result&lt;Record&gt; result = create.select()
    .from(T_AUTHOR)
    .join(T_BOOK)
    .on(ID.equal(AUTHOR_ID))
    .where(YEAR_OF_BIRTH.greaterThan(1920)
    .and(FIRST_NAME.equal("Paulo")))
    .orderBy(TITLE).fetch();</pre>
</td>
</tr>
</table>
							
							<p>
								In the above example, some generated artefacts are used for querying. 
								In this case, T_AUTHOR and T_BOOK are instances of types 
								<a href="https://github.com/lukaseder/jOOQ/blob/master/jOOQ-test/src/org/jooq/test/oracle/generatedclasses/tables/TAuthor.java" title="Internal API reference: org.jooq.test.oracle.generatedclasses.tables.TAuthor">TAuthor</a> and 
								<a href="https://github.com/lukaseder/jOOQ/blob/master/jOOQ-test/src/org/jooq/test/oracle/generatedclasses/tables/TBook.java" title="Internal API reference: org.jooq.test.oracle.generatedclasses.tables.TBook">TBook</a> respectively. 
								Their full qualification would read TAuthor.T_AUTHOR and TBook.T_BOOK, but in many cases, 
								it's useful to static import elements involved with queries, in order to decrease verbosity. 
							</p>
							
							<p>
								Apart from the singleton Table instances TAuthor.T_AUTHOR and
								TBook.T_BOOK, these generated classes also contain one static member
								for every physical field, such as TAuthor.ID or TBook.TAUTHOR_ID, etc. 
							</p>
							
							<ul>
								
<li>For more information about code generation, check out the manual's section about 
									<a href="<?=$root?>/manual/META/" title="jOOQ Manual reference: Meta model code generation">Meta model source code generation</a>.</li>
    							
<li>For more DSL examples, please consider the manual's section about the 
    								<a href="<?=$root?>/manual/DSL/" title="jOOQ Manual reference: DSL or fluent API. Where SQL meets Java">DSL API</a>.</li>
							
</ul>
							
							<h3>Example: Non-DSL query</h3>
							<p>
								If you choose not to use the DSL API (for instance, because you don't
								want to add Query parts in the order SQL expects them), you can use
								this syntax: 
							</p>
							<pre class="prettyprint lang-java">
// Re-use the factory to create a SelectQuery. This example will not make use of static imports...
SelectQuery q = create.selectQuery();
q.addFrom(TAuthor.T_AUTHOR);

// This example shows some "mixed" API usage, where the JOIN is added with the standard API, and the 
// Condition is created using the DSL API
q.addJoin(TBook.T_BOOK, TAuthor.ID.equal(TBook.AUTHOR_ID));

// The AND operator between Conditions is implicit here
q.addConditions(TAuthor.YEAR_OF_BIRTH.greaterThan(1920));
q.addConditions(TAuthor.FIRST_NAME.equal("Paulo"));
q.addOrderBy(TBook.TITLE);</pre>

							<h3>Fetching data</h3>
							<p>
								The <a href="https://github.com/lukaseder/jOOQ/blob/master/jOOQ/src/main/java/org/jooq/Select.java" title="Internal API reference: org.jooq.Select">org.jooq.Select</a> interface extends 
								<a href="https://github.com/lukaseder/jOOQ/blob/master/jOOQ/src/main/java/org/jooq/ResultQuery.java" title="Internal API reference: org.jooq.ResultQuery">org.jooq.ResultQuery</a>, 
								which provides a range of methods to fetch data from the database. 
								Once you have constructed your SELECT query (see examples above), you 
								may choose to either simply execute() it, or use a variety of convenience
								fetchXXX() methods. 
							</p>
							<p>
								See the manual's 
								<a href="<?=$root?>/manual/JOOQ/ResultQuery/" title="jOOQ Manual reference: ResultQuery and various ways of fetching data">section on the ResultQuery</a>
								for more details. 
							</p>
							
							
							<h2>INSERT Statements</h2>
							<p>jOOQ supports two modes for INSERT statements. 
							The INSERT VALUES and the INSERT SELECT syntax</p>
							
							<h3>Example: SQL query and DSL query</h3>
							<table width="100%" cellpadding="0" cellspacing="0">
<tr>
<td width="50%" class="left">
<pre class="prettyprint lang-sql">
INSERT INTO T_AUTHOR 
    (ID, FIRST_NAME, LAST_NAME)
VALUES 
    (100, 'Hermann', 'Hesse'),
    (101, 'Alfred', 'D&ouml;blin');</pre>
</td><td width="50%" class="right">
<pre class="prettyprint lang-java">
create.insertInto(T_AUTHOR, 
          TAuthor.ID, TAuthor.FIRST_NAME, TAuthor.LAST_NAME)
      .values(100, "Hermann", "Hesse")
      .values(101, "Alfred", "D&ouml;blin")
      .execute();</pre>
</td>
</tr>
</table>

							<p>The DSL syntax tries to stay close to actual SQL. In detail,
								however, Java is limited in its possibilities. That's why the
								.values() clause is repeated for every record. Some RDBMS support
								inserting several records at the same time. This is also supported in
								jOOQ, and simulated using INSERT INTO .. SELECT .. UNION ALL SELECT ..
								clauses for those RDBMS that don't support this syntax.
							</p>
							<p>Note: Just like in SQL itself, you can have syntax errors when you
								don't have matching numbers of fields/values. Also, you can run into
								runtime problems, if your field/value types don't match. </p>
								
							<h3>Example: DSL Query, alternative syntax</h3>
							<p>MySQL (and some other RDBMS) allow for using an UPDATE-like syntax
								for INSERT statements. This is also supported in jOOQ, should you
								prefer that syntax. The above INSERT statement can also be expressed
								as follows: </p>
							<pre class="prettyprint lang-java">
create.insertInto(T_AUTHOR)
      .set(TAuthor.ID, 100)
      .set(TAuthor.FIRST_NAME, "Hermann")
      .set(TAuthor.LAST_NAME, "Hesse")
      .newRecord()
      .set(TAuthor.ID, 101)
      .set(TAuthor.FIRST_NAME, "Alfred")
      .set(TAuthor.LAST_NAME, "D&ouml;blin")
      .execute();</pre>
							<p>As you can see, this syntax is a bit more verbose, but also more
								type-safe, as every field can be matched with its value.</p>
								
							<h3>Example: ON DUPLICATE KEY UPDATE clause</h3>
							<p>The MySQL database supports a very convenient way to INSERT or
								UPDATE a record. This is a non-standard extension to the SQL syntax,
								which is supported by jOOQ and simulated in other RDBMS, where this is
								possible. Here is an example how to use the ON DUPLICATE KEY UPDATE
								clause: </p>
							<pre class="prettyprint lang-java">
// Add a new author called "Koontz" with ID 3.
// If that ID is already present, update the author's name
create.insertInto(T_AUTHOR, TAuthor.ID, TAuthor.LAST_NAME)
      .values(3, "Koontz")
      .onDuplicateKeyUpdate()
      .set(TAuthor.LAST_NAME, "Koontz")
      .execute();</pre>
      
      						<h3>Example: INSERT .. RETURNING clause</h3>
							<p>The Postgres database has native support for an INSERT .. RETURNING
								clause. This is a very powerful concept that is simulated for all
								other dialects using JDBC's 
								<a href="http://download.oracle.com/javase/6/docs/api/java/sql/Statement.html#getGeneratedKeys()" title="External API reference: java.sql.Statement">getGeneratedKeys()</a> 
								method. Take this example:</p>
								
							<pre class="prettyprint lang-java">
// Add another author, with a generated ID
Record&lt;?&gt; record =
create.insertInto(T_AUTHOR, TAuthor.FIRST_NAME, TAuthor.LAST_NAME)
      .values("Charlotte", "Roche")
      .returning(TAuthor.ID)
      .fetchOne();

System.out.println(record.getValue(TAuthor.ID));

// For some RDBMS, this also works when inserting several values
Result&lt;?&gt; result =
create.insertInto(T_AUTHOR, TAuthor.FIRST_NAME, TAuthor.LAST_NAME)
      .values("Johann Wolfgang", "von Goethe")
      .values("Friedrich", "Schiller")
      // You can request any field. Also trigger-generated values
      .returning(TAuthor.ID, TAuthor.CREATION_DATE)
      .fetch();</pre>
      						
      						<h3>Example: Non-DSL Query</h3>
      						<p>You can always use the more verbose regular syntax of the InsertQuery, if you need more control: </p>
      						<pre class="prettyprint lang-java">
// Insert a new author into the T_AUTHOR table
InsertQuery&lt;TAuthorRecord&gt; i = create.insertQuery(T_AUTHOR);
i.addValue(TAuthor.ID, 100);
i.addValue(TAuthor.FIRST_NAME, "Hermann");
i.addValue(TAuthor.LAST_NAME, "Hesse");

i.newRecord();
i.addValue(TAuthor.ID, 101);
i.addValue(TAuthor.FIRST_NAME, "Alfred");
i.addValue(TAuthor.LAST_NAME, "D&ouml;blin");
i.execute();</pre>

							<h3>Example: INSERT Query combined with SELECT statements</h3>
							<p>The InsertQuery.addValue() method is overloaded, such that you can
								also provide a Field, potentially containing an expression: </p>
							<pre class="prettyprint lang-java">
// Insert a new author into the T_AUTHOR table
InsertQuery&lt;TAuthorRecord&gt; i = create.insertQuery(T_AUTHOR);
i.addValue(TAuthor.ID, create.select(TAuthor.ID.max().add(1)).from(T_AUTHOR).asField())
i.addValue(TAuthor.FIRST_NAME, "Hermann");
i.addValue(TAuthor.LAST_NAME, "Hesse");
i.execute();</pre>
							<p>Note that especially MySQL (and some other RDBMS) has some
								limitations regarding that syntax. You may not be able to
								select from the same table you're inserting into</p>
								
							<h3>Example: INSERT SELECT syntax support</h3>
							<p>In some occasions, you may prefer the INSERT SELECT syntax, for instance, when 
								you copy records from one table to another: </p>
							<pre class="prettyprint lang-java">
Insert i = create.insertInto(T_AUTHOR_ARCHIVE,
           create.selectFrom(T_AUTHOR).where(TAuthor.DECEASED.equal(1)));
i.execute();</pre>

							
							<h2>UPDATE Statements</h2>
							<p>UPDATE statements are only possible on single tables. Support for 
							multi-table updates will be implemented in the near future. </p>
							
							<h3>Example: SQL query and DSL query</h3>
							<table width="100%" cellpadding="0" cellspacing="0">
<tr>
<td width="50%" class="left">
<pre class="prettyprint lang-sql">

UPDATE T_AUTHOR
   SET FIRST_NAME = 'Hermann',
       LAST_NAME = 'Hesse'
 WHERE ID = 3;</pre>
</td><td width="50%" class="right">
<pre class="prettyprint lang-java">
create.update(T_AUTHOR)
      .set(TAuthor.FIRST_NAME, "Hermann")
      .set(TAuthor.LAST_NAME, "Hesse")
      .where(TAuthor.ID.equal(3))
      .execute();</pre>
</td>
</tr>
</table>
							
							<h3>Example: Non-DSL Query</h3>
							<p>Using the <a href="https://github.com/lukaseder/jOOQ/blob/master/jOOQ/src/main/java/org/jooq/UpdateQuery.java" title="Internal API reference: org.jooq.UpdateQuery">org.jooq.UpdateQuery</a> class, 
							this is how you could express an UPDATE statement:</p> 
							<pre class="prettyprint lang-java">
UpdateQuery&lt;TAuthorRecord&gt; u = create.updateQuery(T_AUTHOR);
u.addValue(TAuthor.FIRST_NAME, "Hermann");
u.addValue(TAuthor.FIRST_NAME, "Hesse");
u.addConditions(TAuthor.ID.equal(3));
u.execute();</pre>

							
							<h2>DELETE Statements</h2>
							<p>DELETE statements are only possible on single tables. Support for 
							multi-table deletes will be implemented in the near future. </p>
							
							<h3>Example: SQL query and DSL query</h3>
							<table width="100%" cellpadding="0" cellspacing="0">
<tr>
<td width="50%" class="left">
<pre class="prettyprint lang-sql">

DELETE T_AUTHOR
 WHERE ID = 100;</pre>
</td><td width="50%" class="right">
<pre class="prettyprint lang-java">
create.delete(T_AUTHOR)
      .where(TAuthor.ID.equal(100))
      .execute();</pre>
</td>
</tr>
</table>
							
							<h3>Example: Non-DSL Query</h3>
							<p>Using the <a href="https://github.com/lukaseder/jOOQ/blob/master/jOOQ/src/main/java/org/jooq/DeleteQuery.java" title="Internal API reference: org.jooq.DeleteQuery">org.jooq.DeleteQuery</a> class, 
							this is how you could express a DELETE statement: </p> 
							<pre class="prettyprint lang-java">
DeleteQuery&lt;TAuthorRecord&gt; d = create.deleteQuery(T_AUTHOR);
d.addConditions(TAuthor.ID.equal(100));
d.execute();</pre>


							<h2>MERGE Statement</h2>
							<p>
								The MERGE statement is one of the most advanced standardised SQL
								constructs, which is supported by DB2, HSQLDB, Oracle, SQL Server and
								Sybase (MySQL has the similar INSERT .. ON DUPLICATE KEY UPDATE
								construct. H2's MERGE variant is currently not supported.)
							</p>
							<p>
								The point of the standard MERGE statement is to take a TARGET table, and
								merge (INSERT, UPDATE) data from a SOURCE table into it. DB2, Oracle,
								SQL Server and Sybase also allow for DELETING some data and for adding
								many additional clauses. Those non-standard extensions are currently
								not supported. Here is an example:
							</p>
							
							<table width="100%" cellpadding="0" cellspacing="0">
<tr>
<td width="50%" class="left">
<pre class="prettyprint lang-sql">
-- Check if there is already an author called 'Hitchcock'
-- If there is, rename him to John. If there isn't add him.

MERGE INTO T_AUTHOR
USING (SELECT 1 FROM DUAL)
ON (LAST_NAME = 'Hitchcock')
WHEN MATCHED THEN UPDATE SET FIRST_NAME = 'John'
WHEN NOT MATCHED THEN INSERT (LAST_NAME) VALUES ('Hitchcock')</pre>
</td><td width="50%" class="right">
<pre class="prettyprint lang-java">
create.mergeInto(T_AUTHOR)
      .using(create().selectOne())
      .on(TAuthor.LAST_NAME.equal("Hitchcock"))
      .whenMatchedThenUpdate()
      .set(TAuthor.FIRST_NAME, "John")
      .whenNotMatchedThenInsert(TAuthor.LAST_NAME)
      .values("Hitchcock")
      .execute();</pre>
</td>
</tr>
</table>
							
							
							<h2>TRUNCATE Statement</h2>
							<p>
								The syntax is trivial:
							</p>
							
							<table width="100%" cellpadding="0" cellspacing="0">
<tr>
<td width="50%" class="left">
<pre class="prettyprint lang-sql">TRUNCATE TABLE T_AUTHOR;</pre>
</td><td width="50%" class="right">
<pre class="prettyprint lang-java">create.truncate(T_AUTHOR).execute();</pre>
</td>
</tr>
</table>
							<p>This is not supported by Ingres and SQLite. jOOQ will execute a DELETE FROM
								T_AUTHOR statement instead. </p>
						<br><table cellpadding="0" cellspacing="0" border="0" width="100%">
<tr>
<td align="left" valign="top"><a href="<?=$root?>/manual/">The jOOQ User Manual</a> : <a href="<?=$root?>/manual/JOOQ/">jOOQ classes and their usage</a> : <a href="<?=$root?>/manual/JOOQ/Query/">The Query and its various subtypes</a></td><td align="right" valign="top" style="white-space: nowrap"><a href="<?=$root?>/manual/JOOQ/UpdatableRecord/" title="Previous section: Updatable Records">previous</a> : <a href="<?=$root?>/manual/JOOQ/ResultQuery/" title="Next section: ResultQuery and various ways of fetching data">next</a></td>
</tr>
</table>
<?php 
}
?>

