package com.indusnet.cruduserdetails.exception;

public class UserDetailsExceptionHandler extends RuntimeException {
	private static final long serialVersionUID = 1L;
	public UserDetailsExceptionHandler(String msg) {
		super(msg);
	}
}
