package com.backend.wallet.iam.interfaces.rest.transform;

import com.backend.wallet.iam.domain.model.commands.SignInCommand;
import com.backend.wallet.iam.interfaces.rest.resources.SignInResource;

public class SignInCommandFromResourceAssembler {
    public static SignInCommand toCommandFromResource(SignInResource resource) {
        return new SignInCommand(resource.email(), resource.password());
    }
}
