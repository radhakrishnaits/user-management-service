package com.wu.usermanagement.common;

import lombok.Getter;

@Getter
public enum Constants {

	ACTIVE_STATUS("Y"), 
	INACTIVE_STATUS("N");

	String strValue;
	int intValue;

	private Constants(String strValue) {
		this.strValue = strValue;
	}

	private Constants(int intValue) {
		this.intValue = intValue;
	}

}
