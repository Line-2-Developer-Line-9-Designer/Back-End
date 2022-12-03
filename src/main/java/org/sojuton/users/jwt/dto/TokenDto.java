package org.sojuton.users.jwt.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TokenDto {


    private String id;
    private String accessToken;
    private Long expirationTime;
    public TokenDto(String accessToken) {
        this.accessToken = accessToken;
    }
}
