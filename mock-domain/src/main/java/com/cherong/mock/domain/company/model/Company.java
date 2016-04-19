package com.cherong.mock.domain.company.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.cherong.mock.domain.base.jpa.model.BaseEntity;
import com.cherong.mock.domain.company.constant.CompanyStatus;

/**
 * Description:	公司表
 * Auth:Paris
 * Date:Apr 19, 2016
**/
@Entity
@Table(name = "sys_company")
public class Company extends BaseEntity<Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6775732498765403479L;

	@Column
	private String code;//唯一
	
	@Column
	private String name;//公司名称
	
	@Column
	@Enumerated(EnumType.STRING)
	private CompanyStatus status;//状态

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public CompanyStatus getStatus() {
		return status;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setStatus(CompanyStatus status) {
		this.status = status;
	}
	
	
}
