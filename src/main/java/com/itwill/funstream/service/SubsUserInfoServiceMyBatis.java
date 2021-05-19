package com.itwill.funstream.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.itwill.funstream.dao.SubsUserInfoDao;
import com.itwill.funstream.domain.Card;
import com.itwill.funstream.domain.SubsUserInfo;
import com.itwill.funstream.domain.Subscribe;

@Service("subsUserInfoService")
public class SubsUserInfoServiceMyBatis implements SubsUserInfoService {

	@Autowired
	private SubsUserInfoDao subsUserInfoDao;

	public SubsUserInfoServiceMyBatis() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int buyPass(SubsUserInfo subsUserInfo) {
		int existed = 0;
		SubsUserInfo userSubscribe = subsUserInfoDao.subsPassbyUserNo(subsUserInfo.getUserInfo().getUser_no());
		if (userSubscribe != null) {
			existed = -1;
		} else {
			subsUserInfoDao.buyPass(subsUserInfo);
			existed = 1;
		}
		return existed;
	}

	@Override
	public int canclePass(int user_no) {
		return subsUserInfoDao.canclePass(user_no);
	}

	@Override
	public int cancleAutoPay(int user_no) {
		return subsUserInfoDao.cancleAutoPay(user_no);
	}

	@Override
	public int changeReDate(SubsUserInfo subsUserInfo) {
		return subsUserInfoDao.changeReDate(subsUserInfo);
	}

	@Override
	public int changeAutoPayCard(SubsUserInfo subsUserInfo) {
		return subsUserInfoDao.changeAutoPayCard(subsUserInfo);
	}

	@Override
	public List<Card> cardListbyUserNo(int user_no) {
		return subsUserInfoDao.cardListbyUserNo(user_no);
	}

	@Override
	public SubsUserInfo subsPassbyUserNo(int user_no) {
		return subsUserInfoDao.subsPassbyUserNo(user_no);
	}

	@Override
	public boolean existenceCheckUserNo(int user_no) {
		return (subsUserInfoDao.existenceCheckUserNo(user_no) == 1);
	}

	@Override
	public List<SubsUserInfo> findAutoPayList() {
		return subsUserInfoDao.findAutoPayList();
	}

	@Scheduled(cron = "0 0 0 * * ?")
	public void autoPay() {
		List<SubsUserInfo> subsUserInfoList = subsUserInfoDao.findAutoPayList();
		for (SubsUserInfo subsUserInfo : subsUserInfoList) {
			subsUserInfoDao.changeReDate(subsUserInfo);
		}
	}

}
