package com.hxzy.dao;

import com.hxzy.entity.Series;

import java.util.List;

public interface SeriesDao extends CommonDao<Series> {

    /**
     * 根据品牌编号查询系列
     * @param id
     * @return
     */
    List<Series> findSeriesByBrandId(Integer id);
}
