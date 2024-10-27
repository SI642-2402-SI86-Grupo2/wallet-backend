package com.backend.wallet.portfolio.domain.services;

import com.backend.wallet.portfolio.domain.model.aggregates.Portfolio;
import com.backend.wallet.portfolio.domain.model.commands.CreatePortfolioCommand;
import com.backend.wallet.portfolio.domain.model.commands.DeletePortfolioCommand;
import com.backend.wallet.portfolio.domain.model.commands.UpdatePortfolioCommand;

import java.util.Optional;

public interface PortfolioCommandService {
    Optional<Portfolio> handle(CreatePortfolioCommand command);
    Optional<Portfolio> handle(UpdatePortfolioCommand command);
    void handle(DeletePortfolioCommand command);
}