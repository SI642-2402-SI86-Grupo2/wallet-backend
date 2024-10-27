package com.backend.wallet.portfolio.domain.model.aggregates;



import com.backend.wallet.portfolio.domain.model.commands.CreatePortfolioCommand;
import com.backend.wallet.profile.domain.model.aggregates.Profile;
import com.backend.wallet.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Entity
public class Portfolio extends AuditableAbstractAggregateRoot<Portfolio> {


    @Column(name = "portfolio_name", length = 100, nullable = false)
    private String portfolioName;

    @Column(name = "description", length = 300)
    private String description;

    @Column(name = "discount_date")
    private Date discountDate;

    @Column(name = "total_tcea", precision = 7, scale = 4)
    private BigDecimal totalTcea;

    @ManyToOne
    @JoinColumn(name = "profile_id", referencedColumnName = "id")
    private Profile profile;

    public Portfolio() {
    }

    public Portfolio(String portfolioName, String description, Date discountDate, BigDecimal totalTcea, Profile profile) {
        this.portfolioName = portfolioName;
        this.description = description;
        this.discountDate = discountDate;
        this.totalTcea = totalTcea;
        this.profile = profile;
    }

    public Portfolio(CreatePortfolioCommand command, Profile profile) {
        this.portfolioName = command.portfolioName();
        this.description = command.description();
        this.discountDate = command.discountDate();
        this.totalTcea = command.totalTcea();
        this.profile = profile;
    }



    public Portfolio updatePortfolio(String portfolioName, String description, Date discountDate, BigDecimal totalTcea) {
        this.portfolioName = portfolioName;
        this.description = description;
        this.discountDate = discountDate;
        this.totalTcea = totalTcea;
        return this;
    }

}
