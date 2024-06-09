package com.leonardo.optics.store.domain;

import com.leonardo.optics.store.infra.constants.Roles;

public record UserDomain(
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
