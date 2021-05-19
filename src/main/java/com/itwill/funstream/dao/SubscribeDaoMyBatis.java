package com.itwill.funstream.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.funstream.domain.Subscribe;
import com.itwill.funstream.mapper.SubscribeMapper;

@Repository("subscribeDao")
public class SubscribeDaoMyBatis implements SubscribeDao {

	@Autowired
	private SubscribeMapper subscribeMapper;

	public SubscribeDaoMyBatis() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int createSubscribePass(Subscribe subscribe) {
		return subscribeMapper.createSubscribePass(subscribe);
	}

	@Override
	public int deleteSubscribePass(int subs_no) {
		return subscribeMapper.deleteSubscribePass(subs_no);
	}

	@Override
	public Subscribe readSubscribebySubsNo(int subs_no) {
		return subscribeMapper.readSubscribebySubsNo(subs_no);
	}

	@Override
	public List<Subscribe> subscribeList() {
		return subscribeMapper.subscribeList();
	}

	@Override
	public int updateSubscribePassPrice(Subscribe subscribe) {
		return subscribeMapper.updateSubscribePassPrice(subscribe);
	}

}
