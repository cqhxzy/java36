package com.ajax.demo.mapper;

import com.ajax.demo.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    @Select("select * from tab_user where account=#{account} and password=#{password}")
    User login(@Param("account") String account,@Param("password") String password);

    @Insert("insert into tab_user(account,name,password,phone,age,gender,address,email,idCard)" +
            "values(#{account},#{name},#{password},#{phone},#{age},#{gender},#{address},#{email},#{idCard})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(User user);

    @Select("select count(0) from tab_user where account=#{account}")
    int validateUserAccount(@Param("account") String account);

}
