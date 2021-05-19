package com.itwill.funstream.dao;

import java.util.List;

import com.itwill.funstream.domain.Card;

public interface CardDao {

	public int registCard(Card card) throws Exception;

	public int unregistCard(int card_no) throws Exception;

	public List<Card> cardListByUserNo(int user_no) throws Exception;

	public int existenceCheckCardRealNo(String card_realNo) throws Exception;

	public Card cardSelectByCardNo(int card_no) throws Exception;
}
