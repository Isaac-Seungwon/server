-- system
create user toy identified by java1234;
grant connect, resource, dba to toy;

-- ToyProject > ddl.sql
-- 게시판

-- 회원
create table tblUser (
	id varchar2(50) not null,
	pw varchar2(50) not null,
	name varchar2(50) not null,
	email varchar2(100) not null,
	lv char(1) not null,
	pic varchar2(100)
);