package com.cherong.mock.domain.api.bank.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.cherong.mock.common.base.jpa.model.BaseVersionEntity;
import com.cherong.mock.domain.api.bank.constant.CardCurrencyType;

/**
 * Description: FQ_VIEW Auth:Paris Date:Apr 7, 2016
 **/
@Entity
@Table(name = "bank_card_fq")
public class CardFq extends BaseVersionEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3676256422648610947L;

	@Column(name ="card_id")
	private Long cardId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "card_id", referencedColumnName = "id", insertable = false, updatable = false)
	private Card card;

	@Column
	private String mdcardno;// 协议号 6222330053902219
	@Column
	private String accno;// 账号 39010000210037000
	@Column
	private BigDecimal amount;// 消费金额 4418200
	@Column
	private BigDecimal authamt;// 授权金额 3626100
	@Column
	private BigDecimal feeamt;// 持卡人手续费 419287
	@Column
	private BigDecimal eachamt;// 每期金额 122700

	@Column(name = "currtype")
	@Enumerated(EnumType.ORDINAL)
	private CardCurrencyType currtype;// 币种 001
	@Column
	private Integer totnum;// 总期数 036
	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date workdate;// 申请日期 2014-09-09
	@Column
	private BigDecimal thisamt;// 上期扣款金额 122700
	@Column
	private BigDecimal realamt;// 已入账金额 1105300
	@Column
	private Integer errnum;// 累计违约次数 003
	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date errdate;// 滞纳金最后收取日期 2015-05-25
	@Column
	private BigDecimal thispfee;// 上期扣款手续费 11600
	@Column
	private BigDecimal realpfee;// 已入账手续费 106087
	@Column
	private BigDecimal firstamt;// 首期金额 123700
	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ortrxdate;// 原消费日期 2014-09-05
	@Column
	private BigDecimal eachpfee;// 每期手续费 11600
	@Column
	private BigDecimal ortrxamt;// 原消费金额 4418200
	@Column
	private BigDecimal firstpfee;// 首期手续费 13287
	@Column
	private Integer leftnum;// 剩余期数 027
	@Column
	private BigDecimal paybamt;// 分期付款已还款本金 974249
	@Column
	private BigDecimal paybfee;// 分期付款已还款手续费 106087
	@Column
	private BigDecimal unpaybamt;// 分期付款未还款本金 131051
	@Column
	private BigDecimal unpaybfee;// 分期付款未还款手续费 0
	@Column
	private BigDecimal lstauamt;// 昨日授权本金 3,435,600.00
	@Column
	private Integer conernum;// 连续违约次数 002
	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date conerdate;// 上次违约日期 2015-05-25
	@Column
	private BigDecimal backfamt;// 已退持卡人手续费 0.00

	public Card getCard() {
		return card;
	}

	public String getMdcardno() {
		return mdcardno;
	}

	public String getAccno() {
		return accno;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public BigDecimal getAuthamt() {
		return authamt;
	}

	public BigDecimal getFeeamt() {
		return feeamt;
	}

	public BigDecimal getEachamt() {
		return eachamt;
	}

	public CardCurrencyType getCurrtype() {
		return currtype;
	}

	public Integer getTotnum() {
		return totnum;
	}

	public Date getWorkdate() {
		return workdate;
	}

	public BigDecimal getThisamt() {
		return thisamt;
	}

	public BigDecimal getRealamt() {
		return realamt;
	}

	public Integer getErrnum() {
		return errnum;
	}

	public Date getErrdate() {
		return errdate;
	}

	public BigDecimal getThispfee() {
		return thispfee;
	}

	public BigDecimal getRealpfee() {
		return realpfee;
	}

	public BigDecimal getFirstamt() {
		return firstamt;
	}

	public Date getOrtrxdate() {
		return ortrxdate;
	}

	public BigDecimal getEachpfee() {
		return eachpfee;
	}

	public BigDecimal getOrtrxamt() {
		return ortrxamt;
	}

	public BigDecimal getFirstpfee() {
		return firstpfee;
	}

	public Integer getLeftnum() {
		return leftnum;
	}

	public BigDecimal getPaybamt() {
		return paybamt;
	}

	public BigDecimal getPaybfee() {
		return paybfee;
	}

	public BigDecimal getUnpaybamt() {
		return unpaybamt;
	}

	public BigDecimal getUnpaybfee() {
		return unpaybfee;
	}

	public BigDecimal getLstauamt() {
		return lstauamt;
	}

	public Integer getConernum() {
		return conernum;
	}

	public Date getConerdate() {
		return conerdate;
	}

	public BigDecimal getBackfamt() {
		return backfamt;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public void setMdcardno(String mdcardno) {
		this.mdcardno = mdcardno;
	}

	public void setAccno(String accno) {
		this.accno = accno;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public void setAuthamt(BigDecimal authamt) {
		this.authamt = authamt;
	}

	public void setFeeamt(BigDecimal feeamt) {
		this.feeamt = feeamt;
	}

	public void setEachamt(BigDecimal eachamt) {
		this.eachamt = eachamt;
	}

	public void setCurrtype(CardCurrencyType currtype) {
		this.currtype = currtype;
	}

	public void setTotnum(Integer totnum) {
		this.totnum = totnum;
	}

	public void setWorkdate(Date workdate) {
		this.workdate = workdate;
	}

	public void setThisamt(BigDecimal thisamt) {
		this.thisamt = thisamt;
	}

	public void setRealamt(BigDecimal realamt) {
		this.realamt = realamt;
	}

	public void setErrnum(Integer errnum) {
		this.errnum = errnum;
	}

	public void setErrdate(Date errdate) {
		this.errdate = errdate;
	}

	public void setThispfee(BigDecimal thispfee) {
		this.thispfee = thispfee;
	}

	public void setRealpfee(BigDecimal realpfee) {
		this.realpfee = realpfee;
	}

	public void setFirstamt(BigDecimal firstamt) {
		this.firstamt = firstamt;
	}

	public void setOrtrxdate(Date ortrxdate) {
		this.ortrxdate = ortrxdate;
	}

	public void setEachpfee(BigDecimal eachpfee) {
		this.eachpfee = eachpfee;
	}

	public void setOrtrxamt(BigDecimal ortrxamt) {
		this.ortrxamt = ortrxamt;
	}

	public void setFirstpfee(BigDecimal firstpfee) {
		this.firstpfee = firstpfee;
	}

	public void setLeftnum(Integer leftnum) {
		this.leftnum = leftnum;
	}

	public void setPaybamt(BigDecimal paybamt) {
		this.paybamt = paybamt;
	}

	public void setPaybfee(BigDecimal paybfee) {
		this.paybfee = paybfee;
	}

	public void setUnpaybamt(BigDecimal unpaybamt) {
		this.unpaybamt = unpaybamt;
	}

	public void setUnpaybfee(BigDecimal unpaybfee) {
		this.unpaybfee = unpaybfee;
	}

	public void setLstauamt(BigDecimal lstauamt) {
		this.lstauamt = lstauamt;
	}

	public void setConernum(Integer conernum) {
		this.conernum = conernum;
	}

	public void setConerdate(Date conerdate) {
		this.conerdate = conerdate;
	}

	public void setBackfamt(BigDecimal backfamt) {
		this.backfamt = backfamt;
	}

	public Long getCardId() {
		return cardId;
	}

	public void setCardId(Long cardId) {
		this.cardId = cardId;
	}

}
