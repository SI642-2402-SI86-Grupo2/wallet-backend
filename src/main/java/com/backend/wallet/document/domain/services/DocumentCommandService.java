package com.backend.wallet.document.domain.services;

import com.backend.wallet.document.domain.model.commands.CreateDocumentCommand;
import com.backend.wallet.document.domain.model.commands.UpdateDocumentCommand;
import com.backend.wallet.document.domain.model.commands.DeleteDocumentCommand;
import com.backend.wallet.document.domain.model.aggregates.Document;

import java.util.Optional;

public interface DocumentCommandService {
    Optional<Document> handle(CreateDocumentCommand command);
    Optional<Document> handle(UpdateDocumentCommand command);
    void handle(DeleteDocumentCommand command);
}