package com.cherong.mock.domain.bank.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.cherong.mock.domain.base.jpa.model.BaseEntity;

/**
 * Description: FQ_VIEW
 * Auth:Paris
 * Date:Apr 7, 2016
**/
@Entity
@Table(name = "FQ_VIEW")
public class FqView extends BaseEntity<String>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3676256422648610947L;
	
	@Column
	private String mdcardno;//协议号
	@Column
	private BigDecimal amount;//贷款金额
	@Column
	private BigDecimal feeamt;//总手续费
	@Column
	private Integer totnum;//总期数
	@Column
	private String workdate;//申请日期	2014-09-09
	@Column
	private BigDecimal thisamt;//上期本金
	@Column
	private Integer errnum;//累计逾期次数
	@Column
	private String errdate;//最后还款日期	2015-05-25
	@Column
	private BigDecimal thispfee;//上期扣款手续费
	@Column
	private BigDecimal firstamt;//首期本金
	@Column
	private BigDecimal firstpfee;//首期手续费
	@Column
	private Integer leftnum;//剩余期数
	@Column
	private BigDecimal paybamt;//已还本金
	@Column
	private BigDecimal paybfee;//已还利息
	@Column
	private BigDecimal unpaybamt;//应还未还本金
	@Column
	private BigDecimal unpaybfee;//应还未还手续费
	@Column
	private BigDecimal eachpfee;//每期手续费
	@Column
	private String conerdate;//最近逾期日期	2014-09-05
	@Column
	private String ortrxdate;//放款日期	2014-09-05
	@Column
	private Integer conernum;//连续逾期次数
	@Column
	private BigDecimal realamt;//已入账金额
	@Column
	private String currtype;//币种
	@Column
	private String accno;//账号
	@Column
	private BigDecimal lstauamt;//昨日授权本金
	@Column
	private BigDecimal realpfee;//已入账手续费
	@Column
	private BigDecimal backfamt;//已退持卡人手续费
	@Column
	private BigDecimal authamt;//授权金额 = 未还本金+未还利息
	public String getMdcardno() {
		return mdcardno;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public BigDecimal getFeeamt() {
		return feeamt;
	}
	public Integer getTotnum() {
		return totnum;
	}
	public String getWorkdate() {
		return workdate;
	}
	public BigDecimal getThisamt() {
		return thisamt;
	}
	public Integer getErrnum() {
		return errnum;
	}
	public String getErrdate() {
		return errdate;
	}
	public BigDecimal getThispfee() {
		return thispfee;
	}
	public BigDecimal getFirstamt() {
		return firstamt;
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
	public BigDecimal getEachpfee() {
		return eachpfee;
	}
	public String getConerdate() {
		return conerdate;
	}
	public String getOrtrxdate() {
		return ortrxdate;
	}
	public Integer getConernum() {
		return conernum;
	}
	public BigDecimal getRealamt() {
		return realamt;
	}
	public String getCurrtype() {
		return currtype;
	}
	public String getAccno() {
		return accno;
	}
	public BigDecimal getLstauamt() {
		return lstauamt;
	}
	public BigDecimal getRealpfee() {
		return realpfee;
	}
	public BigDecimal getBackfamt() {
		return backfamt;
	}
	public BigDecimal getAuthamt() {
		return authamt;
	}
	public void setMdcardno(String mdcardno) {
		this.mdcardno = mdcardno;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public void setFeeamt(BigDecimal feeamt) {
		this.feeamt = feeamt;
	}
	public void setTotnum(Integer totnum) {
		this.totnum = totnum;
	}
	public void setWorkdate(String workdate) {
		this.workdate = workdate;
	}
	public void setThisamt(BigDecimal thisamt) {
		this.thisamt = thisamt;
	}
	public void setErrnum(Integer errnum) {
		this.errnum = errnum;
	}
	public void setErrdate(String errdate) {
		this.errdate = errdate;
	}
	public void setThispfee(BigDecimal thispfee) {
		this.thispfee = thispfee;
	}
	public void setFirstamt(BigDecimal firstamt) {
		this.firstamt = firstamt;
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
	public void setEachpfee(BigDecimal eachpfee) {
		this.eachpfee = eachpfee;
	}
	public void setConerdate(String conerdate) {
		this.conerdate = conerdate;
	}
	public void setOrtrxdate(String ortrxdate) {
		this.ortrxdate = ortrxdate;
	}
	public void setConernum(Integer conernum) {
		this.conernum = conernum;
	}
	public void setRealamt(BigDecimal realamt) {
		this.realamt = realamt;
	}
	public void setCurrtype(String currtype) {
		this.currtype = currtype;
	}
	public void setAccno(String accno) {
		this.accno = accno;
	}
	public void setLstauamt(BigDecimal lstauamt) {
		this.lstauamt = lstauamt;
	}
	public void setRealpfee(BigDecimal realpfee) {
		this.realpfee = realpfee;
	}
	public void setBackfamt(BigDecimal backfamt) {
		this.backfamt = backfamt;
	}
	public void setAuthamt(BigDecimal authamt) {
		this.authamt = authamt;
	}
	
	
}
