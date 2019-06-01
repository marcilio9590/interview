package com.spring.boot.interview.common;

public class InvalidFieldException extends Exception {

	private static final long serialVersionUID = -8071330776903394204L;

	public InvalidFieldException(String message, Object... args) {
		this(String.format(message, args));
	}

	public InvalidFieldException(String message) {
		super(message);
	}

	public InvalidFieldException(Throwable cause) {
		super(cause);
	}

	public InvalidFieldException() {
		super();
	}
}