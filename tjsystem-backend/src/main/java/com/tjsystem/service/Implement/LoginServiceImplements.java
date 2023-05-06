package com.tjsystem.service.Implement;

import com.tjsystem.mapper.UserMapper;
import com.tjsystem.pojo.User;
import com.tjsystem.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImplements implements LoginService {

    @Autowired(required = false)
    private UserMapper userMapper;

    @Override
    public User loginJudge(User user) {
        return userMapper.getByUsernameAndPassword(user);
    }
}
