package com.cherong.mock.web.vo;

public class ResponseVo {
	private Boolean success = Boolean.TRUE;
	private String errorCode;
	private String errorMsg;
	public Boolean getSuccess() {
		return success;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	public static ResponseVo getSuccessResponse() {
		return new ResponseVo();
	}
	
	public static ResponseVo getFailureResponse(String errorCode, String errorMsg) {
		ResponseVo vo = new ResponseVo();
		vo.setSuccess(Boolean.FALSE);
		vo.setErrorCode(errorCode);
		vo.setErrorMsg(errorMsg);
		return vo;
	}
}
