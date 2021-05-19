package com.itwill.funstream.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.funstream.dao.MovieDao;
import com.itwill.funstream.domain.Genre;
import com.itwill.funstream.domain.Movie;
import com.itwill.funstream.domain.MovieDetail;
import com.itwill.funstream.domain.UserInfo;
import com.itwill.funstream.domain.UserInfoMovie;
import com.itwill.funstream.util.moviepagemaker.MovieListPageMakerDto;
import com.itwill.funstream.util.moviepagemaker.PageMaker;

@Service("movieService")
public class MovieServiceMyBatis implements MovieService {
	@Autowired
	private MovieDao movieDao;

	public MovieServiceMyBatis() {
	}

	public MovieServiceMyBatis(MovieDao movieDao) {
		super();
		this.movieDao = movieDao;
	}

	@Override
	public List<Movie> findMovieListOrderByCountDesc() {
		return movieDao.findMovieListOrderByCountDesc();
	}

	@Override
	public MovieListPageMakerDto findMovieListBySearch(int currentPage, String searchWord) {
		int totalRecordCount = movieDao.findMovieListCountBySearch(searchWord);
		// 2. paging계산
		PageMaker pageMaker = new PageMaker(totalRecordCount, currentPage);
		// 3. 영화데이터 얻기
		List<Movie> movieList = movieDao.findMovieListBySearch(searchWord, pageMaker.getPageBegin(),
				pageMaker.getPageEnd());
		MovieListPageMakerDto pageMakerMovieList = new MovieListPageMakerDto();
		pageMakerMovieList.totRecordCount = totalRecordCount;
		pageMakerMovieList.movieList = movieList;
		pageMakerMovieList.pageMaker = pageMaker;
		return pageMakerMovieList;
	}
	
	@Override
	public MovieListPageMakerDto findMovieListBySearchAndUserNo(int currentPage, String searchWord, int user_no) {
		int totalRecordCount = movieDao.findMovieListCountBySearch(searchWord);
		// 2. paging계산
		PageMaker pageMaker = new PageMaker(totalRecordCount, currentPage);
		// 3. 영화데이터 얻기
		List<Movie> movieList = movieDao.findMovieListBySearchAndUserNo(searchWord, user_no, pageMaker.getPageBegin(),
				pageMaker.getPageEnd());
		MovieListPageMakerDto pageMakerMovieList = new MovieListPageMakerDto();
		pageMakerMovieList.totRecordCount = totalRecordCount;
		pageMakerMovieList.movieList = movieList;
		pageMakerMovieList.pageMaker = pageMaker;
		return pageMakerMovieList;
	}

	@Override
	public MovieListPageMakerDto findMovieListByGenreNo(int currentPage, int genre_no) {
		int totalRecordCount = movieDao.findMovieListCountByGenreNo(genre_no);
		// 2. paging계산
		PageMaker pageMaker = new PageMaker(totalRecordCount, currentPage);
		// 3. 영화데이터 얻기
		List<Movie> movieList = movieDao.findMovieListByGenreNo(genre_no, pageMaker.getPageBegin(),
				pageMaker.getPageEnd());
		MovieListPageMakerDto pageMakerMovieList = new MovieListPageMakerDto();
		pageMakerMovieList.totRecordCount = totalRecordCount;
		pageMakerMovieList.movieList = movieList;
		pageMakerMovieList.pageMaker = pageMaker;
		return pageMakerMovieList;
	}
	
	@Override
	public MovieListPageMakerDto findMovieListByGenreNoAndUserNo(int currentPage, int genre_no, int user_no) {
		int totalRecordCount = movieDao.findMovieListCountByGenreNo(genre_no);
		// 2. paging계산
		PageMaker pageMaker = new PageMaker(totalRecordCount, currentPage);
		// 3. 영화데이터 얻기
		List<Movie> movieList = movieDao.findMovieListByGenreNoAndUserNo(genre_no, user_no, pageMaker.getPageBegin(),
				pageMaker.getPageEnd());
		MovieListPageMakerDto pageMakerMovieList = new MovieListPageMakerDto();
		pageMakerMovieList.totRecordCount = totalRecordCount;
		pageMakerMovieList.movieList = movieList;
		pageMakerMovieList.pageMaker = pageMaker;
		return pageMakerMovieList;
	}

	@Override
	public Movie findMovieDetailByMovieNo(int movie_no) {
		return movieDao.findMovieDetailByMovieNo(movie_no);
	}

	@Override
	public List<Genre> findGenreNameByMovieNo(int movie_no) {
		return movieDao.findGenreNameByMovieNo(movie_no);
	}

	@Override
	public int updateMovieCountByMovieNo(int movie_no) {
		return movieDao.updateMovieCountByMovieNo(movie_no);
	}

	@Override
	public MovieListPageMakerDto findMovieWishListByUserNo(int currentPage, int user_no) {
		// 1. 전체 영화의 갯수
		int totalRecordCount = movieDao.findMovieWishListCountByUserNo(user_no);
		// 2. paging계산
		PageMaker pageMaker = new PageMaker(totalRecordCount, currentPage);
		// 3. 영화데이터 얻기
		List<Movie> movieList = movieDao.findMovieWishListByUserNo(user_no, pageMaker.getPageBegin(),
				pageMaker.getPageEnd());
		MovieListPageMakerDto pageMakerMovieList = new MovieListPageMakerDto();
		pageMakerMovieList.totRecordCount = totalRecordCount;
		pageMakerMovieList.movieList = movieList;
		pageMakerMovieList.pageMaker = pageMaker;
		return pageMakerMovieList;
	}

	@Override
	public int insertUserInfoMovie(UserInfoMovie userInfo_movie) {
		return movieDao.insertUserInfoMovie(userInfo_movie);
	}

	@Override
	public int deleteUserInfoMovie(int user_no, int movie_no) {
		return movieDao.deleteUserInfoMovie(user_no, movie_no);
	}

	public boolean wishList(int user_no, int movie_no) {
		boolean result = false;
		int count = movieDao.findUserInfoMovie(user_no, movie_no);
		if (count == 1) {
			movieDao.deleteUserInfoMovie(user_no, movie_no);
			result = false;
		} else {
			movieDao.insertUserInfoMovie(new UserInfoMovie(0, new UserInfo(user_no, "", "", ""),
					new Movie(movie_no, "", "", "", 0, new Date(), "", null)));
			result = true;
		}
		return result;
	}

	@Override
	public int insertMovieDetail(MovieDetail movieDetail) {
		return movieDao.insertMovieDetail(movieDetail);
	}

	@Override
	public int updateMovieDetailByMovieNo(MovieDetail movieDetail) {
		return movieDao.updateMovieDetailByMovieNo(movieDetail);
	}

	@Override
	public int deleteMovieDetailByMovieNo(int movie_no) {
		return movieDao.deleteMovieDetailByMovieNo(movie_no);
	}

	@Override
	public int insertMovie(Movie movie) {
		return movieDao.insertMovie(movie);
	}

	@Override
	public int updateMovieByNo(Movie movie) {
		return movieDao.updateMovieByNo(movie);
	}

	@Override
	public int deleteMovieByNo(int movie_no) {
		return movieDao.deleteMovieByNo(movie_no);
	}

	@Override
	public MovieListPageMakerDto selectMovieAll(int currentPage) {
		// 1. 전체 영화의 갯수
		int totalRecordCount = movieDao.selectMovieCountAll();
		// 2. paging계산
		PageMaker pageMaker = new PageMaker(totalRecordCount, currentPage);
		// 3. 영화데이터 얻기
		List<Movie> movieList = movieDao.selectMovieAll(pageMaker.getPageBegin(), pageMaker.getPageEnd());
		MovieListPageMakerDto pageMakerMovieList = new MovieListPageMakerDto();
		pageMakerMovieList.totRecordCount = totalRecordCount;
		pageMakerMovieList.movieList = movieList;
		pageMakerMovieList.pageMaker = pageMaker;
		return pageMakerMovieList;
	}
	
	@Override
	public MovieListPageMakerDto selectMovieAllAndUserNo(int user_no, int currentPage) {
		// 1. 전체 영화의 갯수
		int totalRecordCount = movieDao.selectMovieCountAll();
		// 2. paging계산
		PageMaker pageMaker = new PageMaker(totalRecordCount, currentPage);
		// 3. 영화데이터 얻기
		List<Movie> movieList = movieDao.selectMovieAllAndUserNo(user_no,pageMaker.getPageBegin(), pageMaker.getPageEnd());
		MovieListPageMakerDto pageMakerMovieList = new MovieListPageMakerDto();
		pageMakerMovieList.totRecordCount = totalRecordCount;
		pageMakerMovieList.movieList = movieList;
		pageMakerMovieList.pageMaker = pageMaker;
		return pageMakerMovieList;
	}

	@Override
	public Movie selectMovieByNo(int movie_no) {
		return movieDao.selectMovieByNo(movie_no);
	}

	@Override
	public int insertGenre(Genre genre) {
		return movieDao.insertGenre(genre);
	}

	@Override
	public int updateGenreByNo(Genre genre) {
		return movieDao.updateGenreByNo(genre);
	}

	@Override
	public int deleteGenreByNo(int genre_no) {
		return movieDao.deleteGenreByNo(genre_no);
	}

	@Override
	public Genre selectGenreByNo(int genre_no) {
		return movieDao.selectGenreByNo(genre_no);
	}

	@Override
	public List<Genre> selectGenreAll() {
		return movieDao.selectGenreAll();
	}

	@Override
	public int insertMovieGenre(int movie_no, int genre_no) {
		return movieDao.insertMovieGenre(movie_no, genre_no);
	}

	@Override
	public int deleteMovieGenre(int movie_no, int genre_no) {
		return movieDao.deleteMovieGenre(movie_no, genre_no);
	}

	@Override
	public String findGenreNameByGenreNo(int genre_no) {
		return movieDao.findGenreNameByGenreNo(genre_no);
	}

	@Override
	public List<Integer> findGenreNoByMovieNo(int movie_no) {
		return movieDao.findGenreNoByMovieNo(movie_no);
	}

	@Override
	public List<Movie> findFourMovieListByGenreNo(int genro_no) {
		return movieDao.findFourMovieListByGenreNo(genro_no);
	}

	@Override
	public Map movieDetailMap(int movie_no) {
		Map movieMap = new HashMap();

		List<Integer> genreNoList = movieDao.findGenreNoByMovieNo(movie_no);
		int genre_no = genreNoList.get(0);

		movieMap.put("movie", movieDao.findMovieDetailByMovieNo(movie_no));
		movieMap.put("movieCount", movieDao.updateMovieCountByMovieNo(movie_no));
		movieMap.put("genreList", movieDao.findGenreNameByMovieNo(movie_no));
		//movieMap.put("sameGenreMovieList", movieDao.findFourMovieListByGenreNo(genre_no));
		movieMap.put("genreName", movieDao.findGenreNameByGenreNo(genre_no));
		movieMap.put("genreNo", genre_no);

		return movieMap;
	}

	@Override
	public List<Movie> findFourMovieListByGenreNoAndUserNo(int genro_no, int user_no) {
		return movieDao.findFourMovieListByGenreNoAndUserNo(genro_no, user_no);
	}

}