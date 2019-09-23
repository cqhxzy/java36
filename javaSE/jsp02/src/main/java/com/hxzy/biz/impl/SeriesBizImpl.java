package com.hxzy.biz.impl;

import com.hxzy.biz.SeriesBiz;
import com.hxzy.dao.SeriesDao;
import com.hxzy.dao.impl.SeriesDaoImpl;
import com.hxzy.entity.Series;

import java.util.List;

public class SeriesBizImpl implements SeriesBiz {
    private SeriesDao seriesDao = new SeriesDaoImpl();
    @Override
    public int insert(Series series) {
        return seriesDao.insert(series);
    }

    @Override
    public int update(Series series) {
        return seriesDao.update(series);
    }

    @Override
    public int delete(Integer id) {
        return seriesDao.delete(id);
    }

    @Override
    public Series findById(Integer id) {
        return seriesDao.findById(id);
    }

    @Override
    public List<Series> queryAll() {
        return seriesDao.queryAll();
    }

    @Override
    public List<Series> findSeriesByBrandId(Integer id) {
        return seriesDao.findSeriesByBrandId(id);
    }
}
