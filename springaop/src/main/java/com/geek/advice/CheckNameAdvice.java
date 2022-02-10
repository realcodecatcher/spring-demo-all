package com.geek.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author geek
 * @date 2022/1/24 16:58
 */
@Aspect
@Component
@Order(0)
public class CheckNameAdvice {

    @Pointcut("@annotation(com.geek.annotation.CheckParam)")
    private void checkName() {
    }

    @Before("checkName() && args(name, id)")
    public void beforeOne(String name,int id){
        System.out.println("目标方法的参数：name:" + name+" id:"+id);
    }

    @AfterReturning(value="checkName()", returning="returnValue")
    public void beforeOne(JoinPoint point, Object returnValue){
        System.out.println("目标方法的参数：" + Arrays.toString(point.getArgs()));
        System.out.println("返回值：" + returnValue);
    }

    @AfterThrowing(value="checkName()", throwing="ex")
    public void beforeOne(JoinPoint point, Throwable ex){
        System.out.println("目标方法的参数：" + Arrays.toString(point.getArgs()));
        System.out.println("异常：" + ex);
    }

    @Around("checkName()")
    public Object checkNameAround(ProceedingJoinPoint joinPoint) throws Throwable {

        Object[] objects = joinPoint.getArgs();
        String name = (String) objects[0];
        if(name != null){
            System.out.println("切面CheckNameAdvice验证参数name:"+name );
        }

        return joinPoint.proceed();
    }
}
