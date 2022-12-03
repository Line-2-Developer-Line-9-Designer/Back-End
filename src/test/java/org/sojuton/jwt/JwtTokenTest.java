package org.sojuton.jwt;

import org.junit.jupiter.api.Test;
import org.sojuton.users.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JwtTokenTest {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Test
    void testCreateToken() {
        jwtTokenProvider.createToken(1L, "tester", "닉네");
    }



}
