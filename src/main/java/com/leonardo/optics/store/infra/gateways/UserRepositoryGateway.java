package com.leonardo.optics.store.infra.gateways;

import com.leonardo.optics.store.application.gateways.UserGateway;
import com.leonardo.optics.store.domain.UserDomain;
import com.leonardo.optics.store.infra.errorHandling.GlobalErrorHandling;
import com.leonardo.optics.store.infra.persistence.UserEntity;
import com.leonardo.optics.store.infra.persistence.UserRepository;


public class UserRepositoryGateway implements UserGateway {
    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;

    public UserRepositoryGateway(UserRepository userRepository, UserEntityMapper userEntityMapper) {
        this.userRepository = userRepository;
        this.userEntityMapper = userEntityMapper;
    }
    @Override   
    public UserDomain createUser(UserDomain userDomainObj) {
        UserEntity userEntity = userEntityMapper.toEntity(userDomainObj);
        UserEntity savedUserEntity = userRepository.save(userEntity);

        return userEntityMapper.toDomain(savedUserEntity);
    }

    @Override
    public UserDomain returnUserById(Long id) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow();
        return userEntityMapper.toDomain(userEntity);
    }

    @Override
    public UserDomain returnUserByEmail(String email) {
        UserEntity userEntity = userRepository.findByEmail(email);
        if(userEntity == null) {
            throw new GlobalErrorHandling
            .ResourceNotFoundException("User not found");
        }
        return userEntityMapper.toDomain(userEntity);
    }
}
