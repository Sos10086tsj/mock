package com.cherong.mock.domain.api.bank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cherong.mock.common.base.jpa.model.BaseVersionEntity;
import com.cherong.mock.domain.api.company.model.Company;

/**
 * Description: 银行entity
 * Auth:Paris
 * Date:Apr 19, 2016
**/
@Entity
@Table(name = "bank")
public class Bank extends BaseVersionEntity<Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6962896045097470699L;

	@Column
	private String name;//银行名称
	
	@Column(name ="company_code")
	private String companyCode;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "company_code", referencedColumnName="code", insertable = false, updatable = false)
	private Company company;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	
	
}
