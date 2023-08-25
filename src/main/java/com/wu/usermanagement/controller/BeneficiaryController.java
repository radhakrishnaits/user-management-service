package com.wu.usermanagement.controller;

import com.wu.usermanagement.model.TransactionHistoryResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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

@Tag(name = "beneficiary-management", description = "beneficiary-management APIs")
@RestController
@RequestMapping("/beneficiary/v1")
public class BeneficiaryController {

    @Autowired
    private BeneficiaryService service;

    @Operation(
            summary = "get All Beneficiary",
            description = "get All Beneficiary",
            tags = { "BeneficiaryList", "List out all Beneficiary data" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = BeneficiaryListResponse.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @GetMapping("/all")
    public BeneficiaryListResponse getAll(){
        return service.getAll();
    }


    @Operation(
            summary = "Create new Beneficiary",
            description = "Create new Beneficiary",
            tags = { "create new Beneficiary", "add new Beneficiary" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = BeneficiaryResponse.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @PostMapping("/new")
    public BeneficiaryResponse addBen(@RequestBody Beneficiary beneficiary){
        return service.addBeneficiary(beneficiary);
    }

    @Operation(
            summary = "update Beneficiary",
            description = "update Beneficiary",
            tags = { "update Beneficiary", "update Beneficiary" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = BeneficiaryResponse.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @PutMapping("/update")
    public BeneficiaryResponse updateBen(@RequestBody Beneficiary beneficiary){
        return service.addBeneficiary(beneficiary);
    }

    @Operation(
            summary = "delete Beneficiary",
            description = "delete Beneficiary",
            tags = { "delete Beneficiary", "delete Beneficiary" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = DeleteBeneficiaryResponse.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @DeleteMapping("/delete/{id}")
    public DeleteBeneficiaryResponse deleteBen(@PathVariable Long id){
        BeneficiaryResponse beneficiary = service.getById(id);
        return service.deleteBeneficiary(beneficiary.getBeneficiary());
    }
}
