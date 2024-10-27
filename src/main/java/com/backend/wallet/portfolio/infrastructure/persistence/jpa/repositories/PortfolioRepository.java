package com.backend.wallet.portfolio.infrastructure.persistence.jpa.repositories;

import com.backend.wallet.portfolio.domain.model.aggregates.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {
    Optional<Portfolio> findByPortfolioName(String portfolioName);
    List<Portfolio> findByProfileId(Long profileId);
    List<Portfolio> findByDiscountDateBetween(Date startDate, Date endDate);
}