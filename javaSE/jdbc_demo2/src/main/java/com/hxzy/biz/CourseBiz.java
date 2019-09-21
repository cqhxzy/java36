package com.hxzy.biz;

import com.hxzy.vo.CourseVo;

import java.util.List;

/**
 * 业务逻辑层
 */
public interface CourseBiz {

    /*
     * 任何一个类都应该包含如下操作
     *
     * */

    /**
     * 新增课程
     * @return
     */
    int insert(CourseVo vo);

    /**
     * 根据主键修改
     * @return
     */
    int update(CourseVo vo);

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
    CourseVo findById(Integer id);

    /**
     * 全查
     * @return
     */
    List<CourseVo> queryAll();
}
