package pe.edu.pe.walletbackend1.dtos;

import pe.edu.pe.walletbackend1.entities.Users;

import java.time.LocalDate;

public class PortfoliosDTO {

    public String portfolioname;

    public String description;

    public LocalDate date;

    public double totaltcea;

    private int userId;

    public String getPortfolioname() {
        return portfolioname;
    }

    public void setPortfolioname(String portfolioname) {
        this.portfolioname = portfolioname;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
