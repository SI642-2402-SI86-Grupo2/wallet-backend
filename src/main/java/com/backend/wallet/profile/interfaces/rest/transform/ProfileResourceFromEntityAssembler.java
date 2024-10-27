package com.backend.wallet.profile.interfaces.rest.transform;

import com.backend.wallet.profile.domain.model.aggregates.Profile;
import com.backend.wallet.profile.interfaces.rest.resources.ProfileResource;

public class ProfileResourceFromEntityAssembler {
    public static ProfileResource toResourceFromEntity(Profile entity){
        return new ProfileResource(
                entity.getId(),
                entity.getName().getFullName(),
                entity.getEmail(),
                entity.getPhoto(),
                entity.getUser().getId()
        );
    }
}
