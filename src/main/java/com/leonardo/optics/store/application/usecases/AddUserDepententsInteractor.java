package com.leonardo.optics.store.application.usecases;

import com.leonardo.optics.store.application.gateways.UserGateway;

public class AddUserDepententsInteractor {
    private final UserGateway userGateway;

    public AddUserDepententsInteractor(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    public void addDependents(Long userId, Long dependentId) {
        this.userGateway.addDependent(userId, dependentId);
    }
}
