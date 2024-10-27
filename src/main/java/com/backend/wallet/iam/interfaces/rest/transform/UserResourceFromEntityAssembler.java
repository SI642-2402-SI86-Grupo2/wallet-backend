package com.backend.wallet.iam.interfaces.rest.transform;

import com.backend.wallet.iam.domain.model.aggregates.User;
import com.backend.wallet.iam.domain.model.entities.Role;
import com.backend.wallet.iam.interfaces.rest.resources.UserResource;

public class UserResourceFromEntityAssembler {
    public static UserResource toResourceFromEntity(User entity) {
        var roles = entity.getRoles().stream().map(Role::getStringName).toList();
        return new UserResource(entity.getId(), entity.getEmail(), roles);
    }
}
