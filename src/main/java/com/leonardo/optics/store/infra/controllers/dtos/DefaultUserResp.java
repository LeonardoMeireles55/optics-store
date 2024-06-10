package com.leonardo.optics.store.infra.controllers.dtos;

import com.leonardo.optics.store.infra.constants.Roles;

public record DefaultUserResp(
        String firstName,
        String lastName,
        String email,
        String cep,
        String address,
        String telephone,
        String cpf,
        Roles role
) {
}
