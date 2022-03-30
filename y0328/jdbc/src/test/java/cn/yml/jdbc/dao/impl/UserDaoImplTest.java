package cn.yml.jdbc.dao.impl;

import cn.yml.jdbc.dao.UserDao;
import cn.yml.jdbc.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.Assert;

import java.util.List;

@SpringBootTest
public class UserDaoImplTest {

    @Autowired
    private UserDao userDao;
    @Test
    public void testLoadUser(){
        User user=userDao.loadUser(1);
        System.out.println(user.getUname());
//        Assert.isTrue(1==1);
    }
    @Test
    public void testfindAllUser(){
        List<User> users=userDao.findAllUser();
        for (int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i).getUname());
        }
    }
    @Test
    public void testAddUser(){
       User user=new User();
       user.setUname("css");
       user.setPassword("123");
       user.setAge(100);
       int rs=userDao.addUser(user);
    }
    @Test
    public void testUpdataUser(){
        User user=new User();
        user.setId(2);
        user.setUname("css01");
        user.setPassword("123");
        user.setAge(10);
        userDao.updateUser(user);
    }
    @Test
    public void testDeleteUser(){
        int rs=userDao.deleteUser(3);
    }
}
