package com.handlecoder.jdk;


import net.sf.cglib.core.DebuggingClassWriter;
import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.net.URL;

/**
 * @author handlecoder
 * @date 2022/2/18 12:13
 */
public class TestCase {
    public static void main(String[] args)  throws Exception{
        System.out.println("法庭开庭");

        // 获取增强类
        InvocationHandler lawerHandler = new LawerInvocationHandler<SeeChildSuit>(new Wanglihong());

        // 传入被代理类类加载器，被代理类接口，和增强类，获得代理类
        SeeChildSuit seeChildSuitProxy = (SeeChildSuit) Proxy.newProxyInstance(SeeChildSuit.class.getClassLoader(), new Class<?>[]{SeeChildSuit.class}, lawerHandler);

        // 使用代理类执行目标方法
        seeChildSuitProxy.seeChild();

        // 代理类class文件存入本地磁盘,使用反编译工具查看生成的代码
        genClass();
    }


    public static void genClass() throws Exception {
        byte[] bts = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{SeeChildSuit.class});
        FileOutputStream fos = new FileOutputStream( "$Proxy0.class");

        fos.write(bts);
        fos.flush();
        fos.close();
    }



}
