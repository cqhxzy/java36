package com.hxzy.biz;

import com.hxzy.entity.Phone;
import com.hxzy.vo.PhoneVo;

import java.util.List;

public interface PhoneBiz extends CommonBiz<Phone> {

    List<PhoneVo> queryAllPhone();

    java.util.Map<String,Object> findPhoneById(Integer id);
}
