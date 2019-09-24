package com.hxzy.dao;

import com.hxzy.entity.Phone;

import java.util.List;

public interface PhoneDao extends CommonDao<Phone>{

    List<java.util.Map<String,Object>> queryAllPhone2Map();


    java.util.Map<String,Object> findPhoneById(Integer id);


}
