package com.spring.boot.interview.common;

import org.springframework.http.HttpStatus;

public class InterviewException extends Exception implements IInterviewException {

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

	@Override
	public HttpStatus getStatus() {
		return HttpStatus.NO_CONTENT;
	}

	@Override
	public Boolean mustShowThrowable() {
		return Boolean.TRUE;
	}
}