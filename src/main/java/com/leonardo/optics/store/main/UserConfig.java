package com.leonardo.optics.store.main;

import com.leonardo.optics.store.application.usecases.AddUserDepententsInteractor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.leonardo.optics.store.application.gateways.UserGateway;
import com.leonardo.optics.store.application.usecases.CreateUserInteractor;
import com.leonardo.optics.store.application.usecases.ReturnUserByIdInteractor;
import com.leonardo.optics.store.infra.controllers.mapper.UserDTOMapper;
import com.leonardo.optics.store.infra.gateways.UserEntityMapper;
import com.leonardo.optics.store.infra.gateways.UserRepositoryGateway;
import com.leonardo.optics.store.infra.persistence.UserRepository;

@Configuration
public class UserConfig {
    @Bean
    CreateUserInteractor createUserCase(UserGateway userGateway) {
        return new CreateUserInteractor(userGateway);
    }

    @Bean
    ReturnUserByIdInteractor returnUserByIdCase(UserGateway userGateway) {
        return new ReturnUserByIdInteractor(userGateway);
    }

    @Bean
    AddUserDepententsInteractor addUserDependentsCase(UserGateway userGateway) {
        return new AddUserDepententsInteractor(userGateway);
    }


    @Bean
    UserGateway userGateway(UserRepository userRepository, UserEntityMapper userEntityMapper) {
        return new UserRepositoryGateway(userRepository, userEntityMapper);
    }

    @Bean
    UserEntityMapper userEntityMapper() {
        return new UserEntityMapper();
    }

    @Bean
    UserDTOMapper userDTOMapper() {
        return new UserDTOMapper();
    }
}
