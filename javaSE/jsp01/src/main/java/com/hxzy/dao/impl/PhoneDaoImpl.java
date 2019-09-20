package com.hxzy.dao.impl;

import com.hxzy.dao.PhoneDao;
import com.hxzy.entity.Phone;
import com.hxzy.util.JdbcUtils;

import java.util.List;

public class PhoneDaoImpl extends JdbcUtils implements PhoneDao {
    @Override
    public int insert(Phone phone) {
        return 0;
    }

    @Override
    public int update(Phone phone) {
        return 0;
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
}
