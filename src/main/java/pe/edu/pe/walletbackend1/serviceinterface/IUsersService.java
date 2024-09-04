package pe.edu.pe.walletbackend1.serviceinterface;

import pe.edu.pe.walletbackend1.entities.Users;

import java.util.List;

public interface IUsersService {

    public List<Users> list();

    public void insert (Users users);

    public void update (Users users);

    public void delete (int id_users);

}
