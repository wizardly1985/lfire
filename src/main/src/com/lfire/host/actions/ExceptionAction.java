package com.lfire.host.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;
@ParentPackage("json-default")
@Namespace("/")  
@Action(value="error") 
@Results({
	@Result(name="error",location="/WEB-INF/demo/error.jsp"),
	
})
public class ExceptionAction extends ActionSupport{

	public String errorMsg;
	public String errorCode;
	
	public String error(){
		return "error";
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
	
}
