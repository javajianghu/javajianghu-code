package com.zhengjue.bhrpctest01.dynamicproxy.jdk;

public class MyServiceImpl implements MyService{
    @Override
    public void sayHello() {
        System.out.println("hello jdk Dynamic Proxy");
    }
}
