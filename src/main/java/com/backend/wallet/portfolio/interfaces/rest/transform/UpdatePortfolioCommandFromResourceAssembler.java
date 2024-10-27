package com.backend.wallet.portfolio.interfaces.rest.transform;

import com.backend.wallet.portfolio.domain.model.commands.UpdatePortfolioCommand;
import com.backend.wallet.portfolio.interfaces.rest.resources.UpdatePortfolioResource;

public class UpdatePortfolioCommandFromResourceAssembler {
    public static UpdatePortfolioCommand toCommandFromResource(Long id, UpdatePortfolioResource resource) {
        return new UpdatePortfolioCommand(
                id,
                resource.portfolioName(),
                resource.description(),
                resource.discountDate(),
                resource.totalTcea()
        );
    }
}