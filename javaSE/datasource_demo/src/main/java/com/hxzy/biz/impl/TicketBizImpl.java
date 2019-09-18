package com.hxzy.biz.impl;

import com.hxzy.biz.TicketBiz;
import com.hxzy.dao.TicketDao;
import com.hxzy.dao.impl.TicketDaoImpl;
import com.hxzy.entity.Ticket;

import java.util.List;

public class TicketBizImpl implements TicketBiz {
    private TicketDao ticketDao = new TicketDaoImpl();
    @Override
    public int insert(Ticket ticket) {
        return ticketDao.insert(ticket);
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
        return ticketDao.findById(id);
    }

    @Override
    public List<Ticket> queryAll() {
        return null;
    }
}
