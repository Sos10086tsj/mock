package com.cherong.mock.web.bank.logic;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.cherong.mock.domain.api.bank.model.CardFq;
import com.cherong.mock.domain.api.bank.vo.CardFqQueryVo;
import com.cherong.mock.domain.api.serializable.Pagination;
import com.cherong.mock.web.vo.SelectVo;

/**
 * Description:
 * Auth:Paris
 * Date:May 12, 2016
**/
public interface CardFqLogic {
	public Pagination<CardFq> findPage(CardFqQueryVo queryVo, Pageable pageable);
	
	public void update(CardFq cardFq);
	
	public List<SelectVo> findMdcardno(String mdcardno);
}
