package com.backend.wallet.iam.infrastructure.persistence.jpa.repositories;

import com.backend.wallet.iam.domain.model.aggregates.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail (String email);
    boolean existsByEmail (String email);
}
