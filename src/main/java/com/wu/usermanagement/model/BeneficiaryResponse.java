package com.wu.usermanagement.model;

import com.wu.usermanagement.entity.Beneficiary;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BeneficiaryResponse extends BaseResponse{

    private Beneficiary beneficiary;
}
