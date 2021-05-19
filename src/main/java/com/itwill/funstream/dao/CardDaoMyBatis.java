package com.itwill.funstream.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.funstream.domain.Card;
import com.itwill.funstream.mapper.CardMapper;

@Repository("cardDao")
public class CardDaoMyBatis implements CardDao {

	@Autowired
	private CardMapper cardMapper;

	public CardDaoMyBatis() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int registCard(Card card) throws Exception {
		return cardMapper.registCard(card);
	}

	@Override
	public int unregistCard(int card_no) throws Exception {
		return cardMapper.unregistCard(card_no);
	}

	@Override
	public List<Card> cardListByUserNo(int user_no) throws Exception {
		return cardMapper.cardListByUserNo(user_no);
	}

	@Override
	public int existenceCheckCardRealNo(String card_realNo) throws Exception {
		return cardMapper.existenceCheckCardRealNo(card_realNo);
	}

	@Override
	public Card cardSelectByCardNo(int card_no) throws Exception {
		return cardMapper.cardSelectByCardNo(card_no);
	}

}
