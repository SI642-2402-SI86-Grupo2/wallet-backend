package com.backend.wallet.document.interfaces.rest;

import com.backend.wallet.document.domain.model.commands.DeleteDocumentCommand;
import com.backend.wallet.document.domain.model.queries.GetAllDocumentsQuery;
import com.backend.wallet.document.domain.model.queries.GetDocumentByIdQuery;
import com.backend.wallet.document.domain.model.queries.GetDocumentByPortfolioIdQuery;
import com.backend.wallet.document.domain.services.DocumentCommandService;
import com.backend.wallet.document.domain.services.DocumentQueryService;
import com.backend.wallet.document.interfaces.rest.resources.CreateDocumentResource;
import com.backend.wallet.document.interfaces.rest.resources.DocumentResource;
import com.backend.wallet.document.interfaces.rest.resources.UpdateDocumentResource;
import com.backend.wallet.document.interfaces.rest.transform.CreateDocumentCommandFromResourceAssembler;
import com.backend.wallet.document.interfaces.rest.transform.DocumentResourceFromEntityAssembler;
import com.backend.wallet.document.interfaces.rest.transform.UpdateDocumentCommandFromResourceAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1/document", produces = MediaType.APPLICATION_JSON_VALUE)
public class DocumentController {
    private final DocumentCommandService documentCommandService;
    private final DocumentQueryService documentQueryService;

    public DocumentController(DocumentCommandService documentCommandService, DocumentQueryService documentQueryService) {
        this.documentCommandService = documentCommandService;
        this.documentQueryService = documentQueryService;
    }

    @PostMapping
    public ResponseEntity<DocumentResource> createDocument(@RequestBody CreateDocumentResource resource) {
        var createDocumentCommand = CreateDocumentCommandFromResourceAssembler.toCommandFromResource(resource);
        try {
            var document = documentCommandService.handle(createDocumentCommand);
            if (document.isEmpty()) return ResponseEntity.badRequest().build();
            var documentResource = DocumentResourceFromEntityAssembler.toResourceFromEntity(document.get());
            return new ResponseEntity<>(documentResource, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<DocumentResource>> getAllDocuments() {
        var documents = documentQueryService.handle(new GetAllDocumentsQuery());
        var documentResources = documents.stream()
                .map(DocumentResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(documentResources);
    }

    @GetMapping("/{documentId}")
    public ResponseEntity<DocumentResource> getDocumentById(@PathVariable Long documentId) {
        var getDocumentByIdQuery = new GetDocumentByIdQuery(documentId);
        var document = documentQueryService.handle(getDocumentByIdQuery);
        if (document.isEmpty()) return ResponseEntity.notFound().build();
        var documentResource = DocumentResourceFromEntityAssembler.toResourceFromEntity(document.get());
        return ResponseEntity.ok(documentResource);
    }

    @GetMapping("/portfolio/{portfolioId}")
    public ResponseEntity<List<DocumentResource>> getDocumentsByPortfolioId(@PathVariable Long portfolioId) {
        var query = new GetDocumentByPortfolioIdQuery(portfolioId);
        var documents = documentQueryService.handle(query);
        var documentResources = documents.stream()
                .map(DocumentResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(documentResources);
    }


    @PutMapping("/{documentId}")
    public ResponseEntity<DocumentResource> updateDocument(@PathVariable Long documentId, @RequestBody UpdateDocumentResource resource) {
        var updateDocumentCommand = UpdateDocumentCommandFromResourceAssembler.toCommandFromResource(documentId, resource);
        var updatedDocument = documentCommandService.handle(updateDocumentCommand);
        if (updatedDocument.isEmpty()) return ResponseEntity.notFound().build();
        var updatedDocumentResource = DocumentResourceFromEntityAssembler.toResourceFromEntity(updatedDocument.get());
        return ResponseEntity.ok(updatedDocumentResource);
    }

    @DeleteMapping("/{documentId}")
    public ResponseEntity<Void> deleteDocument(@PathVariable Long documentId) {
        var deleteDocumentCommand = new DeleteDocumentCommand(documentId);
        documentCommandService.handle(deleteDocumentCommand);
        return ResponseEntity.noContent().build();
    }
}