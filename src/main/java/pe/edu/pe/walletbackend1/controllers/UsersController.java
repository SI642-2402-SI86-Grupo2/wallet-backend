package pe.edu.pe.walletbackend1.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.pe.walletbackend1.dtos.UsersDTO;
import pe.edu.pe.walletbackend1.entities.Users;
import pe.edu.pe.walletbackend1.serviceinterface.IUsersService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsersController {

    @Autowired
    private IUsersService usersService;

    @GetMapping
    public List<UsersDTO> listar() {
        return usersService.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,UsersDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void registrar (@RequestBody UsersDTO dto) {
        ModelMapper m = new ModelMapper();
        Users usrs = m.map(dto, Users.class); //transforma el dto
        usersService.insert(usrs);
    };

    @PutMapping
    public void modificar (@RequestBody UsersDTO dto) {
        ModelMapper m = new ModelMapper();
        Users  usrs = m.map(dto, Users.class); //transformamos el dto
        usersService.update(usrs);
    };

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        usersService.delete(id);
    }


}
