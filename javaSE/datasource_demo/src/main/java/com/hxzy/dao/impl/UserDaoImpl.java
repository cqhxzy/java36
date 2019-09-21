package com.hxzy.dao.impl;

import com.hxzy.dao.UserDao;
import com.hxzy.entity.User;
import com.hxzy.utils.JdbcUtils;
import com.hxzy.utils.ResultSetConsumer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends JdbcUtils implements UserDao {
    @Override
    public User login(String userName, String password) {
        return null;
    }

    @Override
    public int insert(User user) {
        return 0;
    }

    @Override
    public int update(User user) {
        return 0;
    }

    @Override
    public int delete(Integer id) {
        return 0;
    }

    @Override
    public User findById(Integer id) {
        return null;
    }

    @Override
    public List<User> queryAll() {
        String sql = "select userId id,userAccount account,userPassword password,admin,userName username from `user`";
        /*List<User> users = super.queryAll(User.class, sql);
        return users;*/

        List<User> list = new ArrayList<>();
        super.executeQuery(new ResultSetConsumer<User>() {
            @Override
            public User apply(ResultSet rs) {
                //获取当前行的数据
                try {
                    int id = rs.getInt(1);//从当前行中获取id
                    String account = rs.getString(2); //从当前行中获取账号
                    String password = rs.getString(3);
                    boolean admin = rs.getBoolean(4);
                    String username = rs.getString(5);

                    User user = new User(id, account, password, admin, username);
                    return user;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            public void accept(User user) {
                list.add(user); //将JdbcUtils返回的User对象保存到集合
            }
        }, sql);

        return list;
    }
}
