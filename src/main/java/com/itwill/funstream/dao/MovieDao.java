package com.itwill.funstream.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.itwill.funstream.domain.Genre;
import com.itwill.funstream.domain.Movie;
import com.itwill.funstream.domain.MovieDetail;
import com.itwill.funstream.domain.UserInfoMovie;

public interface MovieDao {

	List<Movie> findMovieListOrderByCountDesc();

	int findMovieListCountBySearch(String searchWord);

	List<Movie> findMovieListBySearch(String searchWord, int start, int last);
	
	List<Movie> findMovieListBySearchAndUserNo(String searchWord, int user_no, int start, int last);

	int findMovieListCountByGenreNo(int genre_no);

	List<Movie> findMovieListByGenreNo(int genro_no, int start, int last);

	List<Movie> findMovieListByGenreNoAndUserNo(int genro_no, int user_no, int start, int last);

	List<Movie> findFourMovieListByGenreNoAndUserNo(int genro_no, int user_no);

	List<Movie> findFourMovieListByGenreNo(int genro_no);

	Movie findMovieDetailByMovieNo(int movie_no);

	List<Genre> findGenreNameByMovieNo(int movie_no);

	List<Genre> findGenreListByUserNo(int user_no);

	int updateMovieCountByMovieNo(int movie_no);

	int findMovieWishListCountByUserNo(int user_no);

	List<Movie> findMovieWishListByUserNo(@Param("user_no") int user_no, @Param("start") int start,
			@Param("last") int last);

	int insertUserInfoMovie(UserInfoMovie userInfo_movie);

	int deleteUserInfoMovie(int user_no, int movie_no);

	int findUserInfoMovie(@Param("user_no") int user_no, @Param("movie_no") int movie_no);

	int insertMovieDetail(MovieDetail movieDetail);

	int updateMovieDetailByMovieNo(MovieDetail movieDetail);

	int deleteMovieDetailByMovieNo(int movie_no);

	int insertMovie(Movie movie);

	int updateMovieByNo(Movie movie);

	int deleteMovieByNo(int movie_no);

	int selectMovieCountAll();

	List<Movie> selectMovieAll(@Param("start") int start, @Param("last") int last);

	List<Movie> selectMovieAllAndUserNo(@Param("user_no") int user_no, @Param("start") int start, @Param("last") int last);

	Movie selectMovieByNo(int movie_no);

	int insertGenre(Genre genre);

	int updateGenreByNo(Genre genre);

	int deleteGenreByNo(int genre_no);

	Genre selectGenreByNo(int genre_no);

	List<Genre> selectGenreAll();

	int insertMovieGenre(int movie_no, int genre_no);

	int deleteMovieGenre(int movie_no, int genre_no);

	String findGenreNameByGenreNo(int genre_no);

	List<String> selectGenreNameByMovieNo(int movie_no);

	List<Integer> findGenreNoByMovieNo(int movie_no);
}