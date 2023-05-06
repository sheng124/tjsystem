package com.tjsystem.mapper;

import com.tjsystem.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {

    @Select("select * from user where username = #{username} and password = #{password}")
    User getByUsernameAndPassword(User user);

    @Update("insert into user(username,password) VALUES (#{username},#{password})")
    boolean insertUserInfo(User user);
}
