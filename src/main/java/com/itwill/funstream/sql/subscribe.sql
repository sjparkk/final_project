--이용권 등록
INSERT INTO subscribe VALUES (subscribe_subs_no_SEQ.NEXTVAL, '월간', 10000, 30, 'ture');

--이용권 종류 불러오기
SELECT * FROM subscribe;

--이용권 가격수정
UPDATE subscribe SET subs_price = '5000' WHERE subs_no=1;

--이용권 삭제
DELETE FROM subscribe WHERE subs_no=3;

commit;