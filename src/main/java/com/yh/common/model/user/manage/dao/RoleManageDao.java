package com.yh.common.model.user.manage.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yh.common.model.user.common.vo.SelectOption;
import com.yh.common.model.user.entity.Role;
import com.yh.common.model.user.manage.search.PlatformRoleSearch;
import com.yh.common.model.user.manage.search.RoleSearch;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Alan Chen
 * @description 用户角色
 * @date 2020-01-02
 */
@Mapper
@Repository
public interface RoleManageDao extends BaseMapper<Role> {

    /**
     * 查询角色列表
     * @param page
     * @param search
     * @return
     */
    IPage<Role> pageRoles(Page page, @Param("search") RoleSearch search);

    /**
     * 查询平台角色列表
     * @param page
     * @param search
     * @return
     */
    IPage<Role> pagePlatformRoles(Page page, @Param("search") PlatformRoleSearch search);

    /**
     * 查询角色拥有的菜单
     * @param roleId
     * @return
     */
    List<String> getMenuIdsByRole(@Param("roleId") String roleId);

    /**
     * 获取角色下拉项
     * @param merchantId
     * @return
     */
    List<SelectOption> getRoleOptions(@Param("merchantId") String merchantId);

    /**
     * 获取平台角色下拉项
     * @return
     */
    List<SelectOption> getPlatformRoleOptions();

}
