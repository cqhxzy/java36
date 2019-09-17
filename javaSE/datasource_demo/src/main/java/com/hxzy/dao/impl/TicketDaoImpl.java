package com.hxzy.dao.impl;

import com.hxzy.dao.TicketDao;
import com.hxzy.entity.Ticket;
import com.hxzy.utils.JdbcUtils;

import java.util.List;

public class TicketDaoImpl extends JdbcUtils implements TicketDao {
    @Override
    public int insert(Ticket ticket) {
        return 0;
    }

    @Override
    public int update(Ticket ticket) {
        return 0;
    }

    @Override
    public int delete(Integer id) {
        return 0;
    }

    @Override
    public Ticket findById(Integer id) {
        return null;
    }

    @Override
    public List<Ticket> queryAll() {
        return null;
    }
}
