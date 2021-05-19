package com.itwill.funstream.test;


import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.funstream.dao.FundingDao;
import com.itwill.funstream.dao.MovieDao;
import com.itwill.funstream.domain.FundingDetail;
import com.itwill.funstream.domain.FundingResultValue;

public class FundingDaoTest {

	public static void main(String[] args) throws Exception {
	ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/spring/application-config.xml");
	FundingDao fundingDao = (FundingDao)applicationContext.getBean("fundingDao");
	MovieDao movieDao = (MovieDao)applicationContext.getBean("movieDao");

	//System.out.println(fundingDao.selectfundingListByUserNo(3, 1, 3));
	//System.out.println(fundingDao.selectAllFundingCount(3));
	//System.out.println(fundingDao.findTheaterName());


	//System.out.println(fundingService.findPreferedTheaterListByUserNo(1));

	System.out.println("-------------");
	List<FundingDetail> list = fundingDao.findFundingListByPercent();
	for (FundingDetail fundingDetail : list) {
		System.out.println(fundingDetail);
	}
	
	//int j = fundingDao.createFundingAndFundingDetail(7, 7);
	//System.out.println(fundingDao.createFundingAndFundingDetail(7, 7));

	//System.out.println(fundingService.findPreferedTheaterListByUserNo(10));
	
	//System.out.println(fundingService.selectfundingListByUserNo(1, 3));
	
	/*날짜 비교후 상태 변화시 상태 변경 및 펀딩과 펀딩디테일 생성
	List<FundingResultValue> date = fundingDao.findAllFundingOrderByFundingEndDateAsc();
	int movieTotalNo = movieDao.selectMovieCountAll();
	Date sysdate = new Date();
	
	for (FundingResultValue fundingResultValue : date) {
		
		if (sysdate.after(fundingResultValue.getFunding_endDate())) {
			fundingResultValue.getFunding_no();
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

	*/

	/*
	 List<FundingList> list= fundingDao.findFundingListByUserNo(3);

	
	 	
	/*
	 List<FundingResultValue> fundingDetail= fundingDao.findFundingPayInfoByUserNoAndFundingNo(1, 1);
	 for (FundingResultValue fundingResultValue : fundingDetail) {
		System.out.println(fundingResultValue);
	}*/
	 //System.out.println(fundingDetail.getFunding_resvSeat());
	 //System.out.println(fundingDetail);
	/*
	 System.out.format("%.2f%%%n",((double)fundingDetail.getFunding_resvSeat()/(double)fundingDetail.getFunding_totalSeat())*100);
	  */
	//System.out.println(fundingDao.insertFundingUser(6, 10));
	//List<FundingResultValue> fundingInfoList = fundingDao.findAllFundingOrderByFundingEndDateAsc();
	//List<FundingResultValue> fundingInfoList = fundingDao.findAllFundingOrderByFundingStartDateDesc();
	/*
	List<FundingDetail> fundingInfoList = fundingDao.findFundingListByPercent();
	for (FundingDetail fundingInfo1 : fundingInfoList) {
		System.out.println(fundingInfo1);
	}
	List<FundingDetail> fundingList = fundingDao.findAllFundingOrderByPercentDesc();
	for(FundingDetail funding : fundingList) {
		System.out.println(funding);
	}
		//System.out.println(fundingDao.findAllFundingOrderByPercentDesc());
	List<FundingDetail> fundingListByPercentThree = fundingDao.findFundingListByPercent();
	for(FundingDetail funding : fundingListByPercentThree) {
		System.out.println(funding);
	}*/
		//System.out.println(fundingDao.findFundingListByTheaterNo(1));
		//System.out.println(fundingDao.findPreferedTheaterListByUserNo(7));
		//System.out.println(fundingDao.updateFundingStatusByFundingNo("성공",4));
		//System.out.println(fundingDao.deletePreferedTheaterByPreferNo(0));
	}
	

}
