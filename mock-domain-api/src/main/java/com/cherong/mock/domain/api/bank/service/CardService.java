package com.cherong.mock.domain.api.bank.service;

import com.cherong.mock.common.base.jpa.service.BaseService;
import com.cherong.mock.domain.api.bank.model.Card;

/**
 * Description:	CARD_VIEW DAO层service
 * Auth:Paris
 * Date:Apr 7, 2016
**/
public interface CardService extends BaseService<Card, Long>{
	/**
	 * 根据卡号查询卡片信息
	 * @param mdcardno
	 * @return
	 */
	public Card findByMdcardno(String mdcardno);
}
