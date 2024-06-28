package com.leonardo.optics.store.infra.persistence;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
    UserEntity findByEmail(String email);
    @Modifying
    @Transactional
    @Query("INSERT INTO dependents (user_id, dependent_id) VALUES (:userId, :dependentId)")
    void addDependent(Long userId, Long dependentId);
}
