package com.backend.wallet.document.domain.model.commands;

import java.math.BigDecimal;
import java.util.Date;

public record CreateDocumentCommand(
        String documentType,
        String financialInstitutionsName,
        String number,
        String series,
        String issuerName,
        String issuerRuc,
        String currency,
        BigDecimal amount,
        BigDecimal igv,
        Date issueDate,
        Date dueDate,
        Date discountDate,
        String paymentTerms,
        BigDecimal nominalRate,
        BigDecimal effectiveRate,
        BigDecimal tcea,
        BigDecimal commission,
        String status,
        Long portfolioId
) {
}