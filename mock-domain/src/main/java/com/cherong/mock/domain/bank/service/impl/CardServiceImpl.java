package com.cherong.mock.domain.bank.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cherong.mock.common.base.jpa.service.BaseServiceImpl;
import com.cherong.mock.domain.api.bank.model.Card;
import com.cherong.mock.domain.api.bank.service.CardService;
import com.cherong.mock.domain.bank.repository.CardRepository;

/**
 * Description:
 * Auth:Paris
 * Date:Apr 7, 2016
**/
@Service
public class CardServiceImpl extends BaseServiceImpl<Card, Long> implements CardService{
	@Resource
	private CardRepository repository;
	
	@Override
	public Card findByMdcardno(String mdcardno) {
		return this.repository.findByMdcardno(mdcardno);
	}

}
