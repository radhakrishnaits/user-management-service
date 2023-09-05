package com.wu.usermanagementservice.service;

import com.wu.usermanagement.entity.UserCards;
import com.wu.usermanagement.entity.Users;
import com.wu.usermanagement.model.AddUserCardRequest;
import com.wu.usermanagement.model.AddUserCardResponse;
import com.wu.usermanagement.repository.UserCardsRepository;
import com.wu.usermanagement.repository.UsersRepository;
import com.wu.usermanagement.service.AddUserCardService;
import com.wu.usermanagementservice.common.CommonBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AddUserCardServiceTest {

    @Mock
    private UsersRepository usersRepository;

    @Mock
    private UserCardsRepository userCardsRepository;

    @Mock
    private MessageSource messageSource;

    @InjectMocks
    private AddUserCardService addUserCardService;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void testAddUserCardDetails() {
        //Given
        Users user = CommonBuilder.getUsers();
        UserCards userCards = CommonBuilder.getUsersCard();
        String cardNumber = String.valueOf(userCards.getCardNumber());
        Set<UserCards> cardsSet = CommonBuilder.getUsersCardList();
        List<UserCards> cardsList = new ArrayList<>(cardsSet);
        AddUserCardRequest addUserCardRequest = CommonBuilder.addUserCardRequest();

        //When
        when(userCardsRepository.getUserCards(anyLong())).thenReturn(cardsList);
        AddUserCardResponse addUserCardResponse = addUserCardService.addUserCard("abcd@abcd.com",addUserCardRequest);

        //Then
        Assertions.assertNotNull(cardsList);
        Assertions.assertTrue(cardsList.isEmpty());
        Assertions.assertTrue(cardNumber != null && cardNumber.matches("\\d{16}"));
        assertEquals(HttpStatus.OK.value(),addUserCardResponse.getStatus());

    }
}
