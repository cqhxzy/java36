package com.hxzy.biz;

import java.util.List;

/**
 * 通用的业务逻辑接口
 * @param <T>
 */
public interface CommonBiz<T> {
    /**
     * 新增
     * @return
     */
    int insert(T t);

    /**
     * 根据主键修改
     * @return
     */
    int update(T t);

    /**
     * 根据主键删除
     * @param id
     * @return
     */
    int delete(Integer id);

    /**
     * 根据主键查询
     * @param id
     * @return
     */
    T findById(Integer id);

    /**
     * 全查
     * @return
     */
    List<T> queryAll();
}
