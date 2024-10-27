package com.backend.wallet.profile.interfaces.rest.resources;

public record CreateProfileResource(
        String firstName,
        String lastName,
        String email,
        String photo,
        Long userId) {
}
