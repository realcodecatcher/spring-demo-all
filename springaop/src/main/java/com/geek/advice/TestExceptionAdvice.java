package com.geek.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author geek
 * @date 2022/1/24 16:58
 */
@Aspect
@Component
@Order(3)
public class TestExceptionAdvice {

    @Pointcut("@annotation(com.geek.annotation.CheckParam)")
    private void testexception() {
    }

    @Around("testexception()")
    public Object testException(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            return joinPoint.proceed();
        } catch (Throwable e) {

            System.out.println("发生异常类："+joinPoint.getTarget().getClass().getName());
            System.out.println("发生异常方法："+joinPoint.getSignature().getName());
            System.out.println("发生异常时间："+new Date());
            System.out.println("发生了异常："+e.toString());

            return null;
        }

    }

}
