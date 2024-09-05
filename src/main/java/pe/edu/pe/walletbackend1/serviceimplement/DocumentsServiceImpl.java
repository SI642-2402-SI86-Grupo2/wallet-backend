package pe.edu.pe.walletbackend1.serviceimplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.pe.walletbackend1.entities.Documents;
import pe.edu.pe.walletbackend1.repositories.IDocumentsRepository;
import pe.edu.pe.walletbackend1.serviceinterface.IDocumentsService;

import java.util.List;

@Service
public class DocumentsServiceImpl implements IDocumentsService {

    @Autowired
    private IDocumentsRepository documentsRepository;

    @Override
    public List<Documents> list() {
        return documentsRepository.findAll();
    }

    @Override
    public void insert(Documents documents) {
        documentsRepository.save(documents);
    }

    @Override
    public void update(Documents documents) {
        documentsRepository.save(documents);
    }

    @Override
    public void delete(int documentsId) {
        documentsRepository.deleteById(documentsId);
    }

    @Override
    public Documents listId(int id) {
        return documentsRepository.findById(id).orElse(null);
    }
}