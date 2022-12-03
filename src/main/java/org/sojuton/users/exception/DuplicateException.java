package org.sojuton.users.exception;

import lombok.Getter;

@Getter
public class DuplicateException extends RuntimeException {
    public DuplicateException(String msg) {
        super(msg);
    }
}
