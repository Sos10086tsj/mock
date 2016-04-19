package com.cherong.mock.domain.api.rbac.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cherong.mock.common.base.jpa.model.BaseEntity;

/**
 * Description: 角色、权限mapping
 * Auth:Paris
 * Date:Apr 19, 2016
**/
@Entity
@Table(name = "sys_role_permission")
public class SysRolePermission extends BaseEntity<Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6029931283139552689L;

	@Column(name = "role_code")
	private String roleCode;
	
	@Column(name = "permission_code")
	private String permissionCode;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "permission_code", referencedColumnName = "code", insertable = false, updatable = false)
	private SysPermission permission;

	public String getRoleCode() {
		return roleCode;
	}

	public String getPermissionCode() {
		return permissionCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public void setPermissionCode(String permissionCode) {
		this.permissionCode = permissionCode;
	}

	public SysPermission getPermission() {
		return permission;
	}

	public void setPermission(SysPermission permission) {
		this.permission = permission;
	}
	
	
}
