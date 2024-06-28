package com.leonardo.optics.store.infra.gateways;

import com.leonardo.optics.store.domain.UserDomain;
import com.leonardo.optics.store.infra.persistence.UserEntity;

public class UserEntityMapper {
    public UserDomain toDomain(UserEntity userEntityObj) {
        return new UserDomain(
                userEntityObj.getFirstName(),
                userEntityObj.getLastName(),
                userEntityObj.getPassword(),
                userEntityObj.getEmail(),
                userEntityObj.getCep(),
                userEntityObj.getAddress(),
                userEntityObj.getTelephone(),
                userEntityObj.getCpf(),
                userEntityObj.getRole(),
                userEntityObj.getUserDependentsIds().stream().toList()
        );
    }

    public UserEntity toEntity(UserDomain userDomainObj) {

        return new UserEntity(
                userDomainObj.firstName(),
                userDomainObj.lastName(),
                userDomainObj.password(),
                userDomainObj.email(),
                userDomainObj.cep(),
                userDomainObj.address(),
                userDomainObj.telephone(),
                userDomainObj.cpf(),
                userDomainObj.role(),
                userDomainObj.userDependents().stream().toList()
        );
    }
}
