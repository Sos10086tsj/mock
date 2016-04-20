package com.cherong.mock.web.exception.user;

/**
 * Description: 
 * @author Paris
 * @date Jun 19, 20154:59:17 PM
 * @version beta
 */
public class UserNotExistException extends BaseUserException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3111495111790733072L;

	public UserNotExistException(String code, String message, Throwable cause){
		super(code, message, cause);
	}

	public UserNotExistException(String message, Throwable cause){
		super(message, cause);
	}
	
	public UserNotExistException(String code, String message){
		super(code, message);
	}
	
	public UserNotExistException(String message){
		super(message);
	}
}
