package com.qf;

import com.qf.dto.UserInfoMessage;
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
        UserInfoMessage userInfoMessageById = userInfoService.getUserInfoMessageById(1);
        System.out.println(userInfoMessageById);
    }
}
