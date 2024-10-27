package com.backend.wallet.profile.domain.model.commands;


public record CreateProfileCommand(
        String firstName,
        String lastName,
        String email,
        String photo,
        Long userId
) {
}