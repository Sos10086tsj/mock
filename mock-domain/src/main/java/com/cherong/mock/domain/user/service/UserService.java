package com.cherong.mock.domain.user.service;

import java.util.List;

import com.cherong.mock.domain.base.jpa.service.BaseService;
import com.cherong.mock.domain.user.model.User;
import com.cherong.mock.domain.user.vo.Menu;

/**
 * Description:
 * Auth:Paris
 * Date:Apr 19, 2016
**/
public interface UserService extends BaseService<User, Long>{
	/**
	 * 获取用户菜单
	 * @param userId
	 * @return
	 */
	public List<Menu> getUserMenus(Long userId);
}
