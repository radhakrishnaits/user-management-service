package com.wu.usermanagement.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BadCredentialException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger LOGGER=LoggerFactory.getLogger(BadCredentialException.class);
	
	private String errorCode=null;
	private String  fieldName=null;
	public BadCredentialException(String errorCode, String fieldName) {
		super();
		this.errorCode = errorCode;
		this.fieldName = fieldName;
		LOGGER.error(errorCode);
	}


}
