package com.backend.wallet.profile.interfaces.rest.transform;

import com.backend.wallet.profile.domain.model.commands.UpdateProfilePhotoCommand;
import com.backend.wallet.profile.interfaces.rest.resources.UpdateProfilePhotoResource;

public class UpdateProfilePhotoCommandFromResourceAssembler {
    public static UpdateProfilePhotoCommand toCommandFromResource(Long id, UpdateProfilePhotoResource resource){
        return new UpdateProfilePhotoCommand(
                id,
                resource.photo()
        );
    }
}
