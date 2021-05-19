package com.itwill.funstream.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.funstream.domain.Subscribe;

@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public interface SubscribeService {

	public int createSubscribePass(Subscribe subscribe);

	public int deleteSubscribePass(int subs_no);

	public Subscribe readSubscribebySubsNo(int subs_no);

	public List<Subscribe> subscribeList();

	public int updateSubscribePassPrice(Subscribe subscribe);
	
	public Map subscribeDate();

}
