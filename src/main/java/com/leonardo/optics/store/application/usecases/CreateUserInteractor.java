package com.leonardo.optics.store.application.usecases;

import com.leonardo.optics.store.application.gateways.UserGateway;
import com.leonardo.optics.store.domain.UserDomain;

public class CreateUserInteractor {
    private final UserGateway userGateway;

    public CreateUserInteractor(UserGateway createUser) {
        this.userGateway = createUser;
    }

    public UserDomain createUser(UserDomain userDomain) {
        return userGateway.createUser(userDomain);
    }
}
