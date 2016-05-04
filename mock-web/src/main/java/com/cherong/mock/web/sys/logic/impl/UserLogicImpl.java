package com.cherong.mock.web.sys.logic.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cherong.mock.common.base.cache.BaseCacheAspect;
import com.cherong.mock.common.base.util.EncryptionUtil;
import com.cherong.mock.domain.api.user.model.User;
import com.cherong.mock.domain.api.user.service.UserService;
import com.cherong.mock.domain.api.user.vo.Menu;
import com.cherong.mock.web.exception.constant.ExceptionConstant;
import com.cherong.mock.web.exception.user.BaseUserException;
import com.cherong.mock.web.exception.user.UserNotExistException;
import com.cherong.mock.web.exception.user.UsernamePasswordNotMatchException;
import com.cherong.mock.web.sys.logic.UserLogic;

/**
 * Description:
 * Auth:Paris
 * Date:Apr 20, 2016
**/
@Service
public class UserLogicImpl extends BaseCacheAspect implements UserLogic{
	
	private Logger logger = LoggerFactory.getLogger(UserLogicImpl.class);
	
	private final String accessTokenCachePrefix = "session-token-";
	private final String accessTokenCacheName = "sessionCache";
	
	@Autowired
	private UserService userService;
	
	public UserLogicImpl() {
		setCacheName(accessTokenCacheName);
	}

	@Override
	public void userLogin(String username, String password, String sessionId) throws BaseUserException {
		User user = this.userService.findByUsername(username);
		if (null == user) {
			this.logger.info("User {} not exist.", username);
			throw new UserNotExistException(ExceptionConstant.USER.USER_NOT_EXIST_CODE, ExceptionConstant.USER.USER_NOT_EXIST_MESSAGE);
		}
		if (!user.getPassword().equals(EncryptionUtil.md5L32(password + user.getSalt()))) {
			this.logger.info("Username {} not not match password {}.", username, password);
			throw new UsernamePasswordNotMatchException(ExceptionConstant.USER.USER_PASS_NOT_MATCH_CODE, ExceptionConstant.USER.USER_PASS_NOT_MATCH_MESSAGE);
		}
		this.put(accessTokenCachePrefix + sessionId, username);
	}

	@Override
	public User getUser(String sessionId) {
		String username = (String)this.get(accessTokenCachePrefix + sessionId);
		return this.userService.findByUsername(username);
	}

	@Override
	public List<Menu> getUserMenu(Long userId) {
		return this.userService.getUserMenus(userId);
	}

}
