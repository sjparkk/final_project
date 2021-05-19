package com.itwill.funstream.mapper;

import java.util.List;

import com.itwill.funstream.domain.Card;

public interface CardMapper {

	public int registCard(Card card);

	public int unregistCard(Integer card_no);

	public List<Card> cardListByUserNo(Integer user_no);

	public int existenceCheckCardRealNo(String card_realNo);

	public Card cardSelectByCardNo(Integer card_no);
}
