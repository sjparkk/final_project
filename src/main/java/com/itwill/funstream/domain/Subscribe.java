package com.itwill.funstream.domain;

public class Subscribe {
	private int subs_no;
	private String subs_type;
	private int subs_price;
	private int subs_duration;
	private String subs_autoPay;

	public Subscribe() {
		// TODO Auto-generated constructor stub
	}

	public Subscribe(int subs_no, String subs_type, int subs_price, int subs_duration, String subs_autoPay) {
		super();
		this.subs_no = subs_no;
		this.subs_type = subs_type;
		this.subs_price = subs_price;
		this.subs_duration = subs_duration;
		this.subs_autoPay = subs_autoPay;
	}

	public int getSubs_no() {
		return subs_no;
	}

	public void setSubs_no(int subs_no) {
		this.subs_no = subs_no;
	}

	public String getSubs_type() {
		return subs_type;
	}

	public void setSubs_type(String subs_type) {
		this.subs_type = subs_type;
	}

	public int getSubs_price() {
		return subs_price;
	}

	public void setSubs_price(int subs_price) {
		this.subs_price = subs_price;
	}

	public int getSubs_duration() {
		return subs_duration;
	}

	public void setSubs_duration(int subs_duration) {
		this.subs_duration = subs_duration;
	}

	public String getSubs_autoPay() {
		return subs_autoPay;
	}

	public void setSubs_autoPay(String subs_autoPay) {
		this.subs_autoPay = subs_autoPay;
	}

	@Override
	public String toString() {
		return "Subscribe [subs_no=" + subs_no + ", subs_type=" + subs_type + ", subs_price=" + subs_price
				+ ", subs_duration=" + subs_duration + ", subs_autoPay=" + subs_autoPay + "]";
	}

}
