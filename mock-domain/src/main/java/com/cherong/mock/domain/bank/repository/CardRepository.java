package com.cherong.mock.domain.bank.repository;

import com.cherong.mock.domain.bank.model.Card;
import com.cherong.mock.domain.base.jpa.repository.BaseRepository;

/**
 * Description:
 * Auth:Paris
 * Date:Apr 7, 2016
**/
public interface CardRepository extends BaseRepository<Card, Long>{
	public Card findByMdcardno(String mdcardno);
}
