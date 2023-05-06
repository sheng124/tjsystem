package com.tjsystem.controller;

import com.tjsystem.pojo.Result;
import com.tjsystem.pojo.User;
import com.tjsystem.service.LoginService;
import com.tjsystem.service.RegisterService;
import com.tjsystem.utils.JwtAndLoginUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @PostMapping("/register")
    public Result register(@RequestBody User user){
        //调用Service获取查询结果
        System.out.println("获取到的数据："+user);
        String res=registerService.register(user);
        System.out.println("Service处理的结果："+res);
        //注册成功
        if(res.equals("REGISTER_SUCCESS")){
            return Result.success();
        }
        //注册失败
        else if(res.equals("REGISTER_ERROR")){
            return Result.error("注册失败：数据库插入信息失败！");
        }
        return Result.error("注册失败：用户名重复！");
    }
}