package com.wu.usermanagement.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Gets the errors.
 *
 * @return the errors
 */
@Getter

/**
 * Sets the errors.
 *
 * @param errors the new errors
 */
@Setter

/**
 * To string.
 *
 * @return the java.lang. string
 */
@ToString
public class BaseResponse {
	
	/** The status. */
	protected int status;
	
	/** The message. */
	protected Message message;
    
    /** The errors. */
    protected List<Errors> errors;
}
