package com.cherong.mock.web.sys.logic;

import com.cherong.mock.domain.api.user.model.User;
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
}
