package com.backend.wallet.profile.application.internal.commandservices;

import com.backend.wallet.iam.domain.model.aggregates.User;
import com.backend.wallet.iam.infrastructure.persistence.jpa.repositories.UserRepository;
import com.backend.wallet.profile.domain.model.aggregates.Profile;
import com.backend.wallet.profile.domain.model.commands.CreateProfileCommand;
import com.backend.wallet.profile.domain.model.commands.UpdateProfileCommand;
import com.backend.wallet.profile.domain.model.commands.UpdateProfilePhotoCommand;
import com.backend.wallet.profile.domain.services.ProfileCommandService;
import com.backend.wallet.profile.infrastructure.persistence.jpa.repositories.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfileCommandServiceImpl implements ProfileCommandService {
    private final ProfileRepository profileRepository;
    private final UserRepository userRepository;
    public ProfileCommandServiceImpl(ProfileRepository profileRepository, UserRepository userRepository) {
        this.profileRepository = profileRepository;
        this.userRepository = userRepository;
    }
    @Override
    public Optional<Profile> handle(CreateProfileCommand command) {
        User user = userRepository.findById(command.userId()).orElseThrow(() -> new IllegalArgumentException("User with id " + command.userId() + " does not exist"));
        // Check if the profile already has a profile
        if (profileRepository.existsByUserId(command.userId())) {
            throw new IllegalArgumentException("User with id " + command.userId() + " already has a profile");
        }
        var profile = new Profile(command, user);
        profileRepository.save(profile);
        return Optional.of(profile);
    }


    @Override
    public Optional<Profile> handle(UpdateProfilePhotoCommand command) {
        var id = command.id();
        if (!profileRepository.existsById(id))
            throw new IllegalArgumentException("Profile with id "+ id +" does not exist");
        var result = profileRepository.findById(id);
        var profileToUpdate = result.get();
        try {
            var updateProfile = profileRepository.save(profileToUpdate.upsetImage(command.photo()));
            return Optional.of(updateProfile);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error updating profile with id "+ id);
        }
    }

    @Override
    public Optional<Profile> handle(UpdateProfileCommand command) {
        var id = command.id();
        if (!profileRepository.existsById(id))
            throw new IllegalArgumentException("Profile with id "+ id +" does not exist");
        var result = profileRepository.findById(id);
        var profileToUpdate = result.get();
        try {
            var updateProfile = profileRepository.save(profileToUpdate.updateProfile(command.firstName(), command.lastName(),command.email(),  command.photo()));
            return Optional.of(updateProfile);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error updating profile with id "+ id);
        }
    }
}
