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
}
