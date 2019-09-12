package day2.db;

import day2.entity.Student;

import java.sql.*;
import java.util.List;

/**
 * 对数据库进行操作
 */
public class StudentDbManager implements StudentDbInterface{
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
            pstmt.setInt(1,student.getType());
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
        return executeUpdate(sql,params);
    }

    @Override
    public int delete(Integer flowId) {
        String sql = "delete from examstudent where flowId=?";
        return executeUpdate(sql, flowId);
    }


    /**
     * 通过的增、删、改的方法
     * @param sql
     * @param params
     * @return
     */
    public int executeUpdate(String sql,Object... params){
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
        } finally{
            closeAll(connection,pstmt,null);
        }
        return 0;
    }

    /*获取连接*/
    public Connection getConnection(){
        try {
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 关闭连接释放资源
     * @param connection
     * @param pstmt
     * @param rs
     */
    public void closeAll(Connection connection, PreparedStatement pstmt, ResultSet rs){
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
        return null;
    }

    @Override
    public List<Student> queryByExamCard(String examCard) {
        return null;
    }

    @Override
    public List<Student> queryByIdCard(String idCard) {
        return null;
    }
}
