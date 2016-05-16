package com.cherong.mock.web.bank.logic;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.cherong.mock.domain.api.bank.model.Card;
import com.cherong.mock.domain.api.bank.vo.CardQueryVo;
import com.cherong.mock.domain.api.serializable.Pagination;
import com.cherong.mock.web.vo.SelectVo;
import com.cherong.mock.web.vo.pojo.InitFenqiVo;
import com.cherong.mock.web.vo.pojo.RepaymentVo;

/**
 * Description:
 * Auth:Paris
 * Date:May 4, 2016
**/
public interface CardLogic {
	public Pagination<Card> findPage(CardQueryVo queryVo, Pageable pageable);
	
	/**
	 * 卡号匹配
	 * @param mdcardno
	 * @return
	 */
	public List<SelectVo> findMdcardnoLike(String mdcardno);
	
	public void update(Card card);
	
	public List<Card> findAll();
	
	public Card findByMdcardno(String mdcardno);
	
	public void initFenqi(InitFenqiVo vo);
	
	/**
	 * 获取所有分期中的信用卡
	 * @return
	 */
	public List<Card> findAllFqCard();
	
	public void repayment(RepaymentVo vo);
}
