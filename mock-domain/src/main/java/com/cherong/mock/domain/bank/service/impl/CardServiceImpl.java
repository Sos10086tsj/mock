package com.cherong.mock.domain.bank.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.cherong.mock.common.base.jpa.service.BaseServiceImpl;
import com.cherong.mock.domain.api.bank.model.Card;
import com.cherong.mock.domain.api.bank.service.CardService;
import com.cherong.mock.domain.api.bank.vo.CardQueryVo;
import com.cherong.mock.domain.bank.repository.CardRepository;

/**
 * Description:
 * Auth:Paris
 * Date:Apr 7, 2016
**/
@Service("cardService")
public class CardServiceImpl extends BaseServiceImpl<Card, Long> implements CardService{
	@Resource
	private CardRepository repository;

	@Override
	public Card saveCard(Card card) {
		return this.repository.save(card);
	}

	@Override
	public Card updateCard(Card card) {
		return this.repository.save(card);
	}

	@Override
	public Page<Card> findPage(CardQueryVo queryVo, Pageable pageable) {
		return this.repository.findAll(this.getQuerySpecification(queryVo), pageable);
	}


	private Specification<Card> getQuerySpecification(final CardQueryVo queryVo) {
		Specification<Card> condition = new Specification<Card>() {
			@Override
			public Predicate toPredicate(Root<Card> root, CriteriaQuery<?> query,
					CriteriaBuilder cb) {
				List<Predicate> pds = new ArrayList<Predicate>();
				if (null != queryVo) {
					if (!StringUtils.isEmpty(queryVo.getMdcardno())) {
						Predicate p = cb.like(root.get("mdcardno").as(String.class), "%" + queryVo.getMdcardno() + "%");
						pds.add(p);
					}
				}
				return cb.and(pds.toArray(new Predicate[] {}));
			}
		};
		return condition;
	}
}
