package com.hxzy.biz.impl;

import com.hxzy.biz.BrandBiz;
import com.hxzy.dao.BrandDao;
import com.hxzy.dao.impl.BrandDaoImpl;
import com.hxzy.entity.Brand;

import java.util.List;

public class BrandBizImpl implements BrandBiz {

    private BrandDao brandDao = new BrandDaoImpl();

    @Override
    public int insert(Brand brand) {
        return brandDao.insert(brand);
    }

    @Override
    public int update(Brand brand) {
        return brandDao.update(brand);
    }

    @Override
    public int delete(Integer id) {
        return brandDao.delete(id);
    }

    @Override
    public Brand findById(Integer id) {
        return brandDao.findById(id);
    }

    @Override
    public List<Brand> queryAll() {
        return brandDao.queryAll();
    }
}
