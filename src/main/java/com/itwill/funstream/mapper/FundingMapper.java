
package com.itwill.funstream.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.itwill.funstream.domain.Funding;
import com.itwill.funstream.domain.FundingDetail;
import com.itwill.funstream.domain.FundingList;
import com.itwill.funstream.domain.FundingResultValue;
import com.itwill.funstream.domain.Theater;
import com.itwill.funstream.domain.UserInfoTheater;

public interface FundingMapper {

	public List<Theater> findPreferedTheaterListByUserNo(int user_no);
	public List<FundingResultValue> findFundingPayInfoByUserNoAndFundingNo(@Param("funding_no") int funding_no,@Param("user_no") int user_no);
	public List<FundingResultValue> findAllFundingOrderByFundingStartDateDesc();
	public List<FundingResultValue> findAllFundingOrderByFundingEndDateAsc();
	public FundingResultValue findFundingDetailByFundingNo(int funding_no);
	public int deletePreferedTheaterByPreferNo(int prefer_no);
	public int updateFundingStatusByFundingNo(@Param("funding_status")String funding_status, @Param("funding_no")int funding_no);
	public List<FundingResultValue> findAllFundingOrderByPercentDesc();
	public List<FundingDetail> findFundingListByTheaterNo(int theater_no);
	public List<FundingDetail> findFundingListByPercent();
	public List<FundingResultValue> findAllFundingOrderByTheaterNameAsc();
	public int updateResvSeatByFunding(@Param("qty")int qty, @Param("funding_no")int funding_no);
	public int insertPreferedTheater(UserInfoTheater userInfoTheater);
	public List<FundingList> findFundingListByUserNo(int user_no);
	public int insertFundingUser(@Param("user_no") int user_no, @Param("funding_no") int funding_no);
	public int insertFundingList(@Param("fl_qty")int fl_qty,@Param("user_no")int user_no, @Param("card_no")int card_no, @Param("funding_no")int funding_no, @Param("movie_no")int movie_no);
	//펀딩신청내역페이지메이커
	public List<FundingList> selectfundingListByUserNo(@Param("user_no") int user_no,@Param("start") int start,@Param("last") int last);
	public int selectAllFundingCount(int user_no);
	//선호영화관 이름리스트
	public List<Theater> findTheaterName();

	//펀딩,펀딩디테일 삽입
	public int createFundingAndFundingDetail(@Param("theater_no")int theater_no,@Param("movie_no") int movie_no);


}
