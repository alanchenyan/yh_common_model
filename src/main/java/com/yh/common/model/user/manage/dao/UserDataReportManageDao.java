package com.yh.common.model.user.manage.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yh.common.model.user.entity.User;
import com.yh.common.model.user.entity.enums.ClientSourceEnum;
import com.yh.common.model.user.entity.enums.SexTypeEnum;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


/**
 * @author Alan Chen
 * @description 用户画像（报表）
 * @date 2020-01-15
 */
@Mapper
@Repository
public interface UserDataReportManageDao extends BaseMapper<User> {

    /**
     * 获取用户数量
     * @return
     */
    default Integer getUserCount(){
        Integer count = selectCount(null);
        if(count == null){
            return 0;
        }
        return count;
    }


    /**
     * 按性别获取用户数量
     * @param sexType
     * @return
     */
    default Integer getUserGenderData(SexTypeEnum sexType){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("sex", sexType.getCode());

        Integer count = selectCount(queryWrapper);
        if(count == null){
            return 0;
        }
        return count;
    }

    /**
     * 按注册途径获取用户数量
     * @param source
     * @return
     */
    default Integer getUserRegistSourceData(ClientSourceEnum source){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("regist_source", source.getCode());

        Integer count = selectCount(queryWrapper);
        if(count == null){
            return 0;
        }
        return count;
    }

    /**
     * 按地区获取用户数量
     * @param areaCode
     * @return
     */
    default Integer getUserAreaData(String areaCode){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("area_code", areaCode);

        Integer count = selectCount(queryWrapper);
        if(count == null){
            return 0;
        }
        return count;
    }
}
