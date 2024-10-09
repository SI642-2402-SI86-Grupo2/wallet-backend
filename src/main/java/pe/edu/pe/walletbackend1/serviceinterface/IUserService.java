package pe.edu.pe.walletbackend1.serviceinterface;

import pe.edu.pe.walletbackend1.dtos.LoginRequest;
import pe.edu.pe.walletbackend1.dtos.SignupRequest;
import pe.edu.pe.walletbackend1.dtos.AuthResponse;
import pe.edu.pe.walletbackend1.entities.Users;

import java.util.List;

public interface IUserService {
    List<Users> list();
    Users listId(Integer id);
    boolean emailExists(String email);
    void insert(Users user);
    void update(Users user);
    void delete(Integer id);
    AuthResponse login(LoginRequest request);
    Users signup(SignupRequest request);
}