package com.cherong.mock.domain.api.rbac.constant;
/**
 * Description:
 * Auth:Paris
 * Date:Apr 19, 2016
**/
public enum SysResourceHierarchy {
	FIRST(10000),SECONDE(20000),THIRD(30000);
	
	private final Integer hierarchy;
	
	private SysResourceHierarchy(Integer hierarchy){
		this.hierarchy = hierarchy;
	}

	public Integer getHierarchy() {
		return hierarchy;
	}
	
	
}
