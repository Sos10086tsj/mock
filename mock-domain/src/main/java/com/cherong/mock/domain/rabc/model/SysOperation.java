package com.cherong.mock.domain.rabc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.cherong.mock.domain.base.jpa.model.BaseEntity;

/**
 * Description: 操作
 * Auth:Paris
 * Date:Apr 19, 2016
**/
@Entity
@Table(name = "sys_operation")
public class SysOperation extends BaseEntity<Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8110941585260866295L;

	@Column
	private String code;
	
	@Column
	private String name;

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
