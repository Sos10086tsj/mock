package com.cherong.mock.domain.bank.repository;

import com.cherong.mock.domain.bank.model.CardView;
import com.cherong.mock.domain.base.jpa.repository.BaseRepository;

/**
 * Description:
 * Auth:Paris
 * Date:Apr 7, 2016
**/
public interface CardViewRepository extends BaseRepository<CardView, String>{
	public CardView findByMdcardno(String mdcardno);
}
