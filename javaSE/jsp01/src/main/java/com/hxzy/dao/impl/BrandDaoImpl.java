package com.hxzy.dao.impl;

import com.hxzy.dao.BrandDao;
import com.hxzy.entity.Brand;
import com.hxzy.util.JdbcUtils;

import java.util.List;

public class BrandDaoImpl extends JdbcUtils implements BrandDao {
    @Override
    public int insert(Brand brand) {
        return 0;
    }

    @Override
    public int update(Brand brand) {
        return 0;
    }

    @Override
    public int delete(Integer id) {
        return 0;
    }

    @Override
    public Brand findById(Integer id) {
        return null;
    }

    @Override
    public List<Brand> queryAll() {
        String sql = "select id,name from brand";
        return super.executeQuery(Brand.class, sql);
    }
}
