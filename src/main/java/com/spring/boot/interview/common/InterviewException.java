package com.spring.boot.interview.common;

public class InterviewException extends Exception {

	private static final long serialVersionUID = -8071330776903394204L;

	public InterviewException(String message, Object... args) {
		this(String.format(message, args));
	}

	public InterviewException(String message) {
		super(message);
	}

	public InterviewException(Throwable cause) {
		super(cause);
	}

	public InterviewException() {
		super();
	}
}