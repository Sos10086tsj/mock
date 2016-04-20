package com.cherong.mock.web.exception.constant;
/**
 * Description:
 * Auth:Paris
 * Date:Apr 20, 2016
**/
public class ExceptionConstant {
	
	public static class UNKNOWN_EXCEPTION{
		public static final String CODE = "ERR001";
		public static final String MESSAGE = "系统错误";
	}
	
	public static class USER {
		//用户不存在
		public static final String USER_NOT_EXIST_CODE = "ERR001";
		public static final String USER_NOT_EXIST_MESSAGE = "用户不存在";
		//用户名密码错误
		public static final String USER_PASS_NOT_MATCH_CODE = "ERR001";
		public static final String USER_PASS_NOT_MATCH_MESSAGE = "用户不存在";
	}
}
