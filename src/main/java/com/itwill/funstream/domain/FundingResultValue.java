package com.itwill.funstream.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class FundingResultValue {
	
	//funding
	private int funding_no;
	private int funding_resvSeat;
	private int funding_totalSeat;
	private int funding_price;
	private String funding_status;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date funding_startDate;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date funding_endDate;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date funding_movieDate;
	//fundingList
	private int fl_no;
	private Date fl_date;
	private int fl_qty;
	//fundingDetail
	private int fd_no;
	//movie
	private int movie_no;
	private String movie_title;
	private String movie_img;
	private String movie_rating;
	private Date movie_opendate;
	private String movie_runtime;
	//moviedetail
	private int md_no;
	private String md_summary;
	private String md_director;
	private String md_actors;
	private String md_film;
	private String md_subfilm;
	//genre
	private int genre_no;
	private String genre_name;
	//theater
	private int theater_no;
	private String theater_address;
	private String theater_name;
	private String theater_phone;
	private String theater_img;
	//userinfo
	private int user_no;
	private String user_id;
	private String user_phone;
	//userinfo_theater
	private int prefer_no;
	//card
	private int card_no;
	private String card_realNo;
	private String card_valid;
	private int card_cvc;
	private int card_password;
	private String card_alias;
	
	public FundingResultValue() {
		// TODO Auto-generated constructor stub
	}

	public FundingResultValue(int funding_no, int funding_resvSeat, int funding_totalSeat, int funding_price,
			String funding_status, Date funding_startDate, Date funding_endDate, Date funding_movieDate, int fl_no,
			Date fl_date, int fl_qty, int fd_no, int movie_no, String movie_title, String movie_img,
			String movie_rating, Date movie_opendate, String movie_runtime, int md_no, String md_summary,
			String md_director, String md_actors, String md_film, String md_subfilm, int genre_no, String genre_name,
			int theater_no, String theater_address, String theater_name, String theater_phone, String theater_img,
			int user_no, String user_id, String user_phone, int prefer_no, int card_no, String card_realNo,
			String card_valid, int card_cvc, int card_password, String card_alias) {
		super();
		this.funding_no = funding_no;
		this.funding_resvSeat = funding_resvSeat;
		this.funding_totalSeat = funding_totalSeat;
		this.funding_price = funding_price;
		this.funding_status = funding_status;
		this.funding_startDate = funding_startDate;
		this.funding_endDate = funding_endDate;
		this.funding_movieDate = funding_movieDate;
		this.fl_no = fl_no;
		this.fl_date = fl_date;
		this.fl_qty = fl_qty;
		this.fd_no = fd_no;
		this.movie_no = movie_no;
		this.movie_title = movie_title;
		this.movie_img = movie_img;
		this.movie_rating = movie_rating;
		this.movie_opendate = movie_opendate;
		this.movie_runtime = movie_runtime;
		this.md_no = md_no;
		this.md_summary = md_summary;
		this.md_director = md_director;
		this.md_actors = md_actors;
		this.md_film = md_film;
		this.md_subfilm = md_subfilm;
		this.genre_no = genre_no;
		this.genre_name = genre_name;
		this.theater_no = theater_no;
		this.theater_address = theater_address;
		this.theater_name = theater_name;
		this.theater_phone = theater_phone;
		this.theater_img = theater_img;
		this.user_no = user_no;
		this.user_id = user_id;
		this.user_phone = user_phone;
		this.prefer_no = prefer_no;
		this.card_no = card_no;
		this.card_realNo = card_realNo;
		this.card_valid = card_valid;
		this.card_cvc = card_cvc;
		this.card_password = card_password;
		this.card_alias = card_alias;
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

	public int getFd_no() {
		return fd_no;
	}

	public void setFd_no(int fd_no) {
		this.fd_no = fd_no;
	}

	public int getMovie_no() {
		return movie_no;
	}

	public void setMovie_no(int movie_no) {
		this.movie_no = movie_no;
	}

	public String getMovie_title() {
		return movie_title;
	}

	public void setMovie_title(String movie_title) {
		this.movie_title = movie_title;
	}

	public String getMovie_img() {
		return movie_img;
	}

	public void setMovie_img(String movie_img) {
		this.movie_img = movie_img;
	}

	public String getMovie_rating() {
		return movie_rating;
	}

	public void setMovie_rating(String movie_rating) {
		this.movie_rating = movie_rating;
	}

	public Date getMovie_opendate() {
		return movie_opendate;
	}

	public void setMovie_opendate(Date movie_opendate) {
		this.movie_opendate = movie_opendate;
	}

	public String getMovie_runtime() {
		return movie_runtime;
	}

	public void setMovie_runtime(String movie_runtime) {
		this.movie_runtime = movie_runtime;
	}

	public int getMd_no() {
		return md_no;
	}

	public void setMd_no(int md_no) {
		this.md_no = md_no;
	}

	public String getMd_summary() {
		return md_summary;
	}

	public void setMd_summary(String md_summary) {
		this.md_summary = md_summary;
	}

	public String getMd_director() {
		return md_director;
	}

	public void setMd_director(String md_director) {
		this.md_director = md_director;
	}

	public String getMd_actors() {
		return md_actors;
	}

	public void setMd_actors(String md_actors) {
		this.md_actors = md_actors;
	}

	public String getMd_film() {
		return md_film;
	}

	public void setMd_film(String md_film) {
		this.md_film = md_film;
	}

	public String getMd_subfilm() {
		return md_subfilm;
	}

	public void setMd_subfilm(String md_subfilm) {
		this.md_subfilm = md_subfilm;
	}

	public int getGenre_no() {
		return genre_no;
	}

	public void setGenre_no(int genre_no) {
		this.genre_no = genre_no;
	}

	public String getGenre_name() {
		return genre_name;
	}

	public void setGenre_name(String genre_name) {
		this.genre_name = genre_name;
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

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public int getPrefer_no() {
		return prefer_no;
	}

	public void setPrefer_no(int prefer_no) {
		this.prefer_no = prefer_no;
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

	@Override
	public String toString() {
		return "FundingResultValue [funding_no=" + funding_no + ", funding_resvSeat=" + funding_resvSeat
				+ ", funding_totalSeat=" + funding_totalSeat + ", funding_price=" + funding_price + ", funding_status="
				+ funding_status + ", funding_startDate=" + funding_startDate + ", funding_endDate=" + funding_endDate
				+ ", funding_movieDate=" + funding_movieDate + ", fl_no=" + fl_no + ", fl_date=" + fl_date + ", fl_qty="
				+ fl_qty + ", fd_no=" + fd_no + ", movie_no=" + movie_no + ", movie_title=" + movie_title
				+ ", movie_img=" + movie_img + ", movie_rating=" + movie_rating + ", movie_opendate=" + movie_opendate
				+ ", movie_runtime=" + movie_runtime + ", md_no=" + md_no + ", md_summary=" + md_summary
				+ ", md_director=" + md_director + ", md_actors=" + md_actors + ", md_film=" + md_film + ", md_subfilm="
				+ md_subfilm + ", genre_no=" + genre_no + ", genre_name=" + genre_name + ", theater_no=" + theater_no
				+ ", theater_address=" + theater_address + ", theater_name=" + theater_name + ", theater_phone="
				+ theater_phone + ", theater_img=" + theater_img + ", user_no=" + user_no + ", user_id=" + user_id
				+ ", user_phone=" + user_phone + ", prefer_no=" + prefer_no + ", card_no=" + card_no + ", card_realNo="
				+ card_realNo + ", card_valid=" + card_valid + ", card_cvc=" + card_cvc + ", card_password="
				+ card_password + ", card_alias=" + card_alias + "]";
	}
	
	
	
	
}
