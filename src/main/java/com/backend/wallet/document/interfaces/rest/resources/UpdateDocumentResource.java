package com.backend.wallet.document.interfaces.rest.resources;

import java.math.BigDecimal;
import java.util.Date;

public record UpdateDocumentResource(
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
        String status,
        String initialCosts,
        String finalCosts

) {
}