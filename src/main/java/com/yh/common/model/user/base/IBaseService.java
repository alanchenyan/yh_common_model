package com.yh.common.model.user.base;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * @program: real_estate
 * @description: service基类
 * @author: David
 * @create: 2020-04-02 17:18
 **/
public interface IBaseService<T,S extends Page> {
    
     /**
     * 新增商品
     *
     * @param t
     */
    void addData(T t);

    /**
     * 获取商品
     *
     * @param id
     * @return
     */
    T getData(String id);

    /**
     * 修改商品信息
     *
     * @param t
     */
    void updateData(T t);

    /**
     * 删除商品
     *
     * @param id
     */
    void deleteData(String id);

     /**
     * 商品列表
     *
     * @param search
     * @return
     */
    IPage<T> pageData(S search);
    

}
