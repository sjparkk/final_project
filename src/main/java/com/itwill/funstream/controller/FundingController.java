package com.itwill.funstream.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itwill.funstream.domain.Card;
import com.itwill.funstream.domain.FundingDetail;
import com.itwill.funstream.domain.FundingList;
import com.itwill.funstream.domain.FundingResultValue;
import com.itwill.funstream.domain.Theater;
import com.itwill.funstream.service.CardService;
import com.itwill.funstream.service.FundingService;
import com.itwill.funstream.util.fundingpagemaker.FundingListPageMakerDto;

@Controller
public class FundingController {
	
	@Autowired
	private FundingService fundingService;
	@Autowired
	private CardService cardService;
	
	public FundingController() {
	}


	// 펀딩메인페이지
	@RequestMapping("funding_main")
	public String funding_main(HttpSession session, Model model) throws Exception {
		
		List<List<FundingDetail>> fundingListByPreferedTheater = new ArrayList<List<FundingDetail>>();
		
		String user_no = String.valueOf(session.getAttribute("sUserNo"));
		if(!(user_no.equals("null")||user_no.equals(""))) {					
			fundingListByPreferedTheater = fundingService.fundingListbyPreferedTheaterNo(Integer.parseInt(user_no));			
		}
	
		List<FundingDetail> percentList = fundingService.findFundingListByPercent();
		List<FundingResultValue> orderByTheaterName = fundingService.findAllFundingOrderByTheaterNameAsc();
		//상단
		model.addAttribute("percentList", percentList);
		//중단
		model.addAttribute("fundingListByPreferedTheater", fundingListByPreferedTheater);
		//하단
		model.addAttribute("orderByTheaterName", orderByTheaterName);
		
		return "funding_main";
	}

	
	// 펀딩 메인 하단 정렬
	@RequestMapping("f_movie_list")
	public String f_movie_list(Model model, @RequestParam(value = "optionNo") int optionNo) throws Exception {
		List<FundingResultValue> fundingTheaterNameList = fundingService.findAllFundingOrderByTheaterNameAsc();
		List<FundingResultValue> fundingEndDateAscList = fundingService.findAllFundingOrderByFundingEndDateAsc();
		List<FundingResultValue> fundingStartDateDescList = fundingService.findAllFundingOrderByFundingStartDateDesc();

		switch (optionNo) {
		case 0:
			// 펀딩 이름
			model.addAttribute("resultList", fundingTheaterNameList);
			break;
		case 1:
			// 최신순
			model.addAttribute("resultList", fundingStartDateDescList);
			break;
		case 2:
			// 마감순
			model.addAttribute("resultList", fundingEndDateAscList);
			break;
		}

		return "f_movie_list";
	}
		
	//펀딩 상세보기 
	@RequestMapping("funding_detail")
	public String funding_detail_form(@RequestParam int funding_no, Model model) throws Exception {
		String forwardPath = "";
		System.out.println(funding_no);
		FundingResultValue fundingDetail =fundingService.findFundingDetailByFundingNo(funding_no);
		String status = fundingDetail.getFunding_status();
		if(status.equals("진행중")) {
			//진행중인 펀딩
			Double percent = fundingService.calculatePercent(funding_no);
			model.addAttribute("percent",percent);
			model.addAttribute("fundingDetail",fundingDetail);
			forwardPath = "funding_detail";
		}else {
			//마감된 펀딩
			forwardPath = "redirect:funding_main";
		}
		return forwardPath;
	}


	//펀딩 결제하기
	@LoginCheck
	@RequestMapping("funding_payment_form")
	public String funding_payment_form(HttpSession session, @RequestParam int funding_no, @RequestParam int qty, Model model) throws Exception {
		String forwardPath = "";
		int user_no = (int) session.getAttribute("sUserNo");

			List<FundingResultValue> fundingDetailList = fundingService.findFundingPayInfoByUserNoAndFundingNo(funding_no,user_no);
			FundingResultValue fundingDetail = fundingDetailList.get(0);
			Double percent = fundingService.calculatePercent(funding_no);
			
			//기본 설정카드 split
			String[] cardNoArray = fundingDetail.getCard_realNo().split("-");
			String cardRealNo = cardNoArray[0]+"-****-****-"+cardNoArray[3];
			System.out.println(cardRealNo);
			//카드리스트
			List<Card> cardList = cardService.cardListByUserNo(user_no);
			
			model.addAttribute("percent",percent);
			model.addAttribute("qty",qty);
			model.addAttribute("fundingDetail",fundingDetail);
			model.addAttribute("cardRealNo",cardRealNo);
			model.addAttribute("cardList", cardList);
			forwardPath = "funding_payment_form";

		return forwardPath;
	}

	@GetMapping("funding_payment_action")
	public String funding_payment_action_get() {
		return "funding_main";
	}

	@ResponseBody
	@PostMapping(value = "funding_payment_action", produces = "text/html;charset=UTF-8")
	public String funding_payment_action_post(HttpSession session, @RequestParam int funding_no, @RequestParam int qty, @RequestParam int card_no, @RequestParam int movie_no, Model model)
			throws Exception {
		String sUserNo = String.valueOf(session.getAttribute("sUserNo"));
		int count = fundingService.payment(Integer.parseInt(sUserNo), funding_no, qty, card_no, movie_no);
		String countStr = Integer.toString(count);
		model.addAttribute("sUserNo", sUserNo);
		return countStr;
	}
		
	// 펀딩신청내역 보기
	@RequestMapping("funding_history")
	@LoginCheck
	public String funding_history(HttpSession session,@RequestParam(value="pageno",defaultValue = "1") String pageno , Model model) throws Exception {
		int user_no = (int) session.getAttribute("sUserNo");
		List<FundingList> fundingList = fundingService.findFundingListByUserNo(user_no);
		if(pageno == null || pageno.equals("")) {
	         pageno = "1";
	      }
		FundingListPageMakerDto fundingHistoryPage = fundingService.selectfundingListByUserNo(Integer.parseInt(pageno), user_no);
		model.addAttribute("fundingList",fundingList);
		model.addAttribute("fundingHistoryPage", fundingHistoryPage);
		model.addAttribute("user_no", user_no);
		return "funding_history";
	}

	// 펀딩 리스트 디테일
	@LoginCheck
	@RequestMapping("f_funding_history_detail")
	public String f_funding_history_detail(@RequestParam int user_no, @RequestParam int pageno, Model model) throws Exception {
		List<FundingList> fundingList = fundingService.findFundingListByUserNo(user_no);
		FundingListPageMakerDto fundingHistoryPage = fundingService.selectfundingListByUserNo(pageno, user_no);
		model.addAttribute("fundingList", fundingList);
		model.addAttribute("fundingHistoryPage", fundingHistoryPage);
		model.addAttribute("user_no", user_no);
		return "f_funding_history_detail";
	}

	// 내정보에서 선호영화관 목록 보기
	@RequestMapping("test/user_prefer_theater")
	public String user_prefer_theater(@RequestParam int user_no, Model model) throws Exception {
		List<Theater> theaterList = fundingService.findPreferedTheaterListByUserNo(user_no);
		model.addAttribute("theaterList", theaterList);
		return "test/user_prefer_theater";
	}

	// 내정보에서 선호영화관 삽입
	@RequestMapping("test/user_prefer_theater_insert_action")
	public String user_prefer_theater_insert_action(@RequestParam String theater_name) throws Exception {
		// fundingService.insertPreferedTheater(userInfoTheater);
		return "redirect:test/user_prefer_theater";
	}

	// 내정보에서 선호영화관 삭제
	@RequestMapping("test/preferTheater_remove_action")
	public String user_prefer_theater_remove_action(@RequestParam int prefer_no) throws Exception {
		fundingService.deletePreferedTheaterByPreferNo(prefer_no);
		return "redirect:test/user_prefer_theater";
	}
}