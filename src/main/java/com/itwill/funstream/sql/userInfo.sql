--회원정보수정	
UPDATE userinfo SET user_password = '1234' , user_phone = '01011112222' where user_no = 1;

--회원탈퇴
DELETE FROM userinfo WHERE user_no = 2;

--회원아이디로 회원정보찾기
SELECT * from userInfo where user_id = 'guard@gmail.com';

--회원아이디 존재여부 확인
select count(*) from userinfo where user_id = 'guard@gmail.com';