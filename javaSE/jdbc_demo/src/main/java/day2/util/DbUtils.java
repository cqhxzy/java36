package day2.util;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DbUtils {
    /*数据库连接字符串*/
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://192.168.91.188:3306/myschool?useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    //加载驱动类,只需要做一次就够了
    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /*获取连接*/
    public Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 关闭连接释放资源
     *
     * @param connection
     * @param pstmt
     * @param rs
     */
    public void closeAll(Connection connection, PreparedStatement pstmt, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过的增、删、改的方法
     *
     * @param sql
     * @param params
     * @return
     */
    public int executeUpdate(String sql, Object... params) {
        Connection connection = null;
        PreparedStatement pstmt = null;
        try {
            //获取连接
            connection = getConnection();
            //预处理sql语句
            pstmt = connection.prepareStatement(sql);
            if (null != params) {
                for (int i = 0; i < params.length; i++) {
                    pstmt.setObject(i + 1, params[i]);
                }
            }

            int executeUpdate = pstmt.executeUpdate();
            return executeUpdate;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(connection, pstmt, null);
        }
        return 0;
    }

    /**
     * 通用的查询方法
     * 该方法能够解析sql语句，将查询得到的数据每行转换为一个map集合
     * 其中，列的别名作为map的键，列所对应的值作为value
     * @param sql
     * @param params
     * @return
     */
    public List<Map<String, Object>> executeQuery1(String sql, Object... params){

        List<Map<String, Object>> list = new ArrayList<>();

        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            connection = getConnection();
            pstmt  = connection.prepareStatement(sql);

            if (null != params) {
                for (int i = 0; i < params.length; i++) {
                    pstmt.setObject(i + 1, params[i]);
                }
            }

            //执行查询的sql
            rs = pstmt.executeQuery();

            //想办法知道sql语句中查询的列名及列的个数
            //通过ResultSet类中的MetaData获取sql的元数据，在元数据中就保存了列名，列的个数等
            ResultSetMetaData metaData = rs.getMetaData();
            while (rs.next()) {
                int columnCount = metaData.getColumnCount(); //获取sql查询的列的个数
                Map<String, Object> map = new HashMap<>();//将每行数据保存到一个map中
                //因为一个sql语句中的结果集有多个列
                for (int i = 0; i < columnCount; i++) {
                    String key = metaData.getColumnLabel(i + 1);//获取列的别名
                    //String key = metaData.getColumnName(i + 1); //获取当前列号对应的真实列名
                    Object value = rs.getObject(key);
                    map.put(key, value);
                }
                list.add(map);
            }
            return list;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(connection,pstmt,rs);
        }
        return null;
    }
}
