--userinfo_theater
--선택극장 번호, 유저번호, 극장번호

insert into userinfo_theater values(USERINFO_THEATER_PREFER_NO_SEQ.nextval, 11, 2);
insert into userinfo_theater values(USERINFO_THEATER_PREFER_NO_SEQ.nextval, 11, 8);
insert into userinfo_theater values(USERINFO_THEATER_PREFER_NO_SEQ.nextval, 11, 9);
insert into userinfo_theater values(USERINFO_THEATER_PREFER_NO_SEQ.nextval, 12, 3);
insert into userinfo_theater values(USERINFO_THEATER_PREFER_NO_SEQ.nextval, 12, 1);
insert into userinfo_theater values(USERINFO_THEATER_PREFER_NO_SEQ.nextval, 12, 6);
insert into userinfo_theater values(USERINFO_THEATER_PREFER_NO_SEQ.nextval, 13, 2);
insert into userinfo_theater values(USERINFO_THEATER_PREFER_NO_SEQ.nextval, 13, 6);
insert into userinfo_theater values(USERINFO_THEATER_PREFER_NO_SEQ.nextval, 13, 3);
insert into userinfo_theater values(USERINFO_THEATER_PREFER_NO_SEQ.nextval, 14, 7);
insert into userinfo_theater values(USERINFO_THEATER_PREFER_NO_SEQ.nextval, 14, 10);
insert into userinfo_theater values(USERINFO_THEATER_PREFER_NO_SEQ.nextval, 14, 3);
insert into userinfo_theater values(USERINFO_THEATER_PREFER_NO_SEQ.nextval, 15, 4);
insert into userinfo_theater values(USERINFO_THEATER_PREFER_NO_SEQ.nextval, 15, 5);
insert into userinfo_theater values(USERINFO_THEATER_PREFER_NO_SEQ.nextval, 15, 2);
insert into userinfo_theater values(USERINFO_THEATER_PREFER_NO_SEQ.nextval, 16, 2);
insert into userinfo_theater values(USERINFO_THEATER_PREFER_NO_SEQ.nextval, 16, 4);
insert into userinfo_theater values(USERINFO_THEATER_PREFER_NO_SEQ.nextval, 16, 9);
insert into userinfo_theater values(USERINFO_THEATER_PREFER_NO_SEQ.nextval, 17, 2);
insert into userinfo_theater values(USERINFO_THEATER_PREFER_NO_SEQ.nextval, 18, 5);
insert into userinfo_theater values(USERINFO_THEATER_PREFER_NO_SEQ.nextval, 17, 9);

--theater
--극장 번호, 주소, 이름, 폰번호, 이미지
insert into theater values(THEATER_THEATER_NO_SEQ.nextval, '서울특별시 강남구 논현동', '강남점', '1544-1123', 'theater_01.jpg');
insert into theater values(THEATER_THEATER_NO_SEQ.nextval, '서울특별시 성동구 왕십리제2동', '왕십리점', '1544-4433', 'theater_02.jpg');
insert into theater values(THEATER_THEATER_NO_SEQ.nextval, '서울특별시 영등포구 영등포동', '영등포점', '1544-2646', 'theater_03.jpg');
insert into theater values(THEATER_THEATER_NO_SEQ.nextval, '서울특별시 중구 명동2가', '명동점', '1544-7674', 'theater_04.jpg');
insert into theater values(THEATER_THEATER_NO_SEQ.nextval, '서울특별시 용산구 한강로3가', '용산점', '1544-3344', 'theater_05.jpg');
insert into theater values(THEATER_THEATER_NO_SEQ.nextval, '서울특별시 강남구 신사동', '압구정점', '1544-6677', 'theater_06.jpg');
insert into theater values(THEATER_THEATER_NO_SEQ.nextval, '서울특별시 마포구 동교동', '홍대입구점', '1544-3357', 'theater_07.jpg');
insert into theater values(THEATER_THEATER_NO_SEQ.nextval, '서울특별시 종로구 이화동', '대학로점', '1544-1117', 'theater_08.jpg');
insert into theater values(THEATER_THEATER_NO_SEQ.nextval, '서울특별시 노원구 상계동', '노원점', '1544-7654', 'theater_09.jpg');
insert into theater values(THEATER_THEATER_NO_SEQ.nextval, '서울특별시 광진구 자양4동', '건대입구점', '1544-9900', 'theater_10.jpg');

commit;