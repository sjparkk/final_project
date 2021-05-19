package com.itwill.funstream.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.funstream.dao.CardDao;
import com.itwill.funstream.domain.Card;

@Service("cardService")
public class CardServiceMyBatis implements CardService {

	@Autowired
	private CardDao cardDao;

	public CardServiceMyBatis() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int registCard(Card card) throws Exception {
		return cardDao.registCard(card);
	}

	@Override
	public int unregistCard(int card_no) throws Exception {
		return cardDao.unregistCard(card_no);
	}

	@Override
	public List<Card> cardListByUserNo(int user_no) throws Exception {
		return cardDao.cardListByUserNo(user_no);
	}

	@Override
	public int existenceCheckCardRealNo(String card_realNo) throws Exception {
		return cardDao.existenceCheckCardRealNo(card_realNo);
	}

	@Override
	public Card cardSelectByCardNo(int card_no) throws Exception {
		return cardDao.cardSelectByCardNo(card_no);
	}

}
