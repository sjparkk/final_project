package com.itwill.funstream.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.funstream.dao.CardDaoMyBatis;
import com.itwill.funstream.dao.UserInfoDaoMyBatis;
import com.itwill.funstream.domain.Card;
import com.itwill.funstream.domain.UserInfo;
import com.itwill.funstream.service.CardService;

public class CardDaoTest {
	public static void main(String[] args) throws Exception {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"classpath:/spring/application-config.xml");
		CardDaoMyBatis cardDao = (CardDaoMyBatis) applicationContext.getBean("cardDao");
		UserInfoDaoMyBatis userInfoDao = (UserInfoDaoMyBatis) applicationContext.getBean("userInfoDao");
		CardService cardService = (CardService)applicationContext.getBean("cardService");
		//UserInfo userInfo = userInfoDao.findUserInfobyUserId("aaa");
		//Card card = new Card(0, "1111-1111-1111-1111", "10/45", 123, 1234, "테스트", userInfo);
		//cardDao.registCard(card);
		//cardDao.unregistCard(11);
		//List<Card> cardList = cardDao.cardListByUserNo(userInfo.getUser_no());
		//System.out.println(cardList);
		//int check1 = cardDao.existenceCheckCardRealNo("1111-1111-1111-1111");
		//int check2 = cardDao.existenceCheckCardRealNo("1234-5678-9012-3456");
		//System.out.println(check1);
		//System.out.println(check2);
		//Card card = cardDao.cardSelectByCardNo(2);
		//System.out.println(card);
		System.out.println(cardService.cardSelectByCardNo(1));
		
	}
}
