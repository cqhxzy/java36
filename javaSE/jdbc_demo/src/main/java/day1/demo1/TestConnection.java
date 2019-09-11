package day1.demo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {
    public static void main(String[] args) {
        //1.加载驱动类
        try {
            //将Driver加载到方法区，从而使Driver中的注册驱动代码得到执行
            Class.forName("com.mysql.cj.jdbc.Driver");

            //2.通过DriverManager建立与数据库的连接
            /*getConnection()需要接收3个参数
                1：连接数据库的url地址
                2：登录数据库的用户名
                3：登录数据库的用户密码

            */
            String url = "jdbc:mysql://192.168.91.188:3306/myschool?useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai";
            String userName = "root";
            String password = "root";
            Connection connection = DriverManager.getConnection(url, userName, password);
            System.out.println(connection);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
