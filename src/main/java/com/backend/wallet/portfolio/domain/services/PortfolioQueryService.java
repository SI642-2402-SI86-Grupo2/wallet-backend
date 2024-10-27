package com.backend.wallet.portfolio.domain.services;

import com.backend.wallet.portfolio.domain.model.aggregates.Portfolio;
import com.backend.wallet.portfolio.domain.model.queries.*;

import java.util.List;
import java.util.Optional;

public interface PortfolioQueryService {
    List<Portfolio> handle(GetAllPortfoliosQuery query);
    Optional<Portfolio> handle(GetPortfolioByIdQuery query);
    List<Portfolio> handle(GetPortfoliosByProfileIdQuery query);
    List<Portfolio> handle(GetPortfoliosByDateRangeQuery query);
}