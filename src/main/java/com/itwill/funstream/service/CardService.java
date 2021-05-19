package com.itwill.funstream.service;

import java.util.List;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.funstream.domain.Card;

@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public interface CardService {

	public int registCard(Card card) throws Exception;

	public int unregistCard(int card_no) throws Exception;

	public List<Card> cardListByUserNo(int user_no) throws Exception;

	public int existenceCheckCardRealNo(String card_realNo) throws Exception;

	public Card cardSelectByCardNo(int card_no) throws Exception;

}
