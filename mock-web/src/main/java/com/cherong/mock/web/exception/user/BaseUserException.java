package com.cherong.mock.web.exception.user;

import com.cherong.mock.common.base.exception.BizException;

/**
 * Description: 
 * @author Paris
 * @date Jun 19, 20154:59:17 PM
 * @version beta
 */
public class BaseUserException extends BizException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -374871362158312020L;

	public BaseUserException(String code, String message, Throwable cause){
		super(code, message, cause);
	}

	public BaseUserException(String message, Throwable cause){
		super(message, cause);
	}
	
	public BaseUserException(String code, String message){
		super(code, message);
	}
	
	public BaseUserException(String message){
		super(message);
	}
}
