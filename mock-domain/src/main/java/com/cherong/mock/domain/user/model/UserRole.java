package com.cherong.mock.domain.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.cherong.mock.domain.base.jpa.model.BaseEntity;

/**
 * Description:
 * Auth:Paris
 * Date:Apr 19, 2016
**/
@Entity
@Table(name = "sys_user_role")
public class UserRole extends BaseEntity<Long>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2971780798362447662L;

	@Column(name = "user_id")
	private String userId;
	
	@Column(name = "role_code")
	private String roleCode;

	public String getUserId() {
		return userId;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	
	
}
