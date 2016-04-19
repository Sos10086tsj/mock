package com.cherong.mock.domain.bank.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cherong.mock.domain.bank.model.CardFq;
import com.cherong.mock.domain.bank.repository.CardFqRepository;
import com.cherong.mock.domain.bank.service.CardFqService;
import com.cherong.mock.domain.base.jpa.service.BaseServiceImpl;

/**
 * Description:
 * Auth:Paris
 * Date:Apr 7, 2016
**/
@Service
public class CardFqServiceImpl extends BaseServiceImpl<CardFq, Long> implements CardFqService{
	@Resource
	private CardFqRepository repository;
}
