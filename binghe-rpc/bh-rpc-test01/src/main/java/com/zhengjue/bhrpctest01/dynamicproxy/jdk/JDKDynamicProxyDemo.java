package com.zhengjue.bhrpctest01.dynamicproxy.jdk;

import java.lang.reflect.Proxy;

public class JDKDynamicProxyDemo {
    public static void main(String[] args) {
        // 创建真实对象
        MyService myService = new MyServiceImpl();

        // 创建InvocationHandler实例并传入真实对象
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(myService);

        // 通过Proxy.newProxyInstance创建代理对象
        MyService proxyObject = (MyService) Proxy.newProxyInstance(
                MyService.class.getClassLoader(),
                new Class[]{MyService.class},
                myInvocationHandler
        );

        // 通过代理对象调用方法
        proxyObject.sayHello();

    }
}
