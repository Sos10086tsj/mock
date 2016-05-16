package com.cherong.mock.domain.api.bank.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.cherong.mock.common.base.jpa.service.BaseService;
import com.cherong.mock.domain.api.bank.model.CardFq;
import com.cherong.mock.domain.api.bank.vo.CardFqQueryVo;
import com.cherong.mock.domain.api.serializable.Pagination;

/**
 * Description:
 * Auth:Paris
 * Date:Apr 7, 2016
**/
public interface CardFqService extends BaseService<CardFq, Long>{
	/**
	 * 开始分期
	 * @param card
	 * @return
	 */
	public CardFq saveCardFq(CardFq fq);
	
	/**
	 * 修改分期信息
	 * @param fq
	 * @return
	 */
	public CardFq updateCardFq(CardFq fq);
	
	/**
	 * 获取分期分页数据
	 * @param queryVo
	 * @param pageable
	 * @return
	 */
	public Pagination<CardFq> findPage(CardFqQueryVo queryVo, Pageable pageable);
	
	/**
	 * 获取指定卡片的分期数据
	 * @param cardId
	 * @return
	 */
	public CardFq findByCardId(Long cardId);
	
	public List<CardFq> findByMdcardnoLike(String mdcardno);
	
	public CardFq findByMdcardno(String mdcardno);
}
