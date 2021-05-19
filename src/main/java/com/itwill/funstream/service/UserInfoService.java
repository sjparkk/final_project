package com.itwill.funstream.service;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.funstream.domain.UserInfo;

@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public interface UserInfoService {

	public int registUserInfo(UserInfo userInfo) throws Exception;

	public int updateUserInfo(UserInfo userInfo) throws Exception;

	public int unregistUserInfo(int user_no) throws Exception;

	public UserInfo findUserInfobyUserId(String user_id) throws Exception;

	public boolean existenceCheckUserId(String user_id) throws Exception;

	public UserInfo login(UserInfo userInfo) throws Exception;
	
	public UserInfo findUserInfobyUserNo(int user_no) throws Exception;

}
