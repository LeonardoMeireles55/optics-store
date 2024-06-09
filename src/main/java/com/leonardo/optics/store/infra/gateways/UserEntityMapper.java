package com.leonardo.optics.store.infra.gateways;

import com.leonardo.optics.store.domain.UserDomain;
import com.leonardo.optics.store.infra.persistence.UserEntity;

public class UserEntityMapper {
    UserDomain toDomain(UserEntity userEntityObj) {
        return new UserDomain(
                userEntityObj.getFirstName(),
                userEntityObj.getLastName(),
                userEntityObj.getPassword(),
                userEntityObj.getEmail(),
                userEntityObj.getCep(),
                userEntityObj.getAddress(),
                userEntityObj.getTelephone(),
                userEntityObj.getCpf(),
                userEntityObj.getRole()
        );
    }

    UserEntity toEntity(UserDomain userDomainObj) {
        return new UserEntity(
                userDomainObj.firstName(),
                userDomainObj.lastName(),
                userDomainObj.password(),
                userDomainObj.email(),
                userDomainObj.cep(),
                userDomainObj.address(),
                userDomainObj.telephone(),
                userDomainObj.cpf(),
                userDomainObj.role()
        );
    }
}
