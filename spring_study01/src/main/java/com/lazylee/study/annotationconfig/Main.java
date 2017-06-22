package com.lazylee.study.annotationconfig;

import com.lazylee.study.javaconfig.AccountService;
import com.lazylee.study.javaconfig.BeanConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by lazylee on 2017/6/22.
 */
public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("/annotation_beans.xml");

        AccountServiceImpl accountServiceImpl = applicationContext.
                getBean("accountServiceImpl",AccountServiceImpl.class);
        System.out.println("Before money transfer");
        System.out.println("Account 1 balance :" + accountServiceImpl.getAccount(1).getBalance());
        System.out.println("Account 2 balance :" + accountServiceImpl.getAccount(2).getBalance());

        accountServiceImpl.transferMoney(1, 2, 5.0);

        System.out.println("After money transfer");
        System.out.println("Account 1 balance :" + accountServiceImpl.getAccount(1).getBalance());
        System.out.println("Account 2 balance :" + accountServiceImpl.getAccount(2).getBalance());
    }
}
