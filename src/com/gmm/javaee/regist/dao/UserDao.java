package com.gmm.javaee.regist.dao;

import com.gmm.javaee.regist.entity.User;

import java.sql.SQLException;

public class UserDao extends  BaseDao<User>{

    //注册用户
    public int insertUser(User user) throws SQLException {
        String sql = "insert into user value(null,?,?,?,?)";
        int i = this.update(sql, user.getName(),user.getPwd(),user.getAge(),user.getSex());
        return i;
    }
    //用户登录
    public User selectOne(String name, String pwd) throws SQLException {
        String sql = "select * from user where name=? and pwd =?";
        User user1 = this.getBean(User.class, sql, name, pwd);
        return user1;

    }
}
