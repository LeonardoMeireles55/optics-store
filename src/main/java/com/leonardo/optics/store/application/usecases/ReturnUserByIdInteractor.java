package com.leonardo.optics.store.application.usecases;

import com.leonardo.optics.store.application.gateways.UserGateway;
import com.leonardo.optics.store.domain.UserDomain;

public class ReturnUserByIdInteractor {
    private final UserGateway userGateway;

    public ReturnUserByIdInteractor(UserGateway returnUserById) {
        this.userGateway = returnUserById;
    }

    public UserDomain getUserById(Long id) {
        return userGateway.returnUserById(id);
    }
}
