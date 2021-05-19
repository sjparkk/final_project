package com.itwill.funstream.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.funstream.domain.Card;
import com.itwill.funstream.domain.SubsUserInfo;
import com.itwill.funstream.mapper.SubsUserInfoMapper;

@Repository("subsUserInfoDao")
public class SubsUserInfoDaoMyBatis implements SubsUserInfoDao {

	@Autowired
	private SubsUserInfoMapper subsUserInfoMapper;

	public SubsUserInfoDaoMyBatis() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int buyPass(SubsUserInfo subsUserInfo) {
		return subsUserInfoMapper.buyPass(subsUserInfo);
	}

	@Override
	public int canclePass(int user_no) {
		return subsUserInfoMapper.canclePass(user_no);
	}

	@Override
	public int cancleAutoPay(int user_no) {
		return subsUserInfoMapper.cancleAutoPay(user_no);
	}

	@Override
	public int changeReDate(SubsUserInfo subsUserInfo) {
		return subsUserInfoMapper.changeReDate(subsUserInfo);
	}

	@Override
	public int changeAutoPayCard(SubsUserInfo subsUserInfo) {
		return subsUserInfoMapper.changeAutoPayCard(subsUserInfo);
	}

	@Override
	public List<Card> cardListbyUserNo(int user_no) {
		return subsUserInfoMapper.cardListbyUserNo(user_no);
	}

	@Override
	public SubsUserInfo subsPassbyUserNo(int user_no) {
		return subsUserInfoMapper.subsPassbyUserNo(user_no);
	}

	@Override
	public int existenceCheckUserNo(int user_no) {
		return subsUserInfoMapper.existenceCheckUserNo(user_no);
	}

	@Override
	public List<SubsUserInfo> findAutoPayList() {
		return subsUserInfoMapper.findAutoPayList();
	}

}
