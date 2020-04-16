package com.yh.common.model.user.manage.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.smm.framework.exception.ServiceException;
import com.yh.common.model.user.entity.User;
import com.yh.common.model.user.manage.dao.UserManageDao;
import com.yh.common.model.user.manage.vo.UserManageVO;
import com.yh.common.model.user.manage.search.UserManageSearch;
import com.yh.common.model.user.manage.service.IUserManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Alan Chen
 * @description 用户管理
 * @date 2020-01-11
 */
@Service
public class UserManageServiceImpl implements IUserManageService {

    @Autowired
    UserManageDao userManageDao;

    @Override
    public IPage<UserManageVO> pageUsers(UserManageSearch search) {
        return userManageDao.pageUsers(search,search);
    }

    @Override
    public User getUser(String id) {
        User user = userManageDao.selectById(id);
        if(user == null){
            throw new ServiceException("not_fund_data");
        }
        return user;
    }
}
