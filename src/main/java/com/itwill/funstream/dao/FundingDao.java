package com.itwill.funstream.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.itwill.funstream.domain.Funding;
import com.itwill.funstream.domain.FundingDetail;
import com.itwill.funstream.domain.FundingList;
import com.itwill.funstream.domain.FundingResultValue;
import com.itwill.funstream.domain.Theater;
import com.itwill.funstream.domain.UserInfoTheater;

public interface FundingDao {

	public List<Theater> findPreferedTheaterListByUserNo(int user_no) throws Exception;
	public List<FundingResultValue> findFundingPayInfoByUserNoAndFundingNo(int funding_no,int user_no) throws Exception;
	public List<FundingResultValue> findAllFundingOrderByFundingStartDateDesc() throws Exception;
	public List<FundingResultValue> findAllFundingOrderByFundingEndDateAsc() throws Exception;
	public FundingResultValue findFundingDetailByFundingNo(int funding_no) throws Exception;
	public int deletePreferedTheaterByPreferNo(int prefer_no) throws Exception;
	public int updateFundingStatusByFundingNo(String funding_status, int funding_no) throws Exception;
	public List<FundingResultValue> findAllFundingOrderByPercentDesc() throws Exception;
	public List<FundingDetail> findFundingListByTheaterNo(int theater_no) throws Exception;
	public List<FundingDetail> findFundingListByPercent() throws Exception;
	public List<FundingResultValue> findAllFundingOrderByTheaterNameAsc()throws Exception;	
	public int updateResvSeatByFunding(int qty, int funding_no)throws Exception;
	public int insertPreferedTheater(UserInfoTheater userInfoTheater)throws Exception;
	public List<FundingList> findFundingListByUserNo(int user_no)throws Exception;
	public int insertFundingUser(int user_no, int funding_no)throws Exception;
	public int insertFundingList(int fl_qty,int user_no, int card_no, int funding_no, int movie_no)throws Exception;
	//펀딩신청내역페이지메이커
	public List<FundingList> selectfundingListByUserNo(@Param("user_no") int user_no,@Param("start") int start,@Param("last") int last);
	public int selectAllFundingCount(int user_no);
	public List<Theater> findTheaterName();

	//펀딩,펀딩디테일 삽입
	public int createFundingAndFundingDetail(int theater_no, int movie_no);

}

