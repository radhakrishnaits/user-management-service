package com.wu.usermanagement.service;

import com.wu.usermanagement.common.ApplicationException;
import com.wu.usermanagement.common.Constants;

import com.wu.usermanagement.entity.Card;
import com.wu.usermanagement.model.AddCardResponse;
import com.wu.usermanagement.model.DeleteCardResponse;
import com.wu.usermanagement.model.Errors;
import com.wu.usermanagement.model.Message;
import com.wu.usermanagement.repository.CardRepository;
import com.wu.usermanagement.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Objects;

@Service
public class CardService extends CommonService {

    @Autowired
    private CardRepository repository;
    @Autowired
    private UsersRepository usersRepository;
    private AddCardResponse addCardResponse;

    private DeleteCardResponse DeleteCardResponse;

    @Autowired
    private MessageSource messageSource;

    public AddCardResponse addCard(Card card){

        if(card==null)
        {
            throw new ApplicationException(Constants.NO_RECORDS_EXISTS.getStrValue(), card.getNameOnCard());
        }
        repository.save(card);
        return createAddCardResponse();
    }

    public DeleteCardResponse deleteCard(Card card) {

        if(card.getCardNumber()==null)
        {
            throw new ApplicationException(Constants.USER_NOT_FOUND.getStrValue(), card.getNameOnCard());
        }
        else if(Objects.equals(card.getStatus(), "n"))
        {
            throw new ApplicationException(Constants.INACTIVE_STATUS.getStrValue(), card.getNameOnCard());
        }
        repository.delete(card);
        return createResponse();
    }
    @Override
    public DeleteCardResponse createResponse() {
        DeleteCardResponse=new DeleteCardResponse();
        DeleteCardResponse.setStatus(HttpStatus.NOT_FOUND.value());
        DeleteCardResponse.setMessage(new Message(Constants.USER_NOT_FOUND.getStrValue(),  messageSource.getMessage(Constants.USER_NOT_FOUND.getStrValue(),
                null, Locale.ENGLISH)));
        return DeleteCardResponse;
    }


    public AddCardResponse createAddCardResponse() {
        addCardResponse = new AddCardResponse();
        addCardResponse.setStatus(HttpStatus.OK.value());
        addCardResponse.setMessage(new Message(Constants.SUCCESS.getStrValue(),  messageSource.getMessage(Constants.SUCCESS_MESSAGE.getStrValue(),
                null, Locale.ENGLISH)));
        return addCardResponse;
    }
}