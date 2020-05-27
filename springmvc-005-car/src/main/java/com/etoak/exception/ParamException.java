package com.etoak.exception;


public class ParamException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ParamException(String message) {
		super(message);//调用父类的构造方法
	}
}
