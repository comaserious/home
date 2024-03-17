package com.lee.common;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Template {

    private static SqlSessionFactory sf;
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String url="jdbc:mysql://localhost/menudb";
    private static String user ="ohgiraffers";
    private static String pass = "ohgiraffers";


    public static SqlSession getSqlSession() {
        if(sf==null){
                Environment e = new Environment("dev",new JdbcTransactionFactory(),new PooledDataSource(driver,url,user,pass));

                Configuration config = new Configuration(e);
                config.addMapper(MenuMapper.class);
                sf = new SqlSessionFactoryBuilder().build(config);

        }
        return sf.openSession(false);



    }
}
