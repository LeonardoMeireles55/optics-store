package com.leonardo.optics.store.infra.controllers;

import com.leonardo.optics.store.application.usecases.CreateUserInteractor;
import com.leonardo.optics.store.domain.UserDomain;
import com.leonardo.optics.store.infra.controllers.dtos.CreateUserReq;
import com.leonardo.optics.store.infra.controllers.dtos.CreateUserResp;
import com.leonardo.optics.store.infra.controllers.mapper.UserDTOMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController {
    private final CreateUserInteractor createUserUseCase;
    private final UserDTOMapper userDTOMapper;

    public UserController(CreateUserInteractor createUserUseCase, UserDTOMapper userDTOMapper) {
        this.createUserUseCase = createUserUseCase;
        this.userDTOMapper = userDTOMapper;
    }

    @PostMapping
    public CreateUserResp createUser(@RequestBody CreateUserReq request) {
        UserDomain userDomain = userDTOMapper.toUser(request);

        UserDomain userCreated = createUserUseCase.createUser(userDomain);

        return userDTOMapper.toResponse(userCreated);
    }
}
