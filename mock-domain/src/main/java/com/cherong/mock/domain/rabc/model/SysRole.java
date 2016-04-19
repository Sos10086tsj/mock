package com.cherong.mock.domain.rabc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.cherong.mock.domain.base.jpa.model.BaseDeletedEntity;

/**
 * Description: 角色
 * Auth:Paris
 * Date:Apr 19, 2016
**/
@Entity
@Table(name = "sys_role")
public class SysRole extends BaseDeletedEntity<Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -798856714921420898L;

	@Column
	private String code;
	
	@Column
	private String name;
	
	@Column
	private String description;
	
	@Column(name = "show", columnDefinition="TINYINT(1)")
	private Boolean show;

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Boolean getShow() {
		return show;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setShow(Boolean show) {
		this.show = show;
	}
	
	
}
