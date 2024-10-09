package pe.edu.pe.walletbackend1.controllers;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.pe.walletbackend1.dtos.UsersDTO;
import pe.edu.pe.walletbackend1.entities.Users;
import pe.edu.pe.walletbackend1.serviceinterface.IUserService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private IUserService uSv;

    @GetMapping
    public List<UsersDTO> listar() {
        return uSv.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, UsersDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public UsersDTO obtenerPorId(@PathVariable("id") Integer id) {
        Users user = uSv.listId(id);
        if (user != null) {
            ModelMapper m = new ModelMapper();
            return m.map(user, UsersDTO.class);
        }
        return null; // or throw an exception if preferred
    }

    @PostMapping
    public void registrar(@Valid @RequestBody UsersDTO dto) {
        if (uSv.emailExists(dto.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }
        ModelMapper m = new ModelMapper();
        Users usrs = m.map(dto, Users.class); // transforma el dto
        uSv.insert(usrs);
    }

    @PutMapping("/{id}")
    public void modificar(@PathVariable("id") Integer id, @Valid @RequestBody UsersDTO dto) {
        Users existingUser = uSv.listId(id);
        if (existingUser != null) {
            if (!existingUser.getEmail().equals(dto.getEmail()) && uSv.emailExists(dto.getEmail())) {
                throw new IllegalArgumentException("Email already exists");
            }
            ModelMapper m = new ModelMapper();
            Users updatedUser = m.map(dto, Users.class);
            updatedUser.setUserid(existingUser.getUserid());
            uSv.update(updatedUser);
        }
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        uSv.delete(id);
    }
}