-- Toyproject > dml.sql

-- 회원
insert into tblUser (id, pw, name, email, lv, pic, intro, ing)
	values ('isaac', '1111', '아이작', 'isaac@gmail.com', '1', default, '자바를 공부하는 학생입니다.', default);
	
insert into tblUser (id, pw, name, email, lv, pic, intro, ing)
	values ('sopia', '1111', '소피아', 'sopia@gmail.com', '1', default, '사회복지를 공부하는 직장인입니다.', default);
	
insert into tblUser (id, pw, name, email, lv, pic, intro, ing)
	values ('admin', '1111', '관리자', 'admin@gmail.com', '1', default, '관리자입니다.', default);
	
select * from tblUser;

update tblUser set ing = 'y';

commit;


-- 게시판
insert into tblBoard (seq, subject, content, regdate, readcount, id)
	values (seqBoard.nextVal, '제목', '내용', default, default, 'isaac');
	
insert into tblBoard (seq, subject, content, regdate, readcount, id)
	values (seqBoard.nextVal, '게시판테스트', '안녕하세요.', default, default, 'isaac');

select * from tblBoard;

-- seq, subject, id, readcount, regdate, name
select * from vwBoard;
delete from tblBoard where seq = 13;

UPDATE tblBoard SET regdate = regdate + 1/24/10 WHERE seq = 5;

commit;