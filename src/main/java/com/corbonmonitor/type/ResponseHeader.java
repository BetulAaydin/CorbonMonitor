package com.corbonmonitor.type;

public class ResponseHeader <T> {
	private String result_code;
	private String message;
	private T contains;
	public String getResult_code() {
		return result_code;
	}
	public void setResult_code(String result_code) {
		this.result_code = result_code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getContains() {
		return contains;
	}
	public void setContains(T contains) {
		this.contains = contains;
	}
	

}
