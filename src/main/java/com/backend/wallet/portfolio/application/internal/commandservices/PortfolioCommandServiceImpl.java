package com.backend.wallet.portfolio.application.internal.commandservices;

import com.backend.wallet.portfolio.domain.model.aggregates.Portfolio;
import com.backend.wallet.portfolio.domain.model.commands.CreatePortfolioCommand;
import com.backend.wallet.portfolio.domain.model.commands.UpdatePortfolioCommand;
import com.backend.wallet.portfolio.domain.model.commands.DeletePortfolioCommand;
import com.backend.wallet.portfolio.domain.services.PortfolioCommandService;
import com.backend.wallet.portfolio.infrastructure.persistence.jpa.repositories.PortfolioRepository;
import com.backend.wallet.profile.domain.model.aggregates.Profile;
import com.backend.wallet.profile.infrastructure.persistence.jpa.repositories.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PortfolioCommandServiceImpl implements PortfolioCommandService {
    private final PortfolioRepository portfolioRepository;
    private final ProfileRepository profileRepository;

    public PortfolioCommandServiceImpl(PortfolioRepository portfolioRepository, ProfileRepository profileRepository) {
        this.portfolioRepository = portfolioRepository;
        this.profileRepository = profileRepository;
    }

    @Override
    public Optional<Portfolio> handle(CreatePortfolioCommand command) {
        Profile profile = profileRepository.findById(command.profileId()).orElseThrow(() -> new IllegalArgumentException("User with id " + command.profileId() + " does not exist"));
        var portfolio = new Portfolio(command, profile);
        portfolioRepository.save(portfolio);
        return Optional.of(portfolio);
    }

    @Override
    public Optional<Portfolio> handle(UpdatePortfolioCommand command) {
        var id = command.id();
        if (!portfolioRepository.existsById(id))
            throw new IllegalArgumentException("Portfolio with id " + id + " does not exist");
        var result = portfolioRepository.findById(id);
        var portfolioToUpdate = result.get();
        try {
            var updatedPortfolio = portfolioRepository.save(portfolioToUpdate.updatePortfolio(command.portfolioName(), command.description(), command.discountDate(), command.totalTcea()));
            return Optional.of(updatedPortfolio);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error updating portfolio with id " + id);
        }
    }

    @Override
    public void handle(DeletePortfolioCommand command) {
        portfolioRepository.deleteById(command.id());
    }
}