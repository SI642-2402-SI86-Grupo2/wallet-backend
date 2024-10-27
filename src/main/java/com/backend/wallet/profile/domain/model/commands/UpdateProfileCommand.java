package com.backend.wallet.profile.domain.model.commands;

public record UpdateProfileCommand(
        Long id,
        String firstName,
        String lastName,
        String email,
        String photo
) {
}
