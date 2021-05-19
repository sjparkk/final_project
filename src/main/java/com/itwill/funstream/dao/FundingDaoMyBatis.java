package com.itwill.funstream.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.funstream.domain.Funding;
import com.itwill.funstream.domain.FundingDetail;
import com.itwill.funstream.domain.FundingList;
import com.itwill.funstream.domain.FundingResultValue;
import com.itwill.funstream.domain.Theater;
import com.itwill.funstream.domain.UserInfoTheater;
import com.itwill.funstream.mapper.FundingMapper;

@Repository("fundingDao")
public class FundingDaoMyBatis implements FundingDao {
	
	@Autowired
	private FundingMapper fundingMapper;
	
	public FundingDaoMyBatis() {
	}
	
	@Override
	public List<Theater> findPreferedTheaterListByUserNo(int user_no) throws Exception {
		return fundingMapper.findPreferedTheaterListByUserNo(user_no);
	}

	@Override
	public List<FundingResultValue> findFundingPayInfoByUserNoAndFundingNo(int funding_no,int user_no) throws Exception {
		return fundingMapper.findFundingPayInfoByUserNoAndFundingNo(funding_no,user_no);
	}

	@Override
	public List<FundingResultValue> findAllFundingOrderByFundingStartDateDesc() throws Exception {
		return fundingMapper.findAllFundingOrderByFundingStartDateDesc();
	}

	@Override
	public List<FundingResultValue> findAllFundingOrderByFundingEndDateAsc() throws Exception {
		return fundingMapper.findAllFundingOrderByFundingEndDateAsc();
	}

	@Override
	public FundingResultValue findFundingDetailByFundingNo(int funding_no) throws Exception {
		return fundingMapper.findFundingDetailByFundingNo(funding_no);
	}

	@Override
	public int deletePreferedTheaterByPreferNo(int prefer_no) throws Exception {
		return fundingMapper.deletePreferedTheaterByPreferNo(prefer_no);
	}

	@Override
	public int updateFundingStatusByFundingNo(String funding_status, int funding_no) throws Exception {
		return fundingMapper.updateFundingStatusByFundingNo(funding_status, funding_no);
	}

	@Override
	public List<FundingResultValue> findAllFundingOrderByPercentDesc() throws Exception {
		return fundingMapper.findAllFundingOrderByPercentDesc();
	}

	@Override
	public List<FundingDetail> findFundingListByTheaterNo(int theater_no) throws Exception {
		return fundingMapper.findFundingListByTheaterNo(theater_no);
	}

	@Override
	public List<FundingDetail> findFundingListByPercent() throws Exception {
		return fundingMapper.findFundingListByPercent();
	}
	
	@Override
	public List<FundingResultValue> findAllFundingOrderByTheaterNameAsc() throws Exception{
		List<FundingResultValue> fundingList = fundingMapper.findAllFundingOrderByTheaterNameAsc();
		return fundingList;
	}
	
	@Override
	public int updateResvSeatByFunding(int qty, int funding_no) throws Exception {
		int updateCount = fundingMapper.updateResvSeatByFunding(qty, funding_no);
		return updateCount;
	}

	@Override
	public int insertPreferedTheater(UserInfoTheater userInfoTheater) throws Exception{
		int insertCount = fundingMapper.insertPreferedTheater(userInfoTheater);
		return insertCount;
	}

	@Override
	public List<FundingList> findFundingListByUserNo(int user_no) throws Exception {
		List<FundingList> fundingList = fundingMapper.findFundingListByUserNo(user_no);
		return fundingList;
	}

	@Override
	public int insertFundingUser(int user_no, int funding_no) {
		int rowCount = fundingMapper.insertFundingUser(user_no, funding_no);
		return rowCount;
	}

	@Override
	public List<FundingList> selectfundingListByUserNo(int user_no, int start, int last) {		
		return fundingMapper.selectfundingListByUserNo(user_no, start, last);
	}

	@Override
	public int selectAllFundingCount(int user_no) {		
		return fundingMapper.selectAllFundingCount(user_no);
	}

	
	@Override
	public int insertFundingList(int fl_qty, int user_no, int card_no, int funding_no, int movie_no) throws Exception {
		int insertCount = fundingMapper.insertFundingList(fl_qty, user_no, card_no, funding_no, movie_no);
		return insertCount;
	}

	@Override
	public List<Theater> findTheaterName() {		
		return fundingMapper.findTheaterName();
	}


	@Override
	public int createFundingAndFundingDetail(int theater_no, int movie_no) {
		int insertCount = fundingMapper.createFundingAndFundingDetail(theater_no, movie_no);
		return insertCount;
	}

	
}
