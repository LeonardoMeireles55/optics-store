package com.leonardo.optics.store.infra.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.leonardo.optics.store.application.usecases.CreateUserInteractor;
import com.leonardo.optics.store.application.usecases.ReturnUserByIdInteractor;
import com.leonardo.optics.store.domain.UserDomain;
import com.leonardo.optics.store.infra.constants.Roles;
import com.leonardo.optics.store.infra.controllers.dtos.CreateUserReq;
import com.leonardo.optics.store.infra.controllers.dtos.DefaultUserResp;
import com.leonardo.optics.store.infra.controllers.mapper.UserDTOMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(UserController.class)
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CreateUserInteractor createUserUseCase;

    @MockBean
    private ReturnUserByIdInteractor returnUserByIdInteractor;

    @MockBean
    private UserDTOMapper userDTOMapper;

    @BeforeEach
    public void setup() {
        when(createUserUseCase.createUser(any(UserDomain.class)))
                .thenAnswer(invocation -> {
                    return invocation.<UserDomain>getArgument(0);
                });

        when(returnUserByIdInteractor.getUserById(any(Long.class)))
                .thenReturn(new UserDomain(
                        "John",
                        "Doe",
                        "password123",
                        "john.doe@example.com",
                        "12345-678",
                        "123 Main St",
                        "(12) 34567-8901",
                        "123.456.789-10",
                        Roles.USER,
                        null
                ));

        when(userDTOMapper.toUser(any(CreateUserReq.class)))
                .thenReturn(new UserDomain(
                        "John",
                        "Doe",
                        "password123",
                        "john.doe@example.com",
                        "12345-678",
                        "123 Main St",
                        "(12) 34567-8901",
                        "123.456.789-10",
                        Roles.USER,
                        null
                ));

        when(userDTOMapper.toResponse(any(UserDomain.class)))
                .thenReturn(new DefaultUserResp(
                        "John",
                        "Doe",
                        "john.doe@example.com",
                        "12345-678",
                        "123 Main St",
                        "(12) 34567-8901",
                        "123.456.789-10",
                        Roles.USER
                ));
    }

    @Test
    public void testCreateUser() throws Exception {
        CreateUserReq request = new CreateUserReq(
                "John",
                "Doe",
                "password123",
                "john.doe@example.com",
                "12345-678",
                "123 Main St",
                "(12) 34567-8901",
                "123.456.789-10",
                Roles.USER,
                null
        );

        mockMvc.perform(MockMvcRequestBuilders.post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(request)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value("John"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.lastName").value("Doe"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("john.doe@example.com"));
    }

    @Test
    public void testGetUserById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users?id=1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value("John"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.lastName").value("Doe"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("john.doe@example.com"));
    }

    private String asJsonString(Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
