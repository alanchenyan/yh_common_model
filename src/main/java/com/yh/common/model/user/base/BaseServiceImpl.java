package com.yh.common.model.user.base;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smm.framework.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: real_estate
 * @description: 基类
 * @author: David
 * @create: 2020-04-02 17:37
 **/

public class BaseServiceImpl<T, S extends Page, D extends BaseDao<T, S>> implements IBaseService<T, S> {

    @Autowired
    protected D dao;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addData(T t) {

        dao.insert(t);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public T getData(String id) {
        T t = dao.selectById(id);
        if (t == null) {
            throw new ServiceException("not_fund_data");
        }
        return t;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateData(T t) {

        dao.updateById(t);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteData(String id) {

        dao.deleteById(id);
    }

    @Override
    public IPage<T> pageData(S s) {

        return dao.pageData(s, s);
    }


}
