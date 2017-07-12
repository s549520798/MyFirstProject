package com.lazylee.study.setter_injection;

import java.util.Date;

/**
 * Created by lazylee on 2017/7/12.
 */
public class Account {
    private long id;
    private String ownerName;
    private double balance;
    private Date accessTime;
    private boolean locked;

    /**
     * 在属性注入时，spring容器要求Bean提供默认构造器，即空参构造器。
     * spring会先调用空参构造器实例化Bean对象，然后再调用Setter方法注入属性.
     * Java规定，如果类中没有声明任何构造器,JVM会为其生成默认构造器,但只要声明了构造器就JVM不会为其生成
     * 默认构造器.
     */
    public Account(){

    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Date getAccessTime() {
        return accessTime;
    }

    public void setAccessTime(Date accessTime) {
        this.accessTime = accessTime;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }
}
