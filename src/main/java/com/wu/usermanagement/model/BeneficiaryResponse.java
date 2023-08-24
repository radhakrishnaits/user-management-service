package com.wu.usermanagement.model;

import com.wu.usermanagement.entity.Beneficiary;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class BeneficiaryResponse extends BaseResponse{

    private Beneficiary beneficiary;
}
