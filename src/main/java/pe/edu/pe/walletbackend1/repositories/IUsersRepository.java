package pe.edu.pe.walletbackend1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.pe.walletbackend1.entities.Users;

import java.util.Optional;

@Repository
public interface IUsersRepository extends JpaRepository<Users, Integer> {
    boolean existsByEmail(String email);
    Users findByEmail(String email);
}