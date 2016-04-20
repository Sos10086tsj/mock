package com.cherong.mock.common.base.exception;
/**
 * Description: 
 * @author Paris
 * @date Jun 19, 20154:59:17 PM
 * @version beta
 */
public abstract class BizException extends BaseException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1749199654386047973L;
	
	public BizException(String code, String message, Throwable cause){
		super(code, message, cause);
	}

	public BizException(String message, Throwable cause){
		super(message, cause);
	}
	
	public BizException(String code, String message){
		super(code, message);
	}
	
	public BizException(String message){
		super(message);
	}
}
