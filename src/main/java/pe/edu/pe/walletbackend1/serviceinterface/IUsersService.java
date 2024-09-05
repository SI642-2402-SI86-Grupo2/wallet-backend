package pe.edu.pe.walletbackend1.serviceinterface;

import pe.edu.pe.walletbackend1.entities.Users;

import java.util.List;

public interface IUsersService {

    List<Users> list();

    void insert(Users users);

    void update(Users users);

    void delete(int id_users);

    Users listId(int id);

    boolean emailExists(String email);
}