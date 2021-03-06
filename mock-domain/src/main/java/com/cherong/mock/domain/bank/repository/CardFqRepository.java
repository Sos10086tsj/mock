package com.cherong.mock.domain.bank.repository;

import java.util.List;

import com.cherong.mock.common.base.jpa.repository.BaseRepository;
import com.cherong.mock.domain.api.bank.model.CardFq;

/**
 * Description:
 * Auth:Paris
 * Date:Apr 7, 2016
**/
public interface CardFqRepository extends BaseRepository<CardFq, Long>{
	public CardFq findByCardIdOrderByLeftnumDesc(Long cardId);
	
	public List<CardFq> findByMdcardnoLikeOrderByMdcardnoAscLeftnumDesc(String mdcardno);
	
	public CardFq findByMdcardno(String mdcardno);
}
