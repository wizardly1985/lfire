package com.lfire.host.entity;

/**
 * json 返回的数据结构
 * @author Ly
 *
 */
public class JsonBack {

	public String code;
	public String msg;
	public Object data;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
}
