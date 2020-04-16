package com.yh.common.model.user.manage.service;


import com.yh.common.model.user.entity.RoleMenuRelation;

/**
 * @author Alan Chen
 * @description  角色-菜单-关联表
 * @date 2020-01-09
 */
public interface IRoleMenuRelationManageService {

    /**
     *  新增角色-菜单
     * @param roleMenuRelation
     */
    void addRoleMenuRelation(RoleMenuRelation roleMenuRelation);

    /**
     * 删除角色-菜单
     * @param roleId
     */
    void deleteRoleMenuRelation(String roleId);
}
