package com.wu.usermanagement.model;

import com.wu.usermanagement.dto.BeneficiaryDto;
import lombok.Getter;
import lombok.Setter;

/**
 * Sets the beneficiaries.
 *
 */
@Setter

/**
 * Gets the beneficiary.
 *
 * @return the beneficiary
 */
@Getter
public class ViewUserBeneficiaryByNickNameResponse extends BaseResponse{

    /** The beneficiaries. */
    private BeneficiaryDto beneficiary;

}
