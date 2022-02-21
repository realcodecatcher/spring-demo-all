package com.handlecoder.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author handlecoder
 * @date 2022/2/18 16:25
 */

public class LawerMethodInterceptor implements MethodInterceptor{

    /**
     * sub：cglib生成的代理对象
     * method：被代理对象方法
     * objects：方法入参
     * methodProxy: 代理方法
     */
    @Override
    public Object intercept(Object sub, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("律师准备证据并陈述诉讼请求：");
        Object object = methodProxy.invokeSuper(sub, objects);
        System.out.println("律师进行法庭辩论");
        return object;
    }
}