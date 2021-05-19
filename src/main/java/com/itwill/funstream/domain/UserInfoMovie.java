package com.itwill.funstream.domain;
/*
이름          널?       유형         
----------- -------- ---------- 
WISHLIST_NO NOT NULL NUMBER(10) 
USER_NO              NUMBER(10) 
MOVIE_NO             NUMBER(10) 
 */
public class UserInfoMovie {
	private int wishlist_no;
	private UserInfo userInfo;
	private Movie movie;
	
	public UserInfoMovie() {
		// TODO Auto-generated constructor stub
	}

	public UserInfoMovie(int wishlist_no, UserInfo userInfo, Movie movie) {
		super();
		this.wishlist_no = wishlist_no;
		this.userInfo = userInfo;
		this.movie = movie;
	}

	public int getWishlist_no() {
		return wishlist_no;
	}

	public void setWishlist_no(int wishlist_no) {
		this.wishlist_no = wishlist_no;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	
}
