package com.yh.common.model.user.manage.service.impl;

import com.yh.common.model.user.entity.RoleMenuRelation;
import com.yh.common.model.user.manage.dao.RoleMenuRelationManageDao;
import com.yh.common.model.user.manage.service.IRoleMenuRelationManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Alan Chen
 * @description 角色-菜单-关联表
 * @date 2020-01-09
 */
@Service
public class RoleMenuRelationManageServiceImpl implements IRoleMenuRelationManageService {

    @Autowired
    RoleMenuRelationManageDao roleMenuRelationDao;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addRoleMenuRelation(RoleMenuRelation roleMenuRelation) {
        roleMenuRelationDao.insert(roleMenuRelation);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteRoleMenuRelation(String roleId) {
        roleMenuRelationDao.deleteRoleMenuRelation(roleId);
    }
}
