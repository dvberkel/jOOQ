DROP PROCEDURE IF EXISTS p_arrays1/
DROP PROCEDURE IF EXISTS p_arrays2/
DROP PROCEDURE IF EXISTS p_arrays3/
DROP FUNCTION IF EXISTS f_arrays1/
DROP FUNCTION IF EXISTS f_arrays2/
DROP FUNCTION IF EXISTS f_arrays3/
DROP PROCEDURE IF EXISTS p_author_exists/
DROP PROCEDURE IF EXISTS p_unused/
DROP PROCEDURE IF EXISTS p_create_author/ 
DROP PROCEDURE IF EXISTS p_create_author_by_name/
DROP PROCEDURE IF EXISTS p391/
DROP FUNCTION IF EXISTS f_author_exists/
DROP FUNCTION IF EXISTS f_one/
DROP FUNCTION IF EXISTS f_number/
DROP FUNCTION IF EXISTS f317/
DROP PROCEDURE IF EXISTS p_get_two_cursors/
DROP PROCEDURE IF EXISTS p_get_one_cursor/
DROP FUNCTION IF EXISTS f_get_one_cursor/

DROP VIEW IF EXISTS v_author/
DROP VIEW IF EXISTS v_book/
DROP VIEW IF EXISTS v_library/

DROP TRIGGER IF EXISTS t_triggers_trigger/
DROP SEQUENCE s_triggers_sequence/

DROP TABLE IF EXISTS t_triggers/
DROP TABLE IF EXISTS t_arrays/
DROP TABLE IF EXISTS t_book_to_book_store/
DROP TABLE IF EXISTS t_book_store/
DROP TABLE IF EXISTS t_book/
DROP TABLE IF EXISTS t_book_details/
DROP TABLE IF EXISTS t_author/
DROP TABLE IF EXISTS t_language/
DROP TABLE IF EXISTS x_test_case_71/
DROP TABLE IF EXISTS x_test_case_85/
DROP TABLE IF EXISTS x_test_case_64_69/
DROP TABLE IF EXISTS x_unused/
DROP TABLE IF EXISTS t_639_numbers_table/
DROP TABLE IF EXISTS t_658_ref/
DROP TABLE IF EXISTS t_658_11/
DROP TABLE IF EXISTS t_658_21/
DROP TABLE IF EXISTS t_658_31/
DROP TABLE IF EXISTS t_658_12/
DROP TABLE IF EXISTS t_658_22/
DROP TABLE IF EXISTS t_658_32/
DROP TABLE IF EXISTS t_725_lob_test/
DROP TABLE IF EXISTS t_785/
DROP TABLE IF EXISTS T_937/
DROP TABLE IF EXISTS "T_941"/
DROP TABLE IF EXISTS "t_941"/
DROP TABLE IF EXISTS T_943/
DROP TABLE IF EXISTS system/
DROP TABLE IF EXISTS class/
DROP TABLE IF EXISTS integer/
DROP TABLE IF EXISTS long/
DROP TABLE IF EXISTS object/
DROP TABLE IF EXISTS string/
DROP TABLE IF EXISTS big_decimal/

CREATE SEQUENCE s_triggers_sequence START WITH 1/

CREATE TABLE t_triggers (
  id_generated int not null,
  id int,
  counter int,
  
  CONSTRAINT pk_t_triggers PRIMARY KEY (id_generated)
)
/

CREATE TRIGGER t_triggers_trigger
BEFORE INSERT
ON t_triggers
REFERENCING NEW AS new
FOR EACH ROW
BEGIN ATOMIC
    select next value for s_triggers_sequence 
	into new.id_generated
	from information_schema.system_users;
	
	set new.id = new.id_generated;
	set new.counter = new.id_generated * 2;
END
/

CREATE TABLE t_language (
  cd CHAR(2) NOT NULL,
  description VARCHAR(50),
  description_english VARCHAR(50),
  id INTEGER NOT NULL,
  
  CONSTRAINT pk_t_language PRIMARY KEY (ID)
)
/

CREATE TABLE t_658_11 (
  id CHAR(3) NOT NULL,
  
  CONSTRAINT pk_t_658_11 PRIMARY KEY (id)
)
/

CREATE TABLE t_658_21 (
  id INT NOT NULL,
  
  CONSTRAINT pk_t_658_21 PRIMARY KEY (id)
)
/

CREATE TABLE t_658_31 (
  id BIGINT NOT NULL,
  
  CONSTRAINT pk_t_658_31 PRIMARY KEY (id)
)
/

CREATE TABLE t_658_12 (
  id CHAR(3) NOT NULL,
  cd CHAR(3) NOT NULL,
  
  CONSTRAINT pk_t_658_12 PRIMARY KEY (id)
)
/

CREATE TABLE t_658_22 (
  id INT NOT NULL,
  cd INT NOT NULL,
  
  CONSTRAINT pk_t_658_22 PRIMARY KEY (id)
)
/

CREATE TABLE t_658_32 (
  id BIGINT NOT NULL,
  cd BIGINT NOT NULL,
  
  CONSTRAINT pk_t_658_32 PRIMARY KEY (id)
)
/

CREATE TABLE t_658_ref (
  ref_11 char(3),
  ref_21 int,
  ref_31 bigint,
  ref_12 char(3),
  ref_22 int,
  ref_32 bigint,

  CONSTRAINT fk_t_658_11 FOREIGN KEY (ref_11) REFERENCES t_658_11(id),
  CONSTRAINT fk_t_658_21 FOREIGN KEY (ref_21) REFERENCES t_658_21(id),
  CONSTRAINT fk_t_658_31 FOREIGN KEY (ref_31) REFERENCES t_658_31(id),
  CONSTRAINT fk_t_658_12 FOREIGN KEY (ref_12) REFERENCES t_658_12(id),
  CONSTRAINT fk_t_658_22 FOREIGN KEY (ref_22) REFERENCES t_658_22(id),
  CONSTRAINT fk_t_658_32 FOREIGN KEY (ref_32) REFERENCES t_658_32(id)
)
/

CREATE TABLE t_725_lob_test (
  ID int NOT NULL,
  LOB LONGVARBINARY NULL,
  
  CONSTRAINT pk_t_725_lob_test PRIMARY KEY (id)
)
/

CREATE TABLE t_785 (
  ID int,
  NAME varchar(50),
  VALUE varchar(50)
)
/

CREATE TABLE T_937 (
  T_937 int,
  
  CONSTRAINT T_937 PRIMARY KEY (T_937)
)
/

CREATE TABLE t_author (
  ID INT,
  FIRST_NAME VARCHAR(50),
  LAST_NAME VARCHAR(50) NOT NULL,
  DATE_OF_BIRTH DATE,
  YEAR_OF_BIRTH INT,
  ADDRESS VARCHAR(50),
  
  CONSTRAINT pk_t_author PRIMARY KEY (ID)
);
/

CREATE TABLE t_book_details (
  ID INT,
    
  CONSTRAINT pk_t_book_details PRIMARY KEY (ID)
);
/

CREATE TABLE t_book (
  ID INT,
  AUTHOR_ID INT NOT NULL,
  co_author_id int,
  DETAILS_ID INT,
  TITLE VARCHAR(400) NOT NULL,
  PUBLISHED_IN INT NOT NULL,
  LANGUAGE_ID INT NOT NULL,
  CONTENT_TEXT LONGVARCHAR,
  CONTENT_PDF LONGVARBINARY,
  
  CONSTRAINT pk_t_book PRIMARY KEY (ID),
  CONSTRAINT fk_t_book_author_id FOREIGN KEY (AUTHOR_ID) REFERENCES T_AUTHOR(ID),
  CONSTRAINT fk_t_book_co_author_id FOREIGN KEY (CO_AUTHOR_ID) REFERENCES T_AUTHOR(ID),
  CONSTRAINT fk_t_book_details_id FOREIGN KEY (DETAILS_ID) REFERENCES T_BOOK_DETAILS(ID), 
  CONSTRAINT fk_t_book_language_id FOREIGN KEY (LANGUAGE_ID) REFERENCES T_LANGUAGE(ID)
);
/

CREATE TABLE t_book_store (
  id INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1),
  name VARCHAR(400) NOT NULL,
  
  CONSTRAINT uk_t_book_store_name UNIQUE(name)
);
/

CREATE TABLE t_book_to_book_store (
  book_store_name VARCHAR(400) NOT NULL,
  book_id INTEGER NOT NULL,
  stock INTEGER,
  
  CONSTRAINT pk_b2bs PRIMARY KEY(book_store_name, book_id),
  CONSTRAINT fk_b2bs_bs_name FOREIGN KEY (book_store_name)
                             REFERENCES t_book_store (name)
                             ON DELETE CASCADE,
  CONSTRAINT fk_b2bs_b_id    FOREIGN KEY (book_id)
                             REFERENCES t_book (id)
                             ON DELETE CASCADE
);
/


CREATE TABLE t_arrays (
  id integer not null,
  string_array VARCHAR(20) ARRAY,
  number_array INTEGER ARRAY,
  date_array DATE ARRAY,
  
  CONSTRAINT pk_t_arrays PRIMARY KEY (ID)
);
/

CREATE TABLE x_unused (
  ID INT NOT NULL,
  NAME VARCHAR(10) NOT NULL,
  BIG_INTEGER DECIMAL(25),
  ID_REF INT,
  CLASS INT,
  FIELDS INT,
  CONFIGURATION INT,
  U_D_T INT,
  META_DATA INT,
  TYPE0 INT,
  PRIMARY_KEY INT,
  PRIMARYKEY INT,	
  NAME_REF VARCHAR(10),	
  "FIELD 737" DECIMAL(25, 2),
 
  CONSTRAINT pk_x_unused PRIMARY KEY(ID, NAME),
  CONSTRAINT uk_x_unused_id UNIQUE(ID),
  CONSTRAINT fk_x_unused_self FOREIGN KEY(ID_REF, NAME_REF) REFERENCES X_UNUSED(ID, NAME)
);
/

CREATE TABLE t_639_numbers_table (
  ID INT NOT NULL,
  BYTE TINYINT,
  SHORT SMALLINT,
  INTEGER INT,
  LONG BIGINT,
  BYTE_DECIMAL DECIMAL(2, 0),
  SHORT_DECIMAL DECIMAL(4, 0),
  INTEGER_DECIMAL DECIMAL(9, 0),
  LONG_DECIMAL DECIMAL(18, 0),
  BIG_INTEGER DECIMAL(22, 0),
  BIG_DECIMAL DECIMAL(22, 5),
  FLOAT REAL,
  DOUBLE DOUBLE,
  
  CONSTRAINT pk_t_639_numbers_table PRIMARY KEY(ID)
);
/

CREATE TABLE x_test_case_64_69 (
  ID INT NOT NULL,
  UNUSED_ID INT,
   
  CONSTRAINT pk_x_test_case_64_69 PRIMARY KEY(ID),
  CONSTRAINT fk_x_test_case_64_69 FOREIGN KEY(UNUSED_ID) REFERENCES X_UNUSED(ID)
);
/

CREATE TABLE x_test_case_71 (
  ID INT NOT NULL,
  TEST_CASE_64_69_ID SMALLINT,
 
  CONSTRAINT pk_x_test_case_71 PRIMARY KEY(ID),
  CONSTRAINT fk_x_test_case_71 FOREIGN KEY(TEST_CASE_64_69_ID) REFERENCES X_TEST_CASE_64_69(ID)
);
/

CREATE TABLE x_test_case_85 (
  id int NOT NULL,
  x_unused_id int,
  x_unused_name VARCHAR(10),
	
  CONSTRAINT pk_x_test_case_85 PRIMARY KEY(ID),
  CONSTRAINT fk_x_test_case_85 FOREIGN KEY(x_unused_id, x_unused_name) REFERENCES X_UNUSED(id, name)
);
/

CREATE TABLE system (id int);/
CREATE TABLE class (class int);/
CREATE TABLE integer (id int);/
CREATE TABLE long (id int, other bigint);/
CREATE TABLE object (id int, other object);/
CREATE TABLE string (id int, other varchar(3));/
CREATE TABLE big_decimal (id int, other decimal);/

CREATE VIEW V_LIBRARY (AUTHOR, TITLE) AS
SELECT T_AUTHOR.FIRST_NAME + ' ' + T_AUTHOR.LAST_NAME, T_BOOK.TITLE
FROM T_AUTHOR JOIN T_BOOK ON T_BOOK.AUTHOR_ID = T_AUTHOR.ID;
/
  
CREATE VIEW v_author AS
SELECT * FROM t_author
/

CREATE VIEW v_book AS
SELECT * FROM t_book
/


CREATE FUNCTION f_author_exists (author_name varchar(50)) 
     RETURNS INTEGER 
     READS SQL DATA
     RETURN ( 
        SELECT COUNT(*) 
          FROM t_author  
   	  WHERE first_name = author_name  
      	  OR last_name = author_name
     ) 
/

CREATE FUNCTION f_one ()
RETURNS INTEGER
RETURN 1
/

CREATE FUNCTION f_number (n integer)
RETURNS INTEGER
RETURN n
/

CREATE FUNCTION f317 (p1 INTEGER, p2 INTEGER, p3 INTEGER, p4 INTEGER)
RETURNS INTEGER
return 1000 * p1 + 100 * p2 + p4
/

CREATE FUNCTION f_get_one_cursor (IN book_ids int array)
RETURNS TABLE (
  ID INT,
  AUTHOR_ID INT,
  co_author_id int,
  DETAILS_ID INT,
  TITLE VARCHAR(400),
  PUBLISHED_IN INT,
  LANGUAGE_ID INT,
  CONTENT_TEXT LONGVARCHAR,
  CONTENT_PDF LONGVARBINARY
)
READS SQL DATA
BEGIN ATOMIC
	IF (book_ids IS NULL) THEN
	    RETURN TABLE(SELECT * FROM t_book WHERE 1 = 0);
	ELSE
		RETURN TABLE(SELECT * FROM t_book WHERE id IN (UNNEST(book_ids)) ORDER BY id ASC);
	END IF;
END
/

CREATE PROCEDURE p_arrays1(IN in_array int array, OUT out_array int array)
BEGIN ATOMIC
	SET out_array = in_array;  
END
/

CREATE PROCEDURE p_arrays2(IN in_array bigint array, OUT out_array bigint array)
BEGIN ATOMIC
	SET out_array = in_array;  
END
/

CREATE PROCEDURE p_arrays3(IN in_array varchar(1000) array, OUT out_array varchar(1000) array)
BEGIN ATOMIC
	SET out_array = in_array;  
END
/

CREATE FUNCTION f_arrays1(IN in_array int array)
RETURNS INTEGER array
RETURN in_array
/

CREATE FUNCTION f_arrays2(IN in_array bigint array)
RETURNS bigint array
RETURN in_array
/

CREATE FUNCTION f_arrays3(IN in_array varchar(1000) array)
RETURNS varchar(1000) array
RETURN in_array
/

CREATE PROCEDURE p_author_exists (IN author_name VARCHAR(50), OUT result INT) 
READS SQL DATA
BEGIN ATOMIC
  SELECT COUNT(*) INTO result
    FROM t_author
   WHERE first_name LIKE author_name
      OR last_name LIKE author_name;
END
/

CREATE PROCEDURE p_create_author_by_name (IN first_name VARCHAR(50), IN last_name VARCHAR(50))
MODIFIES SQL DATA
BEGIN ATOMIC
	INSERT INTO T_AUTHOR (ID, FIRST_NAME, LAST_NAME)
	VALUES ((SELECT MAX(ID)+1 FROM T_AUTHOR), first_name, last_name);
END
/

CREATE PROCEDURE p_create_author()
MODIFIES SQL DATA
BEGIN ATOMIC
	call {jdbc.Schema}.p_create_author_by_name('William', 'Shakespeare');
END
/

CREATE PROCEDURE p_unused (IN in1 VARCHAR(50), OUT out1 INT, INOUT out2 INT)
BEGIN ATOMIC
	SET out1 = 0;
	SET out2 = 0;
END
/


CREATE PROCEDURE p391 (
	i1 INTEGER, INOUT io1 INTEGER, OUT o1 INTEGER,
	OUT o2 INTEGER, INOUT io2 INTEGER, i2 INTEGER)
BEGIN ATOMIC
  SET o1 = io1;
  SET io1 = i1;

  SET o2 = io2;
  SET io2 = i2;
END
/
