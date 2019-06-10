package com.qf;

import com.qf.service.UserInfoService;
import com.qf.vo.UserInfoLoginVo;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {
    @Test
    public void test1() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-mybatis.xml", "spring-service.xml");
        UserInfoService userInfoService = applicationContext.getBean(UserInfoService.class);
        UserInfoLoginVo userInfoLoginVo = new UserInfoLoginVo();
//        userInfoLoginVo.setEmail("zhangsan@qq.com");
//        userInfoLoginVo.setPassword("123");
      //  Boolean aBoolean = userInfoService.userInfoLogin(userInfoLoginVo);
        //System.out.println(aBoolean);
    }
}
