package com.backend.wallet.iam.domain.model.queries;

import com.backend.wallet.iam.domain.model.valueobjects.Roles;

public record GetRoleByNameQuery(Roles name) {
}
