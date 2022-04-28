create table STUDENT
(
	ID   BIGINT primary key  AUTO_INCREMENT,
	NAME varchar(100) not null,
	AGE  tinyint      not null
);

create table COURSE
(
	ID   BIGINT primary key AUTO_INCREMENT,
	NAME VARCHAR(100) not null,
	DESCRIPTION VARCHAR(225) not null,
	STEPS VARCHAR(450)
);

CREATE TABLE STUDENT_COURSE (
								ID_STUDENT BIGINT NOT NULL,
								ID_COURSE BIGINT NOT NULL
);




