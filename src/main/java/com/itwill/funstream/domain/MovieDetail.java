package com.itwill.funstream.domain;
/*
이름          널?       유형             
----------- -------- -------------- 
MD_NO       NOT NULL NUMBER(10)     
MD_SUMMARY           VARCHAR2(4000) 
MD_DIRECTOR          VARCHAR2(200)  
MD_ACTORS            VARCHAR2(1000) 
MD_FILM              VARCHAR2(4000) 
MD_SUBFILM           VARCHAR2(4000) 
MOVIE_NO             NUMBER(10)  
 */
public class MovieDetail {
	private int md_no;
	private String md_summary;
	private String md_director;
	private String md_actors;
	private String md_film;
	private String md_subfilm;
	private Movie movie;
	
	public MovieDetail() {
		// TODO Auto-generated constructor stub
	}

	public MovieDetail(int md_no, String md_summary, String md_director, String md_actors, String md_film,
			String md_subfilm, Movie movie) {
		super();
		this.md_no = md_no;
		this.md_summary = md_summary;
		this.md_director = md_director;
		this.md_actors = md_actors;
		this.md_film = md_film;
		this.md_subfilm = md_subfilm;
		this.movie = movie;
	}

	public int getMd_no() {
		return md_no;
	}

	public void setMd_no(int md_no) {
		this.md_no = md_no;
	}

	public String getMd_summary() {
		return md_summary;
	}

	public void setMd_summary(String md_summary) {
		this.md_summary = md_summary;
	}

	public String getMd_director() {
		return md_director;
	}

	public void setMd_director(String md_director) {
		this.md_director = md_director;
	}

	public String getMd_actors() {
		return md_actors;
	}

	public void setMd_actors(String md_actors) {
		this.md_actors = md_actors;
	}

	public String getMd_film() {
		return md_film;
	}

	public void setMd_film(String md_film) {
		this.md_film = md_film;
	}

	public String getMd_subfilm() {
		return md_subfilm;
	}

	public void setMd_subfilm(String md_subfilm) {
		this.md_subfilm = md_subfilm;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	@Override
	public String toString() {
		return "MovieDetail [md_no=" + md_no + ", md_summary=" + md_summary + ", md_director=" + md_director
				+ ", md_actors=" + md_actors + ", md_film=" + md_film + ", md_subfilm=" + md_subfilm + ", movie="
				+ movie + "]";
	}
}
