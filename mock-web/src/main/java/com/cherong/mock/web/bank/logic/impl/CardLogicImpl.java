package com.cherong.mock.web.bank.logic.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.cherong.mock.domain.api.bank.model.Card;
import com.cherong.mock.domain.api.bank.model.CardFq;
import com.cherong.mock.domain.api.bank.service.CardFqService;
import com.cherong.mock.domain.api.bank.service.CardService;
import com.cherong.mock.domain.api.bank.vo.CardQueryVo;
import com.cherong.mock.domain.api.serializable.Pagination;
import com.cherong.mock.web.bank.logic.CardLogic;
import com.cherong.mock.web.util.BankFormulaUtil;
import com.cherong.mock.web.vo.SelectVo;
import com.cherong.mock.web.vo.pojo.InitFenqiVo;
import com.cherong.mock.web.vo.pojo.RepaymentVo;

/**
 * Description:
 * Auth:Paris
 * Date:May 4, 2016
**/
@Service
public class CardLogicImpl implements CardLogic{
	private Logger logger = LoggerFactory.getLogger(CardLogicImpl.class);
	@Resource
	private CardService cardService;
	@Resource
	private CardFqService cardFqService;

	@Override
	public Pagination<Card> findPage(CardQueryVo queryVo, Pageable pageable) {
		return this.cardService.findPage(queryVo, pageable);
	}

	@Override
	public void update(Card card) {
		this.cardService.update(card);
	}

	@Override
	public List<SelectVo> findMdcardnoLike(String mdcardno) {
		List<SelectVo> vos = new ArrayList<SelectVo>();
		List<Card> cards =  this.cardService.findByMdcardnoLike(mdcardno);
		for (Card card : cards) {
			vos.add(new SelectVo(card.getMdcardno(), card.getMdcardno()));
		}
		return vos;
	}

	@Override
	public List<Card> findAll() {
		return this.cardService.findAll();
	}

	@Override
	public Card findByMdcardno(String mdcardno) {
		return this.cardService.findByMdcardno(mdcardno);
	}

	@Override
	public void initFenqi(InitFenqiVo vo) {
		Card card = this.cardService.findByMdcardno(vo.getCardNo());
		if (null == card || null != this.cardFqService.findByMdcardno(vo.getCardNo())) {
			return;
		}
		CardFq fq = new CardFq();
		BigDecimal zero = new BigDecimal(0);
		fq.setMdcardno(card.getMdcardno());
		fq.setAmount(vo.getAmount());
		
		fq.setFeeamt(vo.getAmount().multiply(vo.getRatio()).divide(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP));
		//计算每期金额
		int total = vo.getPeriod();
		int amout = vo.getAmount().intValue();
		int perAmt = amout / total;
		int firstAmt = amout - perAmt * total + perAmt;
		int feeAmt = fq.getFeeamt().intValue();
		int perFeeAmt = feeAmt / total;
		int firstFeeAmt = feeAmt - perFeeAmt * total + perFeeAmt;
		fq.setEachamt(new BigDecimal(perAmt));
		fq.setTotnum(total);
		fq.setWorkdate(vo.getCreditDate());
		fq.setThisamt(zero);
		fq.setRealamt(new BigDecimal(firstAmt));
		fq.setErrnum(0);
		fq.setThispfee(zero);
		fq.setFirstamt(new BigDecimal(firstAmt));
		fq.setOrtrxdate(vo.getCreditDate());
		fq.setEachpfee(new BigDecimal(perFeeAmt));
		fq.setFirstpfee(new BigDecimal(firstFeeAmt));
		fq.setLeftnum(total - 1);
		fq.setPaybamt(zero);
		fq.setPaybfee(zero);
		fq.setUnpaybamt(new BigDecimal(firstAmt - firstFeeAmt));
		fq.setUnpaybfee(new BigDecimal(firstFeeAmt));
		fq.setConernum(0);
		fq.setRealpfee(new BigDecimal(firstFeeAmt));
		fq.setBackfamt(zero);
		

		fq.setAuthamt(BankFormulaUtil.calculateAuthamt(fq));
		fq.setLstauamt(BankFormulaUtil.calculateLstauamt(fq));
		
		this.cardFqService.save(fq);
		
		//初始化卡片
		BigDecimal negative = new BigDecimal(-1);
		BigDecimal addBal = (fq.getUnpaybamt().add(fq.getUnpaybfee())).multiply(negative);
		card.setLstbal(card.getLstbal().add(addBal));
		BankFormulaUtil.refreshCard(card);
		this.cardService.update(card);
	}

	@Override
	public List<Card> findAllFqCard() {
		return this.cardService.findAllFqCard();
	}

	@Override
	public void repayment(RepaymentVo vo) {
		Card card = this.cardService.findByMdcardno(vo.getCardNo());
		if (null == card) {
			this.logger.info("Card {} not exist.", vo.getCardNo());
			return;
		}
		card.setLstbal(card.getLstbal().add(vo.getRepayment()));
		BankFormulaUtil.refreshCard(card);
		CardFq fq = this.cardFqService.findByMdcardno(card.getMdcardno());
		if (null != fq) {
			BigDecimal remaing = vo.getRepayment();
			BigDecimal zero = new BigDecimal(0);
			if (fq.getOverdueFine().intValue() > 0) {
				if (remaing.intValue() > fq.getOverdueFine().intValue()) {//1. 还滞纳金
					remaing = remaing.subtract(fq.getOverdueFine());
					fq.setOverdueFine(zero);
				}else {
					fq.setOverdueFine(fq.getOverdueFine().subtract(remaing));
					remaing = zero;
				}
			}
			if (fq.getUnpaybamt().intValue() > 0) {
				if (remaing.intValue() > fq.getUnpaybamt().intValue()) {//2. 还本金
					remaing = remaing.subtract(fq.getUnpaybamt());
					fq.setUnpaybamt(zero);
				}else {
					fq.setUnpaybamt(fq.getUnpaybamt().subtract(remaing));
					remaing = zero;
				}
			}
			if (fq.getUnpaybfee().intValue() > 0) {
				if (remaing.intValue() > fq.getUnpaybfee().intValue()) {//3. 还利息
					remaing = remaing.subtract(fq.getUnpaybfee());
					fq.setUnpaybfee(zero);
				}else {
					fq.setUnpaybamt(fq.getUnpaybamt().subtract(remaing));
					remaing = zero;
				}
			}
			this.cardFqService.update(fq);
		}
		this.cardService.update(card);
	}

}
