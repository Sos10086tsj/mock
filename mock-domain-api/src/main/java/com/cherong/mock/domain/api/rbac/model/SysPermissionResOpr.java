package com.cherong.mock.domain.api.rbac.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cherong.mock.common.base.jpa.model.BaseEntity;

/**
 * Description: 权限 = 资源 + 操作
 * Auth:Paris
 * Date:Apr 19, 2016
**/
@Entity
@Table(name = "sys_perm_res_opr")
public class SysPermissionResOpr extends BaseEntity<Long>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2474407064449968118L;

	@Column(name = "permission_code")
	private String permissionCode;
	
	@Column(name = "res_code")
	private String resCode;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "res_code", referencedColumnName = "code", insertable = false, updatable = false)
	private SysResource resource;
	
	@Column(name = "opr_code")
	private String oprCode;

	public String getPermissionCode() {
		return permissionCode;
	}

	public String getResCode() {
		return resCode;
	}

	public String getOprCode() {
		return oprCode;
	}

	public void setPermissionCode(String permissionCode) {
		this.permissionCode = permissionCode;
	}

	public void setResCode(String resCode) {
		this.resCode = resCode;
	}

	public void setOprCode(String oprCode) {
		this.oprCode = oprCode;
	}

	public SysResource getResource() {
		return resource;
	}

	public void setResource(SysResource resource) {
		this.resource = resource;
	}
	
	
}
