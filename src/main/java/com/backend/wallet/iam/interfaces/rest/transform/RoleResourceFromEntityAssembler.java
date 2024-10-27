package com.backend.wallet.iam.interfaces.rest.transform;

import com.backend.wallet.iam.domain.model.entities.Role;
import com.backend.wallet.iam.interfaces.rest.resources.RoleResource;

public class RoleResourceFromEntityAssembler {
    public static RoleResource toResourceFromEntity(Role entity) {
        return new RoleResource(entity.getId(), entity.getStringName());

    }
}
