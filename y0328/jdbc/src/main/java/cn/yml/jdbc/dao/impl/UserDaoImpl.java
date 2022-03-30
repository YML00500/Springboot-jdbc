package cn.yml.jdbc.dao.impl;

import cn.yml.jdbc.dao.UserDao;
import cn.yml.jdbc.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Repository
public class UserDaoImpl implements UserDao {
    @Resource
    private JdbcTemplate template;
    
    @Override
    public User loadUser(int id) {
        String sql="select * from users where id=?";
       List<User>users=template.query(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user=new User();
                user.setId(rs.getInt("id"));
                user.setUname(rs.getString("uname"));
                user.setPassword(rs.getString("password"));
                user.setAge(rs.getInt("age"));
                return user;
            }
        },id);
        return users.get(0);
    }

    @Override
    public List<User> findAllUser() {
        String sql="select * from users";
        List<User>users=template.query(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user=new User();
                user.setId(rs.getInt("id"));
                user.setUname(rs.getString("uname"));
                user.setPassword(rs.getString("password"));
                user.setAge(rs.getInt("age"));
                return user;
            }
        });
        return users ;
    }

    @Override
    public int addUser(User user) {
        String sql="insert into users (uname,password,age) values(?,?,?)";
        int rs=template.update(sql,user.getUname(),user.getPassword(),user.getAge());
        return rs;
    }

    @Override
    public int updateUser(User user) {
        String sql="update users set uname=?,password=?,age=? where id=?";
        int rs=template.update(sql,user.getUname(),user.getPassword(),user.getAge(),user.getId());
        return rs;
    }

    @Override
    public int deleteUser(int id) {
        String sql="delete from users where id=?";
        int rs=template.update(sql,id);
        return rs;
    }
}
