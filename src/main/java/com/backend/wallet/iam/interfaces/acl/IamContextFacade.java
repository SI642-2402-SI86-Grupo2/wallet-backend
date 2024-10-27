package com.backend.wallet.iam.interfaces.acl;

import com.backend.wallet.iam.domain.model.commands.SignUpCommand;
import com.backend.wallet.iam.domain.model.entities.Role;
import com.backend.wallet.iam.domain.model.queries.GetUserByEmailQuery;
import com.backend.wallet.iam.domain.model.queries.GetUserByIdQuery;
import com.backend.wallet.iam.domain.services.UserCommandService;
import com.backend.wallet.iam.domain.services.UserQueryService;
import org.apache.logging.log4j.util.Strings;

import java.util.ArrayList;
import java.util.List;

/**
 * IamContextFacade
 * <p>
 *     This class is a facade for the IAM context. It provides a simple interface for other bounded contexts to interact with the
 *     IAM context.
 *     This class is a part of the ACL layer.
 * </p>
 *
 */
public class IamContextFacade {
    private final UserCommandService userCommandService;
    private final UserQueryService userQueryService;

    public IamContextFacade(UserCommandService userCommandService, UserQueryService userQueryService) {
        this.userCommandService = userCommandService;
        this.userQueryService = userQueryService;
    }

    /**
     * Creates a profile with the given email and password.
     * @param email The email of the profile.
     * @param password The password of the profile.
     * @return The id of the created profile.
     */
    public Long createUser(String email, String password) {
        var signUpCommand = new SignUpCommand(email, password, List.of(Role.getDefaultRole()));
        var result = userCommandService.handle(signUpCommand);
        if (result.isEmpty()) return 0L;
        return result.get().getId();
    }

    /**
     * Creates a profile with the given email, password and roles.
     * @param email The email of the profile.
     * @param password The password of the profile.
     * @param roleNames The names of the roles of the profile. When a role does not exist, it is ignored.
     * @return The id of the created profile.
     */
    public Long createUser(String email, String password, List<String> roleNames) {
        var roles = roleNames != null ? roleNames.stream().map(Role::toRoleFromName).toList() : new ArrayList<Role>();
        var signUpCommand = new SignUpCommand(email, password, roles);
        var result = userCommandService.handle(signUpCommand);
        if (result.isEmpty()) return 0L;
        return result.get().getId();
    }

    /**
     * Fetches the id of the profile with the given email.
     * @param email The email of the profile.
     * @return The id of the profile.
     */
    public Long fetchUserIdByEmail(String email) {
        var getUserByEmailQuery = new GetUserByEmailQuery(email);
        var result = userQueryService.handle(getUserByEmailQuery);
        if (result.isEmpty()) return 0L;
        return result.get().getId();
    }

    /**
     * Fetches the email of the profile with the given id.
     * @param userId The id of the profile.
     * @return The email of the profile.
     */
    public String fetchEmailByUserId(Long userId) {
        var getUserByIdQuery = new GetUserByIdQuery(userId);
        var result = userQueryService.handle(getUserByIdQuery);
        if (result.isEmpty()) return Strings.EMPTY;
        return result.get().getEmail();
    }

}