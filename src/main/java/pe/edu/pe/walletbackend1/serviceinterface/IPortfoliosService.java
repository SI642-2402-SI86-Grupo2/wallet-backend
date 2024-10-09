package pe.edu.pe.walletbackend1.serviceinterface;


import pe.edu.pe.walletbackend1.entities.Portfolios;


public interface IPortfoliosService {

    public Portfolios listId(int id);

    public void insert (Portfolios p);

    public void update (Portfolios p);

    public void delete (int id_portfolio);
}
