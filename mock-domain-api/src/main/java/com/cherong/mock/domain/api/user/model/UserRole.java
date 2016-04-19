package com.cherong.mock.domain.api.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cherong.mock.common.base.jpa.model.BaseEntity;
import com.cherong.mock.domain.api.rbac.model.SysRole;

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
	private Long userId;
	
	@Column(name = "role_code")
	private String roleCode;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_code", referencedColumnName = "code", insertable = false, updatable = false)
	private SysRole role;

	public Long getUserId() {
		return userId;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public SysRole getRole() {
		return role;
	}

	public void setRole(SysRole role) {
		this.role = role;
	}
	
	
}
