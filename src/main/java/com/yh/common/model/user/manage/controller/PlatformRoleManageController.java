package com.yh.common.model.user.manage.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.smm.framework.annotation.TRestController;
import com.yh.common.model.user.common.constant.ModulePrePath;
import com.yh.common.model.user.common.vo.SelectOption;
import com.yh.common.model.user.manage.vo.PlatformRoleAddVO;
import com.yh.common.model.user.manage.vo.PlatformRoleUpdateVO;
import com.yh.common.model.user.entity.Role;
import com.yh.common.model.user.manage.search.PlatformRoleSearch;
import com.yh.common.model.user.manage.service.IRoleManageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Alan Chen
 * @description 平台角色
 * @date 2020-01-09
 */

@Api(tags = "平台角色管理")
@TRestController(value = ModulePrePath.PLATFORM + "/platform_roles")
public class PlatformRoleManageController {

    


    @Autowired
    IRoleManageService roleServiceManageImpl;

    @ApiOperation("新增角色")
    @PostMapping
    public void addPlatformRole(@RequestBody @Valid PlatformRoleAddVO roleAddVO) {

        roleServiceManageImpl.addPlatformRole(roleAddVO);
    }

    @ApiOperation("获取需要修改的角色信息")
    @GetMapping("/{roleId}")
    public PlatformRoleUpdateVO getPlatformRoleForUpdate(@PathVariable String roleId) {

        return roleServiceManageImpl.getPlatformRoleForUpdate(roleId);
    }

    @ApiOperation("修改角色")
    @PutMapping
    public void updatePlatformRole(@RequestBody @Valid PlatformRoleUpdateVO roleUpdateVO) {

        roleServiceManageImpl.updatePlatformRole(roleUpdateVO);
    }

    @ApiOperation("删除角色")
    @DeleteMapping("/{id}")
    public void deleteRole(@PathVariable String id) {

        roleServiceManageImpl.deleteRole(id);
    }

    @ApiOperation("查询角色列表")
    @GetMapping("/list")
    public IPage<Role> pagePlatformRoles(@Valid PlatformRoleSearch search) {

        return roleServiceManageImpl.pagePlatformRoles(search);
    }

    @ApiOperation("获取角色下拉项")
    @GetMapping("/options")
    public List<SelectOption> getPlatformRoleOptions() {

        return roleServiceManageImpl.getPlatformRoleOptions();
    }

}
