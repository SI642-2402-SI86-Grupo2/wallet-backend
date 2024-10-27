package com.backend.wallet.profile.infrastructure.persistence.jpa.repositories;

import com.backend.wallet.profile.domain.model.aggregates.Profile;
import com.backend.wallet.profile.domain.model.valueobjects.PersonName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
    Optional<Profile> findByName(PersonName name);
    Optional<Profile> findByEmail(String email);
    boolean existsById(Long id);
    boolean existsByEmail(String email);
    boolean existsByUserId(Long userId);
    Optional<Profile> findByUserId(Long userId);
}
