package com.cherong.mock.domain.bank.service.impl;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;

import com.cherong.mock.domain.bank.model.FqView;
import com.cherong.mock.domain.bank.service.FqViewService;
import com.cherong.mock.domain.base.BaseBankTestService;

/**
 * Description:
 * Auth:Paris
 * Date:Apr 7, 2016
**/
public class FqViewServiceImplTest extends BaseBankTestService{

	@Resource
	private FqViewService fqViewService;
	@Test
	public void testFindOne() {
		FqView fv = this.fqViewService.findOne("231");
		assertNull(fv);
		System.out.println(">>>>>>>>>>>>>>>>pass");
	}

}
