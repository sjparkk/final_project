package com.itwill.funstream.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.funstream.domain.UserInfo;
import com.itwill.funstream.mapper.UserInfoMapper;

@Repository("userInfoDao")
public class UserInfoDaoMyBatis implements UserInfoDao {

	@Autowired
	private UserInfoMapper userInfoMapper;

	public UserInfoDaoMyBatis() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int registUserInfo(UserInfo userInfo) throws Exception {
		return userInfoMapper.registUserInfo(userInfo);
	}

	@Override
	public int updateUserInfo(UserInfo userInfo) throws Exception {
		return userInfoMapper.updateUserInfo(userInfo);
	}

	@Override
	public int unregistUserInfo(int user_no) throws Exception {
		return userInfoMapper.unregistUserInfo(user_no);
	}

	@Override
	public UserInfo findUserInfobyUserId(String user_id) throws Exception {
		return userInfoMapper.findUserInfobyUserId(user_id);
	}

	@Override
	public int existenceCheckUserId(String user_id) throws Exception {
		return userInfoMapper.existenceCheckUserId(user_id);
	}

	@Override
	public UserInfo findUserInfobyUserNo(int user_no) {
		return userInfoMapper.findUserInfobyUserNo(user_no);
	}

}
