package org.sojuton.users.model.dao;

import org.apache.ibatis.annotations.Mapper;
import org.sojuton.users.model.dto.UsersDto;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UsersDao {

    public UsersDto login();
}
