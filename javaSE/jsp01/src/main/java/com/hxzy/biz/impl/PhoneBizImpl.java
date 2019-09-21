package com.hxzy.biz.impl;

import com.hxzy.biz.PhoneBiz;
import com.hxzy.dao.PhoneDao;
import com.hxzy.dao.impl.PhoneDaoImpl;
import com.hxzy.entity.Phone;

import java.util.List;

public class PhoneBizImpl implements PhoneBiz {
    private PhoneDao dao = new PhoneDaoImpl();
    @Override
    public int insert(Phone phone) {
        return dao.insert(phone);
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
