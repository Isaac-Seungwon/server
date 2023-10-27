--script.sql

select * from tblAddress;
drop TABLE tblAddress;

create TABLE tblAddress (
	seq NUMBER primary key,
	name VARCHAR2(30) not null,
	age NUMBER not null,
	gender CHAR(1) not null,
	address VARCHAR2(300) not null,
	regdate DATE default sysdate not null
);

create sequence seqAddress;
drop sequence seqAddress;

insert into tblAddress (seq, name, age, gender, address, regdate)
	values (seqAddress.nextVal, 'Isaac', 24, 'm', '서울시 강남구 역삼동', default);
	
insert into tblAddress (seq, name, age, gender, address, regdate)
	values (seqAddress.nextVal, 'Sopia', 25, 'f', '서울시 강남구 역삼동', default);

insert into tblAddress (seq, name, age, gender, address, regdate)
	values (seqAddress.nextVal, 'Lee', 23, 'm', '서울시 강남구 역삼동', default);

insert into tblAddress (seq, name, age, gender, address, regdate)
	values (seqAddress.nextVal, 'itsh', 27, 'm', '서울시 강남구 역삼동', default);

insert into tblAddress (seq, name, age, gender, address, regdate)
	values (seqAddress.nextVal, 'itsha', 28, 'f', '서울시 강남구 역삼동', default);
			
select * from tblAddress order by seq;

commit;

select seq, name, age, gender, address, to_char(regdate, 'yyyy-MM-dd') as regdate from tblAddress order by seq desc;
select * from tblAddress;

