package org.sojuton.users.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UsersExceptionAdvice {
    @ExceptionHandler(DuplicateException.class)
    protected ResponseEntity duplicateExceptionHandler(DuplicateException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(MissUsersInfoException.class)
    protected ResponseEntity missUsersInfoExceptionHandler(MissUsersInfoException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
    @ExceptionHandler(ExpiredTokenException.class)
    protected ResponseEntity expiredTokenExceptionHandler(ExpiredTokenException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }


}
