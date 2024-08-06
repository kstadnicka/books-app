package org.ks.yourbooks.domain.user.dto;

import lombok.Data;

import java.util.Set;

@Data
public class UserCredentialsDto {
    private final String email;
    private final String password;
    private final Set<String> roles;

    public UserCredentialsDto(String email, String password, Set<String> roles) {
        this.email = email;
        this.password = password;
        this.roles = roles;
    }
}
