package com.leonardo.optics.store.infra.controllers;

import com.leonardo.optics.store.application.usecases.AddUserDepententsInteractor;
import com.leonardo.optics.store.application.usecases.CreateUserInteractor;
import com.leonardo.optics.store.application.usecases.ReturnUserByIdInteractor;
import com.leonardo.optics.store.domain.UserDomain;
import com.leonardo.optics.store.infra.controllers.dtos.CreateUserReq;
import com.leonardo.optics.store.infra.controllers.dtos.DefaultUserResp;
import com.leonardo.optics.store.infra.controllers.dtos.ReturnUserByIdReq;
import com.leonardo.optics.store.infra.controllers.mapper.UserDTOMapper;

import com.leonardo.optics.store.infra.errorHandling.GlobalErrorHandling;
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
    private final CreateUserInteractor createUserInteractor;

    private final AddUserDepententsInteractor addUserDepententsInteractor;

    private final ReturnUserByIdInteractor returnUserByIdInteractor;
    private final UserDTOMapper userDTOMapper;

    public UserController(CreateUserInteractor createUserUseCase,
                          AddUserDepententsInteractor addDependentsUserCase,
                          ReturnUserByIdInteractor returnUserByIdInteractor,
                          UserDTOMapper userDTOMapper) {
        this.createUserInteractor = createUserUseCase;
        this.addUserDepententsInteractor = addDependentsUserCase;
        this.returnUserByIdInteractor = returnUserByIdInteractor;
        this.userDTOMapper = userDTOMapper;
    }

    @PostMapping
    public DefaultUserResp createUser(@Valid @RequestBody CreateUserReq request) {
        UserDomain userDomain = userDTOMapper.toUser(request);

        UserDomain userCreated = createUserInteractor.createUser(userDomain);

        return userDTOMapper.toResponse(userCreated);
    }

    @PostMapping("/addDependent")
    public void addDependent(@RequestParam Long userId, @RequestParam Long dependentId) {
        addUserDepententsInteractor.addDependents(userId, dependentId);
    }

    @GetMapping
    public DefaultUserResp getUserById(@RequestParam Long id) {
        ReturnUserByIdReq req = new ReturnUserByIdReq(id);
        UserDomain user = returnUserByIdInteractor.getUserById(req.id());
        if (user == null) {
            throw new GlobalErrorHandling.ResourceNotFoundException("User not found");
        }
        return userDTOMapper.toResponse(user);
    }

}
