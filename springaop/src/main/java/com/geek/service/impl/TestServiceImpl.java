package com.geek.service.impl;

import com.geek.annotation.CheckParam;
import com.geek.service.TestService;
import org.springframework.stereotype.Service;

/**
 * @author geek
 * @date 2022/1/24 17:49
 */
@Service
public class TestServiceImpl implements TestService {
    @CheckParam()
    public String test(String name, Integer id) {

        //throw new IllegalArgumentException("参数非法！");
      //  int i=1/0;
        return "name:"+name + " id:"+id;
    }
}
