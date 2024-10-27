package com.backend.wallet.iam.interfaces.rest.resources;

public record AuthenticatedUserResource(Long id, String email, String token, String role) {
}
