CREATE TABLE USERS(
	id number(3) NOT NULL,
	email varchar2(30) NOT NULL,
	password varchar2(25) NOT NULL,
	firstname varchar2(20) NOT NULL,
	lastname varchar2(20) NOT NULL,
	address varchar2(50) NOT NULL,
	city varchar2(20) NOT NULL,
	state varchar2(15) NOT NULL,
	phonenumber varchar2(10) NOT NULL,
	PRIMARY KEY(id)
);
SELECT * FROM USERS;
--DROP TABLE USERS;
CREATE SEQUENCE user_id_seq
	START WITH 1
	INCREMENT BY 1
	MINVALUE 0;
DROP SEQUENCE user_id_seq;
CREATE SEQUENCE movie_id_seq
	START WITH 1
	INCREMENT BY 1
	MINVALUE 0;
CREATE SEQUENCE comment_id_seq
	START WITH 1
	INCREMENT BY 1
	MINVALUE 0;
DROP SEQUENCE user_id_seq;

CREATE TABLE MOVIE(
	movieid NUMBER(5) NOT NULL,--Primary Key
	userid number(3) NOT NULL,--Foreign Key
	genre varchar2(15) NOT NULL,
	favorited number(1) DEFAULT 0 CHECK (favorited = 0 OR FAVORITED = 1),
	watched NUMBER(1) DEFAULT 0 CHECK (watched = 0 OR WATCHED = 1),
	PRIMARY KEY(movieid),
	
	CONSTRAINT getUser FOREIGN KEY (userid)
	REFERENCES users(id) ON DELETE CASCADE
);
DROP TABLE MOVIE;

CREATE TABLE "COMMENT"(--Leave the table as ALL CAPS to distinguish between
	commentid number(5) NOT NULL,
	userid number(3) NOT NULL,--Foreign Key
	movieid number(5) NOT NULL,--Foreign Key
	"comment" varchar2(200) NOT NULL,
	
	CONSTRAINT getUserID FOREIGN KEY (userid)
	REFERENCES users(id) ON DELETE CASCADE,
	
	CONSTRAINT getMovie FOREIGN KEY (movieid)
	REFERENCES MOVIE(movieid) ON DELETE CASCADE
);
DROP TABLE "COMMENT";
