
USERINFO
--회원가입
INSERT INTO USERINFO(USER_NO, USER_ID, USER_PASSWORD, USER_PHONE) VALUES (USERINFO_USER_NO_SEQ.nextval,'sjs','qwerqw','010-1234-1234');
INSERT INTO USERINFO(USER_NO, USER_ID, USER_PASSWORD, USER_PHONE) values (USERINFO_USER_NO_SEQ.nextval,'aaa','qwe123','012-1111-1111');
INSERT INTO USERINFO(USER_NO, USER_ID, USER_PASSWORD, USER_PHONE) values (USERINFO_USER_NO_SEQ.nextval,'bbb','qwe122','012-2222-1111');
INSERT INTO USERINFO(USER_NO, USER_ID, USER_PASSWORD, USER_PHONE) values (USERINFO_USER_NO_SEQ.nextval,'ccc','qwe034','012-4533-4444');
INSERT INTO USERINFO(USER_NO, USER_ID, USER_PASSWORD, USER_PHONE) values (USERINFO_USER_NO_SEQ.nextval,'ddd','qwe193','012-5678-2222');
INSERT INTO USERINFO(USER_NO, USER_ID, USER_PASSWORD, USER_PHONE) values (USERINFO_USER_NO_SEQ.nextval,'eee','qwe824','012-5666-7777');
INSERT INTO USERINFO(USER_NO, USER_ID, USER_PASSWORD, USER_PHONE) values (USERINFO_USER_NO_SEQ.nextval,'fff','qwe745','012-4745-8888');
INSERT INTO USERINFO(USER_NO, USER_ID, USER_PASSWORD, USER_PHONE) values (USERINFO_USER_NO_SEQ.nextval,'ggg','qwe364','012-4565-9999');
INSERT INTO USERINFO(USER_NO, USER_ID, USER_PASSWORD, USER_PHONE) values (USERINFO_USER_NO_SEQ.nextval,'hhh','qwe162','012-3645-0000');
INSERT INTO USERINFO(USER_NO, USER_ID, USER_PASSWORD, USER_PHONE) values (USERINFO_USER_NO_SEQ.nextval,'iii','qwe142','012-2354-1234');

--회원정보수정
UPDATE USERINFO SET USER_PASSWORD = ‘qwer’ , USER_PHONE = ‘010-1111-1111’  WHERE USER_NO = 1;
--회원탈퇴
DELETE FROM USERINFO WHERE USER_ID = ‘1’;
--회원아이디로 회원정보찾기
SELECT USER_NO, USER_ID, USER_PASSWORD, USER_PHONE FROM USERINFO WHERE USER_ID = ‘1’;
