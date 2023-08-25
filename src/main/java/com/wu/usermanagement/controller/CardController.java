package com.wu.usermanagement.controller;

import com.wu.usermanagement.entity.Card;
import com.wu.usermanagement.model.AddCardResponse;
import com.wu.usermanagement.model.DeleteBeneficiaryResponse;
import com.wu.usermanagement.repository.CardRepository;
import com.wu.usermanagement.service.CardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Tag(name = "card-management", description = "card-management APIs")
@RestController
@RequestMapping("/card/v1/")
public class CardController {
    @Autowired
    private CardService cardService;

    @Autowired
    private CardRepository repository;

    @Operation(
            summary = "save card based on user wishlist",
            description = "save card based on user wishlist",
            tags = { "save Card details", "save card based on user wishlist" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = AddCardResponse.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @PostMapping("/add")
    public AddCardResponse addCard(@RequestBody Card card){
        return cardService.addCard(card);
    }


    @Operation(
            summary = "delete card details",
            description = "delete card details",
            tags = { "delete card details", "delete card details" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = String.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @DeleteMapping("/delete/{cardId}")
    public String deleteCard(@PathVariable long cardId){
        Card card = repository.getById(cardId);
        cardService.deleteCard(card);
        return "Successfully deleted!";
    }
}