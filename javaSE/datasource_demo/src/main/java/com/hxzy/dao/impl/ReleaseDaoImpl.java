package com.hxzy.dao.impl;

import com.hxzy.dao.ReleaseDao;
import com.hxzy.entity.Movie;
import com.hxzy.entity.Release;
import com.hxzy.entity.Room;
import com.hxzy.utils.JdbcUtils;
import com.hxzy.utils.ResultSetConsumer;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReleaseDaoImpl extends JdbcUtils implements ReleaseDao {
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
        String sql = "select t1.releaseId,t1.roomId,t1.movieId,t1.releaseTime,t2.roomName,t2.roomSeatNums,t3.movieName,t3.movieType,t3.movieState from `release` t1 " +
                "INNER JOIN room t2 " +
                "on t1.roomId = t2.roomId " +
                "INNER JOIN movie t3 " +
                "on t3.movieId = t1.movieId";

        List<Release> list = new ArrayList<>();
        super.executeQuery(new ResultSetConsumer<Release>() {
            @Override
            public Release apply(ResultSet rs) {
                try {
                    int releaseId = rs.getInt(1);
                    int roomId = rs.getInt(2);
                    int movieId = rs.getInt(3);
                    Date date = rs.getDate(4);
                    java.util.Date releaseTime = new java.util.Date(date.getTime());
                    String roomName = rs.getString(5);
                    int roomSeatNums = rs.getInt(6);
                    String movieName = rs.getString(7);
                    String movieType = rs.getString(8);
                    int movieState = rs.getInt(9);

                    Room room = new Room(roomId,roomName,roomSeatNums); //组建房间对象
                    Movie movie = new Movie(movieId,movieName,movieType,movieState);

                    Release release = new Release(releaseId,room,movie,releaseTime);
                    return release;
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                return null;
            }

            @Override
            public void accept(Release release) {
                list.add(release);
            }
        },sql);
        return list;
    }
}
