package com.example.personal.Boot;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class CustomExceptionHandler {

	/*
	 * 작성일 : 2024.03.07
	 * 내 용 : CUSTOM EXCEPTION
	 * 상속받아 사용 시, 포스트맨으로 ENTITY 값 확인하기 위함.
	 **/
	@ExceptionHandler(CustomException.class)
	protected ResponseEntity<Object> handleCustomException(CustomException e) {
		Map<String, String> map = new HashMap<>();
		map.put("HttpStatus", e.getHttpStatus().toString());
		map.put("Message", e.getDetail());

		return ResponseEntity
				.status(e.getHttpStatus())
                .body(map);
    }
}
