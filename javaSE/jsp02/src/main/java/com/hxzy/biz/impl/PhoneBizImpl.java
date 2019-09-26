package com.hxzy.biz.impl;

import com.hxzy.biz.PhoneBiz;
import com.hxzy.dao.PhoneDao;
import com.hxzy.dao.impl.PhoneDaoImpl;
import com.hxzy.entity.Phone;
import com.hxzy.util.PageUtil;
import com.hxzy.vo.PhoneVo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PhoneBizImpl implements PhoneBiz {
    private PhoneDao dao = new PhoneDaoImpl();
    @Override
    public int insert(Phone phone) {
        return dao.insert(phone);
    }

    @Override
    public int update(Phone phone) {
        return dao.update(phone);
    }

    @Override
    public int delete(Integer id) {
        return dao.delete(id);
    }

    @Override
    public Phone findById(Integer id) {
        return dao.findById(id);
    }

    @Override
    public List<Phone> queryAll() {
        return dao.queryAll();
    }

    @Override
    public List<PhoneVo> queryAllPhone() {

        List<Map<String, Object>> list = dao.queryAllPhone2Map();
        //将Phone转换为PhoneVo

        List<PhoneVo> collect = list.stream().map(t -> {  //t为list集合中每个元素map
            Integer id = ((Long) t.get("id")).intValue();
            String brand = (String) t.get("brand");
            String series = (String) t.get("series");
            Integer os = ((Long) t.get("os")).intValue();
            Long networkModel = (Long) t.get("networkModel");
            String os_str = "Android";

            if (os == 2) {
                os_str = "IOS";
            } else if (os == 3) {
                os_str = "老人机";
            }

            String model = "";
            if (networkModel != null) {
                model = networkModel + "G";
            }
            Double price = (Double) t.get("price");

            return new PhoneVo(id, brand, series, os_str, model, price);
        }).collect(Collectors.toList());

        return collect;
    }

    @Override
    public Map<String, Object> findPhoneById(Integer id) {
        return dao.findPhoneById(id);
    }

    @Override
    public PageUtil<PhoneVo> paging(int pageIndex, int pageSize) {
        List<Map<String, Object>> list = dao.paging(pageIndex, pageSize);
        //将map的集合转换为phoneVo的对象
        List<PhoneVo> collect = list.stream().map(t -> {  //t为list集合中每个元素map
            Integer id = ((Long) t.get("id")).intValue();
            String brand = (String) t.get("brand");
            String series = (String) t.get("series");
            Integer os = ((Long) t.get("os")).intValue();
            Long networkModel = (Long) t.get("networkModel");
            String os_str = "Android";

            if (os == 2) {
                os_str = "IOS";
            } else if (os == 3) {
                os_str = "老人机";
            }

            String model = "";
            if (networkModel != null) {
                model = networkModel + "G";
            }
            Double price = (Double) t.get("price");

            return new PhoneVo(id, brand, series, os_str, model, price);
        }).collect(Collectors.toList());

        //组件分页工具类对象
        PageUtil pageUtil = new PageUtil();
        pageUtil.setPageIndex(pageIndex); //页码
        pageUtil.setPageSize(pageSize); //每页显示多少条数据
        pageUtil.setData(collect); //手机的集合
        pageUtil.setTotal(this.pagingCount());

        return pageUtil;
    }

    @Override
    public int pagingCount() {
        return dao.pagingCount();
    }
}
