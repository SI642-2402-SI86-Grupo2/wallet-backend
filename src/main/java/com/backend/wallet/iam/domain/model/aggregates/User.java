package com.backend.wallet.iam.domain.model.aggregates;

import com.backend.wallet.iam.domain.model.entities.Role;
import com.backend.wallet.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
public class User extends AuditableAbstractAggregateRoot<User> {

    @Getter
    @NotBlank
    @Email
    @Size(max = 120)
    @Column(unique = true)
    private String email;

    @Getter
    @NotBlank
    @Size(max = 120)
    private String password;

    @Getter
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public User() { this.roles = new HashSet<>();}

    public User(String email, String password) {
        this();
        this.email = email;
        this.password = password;
    }

    public User(String email, String password, List<Role> roles) {
        this(email, password);
        addRoles(roles);
    }

    public User addRole(Role role) {
        this.roles.add(role);
        return this;
    }

    public User addRoles(List<Role> roles) {
        var validatedRoles = Role.validateRoleSet(roles);
        this.roles.addAll(validatedRoles);
        return this;
    }

    public String getRole() {
        return roles.stream().map(Role::getStringName).collect(Collectors.joining(","));
    }
}