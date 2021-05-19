/*
이름            널?       유형           
------------- -------- ------------ 
CARD_NO       NOT NULL NUMBER(10)   
CARD_REALNO            VARCHAR2(19) 
CARD_VALID             VARCHAR2(5)  
CARD_CVC               NUMBER(3)    
CARD_PASSWORD          NUMBER(4)    
CARD_ALIAS             VARCHAR2(30) 
USER_NO                NUMBER(10)   
*/

insert into card values(card_card_no_SEQ.nextval,'1234-5678-9012-3456','10/22',322,1234,'주거래국민',11);
insert into card values(card_card_no_SEQ.nextval,'2515-1235-4364-2644','12/23',243,2323,'신한',11);
insert into card values(card_card_no_SEQ.nextval,'1252-4565-8976-4353','01/21',412,3465,'롯데',11);
insert into card values(card_card_no_SEQ.nextval,'2425-6574-3543-6266','08/22',252,7454,'신한신용',12);
insert into card values(card_card_no_SEQ.nextval,'5684-2542-4843-2662','07/24',523,7546,'국민체카',12);
insert into card values(card_card_no_SEQ.nextval,'8385-2234-2523-1414','11/22',511,8567,'삼성카드',13);
insert into card values(card_card_no_SEQ.nextval,'4521-2533-7463-5222','10/22',977,8652,'현대주거래',14);
insert into card values(card_card_no_SEQ.nextval,'6345-1726-2627-7366','04/22',745,9667,'농협신용',15);
insert into card values(card_card_no_SEQ.nextval,'3522-6245-7253-2623','05/22',955,9047,'국민신용',16);
insert into card values(card_card_no_SEQ.nextval,'7276-3528-9326-8254','09/22',277,8300,'체크신한',17);

commit;