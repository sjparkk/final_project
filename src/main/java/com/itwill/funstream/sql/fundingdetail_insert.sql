
/*
이름         널?       유형         
---------- -------- ---------- 
FD_NO      NOT NULL NUMBER(10) 
THEATER_NO          NUMBER(10) 
MOVIE_NO            NUMBER(10) 
FUNDING_NO          NUMBER(10) 
*/
--영화관(10개),영화(70개),펀딩

insert into fundingdetail values(fundingDetail_fD_no_SEQ.nextval, 1,1,1);
insert into fundingdetail values(fundingDetail_fD_no_SEQ.nextval, 2,1,2);
insert into fundingdetail values(fundingDetail_fD_no_SEQ.nextval, 1,2,3);
insert into fundingdetail values(fundingDetail_fD_no_SEQ.nextval, 2,2,4);
insert into fundingdetail values(fundingDetail_fD_no_SEQ.nextval, 3,2,5);
insert into fundingdetail values(fundingDetail_fD_no_SEQ.nextval, 1,6,6);
insert into fundingdetail values(fundingDetail_fD_no_SEQ.nextval, 2,7,7);
insert into fundingdetail values(fundingDetail_fD_no_SEQ.nextval, 4,8,8);
insert into fundingdetail values(fundingDetail_fD_no_SEQ.nextval, 4,8,9);
insert into fundingdetail values(fundingDetail_fD_no_SEQ.nextval, 4,9,10);

commit;
