package com.cherong.mock.web.vo.pojo;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * Description:
 * Auth:Paris
 * Date:May 13, 2016
**/
public class InitFenqiVo {
	private BigDecimal amount;
	private String cardNo;
	@DateTimeFormat( pattern = "yyyy-MM-dd" )
	private Date creditDate;
	private Integer period;
	private BigDecimal ratio;
	
	public BigDecimal getRatio() {
		return ratio;
	}
	public void setRatio(BigDecimal ratio) {
		this.ratio = ratio;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public String getCardNo() {
		return cardNo;
	}
	public Date getCreditDate() {
		return creditDate;
	}
	public Integer getPeriod() {
		return period;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public void setCreditDate(Date creditDate) {
		this.creditDate = creditDate;
	}
	public void setPeriod(Integer period) {
		this.period = period;
	}
	
	
}
