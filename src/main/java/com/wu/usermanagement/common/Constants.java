package com.wu.usermanagement.common;

import lombok.Getter;

/**
 * Gets the int value.
 *
 * @return the int value
 */
@Getter
public enum Constants {

	/** The active status. */
	ACTIVE_STATUS("Y"), 
	
	/** The inactive status. */
	INACTIVE_STATUS("N"),
	
	/** The success. */
	SUCCESS("200"),
	
	/** The user not found. */
	USER_NOT_FOUND("user.not.found"),
	
	/** The no records exists. */
	NO_RECORDS_EXISTS("records.not.exists"),
	
	/** The success message. */
	SUCCESS_MESSAGE("api.success");


	/** The str value. */
	String strValue;
	
	/** The int value. */
	int intValue;

	/**
	 * Instantiates a new constants.
	 *
	 * @param strValue the str value
	 */
	private Constants(String strValue) {
		this.strValue = strValue;
	}

	/**
	 * Instantiates a new constants.
	 *
	 * @param intValue the int value
	 */
	private Constants(int intValue) {
		this.intValue = intValue;
	}

}
