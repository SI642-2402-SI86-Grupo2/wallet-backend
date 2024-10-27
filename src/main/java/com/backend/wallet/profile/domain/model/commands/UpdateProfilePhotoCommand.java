package com.backend.wallet.profile.domain.model.commands;

public record UpdateProfilePhotoCommand(
        Long id,
        String photo
) {
}
