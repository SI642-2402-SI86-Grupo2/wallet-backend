package com.backend.wallet.profile.interfaces.rest.resources;

public record ProfileResource
        (
        Long id,
        String fullName,
        String email,
        String photo,
        Long userId)
{
}
