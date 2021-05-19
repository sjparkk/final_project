package com.itwill.funstream.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.funstream.dao.UserInfoDao;
import com.itwill.funstream.domain.UserInfo;
import com.itwill.funstream.exception.LoginException;

@Service("userInfoService")
public class UserInfoServiceMyBatis implements UserInfoService {

	@Autowired
	private UserInfoDao userInfoDao;

	public UserInfoServiceMyBatis() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int registUserInfo(UserInfo userInfo) throws Exception {
		return userInfoDao.registUserInfo(userInfo);
	}

	@Override
	public int updateUserInfo(UserInfo userInfo) throws Exception {
		return userInfoDao.updateUserInfo(userInfo);
	}

	@Override
	public int unregistUserInfo(int user_no) throws Exception {
		return userInfoDao.unregistUserInfo(user_no);
	}

	@Override
	public UserInfo findUserInfobyUserId(String user_id) throws Exception {
		return userInfoDao.findUserInfobyUserId(user_id);
	}

	@Override
	public boolean existenceCheckUserId(String user_id) throws Exception {
		return (userInfoDao.existenceCheckUserId(user_id) == 1);
	}

	@Override
	public UserInfo login(UserInfo userInfo) throws Exception {
		UserInfo user = userInfoDao.findUserInfobyUserId(userInfo.getUser_id());
		if (user == null || !user.getUser_password().equals(userInfo.getUser_password())) {
			throw new LoginException("존재하지 않는 아이디이거나 비밀번호가 일치하지 않습니다.");
		}

		return user;
	}

	@Override
	public UserInfo findUserInfobyUserNo(int user_no) throws Exception {
		return userInfoDao.findUserInfobyUserNo(user_no);
	}

}
