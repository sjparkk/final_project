package com.itwill.funstream.dao;

import java.util.List;

import com.itwill.funstream.domain.Card;
import com.itwill.funstream.domain.SubsUserInfo;

public interface SubsUserInfoDao {

	public int buyPass(SubsUserInfo subsUserInfo);

	public int canclePass(int user_no);

	public int cancleAutoPay(int user_no);

	public int changeReDate(SubsUserInfo subsUserInfo);

	public int changeAutoPayCard(SubsUserInfo subsUserInfo);

	public List<Card> cardListbyUserNo(int user_no);

	public SubsUserInfo subsPassbyUserNo(int user_no);

	public int existenceCheckUserNo(int user_no);

	public List<SubsUserInfo> findAutoPayList();
}
