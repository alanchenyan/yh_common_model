package com.yh.common.model.user.manage.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.smm.framework.annotation.TRestController;
import com.yh.common.model.user.common.constant.ModulePrePath;
import com.yh.common.model.user.common.vo.SelectOption;
import com.yh.common.model.user.manage.search.RoleSearch;
import com.yh.common.model.user.manage.vo.RoleAddVO;
import com.yh.common.model.user.manage.vo.RoleUpdateVO;
import com.yh.common.model.user.entity.Role;
import com.yh.common.model.user.manage.service.IRoleManageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @author Alan Chen
 * @description 角色
 * @date 2020-01-09
 */
@Api(tags = "角色管理")
@TRestController(value = ModulePrePath.MANAGE +"/roles")
public class RoleManageController {

    @Autowired
    IRoleManageService roleServiceManageImpl;

    @ApiOperation("新增角色")
    @PostMapping
    public void addRole(@RequestBody @Valid RoleAddVO roleAddVO){
        roleServiceManageImpl.addRole(roleAddVO);
    }

    @ApiOperation("获取需要修改的角色信息")
    @GetMapping("/{roleId}")
    public RoleUpdateVO getRoleForUpdate(@PathVariable String roleId){
        return roleServiceManageImpl.getRoleForUpdate(roleId);
    }

    @ApiOperation("修改角色")
    @PutMapping
    public void updateRole(@RequestBody @Valid RoleUpdateVO roleUpdateVO){
        roleServiceManageImpl.updateRole(roleUpdateVO);
    }

    @ApiOperation("删除角色")
    @DeleteMapping("/{id}")
    public void deleteRole(@PathVariable String id){
        roleServiceManageImpl.deleteRole(id);
    }

    @ApiOperation("查询角色列表")
    @GetMapping("/list")
    public IPage<Role> pageRoles(@Valid RoleSearch search){
        return roleServiceManageImpl.pageRoles(search);
    }

    @ApiOperation("获取角色下拉项")
    @GetMapping("/options")
    public List<SelectOption> getRoleOptions(@RequestParam @NotBlank(message = "商户ID不能为空") String merchantId){
        return roleServiceManageImpl.getRoleOptions(merchantId);
    }

}
