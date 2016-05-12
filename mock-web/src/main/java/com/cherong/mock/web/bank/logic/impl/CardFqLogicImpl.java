package com.cherong.mock.web.bank.logic.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cherong.mock.domain.api.bank.model.CardFq;
import com.cherong.mock.domain.api.bank.service.CardFqService;
import com.cherong.mock.domain.api.bank.vo.CardFqQueryVo;
import com.cherong.mock.domain.api.serializable.Pagination;
import com.cherong.mock.web.bank.logic.CardFqLogic;
import com.cherong.mock.web.vo.SelectVo;

/**
 * Description:
 * Auth:Paris
 * Date:May 12, 2016
**/
@Service
public class CardFqLogicImpl implements CardFqLogic{
	@Resource
	private CardFqService cardFqService;

	@Override
	public Pagination<CardFq> findPage(CardFqQueryVo queryVo, Pageable pageable) {
		return this.cardFqService.findPage(queryVo, pageable);
	}

	@Override
	public void update(CardFq cardFq) {
		this.cardFqService.update(cardFq);
	}
	
	@Override
	public List<SelectVo> findMdcardno(String mdcardno) {
		List<SelectVo> vos = new ArrayList<SelectVo>();
		List<CardFq> cards =  this.cardFqService.findByMdcardnoLike(mdcardno);
		for (CardFq cardFq : cards) {
			vos.add(new SelectVo(cardFq.getMdcardno(), cardFq.getMdcardno()));
		}
		return vos;
	}
}
