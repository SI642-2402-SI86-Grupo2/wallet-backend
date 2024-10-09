package pe.edu.pe.walletbackend1.dtos;

public class AuthResponse {
    private String token;

    // Constructor that accepts a token
    public AuthResponse(String token) {
        this.token = token;
    }

    // Default constructor
    public AuthResponse() {
    }

    // Getters and Setters
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}