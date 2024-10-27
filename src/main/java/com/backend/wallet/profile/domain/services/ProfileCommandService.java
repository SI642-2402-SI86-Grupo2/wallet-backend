package com.backend.wallet.profile.domain.services;

import com.backend.wallet.profile.domain.model.aggregates.Profile;
import com.backend.wallet.profile.domain.model.commands.CreateProfileCommand;
import com.backend.wallet.profile.domain.model.commands.UpdateProfileCommand;
import com.backend.wallet.profile.domain.model.commands.UpdateProfilePhotoCommand;

import java.util.Optional;

public interface ProfileCommandService {
    Optional<Profile> handle(CreateProfileCommand command);
    Optional<Profile> handle(UpdateProfilePhotoCommand command);
    Optional<Profile> handle(UpdateProfileCommand command);
}
