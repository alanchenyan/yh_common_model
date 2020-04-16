package com.yh.common.model.user.manage.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yh.common.model.user.entity.User;
import com.yh.common.model.user.manage.search.UserManageSearch;
import com.yh.common.model.user.manage.vo.UserManageVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author Alan Chen
 * @description 用户管理
 * @date 2020-01-11
 */
@Repository
@Mapper
public interface UserManageDao extends BaseMapper<User> {

    /**
     * 查询用户积分列表
     * @param page
     * @param search
     * @return
     */
    IPage<UserManageVO> pageUsers(Page page, @Param("search") UserManageSearch search);

}
