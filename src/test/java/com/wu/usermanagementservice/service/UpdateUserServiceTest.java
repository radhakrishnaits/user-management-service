package com.wu.usermanagementservice.service;

import com.wu.usermanagement.entity.Users;
import com.wu.usermanagement.model.UpdateUserRequest;
import com.wu.usermanagement.model.UpdateUserResponse;
import com.wu.usermanagement.repository.UsersRepository;
import com.wu.usermanagement.service.UpdateUserService;
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
public class UpdateUserServiceTest {

    @Mock
    private UsersRepository usersRepository;
    @Mock
    private MessageSource messageSource;

    @InjectMocks
    private UpdateUserService updateUserService;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void testUpdateUserDetails() {
        // Given
        UpdateUserRequest updateUserRequest = CommonBuilder.getUpdateUserRequest();
        Optional<Users> users = Optional.of(CommonBuilder.getUsers());

        // Mock repository behavior
        when(usersRepository.getUserByUserName(anyString())).thenReturn(users);
        UpdateUserResponse updateUserResponse = updateUserService.updateUserInfo(anyString(), updateUserRequest);

        // Then
        assertEquals(HttpStatus.OK.value(), updateUserResponse.getStatus());
        verify(this.usersRepository).getUserByUserName(anyString());
    }
}
