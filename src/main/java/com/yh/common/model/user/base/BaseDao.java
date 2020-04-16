package com.yh.common.model.user.base;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

/**
 * @program: real_estate
 * @description: 基类
 * @author: David
 * @create: 2020-04-02 18:07
 **/
public interface BaseDao<T,S extends Page>  extends BaseMapper<T> {

    /**
     * 分页查询
     *
     * @param page
     * @param search
     * @return
     */
     IPage<T> pageData(S page, @Param("search") S search);
     
     
     
     

}
