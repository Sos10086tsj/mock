package com.cherong.mock.domain.bank.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cherong.mock.domain.bank.model.Card;
import com.cherong.mock.domain.bank.repository.CardRepository;
import com.cherong.mock.domain.bank.service.CardService;
import com.cherong.mock.domain.base.jpa.service.BaseServiceImpl;

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
