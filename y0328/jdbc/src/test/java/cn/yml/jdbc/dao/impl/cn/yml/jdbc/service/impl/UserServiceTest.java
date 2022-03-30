package cn.yml.jdbc.dao.impl.cn.yml.jdbc.service.impl;

import cn.yml.jdbc.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;
    @Test
    public  void testExchangAge(){
        userService.exchangAge(1,2,10);
    }
}
