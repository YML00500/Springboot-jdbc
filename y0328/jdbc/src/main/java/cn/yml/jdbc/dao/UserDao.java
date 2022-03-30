package cn.yml.jdbc.dao;

import cn.yml.jdbc.pojo.User;

import java.util.List;

public interface UserDao {
    User loadUser (int id);
    List<User> findAllUser();
    int addUser(User user);
    int updateUser(User user);
    int deleteUser(int id);
}
