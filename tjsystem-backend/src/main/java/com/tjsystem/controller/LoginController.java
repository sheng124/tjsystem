package com.tjsystem.controller;

import com.tjsystem.pojo.Result;
import com.tjsystem.pojo.User;
import com.tjsystem.service.LoginService;
import com.tjsystem.utils.JwtAndLoginUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public Result loginJudge(@RequestBody User user){
        //调用Service获取查询结果
        System.out.println(user);
        User u=loginService.loginJudge(user);
        System.out.println(u);
        //登录成功，发放令牌
        if(u!=null){
            Map<String, Object> claims = new HashMap<>();
            claims.put("id",u.getId());
            claims.put("username",u.getUsername());
            claims.put("password",u.getPassword());
            String jwt = JwtAndLoginUtils.generateJwt(claims);
            System.out.println(jwt);
            return Result.success(jwt);
        }
        //登录失败，返回错误信息
        return Result.error("用户名或密码不正确！");
    }
}
