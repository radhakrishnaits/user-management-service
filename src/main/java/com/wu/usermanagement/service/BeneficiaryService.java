package com.wu.usermanagement.service;

import com.wu.usermanagement.entity.Beneficiary;
import com.wu.usermanagement.repository.BeneficiaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeneficiaryService {

    @Autowired
    private BeneficiaryRepository repository;

    public List<Beneficiary> getAll(){
        return repository.findAll();
    }

    public Beneficiary addBeneficiary(Beneficiary beneficiary){
        return repository.save(beneficiary);
    }

    public Beneficiary getById(Long id){
        return repository.findById(id).get();
    }

    public void deleteBeneficiary(Beneficiary beneficiary){
        repository.delete(beneficiary);
    }
}
