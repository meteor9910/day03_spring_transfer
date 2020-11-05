package com.hopu.tx;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Component
public class TxManger {
    // 声明一个本地线程属性变量
    private  ThreadLocal<Connection> th = new ThreadLocal<>();
    @Autowired
    private DataSource dataSource;
   //获取连接
    public Connection getConnection() {
        Connection connection = th.get();
        try {
            if(connection == null){
                connection = dataSource.getConnection();
                th.set(connection);


            }return connection;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
    //开启
    public void begin(){
        try {
            getConnection().setAutoCommit(false);

        }catch (SQLException e) {
            e.printStackTrace();

        }
    }
    //提交
//    public void commit() {
//        try {
//            getConnection().commit();
//        }catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//    }
//    //回滚
//    public void rollback() {
//        try {
//            getConnection().rollback();
//        }catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//    }
    //关闭
    public void close() {
        try {
            getConnection().close();
            //要从集合中移除连接对象
            th.remove();
        }catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
