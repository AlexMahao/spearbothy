package com.spearbothy.response;

import com.spearbothy.exception.BaseException;

/**
 * 结果响应
 * 
 * @author alex_mahao
 * @param <T>
 */
public class ResultResponse<T> {

	private String code;

	private String msg;

	private T data;

	/**
	 * 设置toast消息
	 * 
	 * @param msg
	 */
	public void setToastMsg(String msg) {
		this.code = Code.TOAST_MESSAGE;
		this.msg = msg;
	}

	public void setSuccessDate(T date) {
		this.data = date;
		this.msg = "请求成功";
		this.code = Code.SUCCESS;

	}

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

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public void setToastMsg(Exception e) {
		this.code = Code.TOAST_MESSAGE;
		this.msg = e.getMessage();		
	}

}
