package com.wu.usermanagementservice.service;

import com.wu.usermanagement.common.ApplicationException;
import com.wu.usermanagement.entity.UserCards;
import com.wu.usermanagement.entity.Users;
import com.wu.usermanagement.model.DeleteUserCardResponse;
import com.wu.usermanagement.repository.UserCardsRepository;
import com.wu.usermanagement.repository.UsersRepository;
import com.wu.usermanagement.service.DeleteUserCardService;
import com.wu.usermanagementservice.common.CommonBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DeleteUserCardServiceTest {

    @Mock
    UsersRepository usersRepository;
    @Mock
    UserCardsRepository userCardsRepository;
    @Mock
    MessageSource messageSource;

    @InjectMocks
    private DeleteUserCardService deleteUserCardService;
    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void testDeleteUserCardSuccess() {
        // Given
        Set<UserCards> userCards = CommonBuilder.getUsersCardList();
        List<UserCards> userCardsList = new ArrayList<>(userCards);
        Optional<Users> users = Optional.of(CommonBuilder.getUsers());
        when(usersRepository.getUserByUserName(anyString())).thenReturn(users);
        when(userCardsRepository.getUserCards(users.get().getUserId())).thenReturn((userCardsList));

        // Mock repos
        DeleteUserCardResponse response = deleteUserCardService.deleteUserCard(anyString(),4321432143214321L);

        // Then
        assertEquals(HttpStatus.NO_CONTENT.value(), response.getStatus());
    }

    @Test(expected = ApplicationException.class)
    public void testDeleteUserCardCardNotFound() {
        // Given
        Set<UserCards> userCards = CommonBuilder.getUsersCardList();
        List<UserCards> userCardsList = new ArrayList<>(userCards);
        Optional<Users> users = Optional.of(CommonBuilder.getUsers());
        when(usersRepository.getUserByUserName(anyString())).thenReturn(users);
        when(userCardsRepository.getUserCards(users.get().getUserId())).thenReturn((userCardsList));

        // Mock repos
        DeleteUserCardResponse response = deleteUserCardService.deleteUserCard(anyString(),4327815317531735L);

    }
}