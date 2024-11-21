package com.backend.wallet.portfolio.interfaces.rest;

import com.backend.wallet.portfolio.domain.services.PortfolioCommandService;
import com.backend.wallet.portfolio.domain.services.PortfolioQueryService;
import com.backend.wallet.portfolio.interfaces.rest.resources.CreatePortfolioResource;
import com.backend.wallet.portfolio.interfaces.rest.resources.PortfolioResource;
import com.backend.wallet.portfolio.interfaces.rest.resources.UpdatePortfolioResource;
import com.backend.wallet.portfolio.interfaces.rest.transform.CreatePortfolioCommandFromResourceAssembler;
import com.backend.wallet.portfolio.interfaces.rest.transform.PortfolioResourceFromEntityAssembler;
import com.backend.wallet.portfolio.interfaces.rest.transform.UpdatePortfolioCommandFromResourceAssembler;
import com.backend.wallet.portfolio.domain.model.commands.DeletePortfolioCommand;
import com.backend.wallet.portfolio.domain.model.queries.GetAllPortfoliosQuery;
import com.backend.wallet.portfolio.domain.model.queries.GetPortfolioByIdQuery;
import com.backend.wallet.portfolio.domain.model.queries.GetPortfoliosByProfileIdQuery;
import com.backend.wallet.portfolio.domain.model.queries.GetPortfoliosByDateRangeQuery;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1/portfolio", produces = MediaType.APPLICATION_JSON_VALUE)
public class PortfolioController {
    private final PortfolioCommandService portfolioCommandService;
    private final PortfolioQueryService portfolioQueryService;

    public PortfolioController(PortfolioCommandService portfolioCommandService, PortfolioQueryService portfolioQueryService) {
        this.portfolioCommandService = portfolioCommandService;
        this.portfolioQueryService = portfolioQueryService;
    }

    @PostMapping
    public ResponseEntity<PortfolioResource> createPortfolio(@RequestBody CreatePortfolioResource resource) {
        var createPortfolioCommand = CreatePortfolioCommandFromResourceAssembler.toCommandFromResource(resource);
        try {
            var portfolio = portfolioCommandService.handle(createPortfolioCommand);
            if (portfolio.isEmpty()) return ResponseEntity.badRequest().build();
            var portfolioResource = PortfolioResourceFromEntityAssembler.toResourceFromEntity(portfolio.get());
            return new ResponseEntity<>(portfolioResource, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<PortfolioResource>> getAllPortfolios() {
        var portfolios = portfolioQueryService.handle(new GetAllPortfoliosQuery());
        var portfolioResources = portfolios.stream()
                .map(PortfolioResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(portfolioResources);
    }

    @GetMapping("/{portfolioId}")
    public ResponseEntity<PortfolioResource> getPortfolioById(@PathVariable Long portfolioId) {
        var getPortfolioByIdQuery = new GetPortfolioByIdQuery(portfolioId);
        var portfolio = portfolioQueryService.handle(getPortfolioByIdQuery);
        if (portfolio.isEmpty()) return ResponseEntity.notFound().build();
        var portfolioResource = PortfolioResourceFromEntityAssembler.toResourceFromEntity(portfolio.get());
        return ResponseEntity.ok(portfolioResource);
    }

    @GetMapping("/profile/{profileId}")
    public ResponseEntity<List<PortfolioResource>> getPortfoliosByProfileId(@PathVariable Long profileId) {
        var query = new GetPortfoliosByProfileIdQuery(profileId);
        var portfolios = portfolioQueryService.handle(query);
        var portfolioResources = portfolios.stream()
                .map(PortfolioResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(portfolioResources);
    }

    @GetMapping("/date-range")
    public ResponseEntity<List<PortfolioResource>> getPortfoliosByDateRange(@RequestParam("startDate") Date startDate, @RequestParam("endDate") Date endDate) {
        var query = new GetPortfoliosByDateRangeQuery(startDate, endDate);
        var portfolios = portfolioQueryService.handle(query);
        var portfolioResources = portfolios.stream()
                .map(PortfolioResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(portfolioResources);
    }

    @PutMapping("/{portfolioId}")
    public ResponseEntity<PortfolioResource> updatePortfolio(@PathVariable Long portfolioId, @RequestBody UpdatePortfolioResource resource) {
        var updatePortfolioCommand = UpdatePortfolioCommandFromResourceAssembler.toCommandFromResource(portfolioId, resource);
        var updatedPortfolio = portfolioCommandService.handle(updatePortfolioCommand);
        if (updatedPortfolio.isEmpty()) return ResponseEntity.notFound().build();
        var updatedPortfolioResource = PortfolioResourceFromEntityAssembler.toResourceFromEntity(updatedPortfolio.get());
        return ResponseEntity.ok(updatedPortfolioResource);
    }

    @DeleteMapping("/{portfolioId}")
    public ResponseEntity<Void> deletePortfolio(@PathVariable Long portfolioId) {
        var deletePortfolioCommand = new DeletePortfolioCommand(portfolioId);
        portfolioCommandService.handle(deletePortfolioCommand);
        return ResponseEntity.noContent().build();
    }
}