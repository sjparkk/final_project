package com.itwill.funstream.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.funstream.domain.Card;
import com.itwill.funstream.domain.SubsUserInfo;
import com.itwill.funstream.domain.Subscribe;
import com.itwill.funstream.domain.Theater;
import com.itwill.funstream.domain.UserInfo;
import com.itwill.funstream.domain.UserInfoTheater;
import com.itwill.funstream.service.CardService;
import com.itwill.funstream.service.FundingService;
import com.itwill.funstream.service.SubsUserInfoService;
import com.itwill.funstream.service.SubscribeService;
import com.itwill.funstream.service.UserInfoService;

@RestController
public class UserInfoRestController {

	@Autowired
	private UserInfoService userInfoService;

	@Autowired
	private SubsUserInfoService subsUserInfoService;

	@Autowired
	private CardService cardService;

	@Autowired
	private SubscribeService subscribeService;

	@Autowired
	private FundingService fundingService;

	public UserInfoRestController() {
		// TODO Auto-generated constructor stub
	}

	@LoginCheck
	@RequestMapping(value = "cardList_check", produces = "text/plain;charset=UTF-8")
	public String cardList_check(HttpSession session) {
		int sUserNo = (int)session.getAttribute("sUserNo");
		String isCardList = "false";

		try {
			List<Card> userCardList = cardService.cardListByUserNo(sUserNo);
			if (userCardList.size() == 0) {
				isCardList = "false";
			} else {
				isCardList = "true";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return isCardList;
	}

	@RequestMapping(value = "user_autopay_cancle", produces = "text/plain;charset=UTF-8")
	public String user_autopay_cancle(HttpSession httpSession) {
		String msg = "fail";
		int user_no = (int) httpSession.getAttribute("sUserNo");
		try {
			subsUserInfoService.cancleAutoPay(user_no);
			msg = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}

		return msg;
	}

	@RequestMapping(value = "user_info_find", produces = "application/json;charset=UTF-8")
	public UserInfo user_info_find(HttpSession httpSession) {
		UserInfo userInfo = new UserInfo();
		UserInfo sUser = (UserInfo) httpSession.getAttribute("sUser");
		try {
			userInfo = userInfoService.findUserInfobyUserId(sUser.getUser_id());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return userInfo;
	}

	@LoginCheck
	@RequestMapping(value = "user_subscribe_payment_action", produces = "text/plain;charset=UTF-8")
	public String user_subscribe_payment_action_post(HttpSession session, @RequestParam String selected_card_no,
			@RequestParam String subs_autoPay, @RequestParam String subs_no) {
		String result = "";
		int sUserNo = (int) session.getAttribute("sUserNo");
		try {
			int subsNo = Integer.parseInt(subs_no);
			int cardNo = Integer.parseInt(selected_card_no);

			UserInfo userInfo = userInfoService.findUserInfobyUserNo(sUserNo);
			Subscribe subscribe = subscribeService.readSubscribebySubsNo(subsNo);
			Card card = cardService.cardSelectByCardNo(cardNo);

			SubsUserInfo subUserInfo = new SubsUserInfo(0, null, null, subs_autoPay, userInfo, subscribe, card);
			int cnt = subsUserInfoService.buyPass(subUserInfo);

			if (cnt == -1) {
				result = "false";
			} else if (cnt == 1) {
				result = "true";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@PostMapping(value = "user_modify_action", produces = "text/plain;charset=UTF-8")
	public String user_modify_action(@ModelAttribute UserInfo userInfo, HttpSession httpSession) {
		String msg = "fail";
		if (userInfo.getUser_password().equals("")) {
			UserInfo loginUser = (UserInfo) httpSession.getAttribute("sUser");
			userInfo.setUser_password(loginUser.getUser_password());
		}
		userInfo.setUser_no((int) httpSession.getAttribute("sUserNo"));
		try {
			userInfoService.updateUserInfo(userInfo);
			httpSession.setAttribute("sUser", userInfo);
			msg = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}

		return msg;
	}

	@RequestMapping(value = "user_subscribe_find", produces = "application/json;charset=UTF-8")
	public SubsUserInfo user_subscribe_find(HttpSession httpSession) {
		int sUserNo = (int) httpSession.getAttribute("sUserNo");
		return subsUserInfoService.subsPassbyUserNo(sUserNo);
	}

	@PostMapping(value = "user_changeAutoPayCard_action", produces = "text/plain;charset=UTF-8")
	public String user_changeAutoPayCard_action(@ModelAttribute SubsUserInfo subsUserInfo, HttpSession session) {
		String msg = "fail";
		try {
			subsUserInfo.setUserInfo((UserInfo) session.getAttribute("sUser"));
			subsUserInfoService.changeAutoPayCard(subsUserInfo);
			msg = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}

		return msg;
	}

	@RequestMapping(value = "user_card_manage", produces = "application/json;charset=UTF-8")
	public List<Card> user_card_manage(HttpSession httpSession) {
		int user_no = (int) httpSession.getAttribute("sUserNo");
		return subsUserInfoService.cardListbyUserNo(user_no);
	}

	@RequestMapping(value = "user_card_find", produces = "application/json;charset=UTF-8")
	public Card user_card_find(@RequestParam int card_no) {
		Card card = new Card();
		try {
			card = cardService.cardSelectByCardNo(card_no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return card;
	}

	@PostMapping(value = "user_card_add_action", produces = "text/plain;charset=UTF-8")
	public String user_card_add_action(@ModelAttribute Card card, HttpSession httpSession) {
		String msg = "fail";		
		
		try {
			card.setUserInfo((UserInfo) httpSession.getAttribute("sUser"));
			cardService.registCard(card);
			msg = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}

		return msg;
	}

	@PostMapping(value = "user_card_remove_action", produces = "text/plain;charset=UTF-8")
	public String user_card_remove_action(@RequestParam int card_no) {
		String msg = "fail";
		try {
			cardService.unregistCard(card_no);
			msg = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}

		return msg;
	}

	//선호영화관 유무확인
	@RequestMapping(value = "user_prefered_theater_find", produces = "text/plain;charset=UTF-8")
	public String user_prefered_theater_find(HttpSession session) throws Exception {
		int user_no = (int)session.getAttribute("sUserNo");
		List<Theater> theaterList = fundingService.findPreferedTheaterListByUserNo(user_no);
		String isExist = "success";
		if (theaterList.size() == 0) {
			isExist = "fail";
		}
		return isExist;
	}

	//선호영화관없을때
	@RequestMapping(value = "user_prefered_theater_form", produces = "application/json;charset=UTF-8")
	public List<Theater> user_prefered_theater_form() {
		return fundingService.findTheaterName();
	}

	//선호영화관있을때
	@RequestMapping(value = "user_prefered_theater_list", produces = "application/json;charset=UTF-8")
	public Map user_prefered_theater_list(HttpSession session) throws Exception {
		int user_no = (int)session.getAttribute("sUserNo");
		Map map = new HashMap();
		map.put("theaterNameList", fundingService.findTheaterName());
		map.put("preferedTheaterList", fundingService.findPreferedTheaterListByUserNo(user_no));
		return map;
	}

	//선호영화관 등록
	@RequestMapping(value = "user_prefered_theater_insert_action", produces = "text/plain;charset=UTF-8")
	public String user_prefered_theater_insert_action(@RequestParam int theater_no, HttpSession session) {
		int user_no = (int)session.getAttribute("sUserNo");
		String msg = "fail";
		try {
			String limit = fundingService.preferedTheaterLimit(user_no);
			if (limit.equals("success")) {
				UserInfoTheater userInfoTheater = new UserInfoTheater(0, new UserInfo(user_no, null, null, null),
						new Theater(theater_no, null, null, null, null, null));
				fundingService.insertPreferedTheater(userInfoTheater);
				msg = "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return msg;
	}

	//선호영화관 삭제
	@RequestMapping(value = "user_prefered_theater_delete_action", produces = "text/plain;charset=UTF-8")
	public String user_prefered_theater_delete_action(@RequestParam int prefer_no) throws Exception {
		String msg = "fail";
		try {
			fundingService.deletePreferedTheaterByPreferNo(prefer_no);
			msg = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

}
