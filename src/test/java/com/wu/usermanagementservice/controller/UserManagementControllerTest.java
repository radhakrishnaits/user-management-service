package com.wu.usermanagementservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wu.usermanagement.common.Constants;
import com.wu.usermanagement.controller.UserManagementController;
import com.wu.usermanagement.model.Message;
import com.wu.usermanagement.model.SignUpRequest;
import com.wu.usermanagement.model.SignUpResponse;
import com.wu.usermanagement.service.SignUpUserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Locale;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserManagementController.class)
@SpringBootTest
public class UserManagementControllerTest {

    private MockMvc mockMvc;

    @Mock
    private SignUpUserService signUpUserService;

    @Mock
    private MessageSource messageSource;

    @InjectMocks
    private UserManagementController userManagementController;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userManagementController).build();
    }

    @Test
    public void user_Sign_In_Positive_Test() throws Exception {

        SignUpRequest signUpRequest=new SignUpRequest();
        signUpRequest.setEmail("sathya@gmail.com");
        signUpRequest.setPassword("123");
        signUpRequest.setWishToAddCard("N");
        SignUpResponse signUpResponse=new SignUpResponse();
        signUpResponse.setStatus(HttpStatus.CREATED.value());
        signUpResponse.setMessage(new Message(Constants.SUCCESS.getStrValue(),
                messageSource.getMessage(Constants.USER_REGISTER_SUCCES.getStrValue(), null, Locale.ENGLISH)));
        when(signUpUserService.registerUser(signUpRequest)).thenReturn(signUpResponse);

        mockMvc.perform(MockMvcRequestBuilders.post("/user-management/v1/signup")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(signUpRequest)))
                .andExpect(status().isOk());

    }

}
