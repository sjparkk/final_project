package com.itwill.funstream.domain;

import java.util.ArrayList;
import java.util.List;

public class UserInfoTheater {
	
	private int prefer_no;
	private UserInfo userInfo;
	private Theater theater;
	
	
	public UserInfoTheater() {
		// TODO Auto-generated constructor stub
	}


	public UserInfoTheater(int prefer_no, UserInfo userInfo, Theater theater) {
		super();
		this.prefer_no = prefer_no;
		this.userInfo = userInfo;
		this.theater = theater;
	}


	public int getPrefer_no() {
		return prefer_no;
	}


	public void setPrefer_no(int prefer_no) {
		this.prefer_no = prefer_no;
	}


	public UserInfo getUserInfo() {
		return userInfo;
	}


	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}


	public Theater getTheater() {
		return theater;
	}


	public void setTheater(Theater theater) {
		this.theater = theater;
	}


	@Override
	public String toString() {
		return "UserInfoTheater [prefer_no=" + prefer_no + ", userInfo=" + userInfo + ", theater=" + theater + "]";
	}


	

	
	
	
}
