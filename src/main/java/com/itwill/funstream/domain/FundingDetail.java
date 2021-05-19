package com.itwill.funstream.domain;

public class FundingDetail {

	private int fd_no;
	private Theater theater;
	private Movie movie;
	private Funding funding;
	
	public FundingDetail() {
		// TODO Auto-generated constructor stub
	}

	public FundingDetail(int fd_no, Theater theater, Movie movie, Funding funding) {
		super();
		this.fd_no = fd_no;
		this.theater = theater;
		this.movie = movie;
		this.funding = funding;
	}

	public int getFd_no() {
		return fd_no;
	}

	public void setFd_no(int fd_no) {
		this.fd_no = fd_no;
	}

	public Theater getTheater() {
		return theater;
	}

	public void setTheater(Theater theater) {
		this.theater = theater;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Funding getFunding() {
		return funding;
	}

	public void setFunding(Funding funding) {
		this.funding = funding;
	}

	@Override
	public String toString() {
		return "FundingDetail [fd_no=" + fd_no + ", theater=" + theater + ", movie=" + movie + ", funding=" + funding
				+ "]";
	}

	
}
