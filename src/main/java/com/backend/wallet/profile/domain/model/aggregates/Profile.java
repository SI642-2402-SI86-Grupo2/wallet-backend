package com.backend.wallet.profile.domain.model.aggregates;

import com.backend.wallet.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import com.backend.wallet.profile.domain.model.commands.CreateProfileCommand;
import com.backend.wallet.iam.domain.model.aggregates.User;
import com.backend.wallet.profile.domain.model.valueobjects.PersonName;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Profile extends AuditableAbstractAggregateRoot<Profile> {

    @Embedded
    @Column()
    private PersonName name;

    @Column(name = "email", length = 100, nullable = false, unique = true)
    private String email;

    @Lob
    @Column(name = "photo")
    private String photo;

    @Getter
    @OneToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id" )
    private User user;

    public Profile() {
    }

    public Profile(PersonName name, String email, String photo, User user) {
        this.name = name;
        this.email = email;
        this.photo = photo;
        this.user = user;
    }
public Profile(CreateProfileCommand command, User user) {
    this.name = new PersonName(command.firstName(), command.lastName());
        this.email = command.email();
        this.photo = command.photo();
        this.user = user;
    }

    public Profile updateProfile(String firstName, String lastName, String email , String photo) {
        this.name = new PersonName(firstName, lastName);
        this.email = email;
        this.photo = photo;
        return this;
    }

    public Profile upsetImage(String photo) {
        this.photo = photo;
        return this;
    }
}
