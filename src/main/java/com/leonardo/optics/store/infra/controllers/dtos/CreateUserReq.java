package com.leonardo.optics.store.infra.controllers.dtos;

import com.leonardo.optics.store.infra.constants.Roles;

public record CreateUserReq(
    String firstName,
    String lastName,
    String password,
    String email,
    String cep,
    String address,
    String telephone,
    String cpf,
    Roles role
) {
}
