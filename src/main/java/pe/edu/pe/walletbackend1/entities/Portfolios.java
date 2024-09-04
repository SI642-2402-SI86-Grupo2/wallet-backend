package pe.edu.pe.walletbackend1.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="Portfolios")
public class Portfolios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int portfolioid;

    @Column(name = "portfolioname", length = 100, nullable = false)
    public String portfolioname;

    @Column(name = "description", length = 300, nullable = false)
    public String description;

    @Column(name= "date", nullable = false)
    public LocalDate date;

    @Column(name = "totaltcea", nullable = false)
    public double totaltcea;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    public Portfolios() {

    }

    public Portfolios(int portfolioid, String portfolioname, String description, LocalDate date, double totaltcea, Users user) {
        this.portfolioid = portfolioid;
        this.portfolioname = portfolioname;
        this.description = description;
        this.date = date;
        this.totaltcea = totaltcea;
        this.user = user;
    }

    public int getPortfolioid() {
        return portfolioid;
    }

    public void setPortfolioid(int portfolioid) {
        this.portfolioid = portfolioid;
    }

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

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
