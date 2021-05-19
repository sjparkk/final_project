--이용권 결제
INSERT INTO subs_userinfo VALUES(subs_userInfo_sUser_no_SEQ.NEXTVAL, SYSDATE, SYSDATE+30, 'true',1,1,1);

--이용권 해지
DELETE FROM subs_userinfo WHERE user_no=1;

--자동결제 해지
UPDATE subs_userinfo SET suser_autopay='false' WHERE user_no=1;

--자동결제 날짜 변경
UPDATE subs_userinfo SET suser_redate=suser_redate+30 WHERE user_no=1;

--자동결제 카드 변경
UPDATE subs_userinfo SET card_no=2 WHERE user_no=1;

--구독중인 유저의 카드리스트 불러오기
SELECT card.* FROM subs_userinfo join card on card.user_no=subs_userinfo.user_no 
WHERE subs_userinfo.user_no=1;

--유저가 사용중인 이용권 정보
SELECT subs_userinfo.*, subscribe.subs_type FROM subs_userinfo join subscribe on subscribe.subs_no=subs_userinfo.subs_no 
WHERE subs_userinfo.user_no=1;
                            
COMMIT;