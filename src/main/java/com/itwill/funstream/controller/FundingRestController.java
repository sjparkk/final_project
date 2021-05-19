package com.itwill.funstream.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.funstream.domain.FundingDetail;
import com.itwill.funstream.domain.FundingResultValue;
import com.itwill.funstream.service.FundingService;

@RestController
public class FundingRestController {
	
	@Autowired
	private FundingService fundingService;
	
	@RequestMapping(value = "api/preferedTheater", produces = "application/json; charset=UTF-8")
	public List<FundingDetail>  getPreferedTheaterListByUserNo() throws Exception {
		return fundingService.findFundingListByPercent();
	}
	
	@RequestMapping(value = "api/funding_history_detail", produces = "application/json; charset=UTF-8")
	public FundingResultValue  getFundingHistoryDetailByFundingNo(@RequestParam int funding_no) throws Exception {
	    //Thread.sleep(2000);
		return fundingService.findFundingDetailByFundingNo(funding_no);
	}
	
}
