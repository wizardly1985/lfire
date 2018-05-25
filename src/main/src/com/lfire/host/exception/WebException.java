package com.lfire.host.exception;

import com.lfire.host.utils.HttpRequest;

public class WebException extends Exception {

	private String errorCode;
	private String errorMsg;
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public WebException(String errorCode, String errorMsg) {
		super();
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
		String str = HttpRequest.sendPost("http://localhost:8080/lfire/ExceptionAction", "errorCode=123&errorMsg=456");
		System.out.println(str);
	}
	
}
