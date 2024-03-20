package com.zhengjue.bhrpctest01.dynamicproxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {
    private Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("方法处理前");

        // 调用真实对象的方法
        Object result = method.invoke(target, args);

        System.out.println("方法处理后");
        return result;
    }
}
