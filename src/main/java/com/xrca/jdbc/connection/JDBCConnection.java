package com.xrca.jdbc.connection;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author xrca
 * @description 获取jdbc连接的几种方式
 * @date 2020-06-29 22:42
 */
public class JDBCConnection {

    /**
     * @description 获取数据库连接：方式一
     * @date 2020-06-30 22:55
     */
    public static Connection getConnection1() throws SQLException {
        Driver driver = new com.mysql.jdbc.Driver();

        // url地址
        String url = "jdbc:mysql://127.0.0.1:3306/xrca_jdbc";

        // 用户名与密码
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "saury2020");

        // 获取连接
        Connection connection = driver.connect(url, properties);
        return connection;
    }

    /**
     * @description 获取数据库连接：方式二
     * @date 2020-06-30 23:15
     */
    public static Connection getConnection2() throws Exception {
        // 反射获取驱动类
        Class clazz = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) clazz.getDeclaredConstructor().newInstance();

        // url地址
        String url = "jdbc:mysql://127.0.0.1:3306/xrca_jdbc";

        // 用户名与密码
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "saury2020");

        // 获取连接
        Connection connection = driver.connect(url, properties);
        return connection;
    }

    /**
     * @description 获取数据库连接：方式三
     * @date 2020-06-30 23:22
     */
    public static Connection getConnection3() throws Exception {
        // url地址
        String url = "jdbc:mysql://127.0.0.1:3306/xrca_jdbc";

        // 用户名与密码
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "saury2020");

        // 反射获取驱动类
        Class clazz = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) clazz.getDeclaredConstructor().newInstance();

        // 注册驱动
        DriverManager.registerDriver(driver);

        // 获取连接
        Connection connection = DriverManager.getConnection(url, properties);
        return connection;
    }

    /**
     * @description 获取数据库连接：方式四
     * @date 2020-06-30 23:27
     */
    public static Connection getConnection4() throws Exception {
        // url地址
        String url = "jdbc:mysql://127.0.0.1:3306/xrca_jdbc";

        // 用户名与密码
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "saury2020");

        /**
         * 反射获取驱动类，此步骤也可以省略，
         * 因为：在mysql的驱动中的META-INF中已经配置了驱动类
         * 但不建议，因为换为类型数据库不一定可以
         */
        Class.forName("com.mysql.jdbc.Driver");

        /**
         * 可以省略这部分代码，因为com.mysql.jdbc.Driver中的静态代码块已经完成了此功能
         * static {
         *      try {
         *         DriverManager.registerDriver(new Driver());
         *      } catch (SQLException var1) {
         *         throw new RuntimeException("Can't register driver!");
         *     }
         * }
         *
         */
        //Driver driver = (Driver) clazz.getDeclaredConstructor().newInstance();
        //DriverManager.registerDriver(driver);

        // 获取连接
        Connection connection = DriverManager.getConnection(url, properties);
        return connection;
    }

    /**
     * @description 获取数据库连接：最终版
     * @date 2020-06-30 23:22
     */
    public static Connection getConnection5() throws Exception {
        // 读取配置文件信息：方式一
        InputStream ips = JDBCConnection.class.getClassLoader().getResourceAsStream("jdbc.properties");

        // 读取配置文件信息：方式二
        // InputStream ips = JDBCConnection.class.getResourceAsStream("/jdbc.properties");

        // 读取配置文件信息：方式三
        /*File file = new File("src/main/resources/jdbc.properties");
        InputStream in = new FileInputStream(file);
        Properties properties = new Properties();
        properties.load(in);*/

        Properties properties = new Properties();
        properties.load(ips);

        // 获取基本信息
        String driverClass = properties.getProperty("driver");
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String passwrod = properties.getProperty("password");

        // 加载驱动
        Class.forName(driverClass);

        // 获取连接
        Connection connection = DriverManager.getConnection(url, user, passwrod);
        return connection;
    }
}
