package org.sojuton.users.service;

import lombok.RequiredArgsConstructor;
import org.sojuton.users.exception.DuplicateException;
import org.sojuton.users.exception.ExpiredTokenException;
import org.sojuton.users.exception.MissUsersInfoException;
import org.sojuton.users.jwt.JwtTokenProvider;
import org.sojuton.users.model.dao.UsersDao;
import org.sojuton.users.model.dto.UsersDto;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
@RequiredArgsConstructor
public class UsersService {

    private final JwtTokenProvider jwtTokenProvider;
    private final UsersDao usersDao;

    public UsersDto signUp(UsersDto usersDto) {
        this.duplicateCheck(usersDto);
        usersDao.signUp(usersDto);
        UsersDto signUpUserInfo = new UsersDto();
        signUpUserInfo.setUserId(usersDto.getUserId());
        signUpUserInfo.setNickName(usersDto.getNickName());
        return signUpUserInfo;
    }

    public UsersDto signIn(UsersDto usersDto, HttpServletResponse response) {
        UsersDto userInfo = usersDao.signIn(usersDto)
                .orElseThrow(() -> new MissUsersInfoException("아이디 또는 패스워드가 틀렸습니다."));
        String accessToken = jwtTokenProvider.createToken(userInfo.getUserSeq(), userInfo.getUserId(), userInfo.getNickName());

        jwtTokenProvider.setHeaderAccessToken(response, accessToken);

        UsersDto signInUserInfo = new UsersDto();
        signInUserInfo.setUserId(userInfo.getUserId());
        signInUserInfo.setNickName(userInfo.getNickName());

        return signInUserInfo;
    }

    public UsersDto getUserInfo(HttpServletRequest request) {
        String token = jwtTokenProvider.resolveAccessToken(request);
        if(!jwtTokenProvider.validateToken(token)) {
            throw new ExpiredTokenException("만료 된 토큰입니다.");
        }
        return usersDao.getUserInfo(jwtTokenProvider.getUserSeqByToken(token));
    }

    public String duplicateCheck(UsersDto usersDto) {
        if(usersDao.duplicateCheck(usersDto.getUserId()) >= 1) {
            throw new DuplicateException("이미 있는 아이디입니다.");
        }
        return "중복 된 아이디가 없습니다.";
    }

}
