package com.gmm.javaee.regist.service;

import com.gmm.javaee.regist.dao.UserDao;
import com.gmm.javaee.regist.entity.User;

import java.sql.SQLException;

public class RegisterService {
    /**
     * 给用户做业务逻辑
     *
     * service 一般用来做事务处理
     */
        private UserDao dao = new UserDao();
        private int i=0;

        public int register(User user){
            try {
                i = dao.insertUser(user);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return i;
        }

}
