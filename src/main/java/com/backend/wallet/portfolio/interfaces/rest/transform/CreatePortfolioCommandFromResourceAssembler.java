package com.backend.wallet.portfolio.interfaces.rest.transform;

import com.backend.wallet.portfolio.domain.model.commands.CreatePortfolioCommand;
import com.backend.wallet.portfolio.interfaces.rest.resources.CreatePortfolioResource;

public class CreatePortfolioCommandFromResourceAssembler {
    public static CreatePortfolioCommand toCommandFromResource(CreatePortfolioResource resource) {
        return new CreatePortfolioCommand(
                resource.portfolioName(),
                resource.description(),
                resource.discountDate(),
                resource.totalTcea(),
                resource.profileId()
        );
    }
}