package com.itwill.funstream.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.funstream.domain.Funding;
import com.itwill.funstream.domain.FundingDetail;
import com.itwill.funstream.domain.FundingList;
import com.itwill.funstream.domain.FundingResultValue;
import com.itwill.funstream.domain.Theater;
import com.itwill.funstream.domain.UserInfoTheater;
import com.itwill.funstream.util.fundingpagemaker.FundingListPageMakerDto;

@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public interface FundingService {

	/*
	 main - top
	 */
	public List<FundingDetail> findFundingListByTheaterNo(int theater_no) throws Exception;

	public List<FundingDetail> findFundingListByPercent() throws Exception;

	/*
	 main - sort
	 */
	public List<FundingResultValue> findAllFundingOrderByFundingStartDateDesc() throws Exception;

	public List<FundingResultValue> findAllFundingOrderByFundingEndDateAsc() throws Exception;

	public List<FundingResultValue> findAllFundingOrderByPercentDesc() throws Exception;

	public List<FundingResultValue> findAllFundingOrderByTheaterNameAsc() throws Exception;	
	
	/*
	 detail
	 */
	public FundingResultValue findFundingDetailByFundingNo(int funding_no) throws Exception;

	/*
	 pay
	 */
	public List<FundingResultValue> findFundingPayInfoByUserNoAndFundingNo(int funding_no, int user_no) throws Exception;
	
	public int payment(int user_no, int funding_no, int qty, int card_no, int movie_no) throws Exception;

	/*
	 history
	 */
	public List<FundingList> findFundingListByUserNo(int user_no) throws Exception;

	//public int insertFundingUser(int user_no, int funding_no) throws Exception;

	/*
	 update status
	 */
	public int updateFundingStatusByFundingNo(String funding_status, int funding_no) throws Exception;

	/*
	 update seat
	 */
	//public int updateReservedSeatByFundingNo(int funding_no, int qty) throws Exception;

	/*
	 preferedTheater
	 */
	public List<Theater> findPreferedTheaterListByUserNo(int user_no) throws Exception;

	public int deletePreferedTheaterByPreferNo(int prefer_no) throws Exception;

	public int insertPreferedTheater(UserInfoTheater userInfoTheater) throws Exception;

	public Double calculatePercent(int funding_no) throws Exception;

	public List<List<FundingDetail>> fundingListbyPreferedTheaterNo(int user_no) throws Exception;
	
	//펀딩신청내역페이지메이커
	public FundingListPageMakerDto selectfundingListByUserNo(int currentPage, int user_no);
	
	public List<Theater> findTheaterName();
	public String preferedTheaterLimit(int user_no) throws Exception;
	
	//펀딩,펀딩디테일 삽입
	public int createFundingAndFundingDetail(int theater_no, int movie_no);
	public void createFunding() throws Exception;
}