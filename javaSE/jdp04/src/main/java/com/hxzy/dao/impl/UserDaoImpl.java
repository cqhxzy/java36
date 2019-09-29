package com.hxzy.dao.impl;

import com.hxzy.dao.UserDao;
import com.hxzy.entity.User;
import com.hxzy.util.JdbcUtils;
import com.hxzy.util.PageUtil;
import com.hxzy.util.StringUtils;

import java.util.List;
import java.util.Map;

public class UserDaoImpl extends JdbcUtils implements UserDao {
    @Override
    public int insert(User user) {
        String sql = "insert into tab_users (account,loginPwd,nickName,email) values(?,?,?,?)";
        Object[] params = {user.getAccount(), user.getLoginPwd(), user.getNickName(), user.getEmail()};
        return super.executeUpdate(sql,params);
    }

    @Override
    public int update(User user) {
        String sql = "update tab_users set account = ?,loginPwd = ?,nickName = ? ,email = ? where id = ?";
        Object[] params = {user.getAccount(), user.getLoginPwd(), user.getNickName(), user.getEmail(), user.getId()};
        return super.executeUpdate(sql,params);
    }

    @Override
    public int delete(Integer id) {
        String sql = "delete from tab_users where id = ?";
        return super.executeUpdate(sql,id);
    }

    @Override
    public User findById(Integer id) {
        String sql = "select id,account,nickName,loginPwd,email from tab_users where id = ?";
        List<User> users = super.executeQuery(User.class, sql, id);
        return users.size() > 0 ? users.get(0) : null;
    }

    @Override
    public List<User> queryAll() {
        String sql = "select id,account,nickName,loginPwd,email from tab_users";
        return super.executeQuery(User.class, sql);
    }

    @Override
    public PageUtil<User> paging(PageUtil util,String condition) {
        //根据条件动态拼接sql语句
        StringBuilder builder = new StringBuilder();
        builder.append("select id,account,nickName,loginPwd,email from tab_users where 1 = 1 \n");

        int limit = ( util.getPageIndex() - 1 ) * util.getPageSize();
        String param = StringUtils.strNotEmpty(condition)?"%" + condition + "%":null;
        Object[] params = StringUtils.strNotEmpty(condition) ? new Object[]{param,param,param,limit,util.getPageSize()}:new Object[]{limit,util.getPageSize()};

        if (StringUtils.strNotEmpty(condition)) {
            builder.append("and account like ? or nickName like ? or email like ?");
        }
        builder.append("\n limit ?,?");
        List<User> users = super.executeQuery(User.class, builder.toString(), params);
        util.setData(users); //查询的数据
        int total = this.total(condition);
        util.setTotal(total); //该条件查询对应的条数

        return util;
    }

    @Override
    public int total(String condition) {
        StringBuilder builder = new StringBuilder();
        builder.append("select count(0) total from tab_users where 1=1");

        condition = StringUtils.strNotEmpty(condition)?"%" + condition + "%":null;
        Object[] params = StringUtils.strNotEmpty(condition) ? new Object[]{condition,condition,condition}:null;

        if (StringUtils.strNotEmpty(condition)) {
            builder.append(" and account like ? or nickName like ? or email like ?");
        }

        List<Map<String, Object>> list = super.executeQuery(builder.toString(), params);

        if (list.size() > 0) {
            Map<String, Object> map = list.get(0);
            int total = ((Long) map.get("total")).intValue();
            return total;
        }
        return 0;
    }

    @Override
    public User validateAccount(String account) {
        String sql = "select id,account,nickName,email from tab_users where account = ?";
        List<User> users = super.executeQuery(User.class, sql, account);
        return users.size() > 0 ? users.get(0) : null;
    }

    @Override
    public User login(String account, String loginPwd) {
        String sql = "select id,account,nickName,loginPwd,email from tab_users where account = ? and loginPwd = ?";
        List<User> users = super.executeQuery(User.class, sql, account, loginPwd);
        return users.size() > 0 ? users.get(0) : null;
    }

}
