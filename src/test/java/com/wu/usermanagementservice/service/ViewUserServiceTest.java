package com.wu.usermanagementservice.service;

import com.wu.usermanagement.entity.Users;
import com.wu.usermanagement.model.ViewUserResponse;
import com.wu.usermanagement.repository.UsersRepository;
import com.wu.usermanagement.service.ViewUserService;
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

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ViewUserServiceTest {
    @Mock
    private UsersRepository usersRepository;

    @Mock
    private MessageSource messageSource;

    @InjectMocks
    private ViewUserService viewUserService;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void testViewUserDetails() {
        //Given
        Users users = CommonBuilder.getUsers();

        // When calling the mocked repository method
        when(usersRepository.getUserByUserName(anyString())).thenReturn(Optional.of(users));
        ViewUserResponse viewUserresponse = viewUserService.getUserByUsername(anyString());

        // Then
        assertEquals(HttpStatus.OK.value(),viewUserresponse.getStatus());
        assertEquals(users.getEmail(),viewUserresponse.getUserDetails().getEmail());
        verify(this.usersRepository).getUserByUserName("");
    }
}