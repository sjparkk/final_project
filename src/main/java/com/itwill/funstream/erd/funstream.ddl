DROP TABLE funding_user CASCADE CONSTRAINTS;
DROP TABLE subs_userInfo CASCADE CONSTRAINTS;
DROP TABLE movie_genre CASCADE CONSTRAINTS;
DROP TABLE fundingDetail CASCADE CONSTRAINTS;
DROP TABLE fundingList CASCADE CONSTRAINTS;
DROP TABLE funding CASCADE CONSTRAINTS;
DROP TABLE movieDetail CASCADE CONSTRAINTS;
DROP TABLE genre CASCADE CONSTRAINTS;
DROP TABLE userInfo_theater CASCADE CONSTRAINTS;
DROP TABLE theater CASCADE CONSTRAINTS;
DROP TABLE userInfo_movie CASCADE CONSTRAINTS;
DROP TABLE movie CASCADE CONSTRAINTS;
DROP TABLE subscribe CASCADE CONSTRAINTS;
DROP TABLE card CASCADE CONSTRAINTS;
DROP TABLE userInfo CASCADE CONSTRAINTS;

CREATE TABLE userInfo(
		user_no                       		NUMBER(10)		 NULL 		 PRIMARY KEY,
		user_id                       		VARCHAR2(20)		 NULL ,
		user_password                 		VARCHAR2(20)		 NULL ,
		user_phone                    		VARCHAR2(13)		 NULL 
);

DROP SEQUENCE userInfo_user_no_SEQ;

CREATE SEQUENCE userInfo_user_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;




CREATE TABLE card(
		card_no                       		NUMBER(10)		 NULL 		 PRIMARY KEY,
		card_realNo                   		VARCHAR2(19)		 NULL ,
		card_valid                    		VARCHAR2(5)		 NULL ,
		card_cvc                      		NUMBER(3)		 NULL ,
		card_password                 		NUMBER(4)		 NULL ,
		card_alias                    		VARCHAR2(30)		 NULL ,
		user_no                       		NUMBER(10)		 NULL ,
  FOREIGN KEY (user_no) REFERENCES userInfo (user_no)
);

DROP SEQUENCE card_card_no_SEQ;

CREATE SEQUENCE card_card_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;




CREATE TABLE subscribe(
		subs_no                       		NUMBER(10)		 NULL 		 PRIMARY KEY,
		subs_type                     		VARCHAR2(50)		 NULL ,
		subs_price                    		NUMBER(10)		 NULL ,
		subs_duration                 		NUMBER(5)		 NULL ,
		subs_autoPay                  		VARCHAR2(10)		 NULL 
);

DROP SEQUENCE subscribe_subs_no_SEQ;

CREATE SEQUENCE subscribe_subs_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;




CREATE TABLE movie(
		movie_no                      		NUMBER(10)		 NULL 		 PRIMARY KEY,
		movie_title                   		VARCHAR2(100)		 NULL ,
		movie_img                     		VARCHAR2(100)		 NULL ,
		movie_rating                  		VARCHAR2(16)		 NULL ,
		movie_count                   		NUMBER(10)		 NULL ,
		movie_openDate                		DATE		 NULL ,
		movie_runtime                 		VARCHAR2(15)		 NULL 
);

DROP SEQUENCE movie_movie_no_SEQ;

CREATE SEQUENCE movie_movie_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;




CREATE TABLE userInfo_movie(
		wishlist_no                   		NUMBER(10)		 NULL 		 PRIMARY KEY,
		user_no                       		NUMBER(10)		 NULL ,
		movie_no                      		NUMBER(10)		 NULL ,
  FOREIGN KEY (user_no) REFERENCES userInfo (user_no),
  FOREIGN KEY (movie_no) REFERENCES movie (movie_no)
);

DROP SEQUENCE userInfo_movie_wishlist_no_SEQ;

CREATE SEQUENCE userInfo_movie_wishlist_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;




CREATE TABLE theater(
		theater_no                    		NUMBER(10)		 NULL 		 PRIMARY KEY,
		theater_address               		VARCHAR2(2000)		 NULL ,
		theater_name                  		VARCHAR2(50)		 NULL ,
		theater_phone                 		VARCHAR2(13)		 NULL ,
		theater_img                   		VARCHAR2(100)		 NULL 
);

DROP SEQUENCE theater_theater_no_SEQ;

CREATE SEQUENCE theater_theater_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;




CREATE TABLE userInfo_theater(
		prefer_no                     		NUMBER(10)		 NULL 		 PRIMARY KEY,
		user_no                       		NUMBER(10)		 NULL ,
		theater_no                    		NUMBER(10)		 NULL ,
  FOREIGN KEY (user_no) REFERENCES userInfo (user_no),
  FOREIGN KEY (theater_no) REFERENCES theater (theater_no)
);

DROP SEQUENCE userInfo_theater_prefer_no_SEQ;

CREATE SEQUENCE userInfo_theater_prefer_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;




CREATE TABLE genre(
		genre_no                      		NUMBER(10)		 NULL 		 PRIMARY KEY,
		genre_name                    		VARCHAR2(20)		 NULL 
);

DROP SEQUENCE genre_genre_no_SEQ;

CREATE SEQUENCE genre_genre_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;




CREATE TABLE movieDetail(
		mD_no                         		NUMBER(10)		 NULL 		 PRIMARY KEY,
		mD_summary                    		VARCHAR2(4000)		 NULL ,
		mD_director                   		VARCHAR2(200)		 NULL ,
		mD_actors                     		VARCHAR2(1000)		 NULL ,
		mD_film                       		VARCHAR2(4000)		 NULL ,
		mD_subFilm                    		VARCHAR2(4000)		 NULL ,
		movie_no                      		NUMBER(10)		 NULL ,
  FOREIGN KEY (movie_no) REFERENCES movie (movie_no)
);

DROP SEQUENCE movieDetail_mD_no_SEQ;

CREATE SEQUENCE movieDetail_mD_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;




CREATE TABLE funding(
		funding_no                    		NUMBER(10)		 NULL 		 PRIMARY KEY,
		funding_resvseat              		NUMBER(10)		 NULL ,
		funding_totalSeat             		NUMBER(10)		 NULL ,
		funding_price                 		NUMBER(10)		 NULL ,
		funding_status                		VARCHAR2(10)		 NULL ,
		funding_startDate             		DATE		 DEFAULT sysdate		 NULL ,
		funding_endDate               		DATE		 NULL ,
		funding_movieDate             		DATE		 NULL 
);

DROP SEQUENCE funding_funding_no_SEQ;

CREATE SEQUENCE funding_funding_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;




CREATE TABLE fundingList(
		fL_no                         		NUMBER(10)		 NULL 		 PRIMARY KEY,
		fL_date                       		DATE		 NULL ,
		fL_qty                        		NUMBER(10)		 NULL ,
		user_no                       		NUMBER(10)		 NULL ,
		card_no                       		NUMBER(10)		 NULL ,
		funding_no                    		NUMBER(10)		 NULL ,
		movie_no                      		NUMBER(10)		 NULL ,
  FOREIGN KEY (funding_no) REFERENCES funding (funding_no),
  FOREIGN KEY (card_no) REFERENCES card (card_no),
  FOREIGN KEY (user_no) REFERENCES userInfo (user_no),
  FOREIGN KEY (movie_no) REFERENCES movie (movie_no)
);

DROP SEQUENCE fundingList_fL_no_SEQ;

CREATE SEQUENCE fundingList_fL_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;




CREATE TABLE fundingDetail(
		fD_no                         		NUMBER(10)		 NULL 		 PRIMARY KEY,
		theater_no                    		NUMBER(10)		 NULL ,
		movie_no                      		NUMBER(10)		 NULL ,
		funding_no                    		NUMBER(10)		 NULL ,
  FOREIGN KEY (movie_no) REFERENCES movie (movie_no),
  FOREIGN KEY (funding_no) REFERENCES funding (funding_no),
  FOREIGN KEY (theater_no) REFERENCES theater (theater_no)
);

DROP SEQUENCE fundingDetail_fD_no_SEQ;

CREATE SEQUENCE fundingDetail_fD_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;




CREATE TABLE movie_genre(
		mG_no                         		NUMBER(10)		 NULL 		 PRIMARY KEY,
		movie_no                      		NUMBER(10)		 NULL ,
		genre_no                      		NUMBER(10)		 NULL ,
  FOREIGN KEY (genre_no) REFERENCES genre (genre_no),
  FOREIGN KEY (movie_no) REFERENCES movie (movie_no)
);

DROP SEQUENCE movie_genre_mG_no_SEQ;

CREATE SEQUENCE movie_genre_mG_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;




CREATE TABLE subs_userInfo(
		sUser_no                      		NUMBER(10)		 NULL 		 PRIMARY KEY,
		sUser_startDate               		DATE		 DEFAULT sysdate		 NULL ,
		sUser_reDate                  		DATE		 NULL ,
		sUser_autoPay                 		VARCHAR2(10)		 NULL ,
		user_no                       		NUMBER(10)		 NULL ,
		subs_no                       		NUMBER(10)		 NULL ,
		card_no                       		NUMBER(10)		 NULL ,
  FOREIGN KEY (user_no) REFERENCES userInfo (user_no),
  FOREIGN KEY (subs_no) REFERENCES subscribe (subs_no),
  FOREIGN KEY (card_no) REFERENCES card (card_no)
);

DROP SEQUENCE subs_userInfo_sUser_no_SEQ;

CREATE SEQUENCE subs_userInfo_sUser_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;




CREATE TABLE funding_user(
		fundUSer_no                   		NUMBER(10)		 NULL 		 PRIMARY KEY,
		user_no                       		NUMBER(10)		 NULL ,
		funding_no                    		NUMBER(10)		 NULL ,
  FOREIGN KEY (user_no) REFERENCES userInfo (user_no),
  FOREIGN KEY (funding_no) REFERENCES funding (funding_no)
);

DROP SEQUENCE funding_user_fundUSer_no_SEQ;

CREATE SEQUENCE funding_user_fundUSer_no_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

COMMIT;


