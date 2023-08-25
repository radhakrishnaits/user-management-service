package com.wu.usermanagement.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateBeneficiaryRequest extends BaseRequest{
	    private String firstName;
	    private String lastName;
	    private String country;
	    private Integer bankAccountNumber;
	    private String iban;

}
