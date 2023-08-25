package com.wu.usermanagement.model;

import java.util.List;

import com.wu.usermanagement.dto.BeneficiaryDto;

import lombok.Getter;
import lombok.Setter;

/**
 * Sets the beneficiaries.
 *
 * @param beneficiaries the new beneficiaries
 */
@Setter

/**
 * Gets the beneficiaries.
 *
 * @return the beneficiaries
 */
@Getter
public class ViewUserBeneficiaryResponse extends BaseResponse{

    /** The beneficiaries. */
    private List<BeneficiaryDto> beneficiaries;

}
