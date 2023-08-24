package com.wu.usermanagement.service;

import com.wu.usermanagement.common.ApplicationException;
import com.wu.usermanagement.entity.Beneficiary;
import com.wu.usermanagement.model.*;
import com.wu.usermanagement.repository.BeneficiaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class BeneficiaryService extends CommonService {

    @Autowired
    private BeneficiaryRepository repository;

    BeneficiaryResponse beneficiaryResponse;
    BeneficiaryListResponse beneficiaryListResponse;
    DeleteBeneficiaryResponse deleteBeneficiaryResponse;
    List<Beneficiary> beneficiaryList;
    Beneficiary beneficiary;
    @Autowired
    private MessageSource messageSource;

    public BeneficiaryListResponse getAll(){

        beneficiaryList = repository.findAll();
        if(beneficiaryList.isEmpty()) {
            throw new ApplicationException("records.not.exists", "userName");
        }
        return createResponse();
    }

    public BeneficiaryResponse addBeneficiary(Beneficiary beneficiary){
        if(beneficiary==null){
            throw new ApplicationException("beneficiary.data.null", "userName");
        }
        beneficiary = repository.save(beneficiary);
        return createResponse(beneficiary);
    }

    public BeneficiaryResponse getById(Long id){
        if(id==null){
            throw new ApplicationException("beneficiary.id.null", "userName");
        }
        Beneficiary ben = repository.findById(id).get();
        if(ben==null){
            throw new ApplicationException("beneficiary.data.null", "userName");
        }
        return createResponse(ben);
    }

    public DeleteBeneficiaryResponse deleteBeneficiary(Beneficiary beneficiary){
        if(beneficiary==null){
            throw new ApplicationException("beneficiary.data.null", "userName");
        }
        repository.delete(beneficiary);
        return deleteResponse();
    }

    public BeneficiaryResponse createResponse(Beneficiary beneficiary) {
        beneficiaryResponse=new BeneficiaryResponse();
        beneficiaryResponse.setBeneficiary(beneficiary);
        beneficiaryResponse.setStatus(HttpStatus.OK.value());
        beneficiaryResponse.setMessage(new Message("200",  messageSource.getMessage("api.success",
                null, Locale.ENGLISH)));
        return beneficiaryResponse;
    }

    @Override
    public BeneficiaryListResponse createResponse() {
        beneficiaryListResponse=new BeneficiaryListResponse();
        beneficiaryListResponse.setBeneficiaryList(beneficiaryList);
        beneficiaryListResponse.setStatus(HttpStatus.OK.value());
        beneficiaryListResponse.setMessage(new Message("200",  messageSource.getMessage("api.success",
                null, Locale.ENGLISH)));
        return beneficiaryListResponse;
    }

    public DeleteBeneficiaryResponse deleteResponse() {
        deleteBeneficiaryResponse=new DeleteBeneficiaryResponse();
        deleteBeneficiaryResponse.setStatus(HttpStatus.OK.value());
        deleteBeneficiaryResponse.setMessage(new Message("200",  messageSource.getMessage("beneficiary.deleted",
                null, Locale.ENGLISH)));
        return deleteBeneficiaryResponse;
    }

}
