--userinfo_movie insert
insert into userinfo_movie values(USERINFO_MOVIE_WISHLIST_NO_SEQ.nextval,1,11);

--userinfo_movie delete
delete userinfo_movie where user_no=1 and movie_no=11;

--userinfo_movie select(movieList)
select m.* from userinfo_movie um
join movie m
on um.movie_no=m.movie_no
where user_no=1;

--메인 movie select
select * from movie order by movie_count;
update movie set movie_count=movie_count+1 where movie_no=11;

--메인 movie 검색
select * from movie where movie_title like '%클라%';

--목록
--movie랑 genre select 조인
select m.* from movie m
join movie_genre mg
on m.movie_no=mg.movie_no
where mg.genre_no=1;

--상세
--movie랑 md랑 조인
select m.*,md.md_no,md.md_summary,md.md_director,md.md_actors,md.md_film,md.md_subfilm from movie m
join moviedetail md
on m.movie_no=md.movie_no
where m.movie_no=13;

--movie랑 movie_genre 조인
select g.genre_name from genre g
join movie_genre mg
on g.genre_no=mg.genre_no
where movie_no=13;