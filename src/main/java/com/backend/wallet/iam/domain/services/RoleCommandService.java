package com.backend.wallet.iam.domain.services;

import com.backend.wallet.iam.domain.model.commands.SeedRolesCommand;

public interface RoleCommandService {
    void handle(SeedRolesCommand command);
}
