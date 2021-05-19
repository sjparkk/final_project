package com.itwill.funstream.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.funstream.dao.SubscribeDao;
import com.itwill.funstream.dao.SubscribeDaoMyBatis;
import com.itwill.funstream.domain.Subscribe;
import com.itwill.funstream.service.SubscribeService;

public class SubscribeDaoTest {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"classpath:/spring/application-config.xml");
		SubscribeDao subscribeDao = (SubscribeDao) applicationContext.getBean("subscribeDao");
		SubscribeService subscribeService = (SubscribeService)applicationContext.getBean("subscribeService");
		/*Subscribe subscribe1 = new Subscribe(0, "월간", 10000, 30, "true");
		Subscribe subscribe2 = new Subscribe(0, "연간", 110000, 365, "true");
		Subscribe subscribe3 = new Subscribe(0, "특별이벤트", 10000, 90, "false");
		subscribeDao.createSubscribePass(subscribe1);
		subscribeDao.createSubscribePass(subscribe2);
		subscribeDao.createSubscribePass(subscribe3);*/

		//subscribeDao.updateSubscribePassPrice(subscribe);
		//subscribeDao.deleteSubscribePass(3);
		//Subscribe subscribe = subscribeDao.readSubscribebySubsNo(1);
		List<Subscribe> subscribeList = subscribeService.subscribeList();
		System.out.println(subscribeList);

	}

}
