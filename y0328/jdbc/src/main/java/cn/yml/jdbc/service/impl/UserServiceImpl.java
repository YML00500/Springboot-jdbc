package cn.yml.jdbc.service.impl;

import cn.yml.jdbc.dao.UserDao;
import cn.yml.jdbc.pojo.User;
import cn.yml.jdbc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Transactional
    @Override
    public void exchangAge(int from, int to, int age) {
        User user1=userDao.loadUser(from);
        user1.setAge(user1.getAge()-age);
        User user2=userDao.loadUser(to);
        user2.setAge(user2.getAge()+age);
        userDao.updateUser(user1);
//        int m=1/0;
        userDao.updateUser(user2);
    }
}
