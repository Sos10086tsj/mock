package com.cherong.mock.web.task;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.math.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.cherong.mock.domain.api.bank.model.Card;
import com.cherong.mock.domain.api.bank.model.CardFq;
import com.cherong.mock.web.bank.logic.CardFqLogic;
import com.cherong.mock.web.bank.logic.CardLogic;
import com.cherong.mock.web.util.BankFormulaUtil;

/**
 * Description:
 * Auth:Paris
 * Date:May 13, 2016
**/
@Component
public class PeriodCreditTask {
	private Logger logger = LoggerFactory.getLogger(PeriodCreditTask.class);
	@Resource
	private CardLogic cardLogic;
	@Resource
	private CardFqLogic cardFqLogic;
	
	/**
	 * 每日速记还款，如果是25号，50%概率还清
	 */
	@Scheduled(cron = "0 0 23 * * ?")
	public void dailyRepayment(){
		this.logger.info("Start daily repayment.");
		//每日随机还款
		Calendar calendar = Calendar.getInstance();
		int day = calendar.get(Calendar.DAY_OF_MONTH);

		List<Card> cards = this.cardLogic.findAllFqCard();
		for (Card card : cards) {
			CardFq fq = this.cardFqLogic.findByMdcardno(card.getMdcardno());
			
			BigDecimal dailyPaybamt = BankFormulaUtil.randomPay(fq.getUnpaybamt());//随机还本金
			BigDecimal dailyPaybfee = BankFormulaUtil.randomPay(fq.getPaybfee());//随机还手续费
			
			if (25 == day) {
				int random = RandomUtils.nextInt(100);

				BigDecimal zero = new BigDecimal(0);
				
				if (random <= 50) {//模拟用户还清
					dailyPaybamt = fq.getUnpaybamt();
					dailyPaybfee = fq.getUnpaybfee();
					fq.setOverdueFine(zero);
					card.setLstbal(zero);
				}else {
					if (card.getLstbal().intValue() > 0) {//账户有余额，优先扣除月
						if (fq.getOverdueFine().intValue() > 0) {
							if (card.getLstbal().intValue() > fq.getOverdueFine().intValue()) {
								card.setLstbal(card.getLstbal().subtract(fq.getOverdueFine()));
								fq.setOverdueFine(zero);
							}else {
								card.setLstbal(zero);
								fq.setOverdueFine(fq.getOverdueFine().subtract(card.getLstbal()));
							}
						}
						if (fq.getUnpaybamt().intValue() > 0) {
							if (card.getLstbal().intValue() > fq.getUnpaybamt().intValue() ) {
								card.setLstbal(card.getLstbal().subtract(fq.getUnpaybamt()));
								fq.setUnpaybamt(zero);
							}else {
								card.setLstbal(zero);
								fq.setUnpaybamt(fq.getUnpaybamt().subtract(card.getLstbal()));
							}
						}
						if (fq.getUnpaybfee().intValue() > 0) {
							if (card.getLstbal().intValue() > fq.getUnpaybfee().intValue()) {
								card.setLstbal(card.getLstbal().subtract(fq.getUnpaybfee()));
								fq.setUnpaybfee(zero);
							}else {
								card.setLstbal(zero);
								fq.setUnpaybfee(fq.getUnpaybfee().subtract(card.getLstbal()));
							}
						}
					}
				}
			}
			
			fq.setUnpaybamt(fq.getUnpaybamt().subtract(dailyPaybamt));
			fq.setUnpaybfee(fq.getUnpaybfee().subtract(dailyPaybfee));
			fq.setPaybamt(fq.getPaybamt().add(dailyPaybamt));
			fq.setPaybfee(fq.getPaybfee().add(dailyPaybfee));

			fq.setAmount(BankFormulaUtil.calculateAuthamt(fq));
			fq.setLstauamt(BankFormulaUtil.calculateLstauamt(fq));
			
			//计算卡片
			card.setLstbal(card.getLstbal().add(dailyPaybfee).add(dailyPaybamt));
			BankFormulaUtil.refreshCard(card);
			this.cardLogic.update(card);
		}
		
		this.logger.info("Daily repayment done.");
	}
	
	/**
	 * 每个月25号分期
	 */
	@Scheduled(cron = "0 0 1 25 * ?")
	public void period(){
		this.logger.info("Start creating period repayment bill.");
		//1. 找到所有的卡片
		List<Card> cards = this.cardLogic.findAllFqCard();
		//2. loop 获取前面的分期信息
		for (Card card : cards) {
			CardFq fq = this.cardFqLogic.findByMdcardno(card.getMdcardno());
			
			//上期扣款
			BigDecimal thisamt = new BigDecimal(0);
			BigDecimal thispfee = new BigDecimal(0);//上期扣款手续费
			if (fq.getTotnum() - fq.getLeftnum() == 1) {//第一期
				thisamt.add(fq.getFirstamt()).subtract(fq.getUnpaybamt()).subtract(fq.getUnpaybfee());//首期金额 - 未还本金 - 未还手续费
				thispfee.add(fq.getFirstpfee()).subtract(fq.getUnpaybfee());
			}else {
				thisamt.add(fq.getEachamt()).subtract(fq.getUnpaybamt()).subtract(fq.getUnpaybfee());//每期金额 - 未还本金 - 未还手续费
				thispfee.add(fq.getEachpfee()).subtract(fq.getUnpaybfee());
			}
			fq.setThisamt(thisamt);
			
			fq.setRealamt(fq.getRealamt().add(fq.getEachamt()));
			fq.setRealpfee(fq.getRealpfee().add(fq.getEachpfee()));
			
			if (fq.getLeftnum() > 0) {
				fq.setLeftnum(fq.getLeftnum() - 1);
			}
			
			BigDecimal zero = new BigDecimal(0);
			if (fq.getUnpaybamt().compareTo(zero) > 0 || fq.getUnpaybfee().compareTo(zero) > 0) {
				fq.setErrnum(fq.getErrnum() + 1);
				Date lastConerdate = fq.getConerdate();
				Date today = new Date();
				if (null != lastConerdate) {
					Calendar calendar1 = Calendar.getInstance();
					calendar1.setTime(lastConerdate);
					Calendar calendar2 = Calendar.getInstance();
					calendar2.setTime(today);
					calendar1.add(Calendar.MONTH, 1);
					int year1 = calendar1.get(Calendar.YEAR);
					int month1 = calendar1.get(Calendar.MONTH);
					int year2 = calendar2.get(Calendar.YEAR);
					int month2 = calendar2.get(Calendar.MONTH);
					if (year1 == year2 && month1 == month2) {
						fq.setConernum(fq.getConernum() + 1);
						card.setLfeegno(card.getLfeegno() + 1);
					}
				}
				fq.setConerdate(today);
				//计算滞纳金，并且增加到卡片月
				fq.setOverdueFine(fq.getOverdueFine().add((fq.getUnpaybamt().add(fq.getUnpaybfee())).multiply(new BigDecimal(0.05))));
				card.setLstbal(card.getLstbal().subtract(fq.getOverdueFine()));
			}
			
			this.cardFqLogic.update(fq);
			
			BigDecimal addBal = fq.getUnpaybamt().add(fq.getUnpaybfee());
			card.setLstbal(card.getLstbal().subtract(addBal));
			BankFormulaUtil.refreshCard(card);
			this.cardLogic.update(card);
		}
		this.logger.info("Period repayment bill create successfully.");
	};

}
