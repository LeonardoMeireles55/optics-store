package com.leonardo.optics.store.infra.controllers.mapper;

import com.leonardo.optics.store.domain.UserDomain;
import com.leonardo.optics.store.infra.controllers.dtos.CreateUserReq;
import com.leonardo.optics.store.infra.controllers.dtos.CreateUserResp;

public class UserDTOMapper {
    public CreateUserResp toResponse(UserDomain user) {
        return new CreateUserResp(
            user.firstName(),
            user.lastName(),
            user.email(),
            user.cep(),
            user.address(),
            user.telephone(),
            user.cpf(),
            user.role()
        );
    }
    public UserDomain toUser(CreateUserReq request) {
        return new UserDomain(request.firstName(), request.lastName(), request.password(),
                request.email(), request.cep(), request.address(), request.telephone(),
                request.cpf(), request.role());
    }
}
