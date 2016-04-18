package com.cherong.mock.domain.bank.service.impl;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;

import com.cherong.mock.domain.bank.model.CardView;
import com.cherong.mock.domain.bank.service.CardViewService;
import com.cherong.mock.domain.base.BaseBankTestService;

/**
 * Description:
 * Auth:Paris
 * Date:Apr 7, 2016
**/
public class CardViewServiceImplTest extends BaseBankTestService{
	@Resource
	private CardViewService cardViewService;
	@Test
	public void testFindOne() {
		CardView cv = this.cardViewService.findOne("62223318881031701");
		assertNull(cv);
		System.out.println(">>>>>>>>>>>>>>>>pass");
	}

}
