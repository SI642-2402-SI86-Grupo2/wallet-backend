package com.backend.wallet.portfolio.domain.model.commands;

import java.math.BigDecimal;
import java.util.Date;

public record UpdatePortfolioCommand(
        Long id,
        String portfolioName,
        String description,
        Date discountDate,
        BigDecimal totalTcea
) {
}