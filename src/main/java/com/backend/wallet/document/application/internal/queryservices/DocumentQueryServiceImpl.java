package com.backend.wallet.document.application.internal.queryservices;

import com.backend.wallet.document.domain.model.aggregates.Document;
import com.backend.wallet.document.domain.model.queries.GetAllDocumentsQuery;
import com.backend.wallet.document.domain.model.queries.GetDocumentByIdQuery;
import com.backend.wallet.document.domain.model.queries.GetDocumentByPortfolioIdQuery;

import com.backend.wallet.document.domain.services.DocumentQueryService;
import com.backend.wallet.document.infrastructure.persistence.jpa.repositories.DocumentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentQueryServiceImpl implements DocumentQueryService {
    private final DocumentRepository documentRepository;

    public DocumentQueryServiceImpl(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    @Override
    public List<Document> handle(GetAllDocumentsQuery query) {
        return documentRepository.findAll();
    }

    @Override
    public Optional<Document> handle(GetDocumentByIdQuery query) {
        return documentRepository.findById(query.id());
    }

    @Override
    public List<Document> handle(GetDocumentByPortfolioIdQuery query) {
        return documentRepository.findByPortfolioId(query.portfolioId());
    }
}
