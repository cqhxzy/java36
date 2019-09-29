package com.hxzy.biz;

import com.hxzy.entity.User;
import com.hxzy.util.PageUtil;
import com.hxzy.vo.UserVo;

public interface UserBiz extends CommonBiz<User> {
    UserVo login(String account, String loginPwd);
    /**
     * 分页查询
     * @param util
     * @return
     */
    PageUtil paging(PageUtil util, String condition);

    /**
     * 分页查询条数
     * @param condition
     * @return
     */
    int total(String condition);

    boolean validateAccount(String account);
}
