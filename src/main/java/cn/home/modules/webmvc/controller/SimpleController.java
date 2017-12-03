package cn.home.modules.webmvc.controller;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Controller
public class SimpleController {
	// @RequestMapping methods omitted ...

	/**
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(IOException.class)
	public ResponseEntity<String> handleIOException(IOException ex) {
		ResponseEntity<String> responseEntity = null;
		// prepare responseEntity
		return responseEntity;
	}

}
