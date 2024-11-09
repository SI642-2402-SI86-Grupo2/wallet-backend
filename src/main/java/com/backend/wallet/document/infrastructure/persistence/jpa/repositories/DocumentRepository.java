package com.backend.wallet.document.infrastructure.persistence.jpa.repositories;

import com.backend.wallet.document.domain.model.aggregates.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {

    List<Document> findByPortfolioId(Long portfolioId);

}