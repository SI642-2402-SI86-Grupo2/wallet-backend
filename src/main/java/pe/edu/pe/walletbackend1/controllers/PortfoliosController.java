package pe.edu.pe.walletbackend1.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.pe.walletbackend1.dtos.PortfoliosDTO;
import pe.edu.pe.walletbackend1.entities.Portfolios;
import pe.edu.pe.walletbackend1.entities.Users;
import pe.edu.pe.walletbackend1.serviceinterface.IPortfoliosService;
import pe.edu.pe.walletbackend1.serviceinterface.IUserService;

@RestController
@RequestMapping("/portfolios")
public class PortfoliosController {

    @Autowired
    private IPortfoliosService portfoliosService;

    @Autowired
    private IUserService usersService;

    @GetMapping("/{id}")
    public PortfoliosDTO listarID(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        PortfoliosDTO dto = m.map(portfoliosService.listId(id), PortfoliosDTO.class);
        return dto;
    }

    @PostMapping
    public void registrar(@RequestBody PortfoliosDTO dto) {
        Users user = usersService.listId(dto.getUserId());
        if (user == null) {
            throw new IllegalArgumentException("User ID not found");
        }
        ModelMapper m = new ModelMapper();
        Portfolios p = m.map(dto, Portfolios.class);
        p.setUser(user); // Set the user entity
        portfoliosService.insert(p);
    }

    @PutMapping("/{id}")
    public void modificar(@PathVariable("id") Integer id, @RequestBody PortfoliosDTO dto) {
        Users user = usersService.listId(dto.getUserId());
        if (user == null) {
            throw new IllegalArgumentException("User ID not found");
        }
        Portfolios existingPortfolio = portfoliosService.listId(id);
        if (existingPortfolio != null) {
            ModelMapper m = new ModelMapper();
            Portfolios updatedPortfolio = m.map(dto, Portfolios.class);
            updatedPortfolio.setPortfolioid(existingPortfolio.getPortfolioid());
            updatedPortfolio.setUser(user);
            portfoliosService.update(updatedPortfolio);
        }
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        portfoliosService.delete(id);
    }
}