package org.sojuton.users.service;

import lombok.RequiredArgsConstructor;
import org.sojuton.users.model.dao.UsersDao;
import org.sojuton.users.model.dto.UsersDto;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersService {

    private final UsersDao usersDao;

    public UsersDto login() {
        return usersDao.login();
    }

}
