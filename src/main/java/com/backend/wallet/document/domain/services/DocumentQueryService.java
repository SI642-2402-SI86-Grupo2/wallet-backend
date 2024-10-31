package com.backend.wallet.document.domain.services;

import com.backend.wallet.document.domain.model.queries.GetAllDocumentsQuery;
import com.backend.wallet.document.domain.model.queries.GetDocumentByIdQuery;

import com.backend.wallet.document.domain.model.aggregates.Document;
import com.backend.wallet.document.domain.model.queries.GetDocumentByPortfolioIdQuery;

import java.util.List;
import java.util.Optional;

public interface DocumentQueryService {
    List<Document> handle(GetAllDocumentsQuery query);
    Optional<Document> handle(GetDocumentByIdQuery query);
    List<Document> handle(GetDocumentByPortfolioIdQuery query);

}