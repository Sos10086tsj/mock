package com.cherong.mock.domain.api.user.service;

import java.util.List;

import com.cherong.mock.common.base.jpa.service.BaseService;
import com.cherong.mock.domain.api.user.model.User;
import com.cherong.mock.domain.api.user.vo.Menu;

/**
 * Description:
 * Auth:Paris
 * Date:Apr 19, 2016
**/
public interface UserService extends BaseService<User, Long>{
	
	/**
	 * 查询客户
	 * @param username
	 * @return
	 */
	public User findByUsername(String username);
	/**
	 * 获取用户菜单
	 * @param userId
	 * @return
	 */
	public List<Menu> getUserMenus(Long userId);
}
