package com.itwill.funstream.domain;

import java.sql.Date;

public class SubsUserInfo {
	private int sUser_no;
	private Date sUser_startDate;
	private Date sUser_reDate;
	private String sUSer_autoPay;
	private UserInfo userInfo;
	private Subscribe subscribe;
	private Card card;

	public SubsUserInfo() {
		// TODO Auto-generated constructor stub
	}

	public SubsUserInfo(int sUser_no, Date sUser_startDate, Date sUser_reDate, String sUSer_autoPay, UserInfo userInfo,
			Subscribe subscribe, Card card) {
		super();
		this.sUser_no = sUser_no;
		this.sUser_startDate = sUser_startDate;
		this.sUser_reDate = sUser_reDate;
		this.sUSer_autoPay = sUSer_autoPay;
		this.userInfo = userInfo;
		this.subscribe = subscribe;
		this.card = card;
	}

	public int getsUser_no() {
		return sUser_no;
	}

	public void setsUser_no(int sUser_no) {
		this.sUser_no = sUser_no;
	}

	public Date getsUser_startDate() {
		return sUser_startDate;
	}

	public void setsUser_startDate(Date sUser_startDate) {
		this.sUser_startDate = sUser_startDate;
	}

	public Date getsUser_reDate() {
		return sUser_reDate;
	}

	public void setsUser_reDate(Date sUser_reDate) {
		this.sUser_reDate = sUser_reDate;
	}

	public String getsUSer_autoPay() {
		return sUSer_autoPay;
	}

	public void setsUSer_autoPay(String sUSer_autoPay) {
		this.sUSer_autoPay = sUSer_autoPay;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public Subscribe getSubscribe() {
		return subscribe;
	}

	public void setSubscribe(Subscribe subscribe) {
		this.subscribe = subscribe;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	@Override
	public String toString() {
		return "SubsUserInfo [sUser_no=" + sUser_no + ", sUser_startDate=" + sUser_startDate + ", sUser_reDate="
				+ sUser_reDate + ", sUSer_autoPay=" + sUSer_autoPay + ", userInfo=" + userInfo + ", subscribe="
				+ subscribe + ", card=" + card + "]";
	}

}
