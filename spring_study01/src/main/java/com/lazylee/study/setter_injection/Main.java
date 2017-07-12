package com.lazylee.study.setter_injection;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by lazylee on 2017/6/22.
 */
public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("/setter_injection.xml");

        AccountService accountService = applicationContext
                .getBean("accountService", AccountService.class);
        System.out.println("Before money transfer");
        System.out.println("Account 1 balance : " + accountService.getAccount(1).getBalance());
        System.out.println("Account 2 balance : " + accountService.getAccount(2).getBalance());
        accountService.transferMoney(1,2,5.0);
        System.out.println("After money transfer");
        System.out.println("Account 1 balance : " + accountService.getAccount(1).getBalance());
        System.out.println("Account 2 balance : " + accountService.getAccount(2).getBalance());
    }
}
