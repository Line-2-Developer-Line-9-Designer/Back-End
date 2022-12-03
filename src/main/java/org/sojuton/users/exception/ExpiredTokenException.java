package org.sojuton.users.exception;

import lombok.Getter;

@Getter
public class ExpiredTokenException extends RuntimeException {
    public ExpiredTokenException(String msg) {
        super(msg);
    }
}
