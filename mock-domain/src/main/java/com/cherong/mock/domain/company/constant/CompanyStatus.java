package com.cherong.mock.domain.company.constant;
/**
 * Description:
 * Auth:Paris
 * Date:Apr 19, 2016
**/
public enum CompanyStatus {
	ACTIVE(0),INACTIVE(1);
	
	private final Integer status;
	
	private CompanyStatus(Integer status){
		this.status = status;
	}

	public Integer getStatus() {
		return status;
	}
	
	
}
