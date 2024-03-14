package com.example.personal.Boot;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class CustomExceptionHandler {

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
