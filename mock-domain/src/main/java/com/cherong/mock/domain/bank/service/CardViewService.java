package com.cherong.mock.domain.bank.service;

import com.cherong.mock.domain.bank.model.CardView;
import com.cherong.mock.domain.base.jpa.service.BaseService;

/**
 * Description:	CARD_VIEW DAO层service
 * Auth:Paris
 * Date:Apr 7, 2016
**/
public interface CardViewService extends BaseService<CardView, String>{
	/**
	 * 根据卡号查询卡片信息
	 * @param mdcardno
	 * @return
	 */
	public CardView findByMdcardno(String mdcardno);
}
