INSERT INTO STUDENT(ID, NAME, AGE)
VALUES (1, 'Toufic', 18);
INSERT INTO STUDENT(ID, NAME, AGE)
VALUES (2, 'Ali', 17);
INSERT INTO STUDENT(ID, NAME, AGE)
VALUES (3, 'Ralph', 20);

INSERT INTO COURSE(ID, NAME, DESCRIPTION, STEPS)
VALUES (1, 'Math', 'Math Description', '1-go, 2-big');
INSERT INTO COURSE(ID, NAME, DESCRIPTION, STEPS)
VALUES (2, 'Computer Science', 'CP Description', '1-go, 2-big');
INSERT INTO COURSE(ID, NAME, DESCRIPTION, STEPS)
VALUES (3, 'English', 'English Course', '1-go, 2-big');

INSERT INTO STUDENT_COURSE
VALUES (1, 1);
INSERT INTO STUDENT_COURSE
VALUES (1, 2);

INSERT INTO STUDENT_COURSE
VALUES (2, 2);
INSERT INTO STUDENT_COURSE
VALUES (2, 3);

INSERT INTO STUDENT_COURSE
VALUES (3, 1);
INSERT INTO STUDENT_COURSE
VALUES (3, 3);

