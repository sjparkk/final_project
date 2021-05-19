package com.itwill.funstream.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.funstream.dao.MovieDao;
import com.itwill.funstream.domain.Movie;
import com.itwill.funstream.service.MovieService;

public class MovieDaoTest {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/spring/application-config.xml");
		MovieDao movieDao = (MovieDao)applicationContext.getBean("movieDao");
		MovieService movieService = (MovieService)applicationContext.getBean("movieService");
		//System.out.println(movieDao);
		//System.out.println(movieDao.findMovieListOrderByCountDesc());
//		System.out.println(movieDao.findMovieListBySearch("트"));
		//System.out.println(movieDao.findMovieListByGenreNo(5));
		//System.out.println(movieDao.findMovieDetailByMovieNo(11));
		//System.out.println(movieDao.findGenreNameByMovieNo(11));
		//System.out.println(movieDao.updateMovieCountByMovieNo(11));
		//System.out.println(movieDao.findMovieDetailByMovieNo(11));
		//System.out.println(movieDao.findMovieWishListByUserNo(1));
		//UserInfo_movie userInfo_movie = new UserInfo_movie(0, new UserInfo(3, "", "", ""), new Movie(3, "", "", "", 0, new Date(), "", null));
		//System.out.println(movieDao.insertUserInfoMovie(userInfo_movie));
		//System.out.println(movieDao.deleteUserInfoMovie(3, 3));
		//System.out.println(movieDao.insertMovie(new Movie(0, "테스트", "테스트", "테스트", 0, new Date(),"테스트" ,null)));
		//System.out.println(movieDao.updateMovieByNo(new Movie(72, "업데이트", "업데이트", "업데이트", 0, new Date(), "업데이트", null)));
//		System.out.println(movieDao.deleteMovieByNo(72));
//		System.out.println(movieDao.selectMovieAll());
//		System.out.println(movieDao.insertGenre(new Genre(0, "테스트")));
//		System.out.println(movieDao.updateGenreByNo(new Genre(9,"변경")));
//		System.out.println(movieDao.deleteGenreByNo(9));
//		System.out.println(movieDao.selectGenreByNo(1));
//		System.out.println(movieDao.selectGenreAll());
//		System.out.println(movieDao.insertMovieGenre(71, 2));
//		System.out.println(movieDao.deleteMovieGenre(71, 2));
//		System.out.println(movieDao.findGenreListByUserNo(1));

//		List<String> genreList = null;
//		for (Movie movie : movieList) {
//			genreList.addAll(movieDao.selectGenreNameByMovieNo(movie.getMovie_no()));
//		}
//		System.out.println(genreList);
		
//		System.out.println(movieDao.selectGenreNameByMovieNo(3));

/*
		List<Movie> movieList=movieDao.findMovieListByGenreNo(1);
		List<String> allgenreList = null;
		for (Movie movie : movieList) {
				movie.setGenreList(movieDao.findGenreNameByMovieNo(movie.getMovie_no()));
		}
		System.out.println(movieList);
		
		//System.out.println(movieDao.findGenreListByUserNo(1));
		System.out.println(movieDao.findMovieWishListCountByUserNo(1));
		//System.out.println(movieDao.findMovieWishListByUserNo(1, 1, 2));
		 
		 */
		//System.out.println("++++++++++"+movieDao.findGenreNoByMovieNo(10));
//		System.out.println(movieDao.findMovieListCountByGenreNo(1));
		//실행//
		
//		System.out.println(movieService.findMovieListByGenreNo(1, 1).movieList);
//		System.out.println(movieDao.findUserInfoMovie(1, 11));
		//System.out.println(movieService.wishList(1, 11));
//		MovieListPageMakerDto movieListPage = movieService.findMovieWishListByUserNo(1,1);
//		System.out.println(movieListPage.movieList.size());
		//System.out.println(movieDao.findMovieWishListCountByUserNo(1));
		
//		System.out.println(movieDao.findMovieListCountBySearch("어"));
//		System.out.println(movieDao.findMovieListBySearch("어", 1, 4));
		
//		System.out.println(movieService.findMovieListBySearch(1, "어").movieList.size());
		//System.out.println(movieDao.findMovieListByGenreNo(1, 1, 8));
		//System.out.println(movieDao.findMovieListByGenreNoAndUserNo(1, 1, 1, 8));
		
	}
}
