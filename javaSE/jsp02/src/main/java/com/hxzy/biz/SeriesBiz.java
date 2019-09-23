package com.hxzy.biz;

import com.hxzy.entity.Series;

import java.util.List;

public interface SeriesBiz extends CommonBiz<Series> {

    List<Series> findSeriesByBrandId(Integer id);
}
