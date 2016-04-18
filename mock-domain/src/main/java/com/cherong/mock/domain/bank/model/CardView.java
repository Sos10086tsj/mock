package com.cherong.mock.domain.bank.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.cherong.mock.domain.base.jpa.model.BaseEntity;

/**
 * Description: CARD_VIEW
 * Auth:Paris
 * Date:Apr 7, 2016
**/
@Entity
@Table(name = "CARD_VIEW")
public class CardView extends BaseEntity<String>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3586958326925653855L;

	@Column
	private String mdcardno;//帐户主卡卡号
	
	@Column
	private BigDecimal lstbal;//昨日余额
	
	@Column
	private Integer lfeegno;//滞纳金连续收取次数
	
	@Column
	private BigDecimal dtopamt;//昨日最优还款额
	
	@Column
	private BigDecimal acpayamt;//帐单应还款金额
	
	@Column
	private BigDecimal lstlfee;//表外滞纳金
	
	@Column
	private BigDecimal lstiint;//表内利息
	
	@Column
	private BigDecimal lstoint;//表外利息
	
	@Column
	private String currtype;//币种
	
	@Column
	private String accno;//帐号
	
	@Column
	private String cino;//客户信息号
	
	@Column
	private BigDecimal letpaamt;//最低还款额
	
	@Column
	private BigDecimal lstpbal;//帐户本金

	public String getMdcardno() {
		return mdcardno;
	}

	public BigDecimal getLstbal() {
		return lstbal;
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

	public BigDecimal getLstlfee() {
		return lstlfee;
	}

	public BigDecimal getLstiint() {
		return lstiint;
	}

	public BigDecimal getLstoint() {
		return lstoint;
	}

	public String getCurrtype() {
		return currtype;
	}

	public String getAccno() {
		return accno;
	}

	public String getCino() {
		return cino;
	}

	public BigDecimal getLetpaamt() {
		return letpaamt;
	}

	public BigDecimal getLstpbal() {
		return lstpbal;
	}

	public void setMdcardno(String mdcardno) {
		this.mdcardno = mdcardno;
	}

	public void setLstbal(BigDecimal lstbal) {
		this.lstbal = lstbal;
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

	public void setLstlfee(BigDecimal lstlfee) {
		this.lstlfee = lstlfee;
	}

	public void setLstiint(BigDecimal lstiint) {
		this.lstiint = lstiint;
	}

	public void setLstoint(BigDecimal lstoint) {
		this.lstoint = lstoint;
	}

	public void setCurrtype(String currtype) {
		this.currtype = currtype;
	}

	public void setAccno(String accno) {
		this.accno = accno;
	}

	public void setCino(String cino) {
		this.cino = cino;
	}

	public void setLetpaamt(BigDecimal letpaamt) {
		this.letpaamt = letpaamt;
	}

	public void setLstpbal(BigDecimal lstpbal) {
		this.lstpbal = lstpbal;
	}
	
}
