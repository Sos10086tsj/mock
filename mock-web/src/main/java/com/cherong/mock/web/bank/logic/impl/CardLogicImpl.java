package com.cherong.mock.web.bank.logic.impl;

import javax.annotation.Resource;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cherong.mock.domain.api.bank.model.Card;
import com.cherong.mock.domain.api.bank.service.CardService;
import com.cherong.mock.domain.api.bank.vo.CardQueryVo;
import com.cherong.mock.domain.api.serializable.Pagination;
import com.cherong.mock.web.bank.logic.CardLogic;

/**
 * Description:
 * Auth:Paris
 * Date:May 4, 2016
**/
@Service
public class CardLogicImpl implements CardLogic{
	@Resource
	private CardService cardService;

	@Override
	public Pagination<Card> findPage(CardQueryVo queryVo, Pageable pageable) {
		return this.cardService.findPage(queryVo, pageable);
	}

	@Override
	public void update(Card card) {
		this.cardService.update(card);
	}

}
