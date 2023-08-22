package com.wu.usermanagement.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.wu.usermanagement.model.Errors;
@ControllerAdvice
public class GlobalExceptionHandler {
	 @ExceptionHandler(Exception.class)
	  public ResponseEntity<Errors> handleException(Exception e) {
	    Errors error = new Errors("GENERIC_ERROR","", e.getMessage());
	    return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	  }
	 
	 @ExceptionHandler(ApplicationException.class)
	  public ResponseEntity<Errors> handleApplicationException(ApplicationException e) {
	    Errors error = new Errors("GENERIC_ERROR","", e.getMessage());
	    return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	  }
}
