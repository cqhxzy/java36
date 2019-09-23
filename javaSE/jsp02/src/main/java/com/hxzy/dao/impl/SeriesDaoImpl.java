package com.hxzy.dao.impl;

import com.hxzy.dao.CommonDao;
import com.hxzy.dao.SeriesDao;
import com.hxzy.entity.Brand;
import com.hxzy.entity.Series;
import com.hxzy.util.JdbcUtils;
import com.hxzy.util.ResultSetConsumer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SeriesDaoImpl extends JdbcUtils implements SeriesDao {
    @Override
    public int insert(Series series) {
        return 0;
    }

    @Override
    public int update(Series series) {
        return 0;
    }

    @Override
    public int delete(Integer id) {
        return 0;
    }

    @Override
    public Series findById(Integer id) {
        return null;
    }

    @Override
    public List<Series> queryAll() {
        return null;
    }

    @Override
    public List<Series> findSeriesByBrandId(Integer id) {
        String sql = "select id,brandId,name from series where brandId=?";
        List<Series> list = new ArrayList<>();

        super.executeQuery(new ResultSetConsumer<Series>() {
            @Override
            public Series apply(ResultSet rs) {
                try {
                    int seriesId = rs.getInt("id");
                    int brandId = rs.getInt("brandId");
                    String name = rs.getString("name");

                    Brand brand = new Brand(brandId);
                    Series series = new Series(seriesId,brand,name);

                    return series;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            public void accept(Series series) {
                list.add(series);
            }
        },sql,id);
        return list;
    }
}
