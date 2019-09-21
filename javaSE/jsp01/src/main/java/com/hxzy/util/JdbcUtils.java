package com.hxzy.util;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

/**
 * jdbc数据库连接池的工具类
 */
public class JdbcUtils {

    private static Logger logger = LoggerFactory.getLogger(JdbcUtils.class);

    /**
     * 配置文件路径
     */
    private static final String CONFIG_FILE= "/jdbc.properties";

    /**
     * Druid数据库连接池
     */
    private static DruidDataSource dataSource;

    static{
        InputStream inputStream = JdbcUtils.class.getResourceAsStream(CONFIG_FILE);
        Properties properties = new Properties();
        try {
            properties.load(inputStream);

            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);

            /*System.out.println(dataSource.getMaxActive());
            System.out.println(dataSource.getDriverClassName());
            System.out.println(dataSource.getUsername());
            System.out.println(dataSource.getPassword());*/

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*public static void main(String[] args) throws SQLException {

            //int poolingCount = dataSource.getPoolingCount(); //获取池中的连接数

            *//*for (int i = 0; i < 20; i++) {
                DruidPooledConnection connection1 = dataSource.getConnection(); //从池中获取一个连接
                System.out.println(System.currentTimeMillis() + "-> poolingCount:" + dataSource.getPoolingCount());
            }*//*
            dataSource.init();//初始化连接池
            List<Map<String, Object>> poolingConnectionInfo = dataSource.getPoolingConnectionInfo(); //获取池中连接的信息

            for (Map<String, Object> map : poolingConnectionInfo) {
                Set<String> strings = map.keySet();
                for (String string : strings) {
                    Object value = map.get(string);
                    System.out.println("key:" + string + ", value:" + value);
                }
                System.out.println();
            }
    }*/

    /**
     * 从连接池中获取连接
     * @return
     */
    public Connection getConnection(){
        try {
            DruidPooledConnection connection = dataSource.getConnection();
            return connection;
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
        closeConnection(connection);
        closePstmt(pstmt);
        closeResultSet(rs);
    }

    public void closeConnection(Connection connection){
        if (connection != null) {
            try {
                connection.close(); //将连接归还到连接池
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void closePstmt(PreparedStatement pstmt){
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void closeResultSet(ResultSet resultSet){
        try {
            if (resultSet != null) resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据源
     * @return
     */
    public DataSource getDataSource(){
        return dataSource;
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
    public List<Map<String, Object>> executeQuery(String sql, Object... params){

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

    /**
     * 这是一个通用的查询方法
     * 限制：查询的表最好不能有多表依赖关系
     *      查询的sql语句的列名必须和类的属性名完全一致。否则不能映射到，从而获取数据
     *      查询映射的类，必须有无参构造方法
     * 只能查一个表对应一个实体类
     * @param tClass
     * @param sql
     * @param params
     * @param <T>
     * @return
     */
    public <T> List<T> executeQuery(Class<T> tClass,String sql, Object... params) {
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<T> list = new ArrayList<>();
        try {
            connection = this.getConnection();
            pstmt = connection.prepareStatement(sql);
            if (null != params) {
                for (int i = 0; i < params.length; i++) {
                    pstmt.setObject(i + 1, params[i]);
                }
            }

            rs = pstmt.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData(); //得到sql的元信息

            /*
             * 注册自定义的转换器：
             *   BeanUtils.setProperty在为对象赋值的时候，会将值根据属性的类型，从ConverterUtilsBean中的集合中获取对应的转换器
             *   根据转换器，就能够将不同的类型转换为对应Java Bean中属性的类型。
             *   ConvertUtils.register(Converter,Class)
             *           注册自定义的转换器。
             *            Converter是转换器的实例，会在 BeanUtils.setProperty中被调用
             *            Class对应的就是java Bean的属性的类型。（特殊的类型需要自定义转换器）
             * */
            ConvertUtils.register((object, value)->{
                //内部类：value接收data转换成string类型
                //SimpleDateFormat中的parse方法可以  把String型的字符串转换成特定格式的java.util.Date类
                if (value != null) {
                    try {
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        Date parse = simpleDateFormat.parse(value.toString());
                        return parse;
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
                return null;
            }, Date.class);

            while (rs.next()) {

                T t = tClass.newInstance(); //通过反射，调用T对应的类的无参构造方法，实例化一个对象
                for (int i = 0; i < metaData.getColumnCount(); i++) {
                    String columnLabel = metaData.getColumnLabel(i + 1); //注意此处：sql语句的列名必须和T对应的类的属性名完全相同
                    Object object = rs.getObject(columnLabel);
                    //System.out.println("object type:" + object.getClass().getName());
                    BeanUtils.setProperty(t,columnLabel,object); //通过Commons-beanutils为t对象的columnLabel属性赋值为object
                }

                //将t保存到集合
                list.add(t);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } finally {
            this.closeAll(connection,pstmt,rs);
        }
        return list;
    }

    public <T> void executeQuery(ResultSetConsumer<T> rsc,String sql,Object...params){
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            connection = this.getConnection();
            pstmt = connection.prepareStatement(sql);
            if (null != params) {
                for (int i = 0; i < params.length; i++) {
                    pstmt.setObject(i + 1, params[i]);
                }
            }

            rs = pstmt.executeQuery();

            while (rs.next()) {
                T apply = rsc.apply(rs);//根据当前行组件一个泛型T的对象
                logger.info("得到方法调用者组件的对象：" + apply);
                rsc.accept(apply);
                logger.info("将包装后的对象传递给方法的调用者：" + apply);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeAll(connection,pstmt,rs);
        }
    }
}
