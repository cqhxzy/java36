package com.hxzy.dao;

import com.hxzy.entity.Phone;

import java.util.List;

public interface PhoneDao extends CommonDao<Phone>{

    List<java.util.Map<String,Object>> queryAllPhone2Map();


    java.util.Map<String,Object> findPhoneById(Integer id);

    /**
     * 分页查询数据
     * @param pageIndex 页码
     * @param pageSize  每页显示数据条数
     * @return
     */
    List<java.util.Map<String,Object>> paging(int pageIndex,int pageSize);

    /**
     * 搭配分页查询一起使用，用于查询数据的条数.注意，sql语句必须和分页查询的sql语句的条件完全相同
     * @return
     */
    int pagingCount();
}
