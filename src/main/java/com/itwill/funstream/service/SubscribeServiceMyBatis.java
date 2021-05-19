package com.itwill.funstream.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.funstream.dao.SubscribeDao;
import com.itwill.funstream.domain.Subscribe;

@Service("subscribeService")
public class SubscribeServiceMyBatis implements SubscribeService {

	@Autowired
	private SubscribeDao subscribeDao;

	public SubscribeServiceMyBatis() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int createSubscribePass(Subscribe subscribe) {
		return subscribeDao.createSubscribePass(subscribe);
	}

	@Override
	public int deleteSubscribePass(int subs_no) {
		return subscribeDao.deleteSubscribePass(subs_no);
	}

	@Override
	public Subscribe readSubscribebySubsNo(int subs_no) {
		return subscribeDao.readSubscribebySubsNo(subs_no);
	}

	@Override
	public List<Subscribe> subscribeList() {
		return subscribeDao.subscribeList();
	}

	@Override
	public int updateSubscribePassPrice(Subscribe subscribe) {
		return subscribeDao.updateSubscribePassPrice(subscribe);
	}
	
	@Override
	public Map subscribeDate() {
		Map subscribeDate = new HashMap();
		SimpleDateFormat format = new SimpleDateFormat ("yyyy-MM-dd");
		Date date = new Date();
		Calendar cal = Calendar.getInstance(); 
		cal.setTime(date); 
				
		String subscribeStartDate = format.format(cal.getTime());
		
		cal.add(Calendar.YEAR, 1); 
		String yearEndDate = format.format(cal.getTime());
		cal.add(Calendar.YEAR, -1);
		cal.add(Calendar.MONTH, 1); 
		String monthEndDate = format.format(cal.getTime());
		cal.add(Calendar.MONTH, -1); 
		cal.add(Calendar.DATE, 90);
		String eventEndDate = format.format(cal.getTime());
		
		subscribeDate.put("subscribeStartDate", subscribeStartDate);
		subscribeDate.put("yearEndDate", yearEndDate);
		subscribeDate.put("monthEndDate", monthEndDate);
		subscribeDate.put("eventEndDate", eventEndDate);
		
		return subscribeDate;
	}

}
