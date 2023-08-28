package com.wu.usermanagement.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateBeneficiaryRequest extends BaseRequest{
	    private String firstName;
	    private String lastName;
	    private String country;
	    private String bankAccountNumber;
	    private String iban;
		private String mobileNumber;

}
