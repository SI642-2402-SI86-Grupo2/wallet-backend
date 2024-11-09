package com.backend.wallet.document.application.internal.commandservices;

import com.backend.wallet.document.domain.model.aggregates.Document;
import com.backend.wallet.document.domain.model.commands.CreateDocumentCommand;
import com.backend.wallet.document.domain.model.commands.UpdateDocumentCommand;
import com.backend.wallet.document.domain.model.commands.DeleteDocumentCommand;
import com.backend.wallet.document.domain.services.DocumentCommandService;
import com.backend.wallet.document.infrastructure.persistence.jpa.repositories.DocumentRepository;
import com.backend.wallet.portfolio.domain.model.aggregates.Portfolio; // Correct import
import com.backend.wallet.portfolio.infrastructure.persistence.jpa.repositories.PortfolioRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DocumentCommandServiceImpl implements DocumentCommandService {
    private final DocumentRepository documentRepository;
    private final PortfolioRepository portfolioRepository;

    public DocumentCommandServiceImpl(DocumentRepository documentRepository, PortfolioRepository portfolioRepository) {
        this.documentRepository = documentRepository;
        this.portfolioRepository = portfolioRepository;
    }

    @Override
    public Optional<Document> handle(CreateDocumentCommand command) {
        Portfolio portfolio = portfolioRepository.findById(command.portfolioId()).orElseThrow(() ->
                new IllegalArgumentException("Portfolio with id " + command.portfolioId() + " does not exist"));
        var document = new Document(command, portfolio);
        documentRepository.save(document);
        return Optional.of(document);
    }

    @Override
    public Optional<Document> handle(UpdateDocumentCommand command) {
        var id = command.id();
        if (!documentRepository.existsById(id))
            throw new IllegalArgumentException("Document with id " + id + " does not exist");
        var result = documentRepository.findById(id);
        var documentToUpdate = result.get();
        try {
            var updatedDocument = documentRepository.save(documentToUpdate.updateDocument(
                    command.documentType(), command.financialInstitutionsName(), command.number(), command.series(),
                    command.issuerName(), command.issuerRuc(), command.currency(), command.amount(), command.igv(),
                    command.issueDate(), command.dueDate(), command.discountDate(), command.paymentTerms(),
                    command.nominalRate(), command.effectiveRate(), command.tcea(), command.status(), command.initialCosts(), command.finalCosts()));
            return Optional.of(updatedDocument);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error updating document with id " + id);
        }
    }

    @Override
    public void handle(DeleteDocumentCommand command) {
        documentRepository.deleteById(command.id());
    }
}