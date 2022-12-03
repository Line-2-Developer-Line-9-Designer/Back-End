package org.sojuton.users.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsersDto {
    private Long userSeq;
    private String nickName;
    private String passWord;
    private Long iconSeq;
}
