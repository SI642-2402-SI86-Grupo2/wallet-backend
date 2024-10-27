package com.backend.wallet.portfolio.interfaces.rest.resources;

import java.math.BigDecimal;
import java.util.Date;

public record PortfolioResource(
        Long id,
        String portfolioName,
        String description,
        Date discountDate,
        BigDecimal totalTcea,
        Long profileId) {
}