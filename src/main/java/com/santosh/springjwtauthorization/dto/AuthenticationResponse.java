package com.santosh.springjwtauthorization.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AuthenticationResponse extends TokenDTO {
    private List<String> roles;

    public AuthenticationResponse(String token, List<String> roles) {
        this.token = token;
        this.roles = roles;
    }
}
