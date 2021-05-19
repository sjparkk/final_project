package com.itwill.funstream.domain;

public class UserInfo {
	private int user_no;
	private String user_id;
	private String user_password;
	private String user_phone;

	public UserInfo() {
		// TODO Auto-generated constructor stub
	}

	public UserInfo(int user_no) {
		super();
		this.user_no = user_no;
	}
	
	public UserInfo(int user_no, String user_id, String user_password, String user_phone) {
		super();
		this.user_no = user_no;
		this.user_id = user_id;
		this.user_password = user_password;
		this.user_phone = user_phone;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	@Override
	public String toString() {
		return "UserInfo [user_no=" + user_no + ", user_id=" + user_id + ", user_password=" + user_password
				+ ", user_phone=" + user_phone + "]";
	}

}
