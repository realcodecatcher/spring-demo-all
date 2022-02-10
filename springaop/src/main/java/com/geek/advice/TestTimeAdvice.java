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
@Order(2)
public class TestTimeAdvice {

    @Pointcut("@annotation(com.geek.annotation.CheckParam)")
    private void testtime() {
    }


    @Around("testtime()")
    public Object testTime(ProceedingJoinPoint joinPoint) throws Throwable {

        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long time = System.currentTimeMillis() - start;
        System.out.println("方法执行消耗时间："+time);
        return result;
    }

}
