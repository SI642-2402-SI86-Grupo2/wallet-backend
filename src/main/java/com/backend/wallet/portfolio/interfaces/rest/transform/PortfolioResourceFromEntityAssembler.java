package com.backend.wallet.portfolio.interfaces.rest.transform;

import com.backend.wallet.portfolio.domain.model.aggregates.Portfolio;
import com.backend.wallet.portfolio.interfaces.rest.resources.PortfolioResource;

public class PortfolioResourceFromEntityAssembler {
    public static PortfolioResource toResourceFromEntity(Portfolio entity) {
        return new PortfolioResource(
                entity.getId(),
                entity.getPortfolioName(),
                entity.getDescription(),
                entity.getDiscountDate(),
                entity.getTotalTcea(),
                entity.getProfile().getId()
        );
    }
}