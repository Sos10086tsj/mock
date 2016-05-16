package com.cherong.mock.web.util;

import java.math.BigDecimal;
import java.util.Calendar;

import org.apache.commons.lang.math.RandomUtils;

import com.cherong.mock.domain.api.bank.model.Card;
import com.cherong.mock.domain.api.bank.model.CardFq;

/**
 * Description: 银行公式util
 * Auth:Paris
 * Date:May 16, 2016
**/
public class BankFormulaUtil {

	/**
	 * 分期授权金额
	 * @param fq
	 * @return
	 */
	public static BigDecimal calculateAuthamt(CardFq fq) {
		return fq.getAmount().subtract(fq.getPaybamt()).subtract(fq.getPaybfee());
	}
	
	/**
	 * 分期昨日授权本金
	 * @param fq
	 * @return
	 */
	public static BigDecimal calculateLstauamt(CardFq fq) {
		return fq.getAmount().subtract(fq.getFeeamt()).subtract(fq.getPaybamt());
	}
	
	/**
	 * 随机还款
	 * @param bill
	 * @return
	 */
	public static BigDecimal randomPay(BigDecimal bill) {
		if (bill.compareTo(new BigDecimal(0)) == 0) {
			return bill;
		}
		int repaymentRatio = RandomUtils.nextInt(100);
		int repayment = bill.intValue() * repaymentRatio / 100;
		return new BigDecimal(repayment);
	}
	
	public static void refreshCard(Card card) {
		Calendar calendar = Calendar.getInstance();
		card.setLsttrand(calendar.getTime());
		BigDecimal negative = new BigDecimal(-1);
		if (card.getLstbal().intValue() < 0) {
			card.setDtopamt(card.getLstbal().multiply(negative));
			card.setAcpayamt(card.getLstbal().multiply(negative));
			card.setLetpaamt(card.getLstbal().multiply(negative).divide(new BigDecimal(10)));
		}else {
			BigDecimal zero = new BigDecimal(0);
			card.setDtopamt(zero);
			card.setAcpayamt(zero);
			card.setLetpaamt(zero);
		}
		card.setLstpbal(card.getLstbal());
	}
}
