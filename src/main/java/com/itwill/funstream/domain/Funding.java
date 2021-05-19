package com.itwill.funstream.domain;

import java.util.Date;

public class Funding {
	
	private int funding_no;
	private int funding_resvSeat;
	private int funding_totalSeat;
	private int funding_price;
	private String funding_status;
	private Date funding_startDate;
	private Date funding_endDate;
	private Date funding_movieDate;
	private FundingDetail fundingDetail;
	private Theater theater;
	private FundingList fundingList;
	private Movie movie;
	
	
	public Funding() {
	}

	public Funding(int funding_no, int funding_resvSeat, int funding_totalSeat, int funding_price,
			String funding_status, Date funding_startDate, Date funding_endDate, Date funding_movieDate,
			FundingDetail fundingDetail) {
		super();
		this.funding_no = funding_no;
		this.funding_resvSeat = funding_resvSeat;
		this.funding_totalSeat = funding_totalSeat;
		this.funding_price = funding_price;
		this.funding_status = funding_status;
		this.funding_startDate = funding_startDate;
		this.funding_endDate = funding_endDate;
		this.funding_movieDate = funding_movieDate;
		this.fundingDetail = fundingDetail;
	}

	public int getFunding_no() {
		return funding_no;
	}

	public void setFunding_no(int funding_no) {
		this.funding_no = funding_no;
	}

	public int getFunding_resvSeat() {
		return funding_resvSeat;
	}

	public void setFunding_resvSeat(int funding_resvSeat) {
		this.funding_resvSeat = funding_resvSeat;
	}

	public int getFunding_totalSeat() {
		return funding_totalSeat;
	}

	public void setFunding_totalSeat(int funding_totalSeat) {
		this.funding_totalSeat = funding_totalSeat;
	}

	public int getFunding_price() {
		return funding_price;
	}

	public void setFunding_price(int funding_price) {
		this.funding_price = funding_price;
	}

	public String getFunding_status() {
		return funding_status;
	}

	public void setFunding_status(String funding_status) {
		this.funding_status = funding_status;
	}

	public Date getFunding_startDate() {
		return funding_startDate;
	}

	public void setFunding_startDate(Date funding_startDate) {
		this.funding_startDate = funding_startDate;
	}

	public Date getFunding_endDate() {
		return funding_endDate;
	}

	public void setFunding_endDate(Date funding_endDate) {
		this.funding_endDate = funding_endDate;
	}

	public Date getFunding_movieDate() {
		return funding_movieDate;
	}

	public void setFunding_movieDate(Date funding_movieDate) {
		this.funding_movieDate = funding_movieDate;
	}

	public FundingDetail getFundingDetail() {
		return fundingDetail;
	}

	public void setFundingDetail(FundingDetail fundingDetail) {
		this.fundingDetail = fundingDetail;
	}

	@Override
	public String toString() {
		return "Funding [funding_no=" + funding_no + ", funding_resvSeat=" + funding_resvSeat + ", funding_totalSeat="
				+ funding_totalSeat + ", funding_price=" + funding_price + ", funding_status=" + funding_status
				+ ", funding_startDate=" + funding_startDate + ", funding_endDate=" + funding_endDate
				+ ", funding_movieDate=" + funding_movieDate + ", fundingDetail=" + fundingDetail + "]";
	}

	

}
