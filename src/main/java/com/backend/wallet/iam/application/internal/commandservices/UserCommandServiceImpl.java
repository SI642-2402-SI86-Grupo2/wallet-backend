package com.backend.wallet.iam.application.internal.commandservices;

import com.backend.wallet.iam.application.internal.outboundservices.hashing.HashingService;
import com.backend.wallet.iam.application.internal.outboundservices.tokens.TokenService;
import com.backend.wallet.iam.domain.model.aggregates.User;
import com.backend.wallet.iam.domain.model.commands.SignInCommand;
import com.backend.wallet.iam.domain.model.commands.SignUpCommand;
import com.backend.wallet.iam.domain.model.valueobjects.Roles;
import com.backend.wallet.iam.domain.services.UserCommandService;
import com.backend.wallet.iam.infrastructure.persistence.jpa.repositories.RoleRepository;
import com.backend.wallet.iam.infrastructure.persistence.jpa.repositories.UserRepository;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.regex.Pattern;

@Service
public class UserCommandServiceImpl implements UserCommandService {
    private final UserRepository userRepository;
    private final HashingService hashingService;
    private final TokenService tokenService;
    private final RoleRepository roleRepository;

    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
            Pattern.CASE_INSENSITIVE
    );

    public UserCommandServiceImpl(UserRepository userRepository, HashingService hashingService, TokenService tokenService, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.hashingService = hashingService;
        this.tokenService = tokenService;
        this.roleRepository = roleRepository;
    }

    @Override
    public Optional<User> handle(SignUpCommand command) {
        if (!EMAIL_PATTERN.matcher(command.email()).matches()) {
            throw new RuntimeException("Invalid email format");
        }
        if (userRepository.existsByEmail(command.email())) {
            throw new RuntimeException("Email already exists");
        }
        var roles = command.roles();
        if (roles.isEmpty()) {
            var role = roleRepository.findByName(Roles.ROLE_USER);
            roles.add(role.get());
        }
        roles = command.roles().stream()
                .map(role -> roleRepository.findByName(role.getName())
                        .orElseThrow(() -> new RuntimeException("Role not found"))).toList();
        var user = new User(command.email(), hashingService.encode(command.password()), roles);
        userRepository.save(user);
        return userRepository.findByEmail(command.email());
    }

    @Override
    public Optional<ImmutablePair<User, String>> handle(SignInCommand command) {
        if (!EMAIL_PATTERN.matcher(command.email()).matches()) {
            throw new RuntimeException("Invalid email format");
        }
        var user = userRepository.findByEmail(command.email());
        if (user.isEmpty()) throw new RuntimeException("User not found");
        if (!hashingService.matches(command.password(), user.get().getPassword()))
            throw new RuntimeException("Invalid password");
        var currentUser = user.get();
        var token = tokenService.generateToken(currentUser.getEmail());
        return Optional.of(ImmutablePair.of(currentUser, token));
    }
}