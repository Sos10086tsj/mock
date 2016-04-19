package com.cherong.mock.domain.user.service.impl;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.cherong.mock.domain.base.BaseBankTestService;
import com.cherong.mock.domain.user.model.User;
import com.cherong.mock.domain.user.service.UserService;
import com.cherong.mock.domain.user.vo.Menu;

/**
 * Description:
 * Auth:Paris
 * Date:Apr 19, 2016
**/
public class UserServiceImplTest extends BaseBankTestService{
	@Resource
	private UserService userService;
	
	@Test
	public void testFindOne() {
		User user = this.userService.findOne(1l);
		assertNotNull(user);
		System.out.println(">>>>>>>>>>>>>>>>user:" + user);
	}

	@Test
	public void testGetUserMenus(){
		List<Menu> menus = this.userService.getUserMenus(1l);
		assertNotNull(menus);
		System.out.println(">>>>>>>>>>>>>>>>");
		for (Menu menu : menus) {
			System.out.println("menu:" + menu);
		}
	}
}
