package com.itwill.funstream.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.funstream.domain.Card;
import com.itwill.funstream.domain.SubsUserInfo;

@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public interface SubsUserInfoService {

	public int buyPass(SubsUserInfo subsUserInfo);

	public int canclePass(int user_no);

	public int cancleAutoPay(int user_no);

	public int changeReDate(SubsUserInfo subsUserInfo);

	public int changeAutoPayCard(SubsUserInfo subsUserInfo);

	public List<Card> cardListbyUserNo(int user_no);

	public SubsUserInfo subsPassbyUserNo(int user_no);

	public boolean existenceCheckUserNo(int user_no);

	public List<SubsUserInfo> findAutoPayList();
	
	public void autoPay();

}
