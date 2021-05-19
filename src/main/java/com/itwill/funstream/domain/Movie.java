package com.itwill.funstream.domain;
/*
이름             널?       유형            
-------------- -------- ------------- 
MOVIE_NO       NOT NULL NUMBER(10)    
MOVIE_TITLE             VARCHAR2(100) 
MOVIE_IMG               VARCHAR2(100) 
MOVIE_RATING            VARCHAR2(16)  
MOVIE_COUNT             NUMBER(10)    
MOVIE_OPENDATE          DATE          
MOVIE_RUNTIME           VARCHAR2(15)  
 */

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Movie {
	private int movie_no;
	private String movie_title;
	private String movie_img;
	private String movie_rating;
	private int movie_count;
	private Date movie_opendate;
	private String movie_runtime;
	private MovieDetail movieDetail;
	private List<Genre> genreList;
	private List<UserInfo> userList;
	
	public Movie() {
		// TODO Auto-generated constructor stub
	}

	public Movie(int movie_no, String movie_title, String movie_img, String movie_rating, int movie_count,
			Date movie_opendate, String movie_runtime, MovieDetail movieDetail) {
		super();
		this.movie_no = movie_no;
		this.movie_title = movie_title;
		this.movie_img = movie_img;
		this.movie_rating = movie_rating;
		this.movie_count = movie_count;
		this.movie_opendate = movie_opendate;
		this.movie_runtime = movie_runtime;
		this.movieDetail = movieDetail;
		genreList = new ArrayList<Genre>();
		userList = new ArrayList<UserInfo>();
	}
	

	public Movie(int movie_no, String movie_title, String movie_img, String movie_rating, int movie_count,
			Date movie_opendate, String movie_runtime, MovieDetail movieDetail, List<UserInfo> userList) {
		super();
		this.movie_no = movie_no;
		this.movie_title = movie_title;
		this.movie_img = movie_img;
		this.movie_rating = movie_rating;
		this.movie_count = movie_count;
		this.movie_opendate = movie_opendate;
		this.movie_runtime = movie_runtime;
		this.movieDetail = movieDetail;
		this.userList = userList;
		genreList = new ArrayList<Genre>();
	}

	public int getMovie_no() {
		return movie_no;
	}

	public void setMovie_no(int movie_no) {
		this.movie_no = movie_no;
	}

	public String getMovie_title() {
		return movie_title;
	}

	public void setMovie_title(String movie_title) {
		this.movie_title = movie_title;
	}

	public String getMovie_img() {
		return movie_img;
	}

	public void setMovie_img(String movie_img) {
		this.movie_img = movie_img;
	}

	public String getMovie_rating() {
		return movie_rating;
	}

	public void setMovie_rating(String movie_rating) {
		this.movie_rating = movie_rating;
	}

	public int getMovie_count() {
		return movie_count;
	}

	public void setMovie_count(int movie_count) {
		this.movie_count = movie_count;
	}

	public Date getMovie_opendate() {
		return movie_opendate;
	}

	public void setMovie_opendate(Date movie_opendate) {
		this.movie_opendate = movie_opendate;
	}

	public String getMovie_runtime() {
		return movie_runtime;
	}

	public void setMovie_runtime(String movie_runtime) {
		this.movie_runtime = movie_runtime;
	}

	public MovieDetail getMovieDetail() {
		return movieDetail;
	}

	public void setMovieDetail(MovieDetail movieDetail) {
		this.movieDetail = movieDetail;
	}

	public List<Genre> getGenreList() {
		return genreList;
	}

	public void setGenreList(List<Genre> genreList) {
		this.genreList = genreList;
	}
	
	public List<UserInfo> getUserList() {
		return userList;
	}

	public void setUserList(List<UserInfo> userList) {
		this.userList = userList;
	}

	@Override
	public String toString() {
		return "Movie [movie_no=" + movie_no + ", movie_title=" + movie_title + ", movie_img=" + movie_img
				+ ", movie_rating=" + movie_rating + ", movie_count=" + movie_count + ", movie_opendate="
				+ movie_opendate + ", movie_runtime=" + movie_runtime + ", movieDetail=" + movieDetail + ", genreList="
				+ genreList + ", userList=" + userList + "]";
	}
	

}
