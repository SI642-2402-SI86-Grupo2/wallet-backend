package com.backend.wallet.profile.interfaces.rest.resources;

public record UpdateProfileResource(
        String firstName,
        String lastName,
        String email,
        String photo
) {
}
