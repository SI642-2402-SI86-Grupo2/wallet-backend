package pe.edu.pe.walletbackend1.controllers;

import pe.edu.pe.walletbackend1.dtos.LoginRequest;
import pe.edu.pe.walletbackend1.dtos.SignupRequest;
import pe.edu.pe.walletbackend1.dtos.AuthResponse;
import pe.edu.pe.walletbackend1.entities.Users;
import pe.edu.pe.walletbackend1.serviceinterface.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private IUserService userService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(userService.login(request));
    }

    @PostMapping("/signup")
    public ResponseEntity<Users> signup(@RequestBody SignupRequest request) {
        return ResponseEntity.ok(userService.signup(request));
    }
}