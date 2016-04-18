package com.cherong.mock.domain.bank.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cherong.mock.domain.bank.model.CardView;
import com.cherong.mock.domain.bank.repository.CardViewRepository;
import com.cherong.mock.domain.bank.service.CardViewService;
import com.cherong.mock.domain.base.jpa.service.BaseServiceImpl;

/**
 * Description:
 * Auth:Paris
 * Date:Apr 7, 2016
**/
@Service
public class CardViewServiceImpl extends BaseServiceImpl<CardView, String> implements CardViewService{
	@Resource
	private CardViewRepository repository;
	
	@Override
	public CardView findByMdcardno(String mdcardno) {
		return this.repository.findByMdcardno(mdcardno);
	}

}
