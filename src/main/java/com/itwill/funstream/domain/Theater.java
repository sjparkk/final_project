package com.itwill.funstream.domain;

public class Theater {

	private int theater_no;
	private String theater_address;
	private String theater_name;
	private String theater_phone;
	private String theater_img;
	private UserInfoTheater userInfoTheater;
	
	public Theater() {
		// TODO Auto-generated constructor stub
	}

	public Theater(int theater_no, String theater_address, String theater_name, String theater_phone,
			String theater_img, UserInfoTheater userInfoTheater) {
		super();
		this.theater_no = theater_no;
		this.theater_address = theater_address;
		this.theater_name = theater_name;
		this.theater_phone = theater_phone;
		this.theater_img = theater_img;
		this.userInfoTheater = userInfoTheater;
	}

	public int getTheater_no() {
		return theater_no;
	}

	public void setTheater_no(int theater_no) {
		this.theater_no = theater_no;
	}

	public String getTheater_address() {
		return theater_address;
	}

	public void setTheater_address(String theater_address) {
		this.theater_address = theater_address;
	}

	public String getTheater_name() {
		return theater_name;
	}

	public void setTheater_name(String theater_name) {
		this.theater_name = theater_name;
	}

	public String getTheater_phone() {
		return theater_phone;
	}

	public void setTheater_phone(String theater_phone) {
		this.theater_phone = theater_phone;
	}

	public String getTheater_img() {
		return theater_img;
	}

	public void setTheater_img(String theater_img) {
		this.theater_img = theater_img;
	}

	public UserInfoTheater getUserInfoTheater() {
		return userInfoTheater;
	}

	public void setUserInfoTheater(UserInfoTheater userInfoTheater) {
		this.userInfoTheater = userInfoTheater;
	}

	@Override
	public String toString() {
		return "Theater [theater_no=" + theater_no + ", theater_address=" + theater_address + ", theater_name="
				+ theater_name + ", theater_phone=" + theater_phone + ", theater_img=" + theater_img
				+ ", userInfoTheater=" + userInfoTheater + "]";
	}
	
	
	
}
