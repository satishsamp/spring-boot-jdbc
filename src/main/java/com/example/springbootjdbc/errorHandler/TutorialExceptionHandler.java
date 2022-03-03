package com.example.springbootjdbc.errorHandler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TutorialExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorType> handleException(Exception exc){		
		return new ResponseEntity<ErrorType>(
				new ErrorType(
						new Date(System.currentTimeMillis()).toString(), 
						"500 - Internal Server error", 
						exc.getMessage()), 
				HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
