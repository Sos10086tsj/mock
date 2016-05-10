package com.cherong.mock.domain.api.bank.service;

import org.springframework.data.domain.Pageable;

import com.cherong.mock.common.base.jpa.service.BaseService;
import com.cherong.mock.domain.api.bank.model.Card;
import com.cherong.mock.domain.api.bank.vo.CardQueryVo;
import com.cherong.mock.domain.api.serializable.Pagination;

/**
 * Description:	CARD_VIEW DAO层service
 * Auth:Paris
 * Date:Apr 7, 2016
**/
public interface CardService extends BaseService<Card, Long>{	
	/**
	 * 用户开卡
	 * @param card
	 * @return
	 */
	public Card saveCard(Card card);
	
	/**
	 * 手动调整卡片信息
	 * @param card
	 * @return
	 */
	public Card updateCard(Card card);
	
	/**
	 * 获取卡片分页数据
	 * @param queryVo
	 * @param pageable
	 * @return
	 */
	public Pagination<Card> findPage(CardQueryVo queryVo, Pageable pageable);
}
