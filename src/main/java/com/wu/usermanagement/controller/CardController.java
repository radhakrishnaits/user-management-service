package com.wu.usermanagement.controller;

import com.wu.usermanagement.entity.Card;
import com.wu.usermanagement.model.AddCardResponse;
import com.wu.usermanagement.repository.CardRepository;
import com.wu.usermanagement.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/card/v1/")
public class CardController {
    @Autowired
    private CardService cardService;

    @Autowired
    private CardRepository repository;

    @PostMapping("/add")
    public AddCardResponse addCard(@RequestBody Card card){
        return cardService.addCard(card);
    }
    @DeleteMapping("/delete/{cardId}")
    public String deleteCard(@PathVariable int cardId){
        Card card = repository.getById(cardId);
        cardService.deleteCard(card);
        return "Successfully deleted!";
    }
}