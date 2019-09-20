package com.hxzy.util;

import java.sql.ResultSet;

/**
 * 自定义的一个适用于复杂的查询的接口
 * ResultSetConsumer相当于是一种方法的回调
 *
 * apply方法为调用通用的查询的方法提供，结果从ResultSet中获取。在调用者
 * 根据需要从ResultSet结果集中得到数据后，组装称为泛型T的类型，在返回给executeQuery方法
 * accept从executeQuery方法中过来的方法
 *
 * apply方法和accept方法组合使用以后，就能够保证程序在执行中在两个方法中之间进行跳转
 *
 * @param <T>
 */
public interface ResultSetConsumer<T> {
    T apply(ResultSet rs);

    void accept(T t);
}
