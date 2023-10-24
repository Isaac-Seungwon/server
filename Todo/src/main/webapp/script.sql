--할일 테이블
DROP TABLE tblTodo;
DROP SEQUENCE seqTodo;

CREATE TABLE tblTodo (
    seq NUMBER(10) PRIMARY KEY, --번호(PK)
    todo VARCHAR2(1000) NOT NULL, --할일
    state CHAR(1) DEFAULT 'n' NOT NULL, --미완료(n), 완료(y)
    regdate DATE DEFAULT SYSDATE NOT NULL --날짜
);
	
CREATE SEQUENCE seqTodo;

SELECT * FROM tblTodo;

INSERT INTO tblTodo (seq, todo, state, regdate) VALUES (seqTodo.nextVal, '할일입니다.', DEFAULT, DEFAULT);

SELECT * FROM tblTodo orderby seq DESC;

SELECT * FROM tblTodo ORDER BY state ASC, seq desc;

UPDATE tblTodo SET state = 'y' WHERE seq = 1;

DELETE FROM tblTodo WHERE seq = 1;

COMMIT;