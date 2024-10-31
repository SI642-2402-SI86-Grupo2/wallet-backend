package com.backend.wallet.document.interfaces.rest.transform;

import com.backend.wallet.document.domain.model.aggregates.Document;
import com.backend.wallet.document.interfaces.rest.resources.DocumentResource;

public class DocumentResourceFromEntityAssembler {
    public static DocumentResource toResourceFromEntity(Document entity) {
        return new DocumentResource(
                entity.getId(),
                entity.getDocumentType(),
                entity.getFinancialInstitutionsName(),
                entity.getNumber(),
                entity.getSeries(),
                entity.getIssuerName(),
                entity.getIssuerRuc(),
                entity.getCurrency(),
                entity.getAmount(),
                entity.getIgv(),
                entity.getIssueDate(),
                entity.getDueDate(),
                entity.getDiscountDate(),
                entity.getPaymentTerms(),
                entity.getNominalRate(),
                entity.getEffectiveRate(),
                entity.getTcea(),
                entity.getCommission(),
                entity.getStatus(),
                entity.getPortfolio().getId()
        );
    }
}