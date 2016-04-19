package com.cherong.mock.domain.bank.service.impl;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;

import com.cherong.mock.domain.bank.model.CardFq;
import com.cherong.mock.domain.bank.service.CardFqService;
import com.cherong.mock.domain.base.BaseBankTestService;

/**
 * Description:
 * Auth:Paris
 * Date:Apr 7, 2016
**/
public class CardFqServiceImplTest extends BaseBankTestService{

	@Resource
	private CardFqService fqViewService;
	@Test
	public void testFindOne() {
		CardFq fv = this.fqViewService.findOne(231l);
		assertNull(fv);
		System.out.println(">>>>>>>>>>>>>>>>pass");
	}

}
