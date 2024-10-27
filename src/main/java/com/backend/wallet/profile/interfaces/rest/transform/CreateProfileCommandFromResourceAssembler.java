package com.backend.wallet.profile.interfaces.rest.transform;

import com.backend.wallet.profile.domain.model.commands.CreateProfileCommand;
import com.backend.wallet.profile.interfaces.rest.resources.CreateProfileResource;

public class CreateProfileCommandFromResourceAssembler {
    public static CreateProfileCommand toCommandFromResource(CreateProfileResource resource){
        return new CreateProfileCommand(
                resource.firstName(),
                resource.lastName(),
                resource.email(),
                resource.photo(),
                resource.userId()
        );
    }
}


