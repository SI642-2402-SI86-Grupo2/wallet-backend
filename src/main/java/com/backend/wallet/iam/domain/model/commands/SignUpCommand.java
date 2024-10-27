package com.backend.wallet.iam.domain.model.commands;

import com.backend.wallet.iam.domain.model.entities.Role;

import java.util.List;

public record SignUpCommand(String email, String password, List<Role> roles) {
}
