package com.backend.wallet.document.domain.model.aggregates;

import com.backend.wallet.document.domain.model.commands.CreateDocumentCommand;
import com.backend.wallet.portfolio.domain.model.aggregates.Portfolio;
import com.backend.wallet.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Entity
public class Document extends AuditableAbstractAggregateRoot<Document> {


    @Column(name = "document_type", length = 30, nullable = false)
    private String documentType;

    @Column(name = "financial_institutions_name", length = 100)
    private String financialInstitutionsName;

    @Column(name = "number", length = 20, nullable = false)
    private String number;

    @Column(name = "series", length = 20)
    private String series;

    @Column(name = "issuer_name", length = 100, nullable = false)
    private String issuerName;

    @Column(name = "issuer_ruc", length = 11, nullable = false)
    private String issuerRuc;

    @Column(name = "currency", length = 3, nullable = false)
    private String currency;

    @Column(name = "amount", precision = 15, scale = 2, nullable = false)
    private BigDecimal amount;

    @Column(name = "igv", precision = 15, scale = 2)
    private BigDecimal igv;

    @Column(name = "issue_date")
    private Date issueDate;

    @Column(name = "due_date")
    private Date dueDate;

    @Column(name = "discount_date")
    private Date discountDate;

    @Column(name = "payment_terms", length = 50)
    private String paymentTerms;

    @Column(name = "nominal_rate", precision = 5, scale = 2)
    private BigDecimal nominalRate;

    @Column(name = "effective_rate", precision = 5, scale = 2)
    private BigDecimal effectiveRate;

    @Column(name = "tcea", precision = 7, scale = 4)
    private BigDecimal tcea;

    @Column(name = "commission", precision = 10, scale = 2)
    private BigDecimal commission;

    @Column(name = "status", length = 20)
    private String status;

    @ManyToOne
    @JoinColumn(name = "portfolios_id", referencedColumnName = "id")
    private Portfolio portfolio;

    public Document() {
    }

    public Document(String documentType, String financialInstitutionsName, String number, String series,
                    String issuerName, String issuerRuc, String currency, BigDecimal amount, BigDecimal igv,
                    Date issueDate, Date dueDate, Date discountDate, String paymentTerms, BigDecimal nominalRate,
                    BigDecimal effectiveRate, BigDecimal tcea, BigDecimal commission, String status, Portfolio portfolio) {
        this.documentType = documentType;
        this.financialInstitutionsName = financialInstitutionsName;
        this.number = number;
        this.series = series;
        this.issuerName = issuerName;
        this.issuerRuc = issuerRuc;
        this.currency = currency;
        this.amount = amount;
        this.igv = igv;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        this.discountDate = discountDate;
        this.paymentTerms = paymentTerms;
        this.nominalRate = nominalRate;
        this.effectiveRate = effectiveRate;
        this.tcea = tcea;
        this.commission = commission;
        this.status = status;
        this.portfolio = portfolio;
    }

    public Document(CreateDocumentCommand command, Portfolio portfolio) {
        this.documentType = command.documentType();
        this.financialInstitutionsName = command.financialInstitutionsName();
        this.number = command.number();
        this.series = command.series();
        this.issuerName = command.issuerName();
        this.issuerRuc = command.issuerRuc();
        this.currency = command.currency();
        this.amount = command.amount();
        this.igv = command.igv();
        this.issueDate = command.issueDate();
        this.dueDate = command.dueDate();
        this.discountDate = command.discountDate();
        this.paymentTerms = command.paymentTerms();
        this.nominalRate = command.nominalRate();
        this.effectiveRate = command.effectiveRate();
        this.tcea = command.tcea();
        this.commission = command.commission();
        this.status = command.status();
        this.portfolio = portfolio;
    }

    public Document updateDocument(String documentType, String financialInstitutionsName, String number, String series,
                                   String issuerName, String issuerRuc, String currency, BigDecimal amount, BigDecimal igv,
                                   Date issueDate, Date dueDate, Date discountDate, String paymentTerms, BigDecimal nominalRate,
                                   BigDecimal effectiveRate, BigDecimal tcea, BigDecimal commission, String status) {
        this.documentType = documentType;
        this.financialInstitutionsName = financialInstitutionsName;
        this.number = number;
        this.series = series;
        this.issuerName = issuerName;
        this.issuerRuc = issuerRuc;
        this.currency = currency;
        this.amount = amount;
        this.igv = igv;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        this.discountDate = discountDate;
        this.paymentTerms = paymentTerms;
        this.nominalRate = nominalRate;
        this.effectiveRate = effectiveRate;
        this.tcea = tcea;
        this.commission = commission;
        this.status = status;
        return this;
    }
}
