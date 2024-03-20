package com.zhengjue.bhrpctest01.dynamicproxy.cglib;

import net.sf.cglib.proxy.Enhancer;

public class CglibTest {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserService.class);
        //设置回调函数
        enhancer.setCallback(new LogInterceptor());

        // create方法正式创建代理类
        UserService userService = (UserService) enhancer.create();
        userService.getUser();
    }
}
