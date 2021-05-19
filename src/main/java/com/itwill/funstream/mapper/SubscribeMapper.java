package com.itwill.funstream.mapper;

import java.util.List;

import com.itwill.funstream.domain.Subscribe;

public interface SubscribeMapper {

	public int createSubscribePass(Subscribe subscribe);

	public int deleteSubscribePass(Integer subs_no);

	public Subscribe readSubscribebySubsNo(Integer subs_no);

	public List<Subscribe> subscribeList();

	public int updateSubscribePassPrice(Subscribe subscribe);

}
