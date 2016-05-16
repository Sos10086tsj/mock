package com.cherong.mock.web.vo.pojo;

import java.math.BigDecimal;

/**
 * Description: 还款vo
 * Auth:Paris
 * Date:May 16, 2016
**/
public class RepaymentVo {
	private String cardNo;
	private BigDecimal repayment;
	public String getCardNo() {
		return cardNo;
	}
	public BigDecimal getRepayment() {
		return repayment;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public void setRepayment(BigDecimal repayment) {
		this.repayment = repayment;
	}
	
	
}
