package com.cherong.mock.web.bank.logic;

import org.springframework.data.domain.Pageable;

import com.cherong.mock.domain.api.bank.model.Card;
import com.cherong.mock.domain.api.bank.vo.CardQueryVo;
import com.cherong.mock.domain.api.serializable.Pagination;

/**
 * Description:
 * Auth:Paris
 * Date:May 4, 2016
**/
public interface CardLogic {
	public Pagination<Card> findPage(CardQueryVo queryVo, Pageable pageable);
	
	public void update(Card card);
}
