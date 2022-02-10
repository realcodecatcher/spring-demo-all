package com.geek.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author geek
 * @date 2022/1/24 16:58
 */
@Aspect
@Component
@Order(1)
public class CheckIDAdvice {

    @Pointcut("@annotation(com.geek.annotation.CheckParam)")
    private void checkId() {
    }

    @Around("checkId()")
    public Object checkIdAround(ProceedingJoinPoint joinPoint) throws Throwable {

        Object[] objects = joinPoint.getArgs();
        Integer id = (Integer) objects[1];
        if(id != null){
            System.out.println("切面CheckIDAdvice验证参数id:"+id );
        }

        return joinPoint.proceed();
    }
}
