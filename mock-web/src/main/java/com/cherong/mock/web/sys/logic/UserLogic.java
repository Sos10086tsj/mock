package com.cherong.mock.web.sys.logic;

import java.util.List;

import com.cherong.mock.domain.api.user.model.User;
import com.cherong.mock.domain.api.user.vo.Menu;
import com.cherong.mock.web.exception.user.BaseUserException;

/**
 * Description:
 * Auth:Paris
 * Date:Apr 20, 2016
**/
public interface UserLogic {
	
	/**
	 * 用户登陆
	 * @param username
	 * @param password
	 * @param sessionId
	 * @return
	 * @throws BaseUserException
	 */
	public void userLogin(String username, String password, String sessionId) throws BaseUserException;
	
	/**
	 * 获取客户信息
	 * @param sessionId
	 * @return
	 */
	public User getUser(String sessionId);
	
	/**
	 * 获取菜单
	 * @param userId
	 * @return
	 */
	public List<Menu> getUserMenu(Long userId);
}
