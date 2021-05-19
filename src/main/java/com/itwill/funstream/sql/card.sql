--카드삭제
delete from card where card_no=1;

--유저가 가지고 있는 카드리스트
select * from card join userinfo on card.user_no = userinfo.user_no where card.user_no=1;

--카드번호에 따른 존재여부 확인
select count(*) isexisted from card where card_realno='1111-1111-1111-1111';

--카드번호
select substr(card_realno, 1, 4) || '-****-****-' ||
       substr(card_realno, 16, 4) as card_realno from card where card_no=2;