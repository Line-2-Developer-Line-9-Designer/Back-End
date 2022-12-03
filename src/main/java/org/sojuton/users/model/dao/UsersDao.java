package org.sojuton.users.model.dao;

import org.apache.ibatis.annotations.Mapper;
import org.sojuton.users.model.dto.UsersDto;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Mapper
public interface UsersDao {

    int duplicateCheck(String userId);
    int signUp(UsersDto usersDto);
    Optional<UsersDto> signIn(UsersDto usersDto);

    UsersDto getUserInfo(String userSeqByToken);
}
