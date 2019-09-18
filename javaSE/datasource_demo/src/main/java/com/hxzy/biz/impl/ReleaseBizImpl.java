package com.hxzy.biz.impl;

import com.hxzy.biz.ReleaseBiz;
import com.hxzy.dao.ReleaseDao;
import com.hxzy.dao.impl.ReleaseDaoImpl;
import com.hxzy.entity.Release;

import java.util.List;

public class ReleaseBizImpl implements ReleaseBiz {

    private ReleaseDao dao = new ReleaseDaoImpl();

    @Override
    public int insert(Release release) {
        return 0;
    }

    @Override
    public int update(Release release) {
        return 0;
    }

    @Override
    public int delete(Integer id) {
        return 0;
    }

    @Override
    public Release findById(Integer id) {
        return null;
    }

    @Override
    public List<Release> queryAll() {
        return dao.queryAll();
    }
}
