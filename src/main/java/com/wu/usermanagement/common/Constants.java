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
	SUCCESS_MESSAGE("api.success"),

	DUPLICATE_USER("user.duplicate"),
	USER_LOGIN_FAIL("usermanagemt.user.login.fail"),
	USER_LOGIN_SUCCES("usermanagemt.user.login.success"),
	USER_LOGOUT_SUCCES("usermanagemt.user.logout.success"),
	USER_REGISTER_SUCCES("usermanagemt.user.registred.success"),
	 USER_MODIFIED("usermanagemt.user.modified.success"),
	 USER_ADD_BENE_NICK_NAME_NOT_UNIQUE("user.add.beneficiary.nickname.not.unique"),
	 USER_BENE_NOT_FOUND("user.beneficiary.not.found"),
	 USER_ADD_BENEFICIARY_SUCCES("usermanagemt.user.add.beneficiary.success"),
	 USER_UPDATE_BENEFICIARY_SUCCES("usermanagemt.user.update.beneficiary.success"),
	 USER_DELETE_BENEFICIARY_SUCCES("usermanagemt.user.delete.beneficiary.success"),
	 USER_CARD_ALREADY_EXISTS("usermanagemt.user.card.already.exists"),
	 USER_CARD_ADDED_SUCCESS("usermanagemt.user.card.added.success"),
	 USER_CARD_DELETED_SUCCESS("usermanagemt.user.card.deleted.success"),
	INVALID_CARD("invalid.card"),
	EMAIL_INVALID("E4012"),
	INVALID_EMAIL_MESSAGE("email.Invalid"),
    CARD_ADDED_SUCCESS("card.success"),
	CARD_NOT_FOUND_MESSAGE("card.not.found");
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
