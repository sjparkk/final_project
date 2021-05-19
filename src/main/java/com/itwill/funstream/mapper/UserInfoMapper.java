package com.itwill.funstream.mapper;

import com.itwill.funstream.domain.UserInfo;

public interface UserInfoMapper {

	public int registUserInfo(UserInfo userInfo);

	public int updateUserInfo(UserInfo userInfo);

	public int unregistUserInfo(Integer user_no);

	public UserInfo findUserInfobyUserId(String user_id);
	
	public UserInfo findUserInfobyUserNo(int user_no);

	public int existenceCheckUserId(String user_id);

}
