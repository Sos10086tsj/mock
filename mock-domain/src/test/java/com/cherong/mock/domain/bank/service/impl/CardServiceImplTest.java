package com.cherong.mock.domain.bank.service.impl;

import static org.junit.Assert.assertNull;

import javax.annotation.Resource;

import org.junit.Test;

import com.cherong.mock.domain.api.bank.model.Card;
import com.cherong.mock.domain.api.bank.service.CardService;
import com.cherong.mock.domain.base.BaseBankTestService;

/**
 * Description:
 * Auth:Paris
 * Date:Apr 7, 2016
**/
public class CardServiceImplTest extends BaseBankTestService{
	@Resource
	private CardService cardViewService;
	@Test
	public void testFindOne() {
		Card cv = this.cardViewService.findOne(62223318881031701l);
		assertNull(cv);
		System.out.println(">>>>>>>>>>>>>>>>pass");
	}

}
