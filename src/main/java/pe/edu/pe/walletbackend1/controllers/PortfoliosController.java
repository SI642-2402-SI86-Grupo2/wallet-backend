package pe.edu.pe.walletbackend1.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.pe.walletbackend1.dtos.PortfoliosDTO;
import pe.edu.pe.walletbackend1.dtos.UsersDTO;
import pe.edu.pe.walletbackend1.entities.Portfolios;
import pe.edu.pe.walletbackend1.entities.Users;
import pe.edu.pe.walletbackend1.serviceinterface.IPortfoliosService;

@RestController
@RequestMapping("/controllers")
public class PortfoliosController {

    @Autowired
    private IPortfoliosService portfoliosService;

    @GetMapping("/{id}")
    public PortfoliosDTO listarID(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        PortfoliosDTO dto=m.map(portfoliosService.listId(id), PortfoliosDTO.class);
        return dto;
    }

    @PostMapping
    public void registrar (@RequestBody PortfoliosDTO dto) {
        ModelMapper m = new ModelMapper();
        Portfolios p = m.map(dto, Portfolios.class); //transforma el dto
        portfoliosService.insert(p);
    };

    @PutMapping
    public void modificar (@RequestBody PortfoliosDTO dto) {
        ModelMapper m = new ModelMapper();
        Portfolios p = m.map(dto, Portfolios.class); //transformamos el dto
        portfoliosService.update(p);
    };

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id){
        portfoliosService.delete(id);
    }
}
