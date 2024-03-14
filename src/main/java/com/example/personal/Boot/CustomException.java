package com.example.personal.Boot;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

@Getter
public class CustomException extends RuntimeException {
	private final HttpStatus httpStatus;

	private final String detail;

	public CustomException(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
		this.detail = "";
	}

	public CustomException(HttpStatus httpStatus, String detail) {
		this.httpStatus = httpStatus;
		this.detail = detail;
	}

	public CustomException(HttpStatus httpStatus, Throwable cause) {
		this.httpStatus = httpStatus;
		this.detail = cause.getMessage();
	}

	public CustomException(HttpStatus httpStatus, CustomException customException) {
		this.httpStatus = httpStatus;
		this.detail = customException.detail;
	}

	public CustomException(Exception exception) {
		if(exception.getClass().equals(CustomException.class)) {
			CustomException customException = (CustomException) exception;
			this.httpStatus = customException.httpStatus;
			this.detail = customException.detail;
		} else {
			this.httpStatus = HttpStatus.BAD_REQUEST;
			this.detail = exception.getMessage();
		}
	}
}
