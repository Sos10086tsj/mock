package com.cherong.mock.domain.user.service.impl;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;

import com.cherong.mock.domain.base.BaseBankTestService;
import com.cherong.mock.domain.user.model.User;
import com.cherong.mock.domain.user.service.UserService;

/**
 * Description:
 * Auth:Paris
 * Date:Apr 19, 2016
**/
public class UserServiceImplTest extends BaseBankTestService{
	@Resource
	private UserService UserService;
	@Test
	public void testFindOne() {
		User user = this.UserService.findOne(1l);
		assertNotNull(user);
		System.out.println(">>>>>>>>>>>>>>>>user:" + user);
	}

}
