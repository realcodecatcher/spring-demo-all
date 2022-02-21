package com.handlecoder.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author handlecoder
 * @date 2022/2/18 12:13
 */
public class LawerInvocationHandler<T> implements InvocationHandler {

    T target;

    public LawerInvocationHandler(T target) {
        this.target = target;
    }

    /**
     * proxy:代表动态代理对象
     * method：代表正在执行的方法
     * args：代表调用目标方法时传入的实参
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("律师准备证据并陈述诉讼请求：");
        Object result = method.invoke(target, args);
        System.out.println("律师进行法庭辩论");
        return result;
    }
}
