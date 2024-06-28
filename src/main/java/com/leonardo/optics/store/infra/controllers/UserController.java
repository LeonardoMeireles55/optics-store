package com.leonardo.optics.store.infra.controllers;

import com.leonardo.optics.store.application.usecases.CreateUserInteractor;
import com.leonardo.optics.store.application.usecases.ReturnUserByIdInteractor;
import com.leonardo.optics.store.domain.UserDomain;
import com.leonardo.optics.store.infra.controllers.dtos.CreateUserReq;
import com.leonardo.optics.store.infra.controllers.dtos.DefaultUserResp;
import com.leonardo.optics.store.infra.controllers.dtos.ReturnUserByIdReq;
import com.leonardo.optics.store.infra.controllers.mapper.UserDTOMapper;

import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
@Validated
public class UserController {
    private final CreateUserInteractor createUserUseCase;
    private final ReturnUserByIdInteractor returnUserByIdInteractor;
    private final UserDTOMapper userDTOMapper;

    public UserController(CreateUserInteractor createUserUseCase,
    ReturnUserByIdInteractor returnUserByIdInteractor,
     UserDTOMapper userDTOMapper) {
        this.createUserUseCase = createUserUseCase;
        this.returnUserByIdInteractor = returnUserByIdInteractor;
        this.userDTOMapper = userDTOMapper;
    }

    @PostMapping
    public DefaultUserResp createUser(@Valid @RequestBody CreateUserReq request) {
        UserDomain userDomain = userDTOMapper.toUser(request);

        UserDomain userCreated = createUserUseCase.createUser(userDomain);

        return userDTOMapper.toResponse(userCreated);
    }

    @GetMapping
    public DefaultUserResp getUserById(@RequestParam ReturnUserByIdReq req) {
        UserDomain user = returnUserByIdInteractor.getUserById(req.id());

        return userDTOMapper.toResponse(user);
    }

}
