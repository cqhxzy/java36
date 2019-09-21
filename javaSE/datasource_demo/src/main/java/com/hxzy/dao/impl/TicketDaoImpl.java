package com.hxzy.dao.impl;

import com.hxzy.dao.TicketDao;
import com.hxzy.entity.Release;
import com.hxzy.entity.Ticket;
import com.hxzy.entity.User;
import com.hxzy.utils.JdbcUtils;
import com.hxzy.utils.ResultSetConsumer;
import com.hxzy.utils.StringUitls;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TicketDaoImpl extends JdbcUtils implements TicketDao {
    @Override
    public int insert(Ticket ticket) {
        String sql = "insert into `ticket` (`releaseId`,`userId`,`ticketPrice`,`ticketTime`) values(?,?,?,?)";
        Object[] params = {ticket.getRelease().getId(),ticket.getUser().getId(),ticket.getPrice(),ticket.getTime()};
        return super.executeUpdate(sql,params);
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
        StringBuilder builder = new StringBuilder();
        builder.append("select t1.ticketId,t1.releaseId,t1.userId,t1.ticketPrice,t1.ticketTime ")
                .append("from `ticket` t1 ")
                .append("INNER JOIN `release` t2 ")
                .append("on t1.releaseId = t2.releaseId ")
                .append("INNER JOIN `user` t3 ")
                .append("on t1.userId = t3.userId ")
                .append("where t1.ticketId = ?");
        List<Ticket> list = new ArrayList<>();

        super.executeQuery(new ResultSetConsumer<Ticket>() {
            @Override
            public Ticket apply(ResultSet rs) {
                try {
                    int ticketId = rs.getInt(1);
                    int releaseId = rs.getInt(2);
                    int userId = rs.getInt(3);
                    double ticketPrice = rs.getDouble(4);
                    Timestamp timestamp = rs.getTimestamp(5);

                    String s = StringUitls.convertDate2Str(timestamp);
                    System.out.println(s);

                    Ticket ticket = new Ticket();
                    ticket.setId(ticketId);
                    ticket.setPrice(ticketPrice);
                    ticket.setTime(timestamp);

                    Release release = new Release();
                    release.setId(releaseId);

                    User user = new User();
                    user.setId(userId);

                    ticket.setRelease(release);
                    ticket.setUser(user);
                    return ticket;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            public void accept(Ticket ticket) {
                list.add(ticket);
            }
        },builder.toString(),id);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<Ticket> queryAll() {

        return null;
    }
}
