package com.cherong.mock.domain.api.bank.vo;

import com.cherong.mock.common.base.entity.BaseQueryVo;

/**
 * Description:
 * Auth:Paris
 * Date:Apr 19, 2016
**/
public class CardQueryVo extends BaseQueryVo{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3940904292606991260L;

	private String mdcardno;

	public String getMdcardno() {
		return mdcardno;
	}

	public void setMdcardno(String mdcardno) {
		this.mdcardno = mdcardno;
	}
	
	
}
