package pe.edu.pe.walletbackend1.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.pe.walletbackend1.dtos.DocumentsDTO;
import pe.edu.pe.walletbackend1.entities.Documents;
import pe.edu.pe.walletbackend1.entities.Portfolios;
import pe.edu.pe.walletbackend1.serviceinterface.IDocumentsService;
import pe.edu.pe.walletbackend1.serviceinterface.IPortfoliosService;

@RestController
@RequestMapping("/documents")
public class DocumentsController {

    @Autowired
    private IDocumentsService documentsService;

    @Autowired
    private IPortfoliosService portfoliosService;

    @GetMapping("/{id}")
    public DocumentsDTO listarID(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        DocumentsDTO dto = m.map(documentsService.listId(id), DocumentsDTO.class);
        return dto;
    }

    @PostMapping
    public void registrar(@RequestBody DocumentsDTO dto) {
        Portfolios portfolio = portfoliosService.listId(dto.getPortfoliosId());
        if (portfolio == null) {
            throw new IllegalArgumentException("Portfolio ID not found");
        }
        ModelMapper m = new ModelMapper();
        Documents d = m.map(dto, Documents.class);
        d.setPortfolios(portfolio); // Set the portfolio entity
        documentsService.insert(d);
    }

    @PutMapping("/{id}")
    public void modificar(@PathVariable("id") Integer id, @RequestBody DocumentsDTO dto) {
        Portfolios portfolio = portfoliosService.listId(dto.getPortfoliosId());
        if (portfolio == null) {
            throw new IllegalArgumentException("Portfolio ID not found");
        }
        Documents existingDocument = documentsService.listId(id);
        if (existingDocument != null) {
            ModelMapper m = new ModelMapper();
            Documents updatedDocument = m.map(dto, Documents.class);
            updatedDocument.setDocumentsId(existingDocument.getDocumentsId());
            updatedDocument.setPortfolios(portfolio); // Set the portfolio entity
            documentsService.update(updatedDocument);
        }
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        documentsService.delete(id);
    }
}