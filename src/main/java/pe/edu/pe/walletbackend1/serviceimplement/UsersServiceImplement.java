package pe.edu.pe.walletbackend1.serviceimplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pe.edu.pe.walletbackend1.dtos.LoginRequest;
import pe.edu.pe.walletbackend1.dtos.SignupRequest;
import pe.edu.pe.walletbackend1.dtos.AuthResponse;
import pe.edu.pe.walletbackend1.entities.Users;
import pe.edu.pe.walletbackend1.repositories.IUsersRepository;
import pe.edu.pe.walletbackend1.serviceinterface.IUserService;

import java.util.List;

@Service
public class UsersServiceImplement implements IUserService {

    @Autowired
    private IUsersRepository usersRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public List<Users> list() {
        return usersRepository.findAll();
    }

    @Override
    public Users listId(Integer id) {
        return usersRepository.findById(id).orElse(null);
    }

    @Override
    public boolean emailExists(String email) {
        return usersRepository.findByEmail(email) != null;
    }

    @Override
    public void insert(Users user) {
        usersRepository.save(user);
    }

    @Override
    public void update(Users user) {
        usersRepository.save(user);
    }

    @Override
    public void delete(Integer id) {
        usersRepository.deleteById(id);
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        Users user = usersRepository.findByEmail(request.getEmail());
        if (user != null && passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            // Generate token (implementation not shown)
            String token = "generated-jwt-token";
            return new AuthResponse(token);
        } else {
            throw new IllegalArgumentException("Invalid email or password");
        }
    }

    @Override
    public Users signup(SignupRequest request) {
        Users user = new Users();
        user.setFirstname(request.getFirstname());
        user.setLastname(request.getLastname());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setImage(request.getImage());
        return usersRepository.save(user);
    }
}