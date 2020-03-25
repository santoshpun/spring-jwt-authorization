package com.santosh.springjwtauthorization.dto;

import com.santosh.springjwtauthorization.model.ModelBase;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TokenDTO extends ModelBase {
    protected String token;
}
