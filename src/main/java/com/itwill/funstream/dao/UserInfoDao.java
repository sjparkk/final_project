package com.itwill.funstream.dao;

import com.itwill.funstream.domain.UserInfo;

public interface UserInfoDao {

	public int registUserInfo(UserInfo userInfo) throws Exception;

	public int updateUserInfo(UserInfo userInfo) throws Exception;

	public int unregistUserInfo(int user_no) throws Exception;

	public UserInfo findUserInfobyUserId(String user_id) throws Exception;

	public int existenceCheckUserId(String user_id) throws Exception;
	
	public UserInfo findUserInfobyUserNo(int user_no);

}
