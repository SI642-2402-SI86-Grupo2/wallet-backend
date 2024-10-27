package com.backend.wallet.portfolio.application.internal.queryservices;

import com.backend.wallet.portfolio.domain.model.aggregates.Portfolio;
import com.backend.wallet.portfolio.domain.model.queries.*;
import com.backend.wallet.portfolio.domain.services.PortfolioQueryService;
import com.backend.wallet.portfolio.infrastructure.persistence.jpa.repositories.PortfolioRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PortfolioQueryServiceImpl implements PortfolioQueryService {
    private final PortfolioRepository portfolioRepository;

    public PortfolioQueryServiceImpl(PortfolioRepository portfolioRepository) {
        this.portfolioRepository = portfolioRepository;
    }

    @Override
    public List<Portfolio> handle(GetAllPortfoliosQuery query) {
        return portfolioRepository.findAll();
    }

    @Override
    public Optional<Portfolio> handle(GetPortfolioByIdQuery query) {
        return portfolioRepository.findById(query.id());
    }

    @Override
    public List<Portfolio> handle(GetPortfoliosByProfileIdQuery query) {
        return portfolioRepository.findByProfileId(query.profileId());
    }

    @Override
    public List<Portfolio> handle(GetPortfoliosByDateRangeQuery query) {
        return portfolioRepository.findByDiscountDateBetween(query.startDate(), query.endDate());
    }
}