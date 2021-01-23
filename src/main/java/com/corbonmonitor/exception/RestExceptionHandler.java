package com.corbonmonitor.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.corbonmonitor.type.ResponseHeader;

@ControllerAdvice
public class RestExceptionHandler {
	@ExceptionHandler(DateFormatException.class)
	   protected ResponseEntity<ResponseHeader> handleDateFormat(DateFormatException ex) {
		   ResponseHeader apiError = new ResponseHeader();
		   apiError.setResult_code(HttpStatus.BAD_REQUEST.toString());
	       apiError.setMessage(ex.getMessage());
	       return ResponseEntity.badRequest().body(apiError);
	   }
}
