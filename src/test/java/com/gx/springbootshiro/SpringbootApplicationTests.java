package com.gx.springbootshiro;

import com.gx.springbootshiro.domain.UserInfo;
import com.gx.springbootshiro.service.IUserInfoService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootApplicationTests {

    Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    IUserInfoService userInfoService ;
    @Test
    void contextLoads() {
    }

    @Test
    public  void testUser(){
        UserInfo admin = userInfoService.findUserWithRoleListByUsername("admin");
        logger.info(admin.toString());
    }
}
