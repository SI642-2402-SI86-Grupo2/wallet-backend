package pe.edu.pe.walletbackend1.serviceinterface;

import pe.edu.pe.walletbackend1.entities.Documents;

import java.util.List;

public interface IDocumentsService {

    List<Documents> list();

    void insert(Documents documents);

    void update(Documents documents);

    void delete(int documentsId);

    Documents listId(int id);
}