package com.itwill.funstream.domain;

public class Card {
	private int card_no;
	private String card_realNo;
	private String card_valid;
	private int card_cvc;
	private int card_password;
	private String card_alias;
	private UserInfo userInfo;

	public Card() {
		// TODO Auto-generated constructor stub
	}

	public Card(int card_no, String card_realNo, String card_valid, int card_cvc, int card_password, String card_alias,
			UserInfo userInfo) {
		super();
		this.card_no = card_no;
		this.card_realNo = card_realNo;
		this.card_valid = card_valid;
		this.card_cvc = card_cvc;
		this.card_password = card_password;
		this.card_alias = card_alias;
		this.userInfo = userInfo;
	}

	public int getCard_no() {
		return card_no;
	}

	public void setCard_no(int card_no) {
		this.card_no = card_no;
	}

	public String getCard_realNo() {
		return card_realNo;
	}

	public void setCard_realNo(String card_realNo) {
		this.card_realNo = card_realNo;
	}

	public String getCard_valid() {
		return card_valid;
	}

	public void setCard_valid(String card_valid) {
		this.card_valid = card_valid;
	}

	public int getCard_cvc() {
		return card_cvc;
	}

	public void setCard_cvc(int card_cvc) {
		this.card_cvc = card_cvc;
	}

	public int getCard_password() {
		return card_password;
	}

	public void setCard_password(int card_password) {
		this.card_password = card_password;
	}

	public String getCard_alias() {
		return card_alias;
	}

	public void setCard_alias(String card_alias) {
		this.card_alias = card_alias;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	@Override
	public String toString() {
		return "Card [card_no=" + card_no + ", card_realNo=" + card_realNo + ", card_valid=" + card_valid
				+ ", card_cvc=" + card_cvc + ", card_password=" + card_password + ", card_alias=" + card_alias
				+ ", userInfo=" + userInfo + "]";
	}

}