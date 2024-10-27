package com.backend.wallet.profile.interfaces.rest.transform;

import com.backend.wallet.profile.domain.model.commands.UpdateProfileCommand;
import com.backend.wallet.profile.interfaces.rest.resources.UpdateProfileResource;

public class UpdateProfileCommandFromResourceAssembler {
    public static UpdateProfileCommand toCommandFromResource(Long id, UpdateProfileResource resource){
        return new UpdateProfileCommand(
                id,
                resource.firstName(),
                resource.lastName(),
                resource.email(),
                resource.photo()
        );
    }
}
