package com.itwill.funstream.domain;

import java.util.ArrayList;
import java.util.List;

public class FundingUser {

	private int funduser_no;
	private UserInfo userInfo;
	private List<Funding> fundingList;
	
	public FundingUser() {
		// TODO Auto-generated constructor stub
	}

	public FundingUser(int funduser_no, UserInfo userInfo) {
		super();
		this.funduser_no = funduser_no;
		this.userInfo = userInfo;
		fundingList = new ArrayList<Funding>();
	}

	public int getFunduser_no() {
		return funduser_no;
	}

	public void setFunduser_no(int funduser_no) {
		this.funduser_no = funduser_no;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public List<Funding> getFundingList() {
		return fundingList;
	}

	public void setFundingList(List<Funding> fundingList) {
		this.fundingList = fundingList;
	}

	@Override
	public String toString() {
		return "Funding_user [funduser_no=" + funduser_no + ", userInfo=" + userInfo + ", fundingList=" + fundingList
				+ "]";
	}
	
	

	
	
}
