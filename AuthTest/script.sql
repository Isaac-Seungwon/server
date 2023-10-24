--user 테이블

--해당 테이블에 걸려 있는 Constraint 확인
SELECT * FROM user_constraints WHERE table_name = 'TBLUSER';

DROP TABLE tblBoard;
DROP TABLE tblUser;

CREATE TABLE tblUser (
	id VARCHAR2(30) PRIMARY KEY,	--아이디(PK)
	pw VARCHAR2(30) NOT NULL,		--암호
	name VARCHAR2(30) NOT NULL,		--이름
	lv number(1) NOT NULL			--등급(1:일반, 2:관리자)
);

SELECT * FROM tblUser;

INSERT INTO tblUser VALUES ('isaac', '1111', '아이작', '1');
INSERT INTO tblUser VALUES ('sopia', '1111', '소피아', '1');
INSERT INTO tblUser VALUES ('admin', '1111', '관리자', '2');

COMMIT;

SELECT * FROM tblUser WHERE id = 'aaa' AND pw = '1111';
SELECT * FROM tblUser WHERE id = 'isaac' AND pw = '1111';