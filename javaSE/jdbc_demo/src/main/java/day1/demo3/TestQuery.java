package day1.demo3;

import java.sql.*;

public class TestQuery {
        private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
        private static final String URL = "jdbc:mysql://192.168.91.188:3306/myschool?useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai";
        private static final String USERNAME = "root";
        private static final String PASSWORD = "root";

        public static void main(String[] args) {

            //1.加载驱动类
            try {
                Class.forName(DRIVER);

                //2.建立连接
                Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

                //3.操作数据库
                Statement statement = connection.createStatement();

                //传递要查询的sql语句
                ResultSet rs = statement.executeQuery("select * from tab_course");

                while (rs.next()) { //只要结果集中有数据
//                    int courseId = rs.getInt("courseId");//获取当前行，列名为courseId的值
//                    String courseName = rs.getString("courseName");

                    int courseId = rs.getInt(1);// 根据查询的sql语句的列的列号获取列的值，列号从1开始
                    String courseName = rs.getString(2);
                    System.out.println("courseId:" + courseId + ",  courseName:" + courseName );
                }

                //通过jdbc对数据库执行了操作后，一定要记得关闭数据库
                //jdbc每次建立和数据库的连接是一种非常耗时及耗资源的过程
                //用完了之后，一定要关闭
                //关闭的顺序：打开的倒序
                rs.close();
                statement.close();
                connection.close();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

}
