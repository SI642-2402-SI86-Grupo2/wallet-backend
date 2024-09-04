package pe.edu.pe.walletbackend1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.pe.walletbackend1.entities.Portfolios;

@Repository
public interface IPortfoliosRepository extends JpaRepository<Portfolios, Integer> {

}
