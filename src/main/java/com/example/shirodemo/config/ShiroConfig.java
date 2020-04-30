package com.example.shirodemo.config;

import com.example.shirodemo.realm.MyRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @program: demo
 * @description: shiro 配置类，简单的从ssm过度过来，类似就是xml改成configuration
 * @author: HyJan
 * @create: 2020-04-30 14:19
 **/
@Configuration
public class ShiroConfig {

    /**
     * 提供一个 Realm 的实例
     * @return
     */
    @Bean
    public MyRealm myRealm(){
        return new MyRealm();
    }

    /**
     * 配置一个 SecurityManager，在 SecurityManager 中配置 Realm。
     * @return
     */
    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(myRealm());
        return manager;
    }

    /**
     * 配置一个 ShiroFilterFactoryBean ，在 ShiroFilterFactoryBean 中指定路径拦截规则等
     *
     * 下面配置的含义：
     * setSecurityManager 表示指定 SecurityManager。
     * setLoginUrl 表示指定登录页面。
     * setSuccessUrl 表示指定登录成功页面。
     * 接下来的 Map 中配置了路径拦截规则，注意，要有序。
     *
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager());
        shiroFilterFactoryBean.setLoginUrl("/login");
        shiroFilterFactoryBean.setSuccessUrl("/index");
        // 设置不需要验证的路径
        shiroFilterFactoryBean.setUnauthorizedUrl("/unauthorized");
        // 注意是要有序的，所以这里要使用link hash map
        Map<String,String> map = new LinkedHashMap<>();
        // 注意：下面两个参数换了值就报错了。。。
        map.put("/doLogin","anon");
        map.put("/**","authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }
}
