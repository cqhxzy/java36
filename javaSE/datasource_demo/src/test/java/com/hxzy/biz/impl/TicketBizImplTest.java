package com.hxzy.biz.impl;

import com.hxzy.biz.TicketBiz;
import com.hxzy.entity.Release;
import com.hxzy.entity.Ticket;
import com.hxzy.entity.User;
import com.hxzy.utils.StringUitls;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class TicketBizImplTest {

    TicketBiz biz = new TicketBizImpl();

    @Test
    public void insert() {


        Ticket ticket = new Ticket();
        ticket.setPrice(55.0);
        ticket.setTime(StringUitls.convertStr2Date("2019-09-15 10:51:00"));

        Release release = new Release();
        release.setId(3);//编号为3的放映信息

        ticket.setRelease(release);

        User user = new User();
        user.setId(3); //编号为3的用户

        ticket.setUser(user);


        int insert = biz.insert(ticket);

        assertEquals(1, insert);
    }

    @Test
    public void testFindById(){
        Ticket ticket = biz.findById(7);
        System.out.println(ticket);
    }
}