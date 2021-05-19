package com.itwill.funstream.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.itwill.funstream.domain.Genre;
import com.itwill.funstream.domain.Movie;
import com.itwill.funstream.domain.MovieDetail;
import com.itwill.funstream.domain.UserInfoMovie;

public interface MovieMapper {
   public List<Movie> findMovieListOrderByCountDesc();
   public int findMovieListCountBySearch(String searchWord);
   public List<Movie> findMovieListBySearch(@Param("searchWord") String searchWord,@Param("start") int start, @Param("last")int last);
   public List<Movie> findMovieListBySearchAndUserNo(@Param("searchWord") String searchWord, @Param("user_no") int user_no,@Param("start") int start, @Param("last")int last);
   public int findMovieListCountByGenreNo(int genre_no);
   public List<Movie> findMovieListByGenreNo(@Param("genre_no") int genre_no,@Param("start") int start, @Param("last")int last);
   public List<Movie> findMovieListByGenreNoAndUserNo(@Param("genre_no") int genre_no,@Param("user_no") int user_no,@Param("start") int start, @Param("last")int last);
   public List<Movie> findFourMovieListByGenreNoAndUserNo(@Param("genre_no") int genre_no,@Param("user_no") int user_no);
   public List<Movie> findFourMovieListByGenreNo(int genro_no);
   public Movie findMovieDetailByMovieNo(int movie_no);
   public List<Genre> findGenreNameByMovieNo(int movie_no);
   public List<Genre> findGenreListByUserNo(int user_no);
   public int updateMovieCountByMovieNo(int movie_no);
   public int findMovieWishListCountByUserNo(int user_no);
   public List<Movie> findMovieWishListByUserNo(@Param("user_no") int user_no,@Param("start") int start, @Param("last") int last);
   public int insertUserInfoMovie(UserInfoMovie userInfoMovie);
   public int deleteUserInfoMovie(@Param("user_no") int user_no,@Param("movie_no") int movie_no);
   public int findUserInfoMovie(@Param("user_no") int user_no, @Param("movie_no") int movie_no);
   public int insertMovieDetail(MovieDetail movieDetail);
   public int updateMovieDetailByMovieNo(MovieDetail movieDetail);
   public int deleteMovieDetailByMovieNo(int movie_no);
   //CRUD
   public int insertMovie(Movie movie);
   public int updateMovieByNo(Movie movie);
   public int deleteMovieByNo(int movie_no);
   public int selectMovieCountAll();
   public List<Movie> selectMovieAll(@Param("start") int start, @Param("last") int last);
   public List<Movie> selectMovieAllAndUserNo(@Param("user_no") int user_no, @Param("start") int start, @Param("last") int last);
   public Movie selectMovieByNo(int movie_no);
   public int insertGenre(Genre genre);
   public int updateGenreByNo(Genre genre);
   public int deleteGenreByNo(int genre_no);
   public Genre selectGenreByNo(int genre_no);
   public List<Genre> selectGenreAll();
   public int insertMovieGenre(@Param("movie_no") int movie_no, @Param("genre_no") int genre_no);
   public int deleteMovieGenre(@Param("movie_no") int movie_no, @Param("genre_no") int genre_no);
   public String findGenreNameByGenreNo(int genre_no);
   public List<String> selectGenreNameByMovieNo(int movie_no);
   public List<Integer> findGenreNoByMovieNo(int movie_no);
   
   
}