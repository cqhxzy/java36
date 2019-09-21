package day1.demo4;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestPreparedStatement {
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
            //insert(connection);
            //update(connection);
            //delete(connection);
            List<Map> query = query(connection);

            query.stream().forEach(map -> {
                Object courseId = map.get("courseId");
                Object courseName = map.get("courseName");

                System.out.println("courseId:" + courseId + ",courseName:" + courseName);
            });


            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过PreparedStatement实现插入
     * @param connection
     * @throws SQLException
     */
    private static void insert(Connection connection) throws SQLException {
        //对sql语句参数化，凡是需要发送到数据库执行的sql参数，均用?替换。
        String courseName = "数学";
        String insert_sql = "insert into tab_course (courseName) values (?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insert_sql);
        //为预处理的sql语句设置参数
        preparedStatement.setString(1,courseName);

        //执行sql语句
        int executeUpdate = preparedStatement.executeUpdate();
        System.out.println(executeUpdate > 0 ? "插入成功" : "插入失败");

        preparedStatement.close();
    }

    private static void update(Connection connection){
        //准备sql语句
        String sql = "update tab_course set courseName = ? where courseId = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "美术");
            preparedStatement.setInt(2, 9);

            int executeUpdate = preparedStatement.executeUpdate();
            System.out.println(executeUpdate > 0 ? "修改成功" : "修改失败");

            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void delete(Connection connection){
        String sql = "delete from tab_course where courseid=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, 9);

            int executeUpdate = preparedStatement.executeUpdate();
            System.out.println(executeUpdate > 0 ? "删除成功" : "删除失败");

            preparedStatement.close(); //关闭preparedStatement
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static List<Map> query(Connection connection){
        String sql = "select courseId,courseName from tab_course";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            //sql语句没有参数，则执行执行sql语句

            ResultSet rs = preparedStatement.executeQuery();
            List list = new ArrayList();
            while (rs.next()) {
                int courseId = rs.getInt(1);
                String courseName = rs.getString(2);

                //将一行数据保存到一个map集合中
                Map map = new HashMap();
                map.put("courseId", courseId);
                map.put("courseName", courseName);

                list.add(map);
            }

            rs.close();
            preparedStatement.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
