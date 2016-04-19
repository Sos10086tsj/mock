package com.cherong.mock.domain.bank.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cherong.mock.common.base.jpa.service.BaseServiceImpl;
import com.cherong.mock.domain.api.bank.model.CardFq;
import com.cherong.mock.domain.api.bank.service.CardFqService;
import com.cherong.mock.domain.bank.repository.CardFqRepository;

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
