package com.cherong.mock.domain.api.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.cherong.mock.common.base.jpa.model.BaseVersionEntity;

/**
 * Description:
 * Auth:Paris
 * Date:Apr 19, 2016
**/
@Entity
@Table(name = "sys_user")
public class User extends BaseVersionEntity<Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 220390840661185298L;

	@Column
	private String username;
	
	@Column
	private String name;
	
	@Column
	private String salt;
	
	@Column
	private String password;
	
	@Column(name = "company_code")
	private String companyCode;

	public String getUsername() {
		return username;
	}

	public String getName() {
		return name;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getSalt() {
		return salt;
	}

	public String getPassword() {
		return password;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", name=" + name + ", salt=" + salt + ", password=" + password
				+ ", companyCode=" + companyCode + ", version=" + version + ", id=" + id + "]";
	}

	
}
