package org.sojuton.users.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Base64;
import java.util.Date;

@Slf4j
@Component
public class JwtTokenProvider {
    @Value("jwt.secret-key")
    private String SECRET_KEY;
    private long accessTokenValidMillisecond = 100L * 60 * 60; //1시간 토큰 유효
    private String type = "bearer ";


    @PostConstruct
    protected void init() {
        SECRET_KEY = Base64.getEncoder().encodeToString(SECRET_KEY.getBytes());
    }

    public String createToken(Long userSeq, String userId, String nickName) {
        Claims claims = Jwts.claims().setSubject(String.valueOf(userSeq));
        claims.put("userId", userId);
        claims.put("nickName", nickName);
        Date now = new Date();

        log.info("claims? : " + claims);

        return Jwts.builder()
                .setClaims(claims)	//데이터
                .setIssuedAt(now)	//토큰 발행일자
                .setExpiration(new Date(now.getTime() + accessTokenValidMillisecond))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)	//암호화 알고리즘
                .compact();
    }


    public String getUserSeqByToken(String token) {
        return parserJwtsBody(token)
                .getSubject();
    }

    public String getUserIdByToken(String token) {
        return parserJwtsBody(token)
                .get("userId")
                .toString();
    }
    public String getNickNameByToken(String token) {
        return parserJwtsBody(token)
                .get("nickName")
                .toString();
    }

    public String resolveAccessToken(HttpServletRequest request) {
        return resolveToken(request.getHeader("Authorization"));
    }
    private String resolveToken(String token) {
        if(token != null) {
            if(token.substring(0, 7).equals(type)) {
                token = token.substring(7);
            }
            return token;
        }
        return null;
    }

    public void setHeaderAccessToken(HttpServletResponse response, String accessToken) {
        response.setHeader("authorization", type + accessToken);
    }

    public boolean validateToken(String token) {
        try {
            return !parserJwts(token).getBody().getExpiration().before(new Date());
        } catch (Exception e) {
            return false;
        }
    }

    private Jws<Claims> parserJwts(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
    }

    private Claims parserJwtsBody(String token) {
        return parserJwts(token).getBody();
    }

}
