package com.example.shirodemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 使用简单的方式，就是从SSM配置过度过来的自己注入的方式集成shiro
 *
 * 所谓的保护，其实保护的是指定的接口，某些可以放行的。如果要授权，shiro要手动或注解实现
 *
 * 如果采用spring security的话，使用简单，功能更大，就是重量级一点，然后如果要授权，spring security 可以 集成 OAuth2.0 更推荐使用
 */
@SpringBootApplication
public class ShiroDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShiroDemoApplication.class, args);
    }

}
