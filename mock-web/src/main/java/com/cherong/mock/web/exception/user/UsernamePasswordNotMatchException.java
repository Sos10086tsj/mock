package com.cherong.mock.web.exception.user;

/**
 * Description: 
 * @author Paris
 * @date Jun 19, 20154:59:17 PM
 * @version beta
 */
public class UsernamePasswordNotMatchException extends BaseUserException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5762418471339527911L;

	public UsernamePasswordNotMatchException(String code, String message, Throwable cause){
		super(code, message, cause);
	}

	public UsernamePasswordNotMatchException(String message, Throwable cause){
		super(message, cause);
	}
	
	public UsernamePasswordNotMatchException(String code, String message){
		super(code, message);
	}
	
	public UsernamePasswordNotMatchException(String message){
		super(message);
	}
}
