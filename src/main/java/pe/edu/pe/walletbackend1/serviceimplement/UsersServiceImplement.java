package pe.edu.pe.walletbackend1.serviceimplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.pe.walletbackend1.entities.Users;
import pe.edu.pe.walletbackend1.repositories.IUsersRepository;
import pe.edu.pe.walletbackend1.serviceinterface.IUsersService;

import java.util.List;

@Service
public class UsersServiceImplement implements IUsersService {

    @Autowired
    private IUsersRepository usersRepository;

    @Override
    public List<Users> list() {
        return usersRepository.findAll();
    }

    @Override
    public void insert(Users users) {
        usersRepository.save(users);
    }

    @Override
    public void update(Users users) {
        usersRepository.save(users);
    }

    @Override
    public void delete(int id_users) {
        usersRepository.deleteById(id_users);
    }
}
