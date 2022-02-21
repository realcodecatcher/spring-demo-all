package com.handlecoder.cglib;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

/**
 * @author handlecoder
 * @date 2022/2/18 16:27
 */

public class TestCase {
    public static void main(String[] args) {
        System.out.println("法庭开庭");

        // 代理类class文件存入本地磁盘,使用反编译工具查看生成的代码
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, System.getProperty("user.dir")+"/cglib/" );

        Enhancer enhancer = new Enhancer();

        // 设置代理类的父类
        enhancer.setSuperclass(Wanglihong.class);

        // 通过回调函数，将增强类引入到生成的代理类中
        enhancer.setCallback(new LawerMethodInterceptor());

        // 生成代理对象
        Wanglihong proxy = (Wanglihong)enhancer.create();

        // 通过代理对象调用目标方法
        proxy.seeChild();
    }
}