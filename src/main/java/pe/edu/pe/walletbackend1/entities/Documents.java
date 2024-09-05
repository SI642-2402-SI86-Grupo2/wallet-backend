package pe.edu.pe.walletbackend1.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "Documents")
public class Documents {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int documentsId;

    @Column(name = "document_type", length = 30, nullable = false)
    private String documentType;

    @Column(name = "financial_institutions_name", length = 100, nullable = false)
    private String financialInstitutionsName;

    @Column(name = "number", length = 20, nullable = false)
    private String number;

    @Column(name = "series", length = 20, nullable = false)
    private String series;

    @Column(name = "issuer_name", length = 100, nullable = false)
    private String issuerName;

    @Column(name = "issuer_ruc", length = 11, nullable = false)
    private String issuerRuc;

    @Column(name = "currency", length = 3, nullable = false)
    private String currency;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @Column(name = "igv", nullable = false)
    private BigDecimal igv;

    @Column(name = "issue_date", nullable = false)
    private LocalDate issueDate;

    @Column(name = "due_date", nullable = false)
    private LocalDate dueDate;

    @Column(name = "discount_date", nullable = false)
    private LocalDate discountDate;

    @Column(name = "payment_terms", length = 50, nullable = false)
    private String paymentTerms;

    @Column(name = "nominal_rate", nullable = false)
    private BigDecimal nominalRate;

    @Column(name = "effective_rate", nullable = false)
    private BigDecimal effectiveRate;

    @Column(name = "tcea", nullable = false)
    private BigDecimal tcea;

    @Column(name = "commission", nullable = false)
    private BigDecimal commission;

    @Column(name = "status", length = 20, nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = "portfolios_id", nullable = false)
    private Portfolios portfolios;

    // Getters and Setters
    public int getDocumentsId() {
        return documentsId;
    }

    public void setDocumentsId(int documentsId) {
        this.documentsId = documentsId;
    }

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

    public Portfolios getPortfolios() {
        return portfolios;
    }

    public void setPortfolios(Portfolios portfolios) {
        this.portfolios = portfolios;
    }
}