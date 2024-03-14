package com.example.personal.Controller.Main;

import com.example.personal.BaseController.BaseController;
import com.example.personal.Boot.CustomException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public abstract class MainApiController extends BaseController {

    /*
     * Exception throw to Custom Exception Object
     * Confirm : Postman (http://host/main/customError.action)
     **/
	@PostMapping("customError.action")
	public ResponseEntity<Object> testError() {
		try {
			throw new CustomException(HttpStatus.UNAUTHORIZED, "Detail Error Code");
		} catch(CustomException e){
			throw new CustomException(e);
		}
	}
}
