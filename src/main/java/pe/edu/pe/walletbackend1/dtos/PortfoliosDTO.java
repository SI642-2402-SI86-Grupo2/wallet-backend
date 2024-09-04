package pe.edu.pe.walletbackend1.dtos;

import pe.edu.pe.walletbackend1.entities.Users;

import java.time.LocalDate;

public class PortfoliosDTO {

    private int portfolioid;

    public String portfolioname;

    public String description;

    public LocalDate date;

    public double totaltcea;

    private Users user;

    public String getPortfolioname() {
        return portfolioname;
    }

    public void setPortfolioname(String portfolioname) {
        this.portfolioname = portfolioname;
    }

    public int getPortfolioid() {
        return portfolioid;
    }

    public void setPortfolioid(int portfolioid) {
        this.portfolioid = portfolioid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getTotaltcea() {
        return totaltcea;
    }

    public void setTotaltcea(double totaltcea) {
        this.totaltcea = totaltcea;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
