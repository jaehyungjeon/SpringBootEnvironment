package com.example.personal.Controller.Main;

import com.example.personal.BaseController.BaseController;
import com.example.personal.Boot.CustomException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public abstract class MainApiController extends BaseController {

	/*
	 * 작성일 : 2024.03.11
	 * 내 용 : CUSTOM ERROR 결과 확인
	 * Exception throw to Custom Exception Object
	 * Confirm : Postman (http://host/main/customError.action)
	 **/
	@PostMapping("customError.action")
	public ResponseEntity<Object> customErrorEntity() {
		try {
			throw new CustomException(HttpStatus.UNAUTHORIZED, "Detail Error Code");
		} catch(CustomException e){
			throw new CustomException(e);
		}
	}
}
