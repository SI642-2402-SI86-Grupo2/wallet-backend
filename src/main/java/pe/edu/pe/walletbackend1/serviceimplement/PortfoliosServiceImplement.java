package pe.edu.pe.walletbackend1.serviceimplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.pe.walletbackend1.entities.Portfolios;
import pe.edu.pe.walletbackend1.repositories.IPortfoliosRepository;
import pe.edu.pe.walletbackend1.serviceinterface.IPortfoliosService;

@Service
public class PortfoliosServiceImplement implements IPortfoliosService {

    @Autowired
    private IPortfoliosRepository portfoliosRepository;

    @Override
    public Portfolios listId(int id) {
        return portfoliosRepository.findById(id).orElse(new Portfolios());
    }

    @Override
    public void insert(Portfolios p) {
        portfoliosRepository.save(p);
    }

    @Override
    public void update(Portfolios p) {
        portfoliosRepository.save(p);
    }

    @Override
    public void delete(int id_portfolio) {
        portfoliosRepository.deleteById(id_portfolio);

    }
}
