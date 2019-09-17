package com.hxzy.dao.impl;

import com.hxzy.dao.ReleaseDao;
import com.hxzy.entity.Release;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ReleaseDaoImplTest {

    @Test
    public void queryAll() {
        ReleaseDao dao = new ReleaseDaoImpl();
        List<Release> releases = dao.queryAll();
        releases.stream().forEach(System.out::println);
    }
}