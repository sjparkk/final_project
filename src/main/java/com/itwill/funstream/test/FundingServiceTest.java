package com.itwill.funstream.test;

import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.funstream.domain.FundingResultValue;
import com.itwill.funstream.service.FundingService;
import com.itwill.funstream.service.FundingServiceMyBatis;

public class FundingServiceTest {

	public static void main(String[] args) throws Exception{
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/spring/application-config.xml");
		FundingService fundingService = (FundingService)applicationContext.getBean("fundingService");

		System.out.println(fundingService.findFundingDetailByFundingNo(39));
		
		//System.out.println(fundingService.findAllFundingOrderByPercentDesc());
		
		//System.out.println(fundingService.findPreferedTheaterListByUserNo(1));
		
		//System.out.println(fundingService.findPreferedTheaterListByUserNo(10));
		
		//System.out.println(fundingService.selectfundingListByUserNo(1, 3));
		
		//마감날짜 
		//List<FundingResultValue> date = fundingService.findAllFundingOrderByFundingEndDateAsc();
		//Date sysdate = new Date();
		//System.out.println(sysdate);
		//System.out.println(date);

		
		//fundingService.createFunding();
		

/*
		for (FundingResultValue fundingResultValue : date) {
			 if(sysdate.after(fundingResultValue.getFunding_endDate())) {
				 System.out.println(fundingResultValue.getFunding_no());
				 //fundingService.updateFundingStatusByFundingNo("실패",fundingResultValue.getFunding_no());
				 
			 }
		}

		fundingService.createFunding();

*/
		

	}

}
