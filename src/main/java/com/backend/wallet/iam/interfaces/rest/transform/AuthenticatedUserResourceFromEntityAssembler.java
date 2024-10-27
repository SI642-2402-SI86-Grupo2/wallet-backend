package com.backend.wallet.iam.interfaces.rest.transform;

import com.backend.wallet.iam.domain.model.aggregates.User;
import com.backend.wallet.iam.interfaces.rest.resources.AuthenticatedUserResource;

public class AuthenticatedUserResourceFromEntityAssembler {
    public static AuthenticatedUserResource toResourceFromEntity(User entity, String token, String role) {
        return new AuthenticatedUserResource(entity.getId(), entity.getEmail(), token, role);
    }
}
