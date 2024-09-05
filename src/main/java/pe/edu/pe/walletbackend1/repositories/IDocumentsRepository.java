package pe.edu.pe.walletbackend1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.pe.walletbackend1.entities.Documents;

public interface IDocumentsRepository extends JpaRepository<Documents, Integer> {
}