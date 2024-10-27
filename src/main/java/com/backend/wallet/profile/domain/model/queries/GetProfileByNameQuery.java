package com.backend.wallet.profile.domain.model.queries;

import com.backend.wallet.profile.domain.model.valueobjects.PersonName;

public record GetProfileByNameQuery(PersonName name) {
}
