package com.geek;

import com.geek.advice.CheckIDAdvice;
import com.geek.advice.CheckNameAdvice;
import com.geek.service.TestService;
import com.geek.service.impl.TestServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
class SpringaopTests {

    @Autowired
    private TestService testService;

    @Test
    public void test1(){
        testService.test("admin",1);

    }


}
