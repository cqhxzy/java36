package day1.demo2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestStatement {

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
            /*
            * 对数据库的操作主要包含：CRUD     增、删、改、查
            * DML: 对应数据库的增、删、改      executeUpdate()  -> int值，代表数据库受影响的行数
            * DQL: 对应数据库的查询操作        executeQuery()  -> ResultSet对象，代表查询的数据
            * DDL: 对应数据定义语言
            * DCL: 对应数据库控制语言
            * */

            String insert_sql = "insert into tab_course (courseName) values ('数学')";
            String update_sql = "update `tab_course` SET `courseName` = '英语' WHERE `courseName` = 'abc'";
            String delete_sql = "delete from `tab_course` where courseId = 8";

            int executeUpdate = statement.executeUpdate(delete_sql);

            System.out.println(executeUpdate > 0 ? "插入成功":"插入失败");

            //通过jdbc对数据库执行了操作后，一定要记得关闭数据库
            //jdbc每次建立和数据库的连接是一种非常耗时及耗资源的过程
            //用完了之后，一定要关闭
            //关闭的顺序：打开的倒序
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
