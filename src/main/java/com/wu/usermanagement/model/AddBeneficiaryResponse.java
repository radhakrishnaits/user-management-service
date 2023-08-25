package com.wu.usermanagement.model;

import com.wu.usermanagement.dto.BeneficiaryDto;

import lombok.Getter;
import lombok.Setter;

/**
 * Sets the beneficiary dto.
 *
 * @param beneficiaryDto the new beneficiary dto
 */
@Setter

/**
 * Gets the beneficiary dto.
 *
 * @return the beneficiary dto
 */
@Getter
public class AddBeneficiaryResponse extends BaseResponse{
    
    /** The beneficiary dto. */
    private BeneficiaryDto beneficiaryDto;
}
