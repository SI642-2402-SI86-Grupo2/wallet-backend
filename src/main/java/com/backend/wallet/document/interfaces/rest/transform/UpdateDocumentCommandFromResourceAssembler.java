package com.backend.wallet.document.interfaces.rest.transform;

import com.backend.wallet.document.domain.model.commands.UpdateDocumentCommand;
import com.backend.wallet.document.interfaces.rest.resources.UpdateDocumentResource;

public class UpdateDocumentCommandFromResourceAssembler {
    public static UpdateDocumentCommand toCommandFromResource(Long id, UpdateDocumentResource resource) {
        return new UpdateDocumentCommand(
                id,
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
                resource.commission(),
                resource.status()
        );
    }
}