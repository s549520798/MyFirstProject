package com.lazylee.study.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by lazylee on 2017/6/22.
 *
 * @configuration 告诉spring容器,该类是一个bean并且包含配置元数据操作
 */
@Configuration
public class BeanConfiguration {
    /**
     * 工厂方法,在启动期间被spring容器调用,返回值被视为spring管理的bean.
     * 默认情况下,方法名就是Bean的名称.
     * 注意:返回值类型定义为接口类型,而不是具体的实现类.
     * @return
     */
    @Bean
    public AccountService accountService(){
        AccountServiceImpl bean = new AccountServiceImpl();
        bean.setAccountDao(accountDao());
        return bean;
    }
    @Bean
    public AccountDao accountDao(){
        AccountDaoInMemoryImpl bean = new AccountDaoInMemoryImpl();
        //depedencies of accountDao bean will be injected here ...
        return bean;
    }
}
