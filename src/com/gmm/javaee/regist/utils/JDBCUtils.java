package com.gmm.javaee.regist.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 数据访问的工具类
 */
public class JDBCUtils {

    private static DataSource dataSource = new ComboPooledDataSource("mysql");

    private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

    //获取连接对象
    public static Connection getConn() throws SQLException {
        Connection connection = tl.get();
        if(connection==null){
            connection = dataSource.getConnection();
            tl.set(connection);
        }
        return connection;
    }

}
