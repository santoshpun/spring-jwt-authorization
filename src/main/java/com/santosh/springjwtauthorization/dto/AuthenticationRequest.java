package com.santosh.springjwtauthorization.dto;

import com.santosh.springjwtauthorization.model.ModelBase;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationRequest extends ModelBase {
    private String username;
    private String password;
}
