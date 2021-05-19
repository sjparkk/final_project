package com.itwill.funstream.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.itwill.funstream.dao.FundingDao;
import com.itwill.funstream.dao.MovieDao;
import com.itwill.funstream.dao.UserInfoDao;
import com.itwill.funstream.domain.Funding;
import com.itwill.funstream.domain.FundingDetail;
import com.itwill.funstream.domain.FundingList;
import com.itwill.funstream.domain.FundingResultValue;
import com.itwill.funstream.domain.Theater;
import com.itwill.funstream.domain.UserInfo;
import com.itwill.funstream.domain.UserInfoTheater;
import com.itwill.funstream.util.fundingpagemaker.FundingListPageMakerDto;
import com.itwill.funstream.util.fundingpagemaker.PageMaker;

@Service("fundingService")
public class FundingServiceMyBatis implements FundingService {
	
	@Autowired
	private FundingDao fundingDao;
	@Autowired
	private UserInfoDao userInfoDao;
	@Autowired
	private MovieDao movieDao;

	public FundingServiceMyBatis() {
	}
	
	@Override
	public List<Theater> findPreferedTheaterListByUserNo(int user_no) throws Exception {
		return fundingDao.findPreferedTheaterListByUserNo(user_no);
	}

	@Override
	public List<FundingResultValue> findFundingPayInfoByUserNoAndFundingNo(int user_no, int funding_no) throws Exception {
		return fundingDao.findFundingPayInfoByUserNoAndFundingNo(user_no, funding_no);
	}

	@Override
	public List<FundingResultValue> findAllFundingOrderByFundingStartDateDesc() throws Exception {
		return fundingDao.findAllFundingOrderByFundingStartDateDesc();
	}

	@Override
	public List<FundingResultValue> findAllFundingOrderByFundingEndDateAsc() throws Exception {
		return fundingDao.findAllFundingOrderByFundingEndDateAsc();
	}

	@Override
	public FundingResultValue findFundingDetailByFundingNo(int funding_no) throws Exception {
		return fundingDao.findFundingDetailByFundingNo(funding_no);
	}

	@Override
	public List<FundingResultValue> findAllFundingOrderByPercentDesc() throws Exception {
		return fundingDao.findAllFundingOrderByPercentDesc();
	}

	@Override
	public List<FundingDetail> findFundingListByTheaterNo(int theater_no) throws Exception {
		return fundingDao.findFundingListByTheaterNo(theater_no);
	}

	@Override
	public List<FundingDetail> findFundingListByPercent() throws Exception {
		return fundingDao.findFundingListByPercent();
	}

	@Override
	public List<FundingResultValue> findAllFundingOrderByTheaterNameAsc() throws Exception{
		return fundingDao.findAllFundingOrderByTheaterNameAsc();
	}

	@Override
	public List<FundingList> findFundingListByUserNo(int user_no) throws Exception{
		return fundingDao.findFundingListByUserNo(user_no);
	}

	@Override
	public int deletePreferedTheaterByPreferNo(int prefer_no) throws Exception {
		return fundingDao.deletePreferedTheaterByPreferNo(prefer_no);
	}

	@Override
	public int updateFundingStatusByFundingNo(String funding_status, int funding_no) throws Exception {
		return fundingDao.updateFundingStatusByFundingNo(funding_status, funding_no);
	}
	
	public int payment(int user_no, int funding_no, int qty, int card_no, int movie_no) throws Exception {
		int existed = 0;
		List<FundingList> list = fundingDao.findFundingListByUserNo(user_no);
		for (FundingList fundingList : list) {
			if(funding_no == fundingList.getFunding().getFunding_no()) {
				System.out.println("이미 신청하신 내역이 있습니다.");
				existed = 1;	//존재한다
				break;
			}
		}
		if(existed==0) {	//존재안함
			//펀딩찾아서 펀딩_유저, 펀딩신청내역 insert, 펀딩qty,펀딩resvSeat 업데이트
			FundingResultValue funding = fundingDao.findFundingDetailByFundingNo(funding_no);
			int updateQty = funding.getFunding_resvSeat()+ qty;
			if(updateQty > funding.getFunding_totalSeat()) {
				//인원초과시 메인으로 리다이렉트
				System.out.println("인원 초과로 신청하실 수 없습니다.");
				existed = 2;
			}else {
				//펀딩_유저 insert
				fundingDao.insertFundingUser(user_no, funding_no);
				//펀딩신청내역 insert
				fundingDao.insertFundingList(qty, user_no, card_no, funding_no, movie_no);
				//펀딩 resvSeat 업데이트
				fundingDao.updateResvSeatByFunding(qty, funding_no);
				if(updateQty == funding.getFunding_totalSeat()) {
					//펀딩 성공시 status 업데이트 성공
					int theaterNo = funding.getTheater_no();
					List<FundingDetail> fundingList= fundingDao.findFundingListByTheaterNo(theaterNo);
					for (FundingDetail fundingDetail : fundingList) {
						int fundingNo = fundingDetail.getFunding().getFunding_no();
						if(fundingNo == funding_no) {
							//현재 펀딩 성공으로 변경
							fundingDao.updateFundingStatusByFundingNo("성공", funding_no);
						}
					}
				}
				existed = 3;
			}
		}
		return existed;
	}
	
	
	@Override
	public int insertPreferedTheater(UserInfoTheater userInfoTheater) throws Exception{
		return fundingDao.insertPreferedTheater(userInfoTheater);
	}

	
	
	/*
	 * percent계산
	 */
	public Double calculatePercent(int funding_no) throws Exception{
		FundingResultValue funding = fundingDao.findFundingDetailByFundingNo(funding_no);
		Double percent = 0.0;
		if(funding.getFunding_resvSeat()!=0) {
			percent = ((double)funding.getFunding_resvSeat()/(double)funding.getFunding_totalSeat());			
		}else {
			percent = 0.0;
		}
		return percent;
	}
		
	/*
	 * 선호영화관의 펀딩리스트
	 */
	public List<List<FundingDetail>> fundingListbyPreferedTheaterNo(int user_no) throws Exception{

			List<Theater> theaterList = fundingDao.findPreferedTheaterListByUserNo(user_no);
			List<List<FundingDetail>> fundingList = new ArrayList<List<FundingDetail>>();
			for (Theater theater : theaterList) {			 
				fundingList.add(fundingDao.findFundingListByTheaterNo(theater.getTheater_no()));
			}
		return fundingList;	
		
	}

	//펀딩신청내역 페이지메이커
	@Override
	public FundingListPageMakerDto selectfundingListByUserNo(int currentPage, int user_no) {
		//펀딩전체갯수
		int totalRecordCount = fundingDao.selectAllFundingCount(user_no);
		//paging계산
		PageMaker pageMaker = new PageMaker(totalRecordCount, currentPage);
		//펀딩리스트얻기
		List<FundingList> fundingList = fundingDao.selectfundingListByUserNo(user_no, pageMaker.getPageBegin(), pageMaker.getPageEnd());
		FundingListPageMakerDto pageMakerFundingList = new FundingListPageMakerDto();
		pageMakerFundingList.totRecordCount = totalRecordCount;
		pageMakerFundingList.fundingList = fundingList;
		pageMakerFundingList.pageMaker = pageMaker;		
		
		return pageMakerFundingList;
	}

	@Override
	public List<Theater> findTheaterName() {
		return fundingDao.findTheaterName();
	}
	//선호영화관 초과시
	public String preferedTheaterLimit(int user_no) throws Exception {
		String msg = "fail";
		List<Theater> preferedTheaterList = findPreferedTheaterListByUserNo(user_no);
		if(preferedTheaterList.size()<3) {
			msg = "success";
		}
		return msg;
	}

	//펀딩,펀딩디테일 삽입
	@Override
	public int createFundingAndFundingDetail(int theater_no, int movie_no) {
		return fundingDao.createFundingAndFundingDetail(theater_no, movie_no);
	}
	
	//마감날짜지난것 실패변경 후 펀딩추가메소드
	@Scheduled(cron = "0 0 0 * * ?")
	public void createFunding() throws Exception {
		List<FundingResultValue> EndDate = fundingDao.findAllFundingOrderByFundingEndDateAsc();
		int movieTotalNo = movieDao.selectMovieCountAll();
		Date sysdate = new Date();
		
		for (FundingResultValue fundingResultValue : EndDate) {			
			if (sysdate.after(fundingResultValue.getFunding_endDate())) {
				int beforeMovieNo = fundingResultValue.getMovie_no();
				int changeMovieNo = (int) (Math.random() * movieTotalNo) +1 ;
				int theaterNo = fundingResultValue.getTheater_no();

				if(beforeMovieNo == changeMovieNo) {
					do {
						changeMovieNo = (int) (Math.random() * movieTotalNo) + 1;
					} while(beforeMovieNo ==changeMovieNo); 
				}

				fundingDao.updateFundingStatusByFundingNo("실패", fundingResultValue.getFunding_no());
				fundingDao.createFundingAndFundingDetail(theaterNo, changeMovieNo);		
			}
		}
		
	}
	
	

}
