package com.yh.common.model.user.app.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yh.common.model.user.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author Alan Chen
 * @description
 * @date 2020-01-02
 */
@Mapper
@Repository
public interface UserDao extends BaseMapper<User> {

    /**
     * 获取用户
     * @param areaCode
     * @param phone
     * @return
     */
    default User getUser(String areaCode, String phone) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("area_code", areaCode).eq("phone", phone);
        return selectOne(queryWrapper);
    }

    /**
     * 获取用户
     * @param phone
     * @return
     */
    default User getUserByPhone(String phone){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("phone", phone);
        return selectOne(queryWrapper);
    }
}
