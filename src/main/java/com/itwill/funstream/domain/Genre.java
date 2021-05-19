package com.itwill.funstream.domain;

import java.util.ArrayList;
import java.util.List;

/*
이름         널?       유형           
---------- -------- ------------ 
GENRE_NO   NOT NULL NUMBER(10)   
GENRE_NAME          VARCHAR2(20) 
 */
public class Genre {
	private int genre_no;
	private String genre_name;
	private List<Movie> movieList;
	
	public Genre() {
		// TODO Auto-generated constructor stub
	}

	public Genre(int genre_no, String genre_name) {
		super();
		this.genre_no = genre_no;
		this.genre_name = genre_name;
		movieList = new ArrayList<Movie>();
	}

	public int getGenre_no() {
		return genre_no;
	}

	public void setGenre_no(int genre_no) {
		this.genre_no = genre_no;
	}

	public String getGenre_name() {
		return genre_name;
	}

	public void setGenre_name(String genre_name) {
		this.genre_name = genre_name;
	}

	public List<Movie> getMovieList() {
		return movieList;
	}

	public void setMovieList(List<Movie> movieList) {
		this.movieList = movieList;
	}

	@Override
	public String toString() {
		return "Genre [genre_no=" + genre_no + ", genre_name=" + genre_name + ", movieList=" + movieList + "]";
	}
	
}
