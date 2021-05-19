package com.itwill.funstream.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.funstream.dao.CardDaoMyBatis;
import com.itwill.funstream.dao.SubsUserInfoDaoMyBatis;
import com.itwill.funstream.dao.SubscribeDaoMyBatis;
import com.itwill.funstream.dao.UserInfoDaoMyBatis;
import com.itwill.funstream.domain.Card;
import com.itwill.funstream.domain.SubsUserInfo;
import com.itwill.funstream.domain.Subscribe;
import com.itwill.funstream.domain.UserInfo;

public class SubsUserInfoDaoTest {

	public static void main(String[] args) throws Exception {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"classpath:/spring/application-config.xml");
		SubsUserInfoDaoMyBatis subsUserInfoDao = (SubsUserInfoDaoMyBatis) applicationContext.getBean("subsUserInfoDao");
		CardDaoMyBatis cardDao = (CardDaoMyBatis) applicationContext.getBean("cardDao");
		UserInfoDaoMyBatis userInfoDao = (UserInfoDaoMyBatis) applicationContext.getBean("userInfoDao");
		SubscribeDaoMyBatis subscribeDao = (SubscribeDaoMyBatis) applicationContext.getBean("subscribeDao");

		Subscribe subscribe = subscribeDao.readSubscribebySubsNo(1);
		UserInfo userInfo = userInfoDao.findUserInfobyUserId("sjs");
		Card card = cardDao.cardSelectByCardNo(1);
		

		//SubsUserInfo subs_userInfo = new SubsUserInfo(0, null, null, null, userInfo, subscribe, card);
		//subsUserInfoDao.buyPass(subs_userInfo);

		//subs_userInfoDao.canclePass(1);
		//subs_userInfoDao.cancleAutoPay(1);

		//List<Card> cardListbyUserNo = subs_userInfoDao.cardListbyUserNo(1);
		//System.out.println(cardListbyUserNo);

		//SubsUserInfo subs_userInfo = subsUserInfoDao.subsPassbyUserNo(1);
		//System.out.println(subs_userInfo);
		//subs_userInfo.getCard().setCard_no(2);
		//subsUserInfoDao.changeAutoPayCard(subs_userInfo);

		//subs_userInfoDao.changeReDate(subs_userInfo);

		//int num = subsUserInfoDao.existenceCheckUserNo(2);
		//System.out.println(num);
		
		System.out.println(subsUserInfoDao.subsPassbyUserNo(3));

	}

}
