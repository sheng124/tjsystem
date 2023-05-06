package com.tjsystem.mapper;

import com.tjsystem.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select * from user where username = #{username} and password = #{password}")
    public User getByUsernameAndPassword(User user);
}
