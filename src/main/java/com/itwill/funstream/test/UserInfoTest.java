package com.itwill.funstream.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.funstream.dao.UserInfoDaoMyBatis;
import com.itwill.funstream.domain.UserInfo;

public class UserInfoTest {

	public static void main(String[] args) throws Exception {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"classpath:/spring/application-config.xml");
		UserInfoDaoMyBatis userInfoDao = (UserInfoDaoMyBatis) applicationContext.getBean("userInfoDao");

		UserInfo userInfo = new UserInfo();
		//userInfoDao.registUserInfo(userInfo);
		//userInfoDao.updateUserInfo(userInfo);
		//userInfoDao.unregistUserInfo(11);
		userInfo = userInfoDao.findUserInfobyUserId("sjs");
		System.out.println(userInfo);
		int existence = userInfoDao.existenceCheckUserId("qwe");
		System.out.println(existence);

	}

}
