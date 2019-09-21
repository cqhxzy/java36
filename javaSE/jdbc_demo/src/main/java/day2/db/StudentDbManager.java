package day2.db;

import day2.entity.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 对数据库进行操作
 */
public class StudentDbManager implements StudentDbInterface {
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

    @Override
    public int insert(Student student) {
        String sql = "INSERT INTO `examstudent` (`type`,`id_card`,`Exam_Card`,`Student_Name`,`Location`,`Grade`) VALUES (?,?,?,?,?,?)";

        Connection connection = null;
        PreparedStatement pstmt = null;
        try {
            //建立连接
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            //预处理sql语句
            pstmt = connection.prepareStatement(sql);
            //为sql语句中的参数赋值
            pstmt.setInt(1, student.getType());
            pstmt.setString(2, student.getIdCard());
            pstmt.setString(3, student.getExamCard());
            pstmt.setString(4, student.getStudentName());
            pstmt.setString(5, student.getLocation());
            pstmt.setDouble(6, student.getGrade());
            //通用的执行DML操作的方法
            int executeUpdate = pstmt.executeUpdate();
            return executeUpdate; //返回数据受影响的行数
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //不管try当中是否出现了异常，都应该在finally中最后关闭掉connection，preparedStatement,resultSet
            try {
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override
    public int update(Student student) {
        //根据流水号的主键修改学生信息
        String sql = "update `examstudent` set `type`=?,`id_card`=?,`Exam_Card`=?,`Student_Name`=?,`Location`=?,`Grade`=? where `flowId`=?";
        //sql语句需要的参数,参数的顺序一定要和sql语句中对应
        Object[] params = {
                student.getType(),
                student.getIdCard(),
                student.getExamCard(),
                student.getStudentName(),
                student.getLocation(),
                student.getGrade(),
                student.getFlowId()
        };
        return executeUpdate(sql, params);
    }

    @Override
    public int delete(Integer flowId) {
        String sql = "delete from examstudent where flowId=?";
        return executeUpdate(sql, flowId);
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

    @Override
    public List<Student> queryAll() {
        String sql = "select `flowId`,`type`,`id_card`,`Exam_Card`,`Student_Name`,`Location`,`Grade` from examstudent";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        List<Student> list = new ArrayList<>();
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(sql);

            //因为没有参数，所以不需要为参数设置值

            rs = preparedStatement.executeQuery();

            while (rs.next()) {

                int flowId = rs.getInt(1);
                int type = rs.getInt(2);
                String idCard = rs.getString(3);
                String examCard = rs.getString(4);
                String studentName = rs.getString(5);
                String location = rs.getString(6);
                double grade = rs.getDouble(7);

                //根据参数，调用构造方法实例化学生对象
                Student student = new Student(flowId, type, idCard, examCard, studentName, location, grade);
                list.add(student);//将学生对象添加到集合中
            }
            return list;//返回集合
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(connection, preparedStatement, rs);
        }
        return null;
    }

    @Override
    public List<Map<String,Object>> queryByExamCard(String param) {
        String sql = "select `flowId`,`type`,`id_card`,`Exam_Card`,`Student_Name`,`Location`,`Grade` from examstudent where `Exam_Card`=?";
        List<Map<String, Object>> list = executeQuery1(sql, param);
        return list;
    }

    @Override
    public List<Map<String,Object>> queryByIdCard(String param) {
        String sql = "select `flowId`,`type`,`id_card` idCard,`Exam_Card` examCard,`Student_Name` studentName,`Location`,`Grade` from examstudent where `id_card`=?";
        List<Map<String, Object>> list = executeQuery1(sql, param);
        return list;
    }

    /*public <T> List<T> executeQuery(Class<T> tClass, String sql, Object... params) {

    }*/

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
