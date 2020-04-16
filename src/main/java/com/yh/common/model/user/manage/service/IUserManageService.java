package com.yh.common.model.user.manage.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yh.common.model.user.entity.User;
import com.yh.common.model.user.manage.vo.UserManageVO;
import com.yh.common.model.user.manage.search.UserManageSearch;

/**
 * @author Alan Chen
 * @description 用户管理
 * @date 2020-01-11
 */
public interface IUserManageService {


    /**
     * 查询用户列表
     * @param search
     * @return
     */
    IPage<UserManageVO> pageUsers(UserManageSearch search);

    /**
     * 获取用户详情
     * @param id
     * @return
     */
    User getUser(String id);

   


   

}
