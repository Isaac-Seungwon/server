SELECT * FROM tblAddress;
DROP TABLE tblAddress;

CREATE TABLE tblAddress (
	seq NUMBER PRIMARY KEY,
	name VARCHAR2(30) NOT NULL,
	age NUMBER NOT NULL,
	gender CHAR(1) NOT NULL,
	address VARCHAR2(300) NOT NULL,
	regdate DATE DEFAULT sysdate NOT null
);

CREATE SEQUENCE seqAddress;
DROP SEQUENCE seqAddress;

INSERT INTO tblAddress (seq, name, age, gender, address, regdate)
	VALUES (seqAddress.nextVal, 'Isaac', 24, 'm', '서울시 강남구 역삼동', default);
	
INSERT INTO tblAddress (seq, name, age, gender, address, regdate)
	VALUES (seqAddress.nextVal, 'Sopia', 25, 'f', '서울시 강남구 역삼동', default);

SELECT * FROM tblAddress;
COMMIT;