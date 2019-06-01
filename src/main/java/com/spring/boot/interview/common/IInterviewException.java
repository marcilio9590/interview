package com.spring.boot.interview.common;

import org.springframework.http.HttpStatus;

public interface IInterviewException {
	HttpStatus getStatus();

	String getMessage();

	Boolean mustShowThrowable();
}
