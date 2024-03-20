package com.zhengjue.bhrpctest01.dynamicproxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class LogInterceptor implements MethodInterceptor {
    /**
     *
     * @param obj 表示要进行增强的对象
     * @param method 表示拦截的方法
     * @param objects 数组表示参数列表，基本数据类型需要传入其包装类型，如int-->Integer、long-Long
     * @param methodProxy 表示对方法的代理，invokeSuper方法表示对被代理对象方法的调用
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object obj, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("方法调用前");

        // 注意这里是调用invokeSuper而不是invoke，否则死循环;
        // methodProxy.invokeSuper执行的是原始类的方法;
        // method.invoke执行的是子类的方法;
        Object result = methodProxy.invokeSuper(obj, objects);

        String name = method.getName();
        System.out.println("代理方法名称是："+name);


        System.out.println("方法调用后");
        return result;
    }
}
