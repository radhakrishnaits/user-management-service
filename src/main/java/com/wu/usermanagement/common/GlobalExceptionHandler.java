package com.wu.usermanagement.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.wu.usermanagement.model.BaseResponse;
import com.wu.usermanagement.model.Errors;
import com.wu.usermanagement.model.Message;
@ControllerAdvice
public class GlobalExceptionHandler {

	@Autowired
    private MessageSource messageSource;

	private BaseResponse baseResponse;
	private List<Errors> errors;
	 @ExceptionHandler(Exception.class)
	  public ResponseEntity<Errors> handleException(Exception e) {
	    Errors error = new Errors("GENERIC_ERROR","", e.getMessage());
	    return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	  }
	 
	 @ExceptionHandler(ApplicationException.class)
	  public ResponseEntity<BaseResponse> handleApplicationException(ApplicationException e) {
		 baseResponse=new BaseResponse();
		 errors=new ArrayList<>();
		 Errors error = new Errors(HttpStatus.BAD_REQUEST.name(),e.getFieldName(), messageSource.getMessage(e.getErrorCode(),
	                null, Locale.ENGLISH));
		 errors.add(error);
		 baseResponse.setErrors(errors);
		 baseResponse.setStatus(String.valueOf(HttpStatus.BAD_REQUEST.value()));
		 baseResponse.setMessage(new Message(HttpStatus.BAD_REQUEST.name(),  messageSource.getMessage(e.getErrorCode(),
                null, Locale.ENGLISH)));
	    return new ResponseEntity<>(baseResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	  }
}
