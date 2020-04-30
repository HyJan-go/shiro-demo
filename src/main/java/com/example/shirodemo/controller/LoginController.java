package com.example.shirodemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: demo
 * @description: 测试登录的控制类
 * @author: HyJan
 * @create: 2020-04-30 14:36
 **/
@RestController
@Slf4j
public class LoginController {

    /**
     * 登录校验接口
     * @param username
     * @param password
     */
    @PostMapping("/doLogin")
    public void login(String username,String password){
        // 从安全配置中获取主题，对象，科目
        Subject subject = SecurityUtils.getSubject();

        try{
            // 根据用户名和密码生成一个token进行对象的登录，交给shiro来判断
            subject.login(new UsernamePasswordToken(username,password));
            log.info("登录成功");
        }catch (AuthenticationException e){
            //如果捕获到验证错误，则说明登录失败
            log.info("用户名或密码错误");
        }
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/login")
    public String login(){
        return "please login and then to look everything";
    }
}
