package com.backend.wallet.profile.interfaces.acl;

import com.backend.wallet.profile.domain.model.commands.CreateProfileCommand;
import com.backend.wallet.profile.domain.model.commands.UpdateProfileCommand;
import com.backend.wallet.profile.domain.model.queries.GetProfileByEmailQuery;
import com.backend.wallet.profile.domain.services.ProfileCommandService;
import com.backend.wallet.profile.domain.services.ProfileQueryService;
import org.springframework.stereotype.Service;

@Service
public class ProfileContextFacade {
    private final ProfileCommandService profileCommandService;
    private final ProfileQueryService profileQueryService;

    public ProfileContextFacade(ProfileCommandService profileCommandService, ProfileQueryService profileQueryService) {
        this.profileCommandService = profileCommandService;
        this.profileQueryService = profileQueryService;

    }

    public Long createProfile(String firstName, String lastName, String email, String photo, Long userId){
        var createProfileCommand = new CreateProfileCommand(firstName, lastName, email, photo, userId);
        var profile = profileCommandService.handle(createProfileCommand);
        if (profile.isEmpty()) return 0L;
        return profile.get().getId();
    }

    public boolean updateProfile(Long profileId, String firstName, String lastName, String email, String photo) {
        var updateProfileCommand = new UpdateProfileCommand(profileId, firstName, lastName, email, photo);
        var updatedProfile = profileCommandService.handle(updateProfileCommand);
        return updatedProfile.isPresent();
    }

    public Long fetchProfileIdByPhoneNumber(String phoneNumber) {
        var getProfileByPhoneNumberQuery = new GetProfileByEmailQuery(phoneNumber);
        var profile = profileQueryService.handle(getProfileByPhoneNumberQuery);
        if (profile.isEmpty()) return 0L;
        return profile.get().getId();
    }
}
