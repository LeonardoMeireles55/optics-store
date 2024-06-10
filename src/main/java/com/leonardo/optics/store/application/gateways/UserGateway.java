package com.leonardo.optics.store.application.gateways;

import com.leonardo.optics.store.domain.UserDomain;

public interface UserGateway {
    UserDomain returnUserById(Long id);
    UserDomain returnUserByEmail(String email);
    UserDomain createUser(UserDomain userDomain);
}
