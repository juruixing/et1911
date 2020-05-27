package com.etoak.exception;

public class LoginException extends RuntimeException {

	/**
	 * 登录异常
	 */
	private static final long serialVersionUID = 1L;
	
	public LoginException(String message) {
		super(message);
	}
}
