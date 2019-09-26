package com.hxzy.dao.impl;

import com.hxzy.dao.PhoneDao;
import com.hxzy.entity.Phone;
import com.hxzy.util.JdbcUtils;

import java.util.List;
import java.util.Map;

public class PhoneDaoImpl extends JdbcUtils implements PhoneDao {
    @Override
    public int insert(Phone phone) {
        String sql = "insert into phone (seriesId,os,networkModel,price) values(?,?,?,?)";
        Object[] params = {phone.getSeries().getId(),phone.getOs(),phone.getNetworkModel(),phone.getPrice()};
        return super.executeUpdate(sql,params);
    }

    @Override
    public int update(Phone phone) {
        String sql = "update phone set seriesId=?,os=?,networkModel=?,price=? where id=?";
        return super.executeUpdate(sql,phone.getSeries().getId(),phone.getOs(),phone.getNetworkModel(),phone.getPrice(),phone.getId());
    }

    @Override
    public int delete(Integer id) {
        return 0;
    }

    @Override
    public Phone findById(Integer id) {
        return null;
    }

    @Override
    public List<Phone> queryAll() {

        return null;
    }

    @Override
    public List<Map<String,Object>> queryAllPhone2Map() {
        StringBuilder builder = new StringBuilder();
        builder.append("select t1.*,t2.`name` `series`,t3.`name` `brand` from phone t1\n" )
                .append("inner join series t2\n" )
                .append("on t1.seriesId = t2.id\n" )
                .append("inner join brand t3\n" )
                .append("on t2.brandId = t3.id");
        List<Map<String, Object>> list = super.executeQuery(builder.toString());
        return list;
    }

    @Override
    public Map<String, Object> findPhoneById(Integer id) {
        StringBuilder builder = new StringBuilder();
        builder.append("select t1.id,t1.seriesId,t1.os,t1.networkModel,t1.price,t3.id brandId from phone t1\n" )
                .append("inner join series t2\n" )
                .append("on t1.seriesId = t2.id\n" )
                .append("inner join brand t3\n" )
                .append("on t2.brandId = t3.id")
                .append(" where t1.id=?");
        List<Map<String, Object>> list = super.executeQuery(builder.toString(),id);

        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<Map<String, Object>> paging(int pageIndex, int pageSize) {
        StringBuilder builder = new StringBuilder();
        builder.append("select t1.*,t2.`name` `series`,t3.`name` `brand` from phone t1\n" )
                .append("inner join series t2\n" )
                .append("on t1.seriesId = t2.id\n" )
                .append("inner join brand t3\n" )
                .append("on t2.brandId = t3.id")
                .append(" order by t1.id")
                .append(" limit ?,?");
        int param1 = (pageIndex - 1) * pageSize; //排除多少条数据

        List<Map<String, Object>> list = super.executeQuery(builder.toString(),param1,pageSize);
        return list;
    }

    @Override
    public int pagingCount() {
        StringBuilder builder = new StringBuilder();
        //必须保证这个sql语句返回的是一个单行单列的结果
        builder.append("select count(0) total from phone t1\n" )
                .append("inner join series t2\n" )
                .append("on t1.seriesId = t2.id\n" )
                .append("inner join brand t3\n" )
                .append("on t2.brandId = t3.id");
        List<Map<String, Object>> list = super.executeQuery(builder.toString());
        int total = ((Long) list.get(0).get("total")).intValue();
        return total;
    }
}
