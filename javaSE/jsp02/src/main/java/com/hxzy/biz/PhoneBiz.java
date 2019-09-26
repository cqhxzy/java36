package com.hxzy.biz;

import com.hxzy.entity.Phone;
import com.hxzy.util.PageUtil;
import com.hxzy.vo.PhoneVo;

import java.util.List;

public interface PhoneBiz extends CommonBiz<Phone> {

    List<PhoneVo> queryAllPhone();

    java.util.Map<String,Object> findPhoneById(Integer id);

    /**
     * 分页查询
     * @param pageIndex
     * @param pageSize
     * @return
     */
    PageUtil<PhoneVo> paging(int pageIndex,int pageSize);

    /**
     * 搭配分页查询一起使用，用于查询数据的条数.注意，sql语句必须和分页查询的sql语句的条件完全相同
     * @return
     */
    int pagingCount();
}
