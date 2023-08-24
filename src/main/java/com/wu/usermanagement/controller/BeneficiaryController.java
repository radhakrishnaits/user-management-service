package com.wu.usermanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wu.usermanagement.entity.Beneficiary;
import com.wu.usermanagement.model.BeneficiaryListResponse;
import com.wu.usermanagement.model.BeneficiaryResponse;
import com.wu.usermanagement.model.DeleteBeneficiaryResponse;
import com.wu.usermanagement.service.BeneficiaryService;

@RestController
@RequestMapping("/beneficiary/v1")
public class BeneficiaryController {

    @Autowired
    private BeneficiaryService service;

    @GetMapping("/all")
    public BeneficiaryListResponse getAll(){
        return service.getAll();
    }

    @PostMapping("/new")
    public BeneficiaryResponse addBen(@RequestBody Beneficiary beneficiary){
        return service.addBeneficiary(beneficiary);
    }

    @PutMapping("/update")
    public BeneficiaryResponse updateBen(@RequestBody Beneficiary beneficiary){
        return service.addBeneficiary(beneficiary);
    }

    @DeleteMapping("/delete/{id}")
    public DeleteBeneficiaryResponse deleteBen(@PathVariable Long id){
        BeneficiaryResponse beneficiary = service.getById(id);
        return service.deleteBeneficiary(beneficiary.getBeneficiary());
    }
}
