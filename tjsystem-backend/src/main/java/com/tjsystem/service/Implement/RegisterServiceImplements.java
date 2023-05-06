package com.tjsystem.service.Implement;

import com.tjsystem.mapper.UserMapper;
import com.tjsystem.pojo.User;
import com.tjsystem.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImplements implements RegisterService {

    @Autowired(required = false)
    private UserMapper userMapper;

    @Override
    public String register(User user) {
        if(userMapper.getByUsernameAndPassword(user)!=null)
            return "USER_REPEAT";
        else
            return userMapper.insertUserInfo(user)?"REGISTER_SUCCESS":"REGISTER_ERROR";
    }
}
