package com.wu.usermanagement.controller;

import com.wu.usermanagement.entity.Beneficiary;
import com.wu.usermanagement.service.BeneficiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/beneficiary/v1")
public class BeneficiaryController {

    @Autowired
    private BeneficiaryService service;

    @GetMapping("/all")
    public List<Beneficiary> getAll(){
        return service.getAll();
    }

    @PostMapping("/new")
    public Beneficiary addBen(@RequestBody Beneficiary beneficiary){
        return service.addBeneficiary(beneficiary);
    }

    @PutMapping("/update")
    public Beneficiary updateBen(@RequestBody Beneficiary beneficiary){
        return service.addBeneficiary(beneficiary);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBen(@PathVariable Long id){
        Beneficiary beneficiary = service.getById(id);
        service.deleteBeneficiary(beneficiary);
        return "Successfully deleted!";
    }
}
