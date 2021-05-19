package com.itwill.funstream.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.funstream.domain.Genre;
import com.itwill.funstream.domain.Movie;
import com.itwill.funstream.domain.MovieDetail;
import com.itwill.funstream.domain.UserInfoMovie;
import com.itwill.funstream.util.moviepagemaker.MovieListPageMakerDto;

@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public interface MovieService {

	List<Movie> findMovieListOrderByCountDesc();

	MovieListPageMakerDto findMovieListBySearch(int currentPage, String searchWord);
	
	MovieListPageMakerDto findMovieListBySearchAndUserNo(int currentPage, String searchWord,int user_no);

	MovieListPageMakerDto findMovieListByGenreNo(int currentPage, int genro_no);
	
	MovieListPageMakerDto findMovieListByGenreNoAndUserNo(int currentPage, int genro_no, int user_no);

	List<Movie> findFourMovieListByGenreNo(int genro_no);
	
	List<Movie> findFourMovieListByGenreNoAndUserNo(int genro_no, int user_no);

	Movie findMovieDetailByMovieNo(int movie_no);

	List<Genre> findGenreNameByMovieNo(int movie_no);

	int updateMovieCountByMovieNo(int movie_no);

	MovieListPageMakerDto findMovieWishListByUserNo(int currentPage, int user_no);

	int insertUserInfoMovie(UserInfoMovie userInfo_movie);

	int deleteUserInfoMovie(int user_no, int movie_no);
	
	boolean wishList(int user_no, int movie_no);

	int insertMovieDetail(MovieDetail movieDetail);

	int updateMovieDetailByMovieNo(MovieDetail movieDetail);

	int deleteMovieDetailByMovieNo(int movie_no);

	int insertMovie(Movie movie);

	int updateMovieByNo(Movie movie);

	int deleteMovieByNo(int movie_no);

	MovieListPageMakerDto selectMovieAll(int currentPage);
	
	MovieListPageMakerDto selectMovieAllAndUserNo(int user_no, int currentPage);

	Movie selectMovieByNo(int movie_no);

	int insertGenre(Genre genre);

	int updateGenreByNo(Genre genre);

	int deleteGenreByNo(int genre_no);

	Genre selectGenreByNo(int genre_no);

	List<Genre> selectGenreAll();

	int insertMovieGenre(int movie_no, int genre_no);

	int deleteMovieGenre(int movie_no, int genre_no);

	String findGenreNameByGenreNo(int genre_no);

	List<Integer> findGenreNoByMovieNo(int movie_no);

	Map movieDetailMap(int movie_no);
}