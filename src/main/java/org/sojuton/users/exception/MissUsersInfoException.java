package org.sojuton.users.exception;

import lombok.Getter;

@Getter
public class MissUsersInfoException extends RuntimeException {
    public MissUsersInfoException(String msg) {
        super(msg);
    }
}
