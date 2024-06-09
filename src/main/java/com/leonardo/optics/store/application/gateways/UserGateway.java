package com.leonardo.optics.store.application.gateways;

import com.leonardo.optics.store.domain.UserDomain;

public interface UserGateway {
    UserDomain createUser(UserDomain userDomain);
    UserDomain returnUserById(Long id);
}
