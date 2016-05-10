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
 * Description: CARD_VIEW
 * Auth:Paris
 * Date:Apr 7, 2016
**/
@Entity
@Table(name = "bank_card")
public class Card extends BaseVersionEntity<Long>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3586958326925653855L;

	@Column
	private String accno;//	帐号	39010000210037000
	@Column(name = "currtype")
	@Enumerated(EnumType.ORDINAL)
	private CardCurrencyType currtype;//	币种	1
	@Column
	private String mdcardno;//	帐户主卡卡号	6222330053902219
	@Column
	private String cino;//	客户信息号	390100077152854
	@Column
	private BigDecimal lstbal;//	昨日余额	-268,402.00
	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date lsttrand;//	最后客户交易日	2015-06-09
	@Column
	private BigDecimal letpaamt;//	最低还款额	13,410.00
	@Column
	private Integer lfeegno;//	滞纳金连续收取次数	2
	@Column
	private BigDecimal dtopamt;//	昨日最优还款额	134,102.00
	@Column
	private BigDecimal acpayamt;//	帐单应还款金额	134,102.00
	@Column
	private BigDecimal lstpbal;//	帐户本金	-265,351.00
	@Column
	private BigDecimal lstiint;//	表内利息	-3,051.00
	@Column
	private BigDecimal lstoint;//	表外利息	0.00
	@Column
	private BigDecimal lstlfee;//	表外滞纳金	0.00
	
	@Column(name = "bank_id")
	private Long bankId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bank_id", referencedColumnName = "id", insertable = false, updatable = false)
	private Bank bank;//所属银行

	public String getAccno() {
		return accno;
	}

	public CardCurrencyType getCurrtype() {
		return currtype;
	}

	public String getMdcardno() {
		return mdcardno;
	}

	public String getCino() {
		return cino;
	}

	public BigDecimal getLstbal() {
		return lstbal;
	}

	public Date getLsttrand() {
		return lsttrand;
	}

	public BigDecimal getLetpaamt() {
		return letpaamt;
	}

	public Integer getLfeegno() {
		return lfeegno;
	}

	public BigDecimal getDtopamt() {
		return dtopamt;
	}

	public BigDecimal getAcpayamt() {
		return acpayamt;
	}

	public BigDecimal getLstpbal() {
		return lstpbal;
	}

	public BigDecimal getLstiint() {
		return lstiint;
	}

	public BigDecimal getLstoint() {
		return lstoint;
	}

	public BigDecimal getLstlfee() {
		return lstlfee;
	}

	public Bank getBank() {
		return bank;
	}

	public void setAccno(String accno) {
		this.accno = accno;
	}

	public void setCurrtype(CardCurrencyType currtype) {
		this.currtype = currtype;
	}

	public void setMdcardno(String mdcardno) {
		this.mdcardno = mdcardno;
	}

	public void setCino(String cino) {
		this.cino = cino;
	}

	public void setLstbal(BigDecimal lstbal) {
		this.lstbal = lstbal;
	}

	public void setLsttrand(Date lsttrand) {
		this.lsttrand = lsttrand;
	}

	public void setLetpaamt(BigDecimal letpaamt) {
		this.letpaamt = letpaamt;
	}

	public void setLfeegno(Integer lfeegno) {
		this.lfeegno = lfeegno;
	}

	public void setDtopamt(BigDecimal dtopamt) {
		this.dtopamt = dtopamt;
	}

	public void setAcpayamt(BigDecimal acpayamt) {
		this.acpayamt = acpayamt;
	}

	public void setLstpbal(BigDecimal lstpbal) {
		this.lstpbal = lstpbal;
	}

	public void setLstiint(BigDecimal lstiint) {
		this.lstiint = lstiint;
	}

	public void setLstoint(BigDecimal lstoint) {
		this.lstoint = lstoint;
	}

	public void setLstlfee(BigDecimal lstlfee) {
		this.lstlfee = lstlfee;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public Long getBankId() {
		return bankId;
	}

	public void setBankId(Long bankId) {
		this.bankId = bankId;
	}
	
	
}
