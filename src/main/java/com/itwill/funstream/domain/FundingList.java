package com.itwill.funstream.domain;

import java.util.Date;

public class FundingList {

	private int fl_no;
	private Date fl_date;
	private int fl_qty;
	private UserInfo userInfo;
	private Card card;
	private Funding funding;
	private Movie movie;
	private FundingUser fundingUser;
	private FundingDetail fundingDetail;
	private Theater theater;
	
	
	public FundingList() {
		// TODO Auto-generated constructor stub
	}


	public FundingList(int fl_no, Date fl_date, int fl_qty, UserInfo userInfo, Card card, Funding funding, Movie movie,
			FundingUser fundingUser, FundingDetail fundingDetail, Theater theater) {
		super();
		this.fl_no = fl_no;
		this.fl_date = fl_date;
		this.fl_qty = fl_qty;
		this.userInfo = userInfo;
		this.card = card;
		this.funding = funding;
		this.movie = movie;
		this.fundingUser = fundingUser;
		this.fundingDetail = fundingDetail;
		this.theater = theater;
	}


	public int getFl_no() {
		return fl_no;
	}


	public void setFl_no(int fl_no) {
		this.fl_no = fl_no;
	}


	public Date getFl_date() {
		return fl_date;
	}


	public void setFl_date(Date fl_date) {
		this.fl_date = fl_date;
	}


	public int getFl_qty() {
		return fl_qty;
	}


	public void setFl_qty(int fl_qty) {
		this.fl_qty = fl_qty;
	}


	public UserInfo getUserInfo() {
		return userInfo;
	}


	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}


	public Card getCard() {
		return card;
	}


	public void setCard(Card card) {
		this.card = card;
	}


	public Funding getFunding() {
		return funding;
	}


	public void setFunding(Funding funding) {
		this.funding = funding;
	}


	public Movie getMovie() {
		return movie;
	}


	public void setMovie(Movie movie) {
		this.movie = movie;
	}


	public FundingUser getFundingUser() {
		return fundingUser;
	}


	public void setFundingUser(FundingUser fundingUser) {
		this.fundingUser = fundingUser;
	}


	public FundingDetail getFundingDetail() {
		return fundingDetail;
	}


	public void setFundingDetail(FundingDetail fundingDetail) {
		this.fundingDetail = fundingDetail;
	}


	public Theater getTheater() {
		return theater;
	}


	public void setTheater(Theater theater) {
		this.theater = theater;
	}


	@Override
	public String toString() {
		return "FundingList [fl_no=" + fl_no + ", fl_date=" + fl_date + ", fl_qty=" + fl_qty + ", userInfo=" + userInfo
				+ ", card=" + card + ", funding=" + funding + ", movie=" + movie + ", fundingUser=" + fundingUser
				+ ", fundingDetail=" + fundingDetail + ", theater=" + theater + "]";
	}

	
	
	
	
}
