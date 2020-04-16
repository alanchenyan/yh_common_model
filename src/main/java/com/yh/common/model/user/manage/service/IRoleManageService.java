package com.yh.common.model.user.manage.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yh.common.model.user.common.vo.SelectOption;
import com.yh.common.model.user.entity.Role;
import com.yh.common.model.user.manage.search.RoleSearch;
import com.yh.common.model.user.manage.vo.PlatformRoleAddVO;
import com.yh.common.model.user.manage.vo.PlatformRoleUpdateVO;
import com.yh.common.model.user.manage.vo.RoleAddVO;
import com.yh.common.model.user.manage.vo.RoleUpdateVO;
import com.yh.common.model.user.manage.search.PlatformRoleSearch;

import java.util.List;

/**
 * @author Alan Chen
 * @description 角色
 * @date 2020-01-03
 */
public interface IRoleManageService {

    /**
     * 新增角色
     * @param roleAddVO
     */
    void addRole(RoleAddVO roleAddVO);

    /**
     * 新增平台角色
     * @param roleAddVO
     */
    void addPlatformRole(PlatformRoleAddVO roleAddVO);

    /**
     * 获取需要修改的角色信息
     * @param roleId
     * @return
     */
    RoleUpdateVO getRoleForUpdate(String roleId);

    /**
     * 获取需要修改的平台角色信息
     * @param roleId
     * @return
     */
    PlatformRoleUpdateVO getPlatformRoleForUpdate(String roleId);

    /**
     * 修改角色
     * @param roleUpdateVO
     */
    void updateRole(RoleUpdateVO roleUpdateVO);

    /**
     * 修改平台角色
     * @param roleUpdateVO
     */
    void updatePlatformRole(PlatformRoleUpdateVO roleUpdateVO);

    /**
     * 删除角色
     * @param id
     */
    void deleteRole(String id);

    /**
     * 角色列表
     * @param search
     * @return
     */
    IPage<Role> pageRoles(RoleSearch search);

    /**
     * 角色列表
     * @param search
     * @return
     */
    IPage<Role> pagePlatformRoles(PlatformRoleSearch search);

    /**
     * 获取角色信息
     * @param id
     * @return
     */
    Role getRole(String id);

    /**
     * 获取角色下拉项
     * @param merchantId
     * @return
     */
    List<SelectOption> getRoleOptions(String merchantId);

    /**
     * 获取平台角色下拉项
     * @return
     */
    List<SelectOption> getPlatformRoleOptions();

}
