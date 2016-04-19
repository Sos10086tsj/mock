package com.cherong.mock.domain.rabc.constant;
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
