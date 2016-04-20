package com.cherong.mock.common.base.exception;


/**
 * Description: 
 * @author Paris
 * @date Jun 19, 20154:57:15 PM
 * @version beta
 */
public abstract class BaseException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7750492725808465565L;

	protected String code;
	
	protected String message;
	
	public BaseException(String code, String message, Throwable cause){
		super(message, cause);
		this.code = code;
		this.message = message;
	}
	
	public BaseException(String message, Throwable cause){
		super(message, cause);
		this.message = message;
	}
	
	public BaseException(String code, String message){
		super(message);
		this.code = code;
		this.message = message;
	}
	
	public BaseException(String message){
		super(message);
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}
