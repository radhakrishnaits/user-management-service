package com.wu.usermanagement.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Errors {
	private String errorCode;
	private String fieldName;
	private String errorMessage;
	public Errors(String errorCode, String fieldName, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.fieldName = fieldName;
		this.errorMessage = errorMessage;
	}
	
}
