package com.xrca.jdbc.connection;

import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConnection {

    /**
     * @description 测试第一种获取数据库连接方式
     */
    @Test
    public void testGetConnection1() throws SQLException {
        Connection connection = JDBCConnection.getConnection1();
        Assert.assertNotNull(connection);
    }

    /**
     * @description 测试第二种获取数据库连接方式
     */
    @Test
    public void testGetConnection2() throws Exception {
        Connection connection = JDBCConnection.getConnection2();
        Assert.assertNotNull(connection);
    }

    /**
     * @description 测试第三种获取数据库连接方式
     */
    @Test
    public void testGetConnection3() throws Exception {
        Connection connection = JDBCConnection.getConnection3();
        Assert.assertNotNull(connection);
    }

    /**
     * @description 测试第四种获取数据库连接方式
     */
    @Test
    public void testGetConnection4() throws Exception {
        Connection connection = JDBCConnection.getConnection4();
        Assert.assertNotNull(connection);
    }

    /**
     * @description 测试第五种获取数据库连接方式
     */
    @Test
    public void testGetConnection5() throws Exception {
        Connection connection = JDBCConnection.getConnection5();
        Assert.assertNotNull(connection);
    }
}
