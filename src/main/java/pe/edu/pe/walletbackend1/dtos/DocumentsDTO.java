package pe.edu.pe.walletbackend1.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;

public class DocumentsDTO {

    private String documentType;
    private String financialInstitutionsName;
    private String number;
    private String series;
    private String issuerName;
    private String issuerRuc;
    private String currency;
    private BigDecimal amount;
    private BigDecimal igv;
    private LocalDate issueDate;
    private LocalDate dueDate;
    private LocalDate discountDate;
    private String paymentTerms;
    private BigDecimal nominalRate;
    private BigDecimal effectiveRate;
    private BigDecimal tcea;
    private BigDecimal commission;
    private String status;
    private int portfoliosId;

    // Getters and Setters
    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getFinancialInstitutionsName() {
        return financialInstitutionsName;
    }

    public void setFinancialInstitutionsName(String financialInstitutionsName) {
        this.financialInstitutionsName = financialInstitutionsName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getIssuerName() {
        return issuerName;
    }

    public void setIssuerName(String issuerName) {
        this.issuerName = issuerName;
    }

    public String getIssuerRuc() {
        return issuerRuc;
    }

    public void setIssuerRuc(String issuerRuc) {
        this.issuerRuc = issuerRuc;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getIgv() {
        return igv;
    }

    public void setIgv(BigDecimal igv) {
        this.igv = igv;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getDiscountDate() {
        return discountDate;
    }

    public void setDiscountDate(LocalDate discountDate) {
        this.discountDate = discountDate;
    }

    public String getPaymentTerms() {
        return paymentTerms;
    }

    public void setPaymentTerms(String paymentTerms) {
        this.paymentTerms = paymentTerms;
    }

    public BigDecimal getNominalRate() {
        return nominalRate;
    }

    public void setNominalRate(BigDecimal nominalRate) {
        this.nominalRate = nominalRate;
    }

    public BigDecimal getEffectiveRate() {
        return effectiveRate;
    }

    public void setEffectiveRate(BigDecimal effectiveRate) {
        this.effectiveRate = effectiveRate;
    }

    public BigDecimal getTcea() {
        return tcea;
    }

    public void setTcea(BigDecimal tcea) {
        this.tcea = tcea;
    }

    public BigDecimal getCommission() {
        return commission;
    }

    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getPortfoliosId() {
        return portfoliosId;
    }

    public void setPortfoliosId(int portfoliosId) {
        this.portfoliosId = portfoliosId;
    }
}