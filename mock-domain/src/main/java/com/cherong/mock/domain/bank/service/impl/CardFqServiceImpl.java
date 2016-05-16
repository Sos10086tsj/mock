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
import com.cherong.mock.domain.api.bank.model.CardFq;
import com.cherong.mock.domain.api.bank.service.CardFqService;
import com.cherong.mock.domain.api.bank.vo.CardFqQueryVo;
import com.cherong.mock.domain.api.serializable.Pagination;
import com.cherong.mock.domain.bank.repository.CardFqRepository;

/**
 * Description:
 * Auth:Paris
 * Date:Apr 7, 2016
**/
@Service("cardFqService")
public class CardFqServiceImpl extends BaseServiceImpl<CardFq, Long> implements CardFqService{
	@Resource
	private CardFqRepository repository;

	@Override
	public CardFq saveCardFq(CardFq fq) {
		return this.repository.save(fq);
	}

	@Override
	public CardFq updateCardFq(CardFq fq) {
		return this.repository.save(fq);
	}

	@Override
	public Pagination<CardFq> findPage(CardFqQueryVo queryVo, Pageable pageable) {
		Page<CardFq> page = this.repository.findAll(this.getQuerySpecification(queryVo), pageable);
		Pagination<CardFq> pagination = new Pagination<CardFq>();
		pagination.setPageNum(page.getNumber());
		pagination.setPageSize(page.getSize());
		pagination.setTotal(page.getTotalElements());
		pagination.setData(page.getContent());
		return pagination;
	}
	
	private Specification<CardFq> getQuerySpecification(final CardFqQueryVo queryVo) {
		Specification<CardFq> condition = new Specification<CardFq>() {
			@Override
			public Predicate toPredicate(Root<CardFq> root, CriteriaQuery<?> query,
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

	@Override
	public CardFq findByCardId(Long cardId) {
		return this.repository.findByCardIdOrderByLeftnumDesc(cardId);
	}

	@Override
	public List<CardFq> findByMdcardnoLike(String mdcardno) {
		return this.repository.findByMdcardnoLikeOrderByMdcardnoAscLeftnumDesc(mdcardno);
	}

	@Override
	public CardFq findByMdcardno(String mdcardno) {
		return this.repository.findByMdcardno(mdcardno);
	}
}
