package com.itwill.funstream.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.funstream.domain.Card;
import com.itwill.funstream.domain.Subscribe;
import com.itwill.funstream.domain.UserInfo;
import com.itwill.funstream.exception.LoginException;
import com.itwill.funstream.service.CardService;
import com.itwill.funstream.service.SubsUserInfoService;
import com.itwill.funstream.service.SubscribeService;
import com.itwill.funstream.service.UserInfoService;

@Controller
public class UserInfoController {

	@Autowired
	private UserInfoService userInfoService;

	@Autowired
	private CardService cardService;

	@Autowired
	private SubscribeService subscribeService;

	public UserInfoController() {
		// TODO Auto-generated constructor stub
	}

	@LoginCheck
	@RequestMapping(value = "user_subscribe_payment")
	public String user_subscribe_payment(@RequestParam("subs_no") String subs_noStr, HttpSession session, Model model) {
		String forwardPath = "";
		int sUserNo = (int) session.getAttribute("sUserNo");

		try {
			int subs_no = Integer.parseInt(subs_noStr);

			Subscribe oneSubscribe = subscribeService.readSubscribebySubsNo(subs_no);
			model.addAttribute("oneSubscribe", oneSubscribe);
			model.addAttribute("subs_no", subs_no);

			List<Card> userCardList = cardService.cardListByUserNo(sUserNo);
			for (int i = 0; i < userCardList.size(); i++) {
				String[] cardNoArray = userCardList.get(i).getCard_realNo().split("-");
				String filteredCardNo = cardNoArray[0] + "-****-****-" + cardNoArray[3];
				userCardList.get(i).setCard_realNo(filteredCardNo);
			}

			model.addAttribute("userCardList", userCardList);

			Map subscribeDate = subscribeService.subscribeDate();
			model.addAttribute("subscribeDate", subscribeDate);

			forwardPath = "user_subscribe_payment";

		} catch (Exception e) {
			e.printStackTrace();
			forwardPath = "error";
		}

		return forwardPath;
	}

	@RequestMapping("user_regist_form")
	public String user_regist_form() {
		return "/user_regist_form";
	}

	@RequestMapping(value = "user_regist_action", method = RequestMethod.GET)
	public String user_regist_action_get() {
		return "redirect:user_regist_form";
	}

	@RequestMapping(value = "user_regist_action", method = RequestMethod.POST)
	public String user_regist_action(@ModelAttribute UserInfo userInfo) {
		String forwardPath = "";
		try {
			userInfoService.registUserInfo(userInfo);
			forwardPath = "redirect:user_login_form";
		} catch (Exception e) {
			e.printStackTrace();
			forwardPath = "error";
		}

		return forwardPath;
	}

	@LoginCheck
	@RequestMapping("user_unregist_form")
	public String user_unregist_form() {
		return "/user_unregist_form";
	}

	@LoginCheck
	@RequestMapping(value = "user_unregist_action", method = RequestMethod.GET)
	public String user_unregist_action_get() {
		return "redirect:user_unregist_form";
	}

	@LoginCheck
	@RequestMapping(value = "user_unregist_action", method = RequestMethod.POST)
	public String user_unregist_action(@RequestParam("sUserNo") String user_noStr, HttpSession httpSession,
			Model model) {
		String forwardPath = "error";
		UserInfo userInfo = (UserInfo) httpSession.getAttribute("sUser");
		if (userInfo.getUser_no() == Integer.parseInt(user_noStr)) {
			try {
				userInfoService.unregistUserInfo(Integer.parseInt(user_noStr));
				httpSession.invalidate();
				forwardPath = "redirect:index";
			} catch (Exception e) {
				e.printStackTrace();
				forwardPath = "error";
			}
		} else {
			model.addAttribute("unregisterErrorMsg", "번호를 잘못 입력하였습니다. 다시 입력해주세요.");
			forwardPath = "user_unregist_form";
		}
		return forwardPath;
	}

	@RequestMapping("user_login_form")
	public String user_login_form() {
		return "/user_login_form";
	}

	@RequestMapping(value = "user_login_action", method = RequestMethod.GET)
	public String user_login_action_get() {
		return "redirect:user_login_form";
	}

	@RequestMapping(value = "user_login_action", method = RequestMethod.POST)
	public String user_login_action(@ModelAttribute UserInfo userInfo, HttpSession httpSession, Model model,
			HttpServletRequest request) {
		String forwardPath = "";
		try {
			UserInfo loginUser = userInfoService.login(userInfo);
			httpSession.setAttribute("sUserNo", loginUser.getUser_no());
			httpSession.setAttribute("sUser", loginUser);
			if (request.getParameter("redirect_uri") == null || request.getParameter("redirect_uri").equals("")) {
				forwardPath = "redirect:" + request.getRequestURI().split("/")[2];
			} else {
				forwardPath = "redirect:" + request.getParameter("redirect_uri");
			}
		} catch (LoginException e) {
			model.addAttribute("loginErrorMsg", e.getMessage());
			model.addAttribute("fUserId", userInfo.getUser_id());
			forwardPath = "user_login_form";

		} catch (Exception e) {
			e.printStackTrace();
			forwardPath = "error";
		}

		return forwardPath;
	}

	@LoginCheck
	@RequestMapping("user_logout_action")
	public String user_logout_action(HttpSession session, HttpServletRequest request) {
		session.invalidate();
		return "redirect:index";
	}

	@LoginCheck
	@RequestMapping("user_info_main")
	public String user_info_main() {
		return "/user_info_main";
	}

}
