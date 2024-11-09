package com.backend.wallet.document.interfaces.rest.transform;

import com.backend.wallet.document.domain.model.commands.CreateDocumentCommand;
import com.backend.wallet.document.interfaces.rest.resources.CreateDocumentResource;

public class CreateDocumentCommandFromResourceAssembler {
    public static CreateDocumentCommand toCommandFromResource(CreateDocumentResource resource) {
        return new CreateDocumentCommand(
                resource.documentType(),
                resource.financialInstitutionsName(),
                resource.number(),
                resource.series(),
                resource.issuerName(),
                resource.issuerRuc(),
                resource.currency(),
                resource.amount(),
                resource.igv(),
                resource.issueDate(),
                resource.dueDate(),
                resource.discountDate(),
                resource.paymentTerms(),
                resource.nominalRate(),
                resource.effectiveRate(),
                resource.tcea(),
                resource.status(),
                resource.initialCosts(),
                resource.finalCosts(),
                resource.portfolioId()
        );
    }
}