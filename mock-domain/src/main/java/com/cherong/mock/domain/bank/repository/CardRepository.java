package com.cherong.mock.domain.bank.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cherong.mock.common.base.jpa.repository.BaseRepository;
import com.cherong.mock.domain.api.bank.model.Card;

/**
 * Description:
 * Auth:Paris
 * Date:Apr 7, 2016
**/
public interface CardRepository extends BaseRepository<Card, Long>{
	public Card findByMdcardno(String mdcardno);
	
	public Page<Card> findByMdcardno(String mdcardno, Pageable pageable);
	
	public Page<Card> findAll(Pageable pageable);
}
