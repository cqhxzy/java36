package com.hxzy.biz.impl;

import com.hxzy.biz.BrandBiz;
import com.hxzy.entity.Brand;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BrandBizImplTest {

    @Test
    public void queryAll() {
        BrandBiz brandBiz = new BrandBizImpl();
        List<Brand> brands = brandBiz.queryAll();
        brands.stream().forEach(System.out::println);
    }
}