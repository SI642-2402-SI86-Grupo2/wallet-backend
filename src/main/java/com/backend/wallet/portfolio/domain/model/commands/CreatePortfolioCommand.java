package com.backend.wallet.portfolio.domain.model.commands;

import java.math.BigDecimal;
import java.util.Date;

public record CreatePortfolioCommand(
        String portfolioName,
        String description,
        Date discountDate,
        BigDecimal totalTcea,
        Long profileId
) {
}