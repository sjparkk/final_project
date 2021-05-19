package com.itwill.funstream.mapper;

import java.util.List;

import com.itwill.funstream.domain.Card;
import com.itwill.funstream.domain.SubsUserInfo;

public interface SubsUserInfoMapper {

	public int buyPass(SubsUserInfo subsUserInfo);

	public int canclePass(Integer user_no);

	public int cancleAutoPay(Integer user_no);

	public int changeReDate(SubsUserInfo subsUserInfo);

	public int changeAutoPayCard(SubsUserInfo subsUserInfo);

	public List<Card> cardListbyUserNo(Integer user_no);

	public SubsUserInfo subsPassbyUserNo(int user_no);

	public int existenceCheckUserNo(Integer user_no);
	
	public List<SubsUserInfo> findAutoPayList();
}
