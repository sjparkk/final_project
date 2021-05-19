package com.itwill.funstream.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.funstream.domain.Genre;
import com.itwill.funstream.domain.Movie;
import com.itwill.funstream.domain.MovieDetail;
import com.itwill.funstream.domain.UserInfoMovie;
import com.itwill.funstream.mapper.MovieMapper;

@Repository("movieDao")
public class MovieDaoMyBatis implements MovieDao {
   @Autowired
   private MovieMapper movieMapper;

   public MovieDaoMyBatis() {
   }

   public MovieDaoMyBatis(MovieMapper movieMapper) {
      this.movieMapper = movieMapper;
   }

   @Override
   public List<Movie> findMovieListOrderByCountDesc() {
      List<Movie> movieList = movieMapper.findMovieListOrderByCountDesc();
      return movieList;
   }

   @Override
   public List<Movie> findMovieListBySearch(String searchWord, int start, int last) {
      List<Movie> movieList = movieMapper.findMovieListBySearch(searchWord,start,last);
      return movieList;
   }
   
   @Override
   public List<Movie> findMovieListBySearchAndUserNo(String searchWord, int user_no, int start, int last) {
	   List<Movie> movieList = movieMapper.findMovieListBySearchAndUserNo(searchWord, user_no, start, last);
	   return movieList;
   }
   
   public int findMovieListCountByGenreNo(int genre_no) {
      return movieMapper.findMovieListCountByGenreNo(genre_no);
   }
   
   @Override
   public List<Movie> findMovieListByGenreNo(int genro_no, int start, int last) {
      List<Movie> movieList = movieMapper.findMovieListByGenreNo(genro_no,start,last);
      return movieList;
   }
   
   @Override
   public List<Movie> findMovieListByGenreNoAndUserNo(int genro_no, int user_no, int start, int last) {
	   List<Movie> movieList = movieMapper.findMovieListByGenreNoAndUserNo(genro_no, user_no, start, last);
	   return movieList;
   }

   @Override
   public Movie findMovieDetailByMovieNo(int movie_no) {
      Movie movie = movieMapper.findMovieDetailByMovieNo(movie_no);
      return movie;
   }

   @Override
   public List<Genre> findGenreNameByMovieNo(int movie_no) {
      List<Genre> genreList = movieMapper.findGenreNameByMovieNo(movie_no);
      return genreList;
   }
   
   @Override
   public List<Genre> findGenreListByUserNo(int user_no) {
      return movieMapper.findGenreListByUserNo(user_no);
   }

   @Override
   public int updateMovieCountByMovieNo(int movie_no) {
      int rowCount = movieMapper.updateMovieCountByMovieNo(movie_no);
      return rowCount;
   }
   
   @Override
   public int findMovieWishListCountByUserNo(int user_no) {
      return movieMapper.findMovieWishListCountByUserNo(user_no);
   }
   
   @Override
   public List<Movie> findMovieWishListByUserNo(int user_no,int start,int last) {
      List<Movie> movieList = movieMapper.findMovieWishListByUserNo(user_no,start,last);
      return movieList;
   }

   @Override
   public int insertUserInfoMovie(UserInfoMovie userInfo_movie) {
      int rowCount = movieMapper.insertUserInfoMovie(userInfo_movie);
      return rowCount;
   }

   @Override
   public int deleteUserInfoMovie(int user_no, int movie_no) {
      int rowCount = movieMapper.deleteUserInfoMovie(user_no, movie_no);
      return rowCount;
   }
   
   @Override
   public int findUserInfoMovie(int user_no, int movie_no) {
	   return movieMapper.findUserInfoMovie(user_no, movie_no);
   }
   
   @Override
   public int insertMovieDetail(MovieDetail movieDetail) {
      int rowCount = movieMapper.insertMovieDetail(movieDetail);
      return rowCount;
   }

   @Override
   public int updateMovieDetailByMovieNo(MovieDetail movieDetail) {
      int rowCount = movieMapper.updateMovieDetailByMovieNo(movieDetail);
      return rowCount;
   }

   @Override
   public int deleteMovieDetailByMovieNo(int movie_no) {
      int rowCount = movieMapper.deleteMovieDetailByMovieNo(movie_no);
      return rowCount;
   }

   @Override
   public int insertMovie(Movie movie) {
      int rowCount = movieMapper.insertMovie(movie);
      return rowCount;
   }

   @Override
   public int updateMovieByNo(Movie movie) {
      int rowCount = movieMapper.updateMovieByNo(movie);
      return rowCount;
   }

   @Override
   public int deleteMovieByNo(int movie_no) {
      int rowCount = movieMapper.deleteMovieByNo(movie_no);
      return rowCount;
   }

   @Override
   public int selectMovieCountAll() {
      return movieMapper.selectMovieCountAll();
   }
   
   @Override
   public List<Movie> selectMovieAll(int start, int last) {
      List<Movie> movieList = movieMapper.selectMovieAll(start,last);
      return movieList;
   }
   
   @Override
   public List<Movie> selectMovieAllAndUserNo(int user_no, int start, int last) {
	   List<Movie> movieList = movieMapper.selectMovieAllAndUserNo(user_no, start, last);
	   return movieList;
   }

   @Override
   public Movie selectMovieByNo(int movie_no) {
      Movie movie = movieMapper.selectMovieByNo(movie_no);
      return movie;
   }

   @Override
   public int insertGenre(Genre genre) {
      int rowCount = movieMapper.insertGenre(genre);
      return rowCount;
   }

   @Override
   public int updateGenreByNo(Genre genre) {
      int rowCount = movieMapper.updateGenreByNo(genre);
      return rowCount;
   }

   @Override
   public int deleteGenreByNo(int genre_no) {
      int rowCount = movieMapper.deleteGenreByNo(genre_no);
      return rowCount;
   }

   @Override
   public Genre selectGenreByNo(int genre_no) {
      Genre genre = movieMapper.selectGenreByNo(genre_no);
      return genre;
   }

   @Override
   public List<Genre> selectGenreAll() {
      List<Genre> genreList = movieMapper.selectGenreAll();
      return genreList;
   }

   @Override
   public int insertMovieGenre(int movie_no, int genre_no) {
      int rowCount = movieMapper.insertMovieGenre(movie_no, genre_no);
      return rowCount;
   }

   @Override
   public int deleteMovieGenre(int movie_no, int genre_no) {
      int rowCount = movieMapper.deleteMovieGenre(movie_no, genre_no);
      return rowCount;
   }

   @Override
   public String findGenreNameByGenreNo(int genre_no) {
      String genreName = movieMapper.findGenreNameByGenreNo(genre_no);
      return genreName;
   }

   @Override
   public List<String> selectGenreNameByMovieNo(int movie_no) {
      List<String> genreList = movieMapper.selectGenreNameByMovieNo(movie_no);
      return genreList;
   }

   @Override
   public List<Integer> findGenreNoByMovieNo(int movie_no) {
      List<Integer> genreNoList = movieMapper.findGenreNoByMovieNo(movie_no);
      return genreNoList;
   }

   @Override
   public List<Movie> findFourMovieListByGenreNo(int genro_no) {
      List<Movie> fourMovieList = movieMapper.findFourMovieListByGenreNo(genro_no);
      return fourMovieList;
   }
   
   

@Override
public int findMovieListCountBySearch(String searchWord) {
	int rowCount = movieMapper.findMovieListCountBySearch(searchWord);
	return rowCount;
}

@Override
public List<Movie> findFourMovieListByGenreNoAndUserNo(int genro_no, int user_no) {
	List<Movie> movieList = movieMapper.findFourMovieListByGenreNoAndUserNo(genro_no, user_no);
	return movieList;
}


}