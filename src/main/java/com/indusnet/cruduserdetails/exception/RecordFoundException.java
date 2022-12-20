package com.indusnet.cruduserdetails.exception;

public class RecordFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	public RecordFoundException(String msg) {
		super(msg);
	}
}
