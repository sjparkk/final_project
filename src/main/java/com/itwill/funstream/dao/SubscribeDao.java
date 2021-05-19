package com.itwill.funstream.dao;

import java.util.List;

import com.itwill.funstream.domain.Subscribe;

public interface SubscribeDao {

	public int createSubscribePass(Subscribe subscribe);

	public int deleteSubscribePass(int subs_no);

	public Subscribe readSubscribebySubsNo(int subs_no);

	public List<Subscribe> subscribeList();

	public int updateSubscribePassPrice(Subscribe subscribe);
}
