package com.yh.common.model.user.manage.controller;

import com.smm.framework.annotation.TRestController;
import com.yh.common.model.user.common.constant.ModulePrePath;
import com.yh.common.model.user.entity.Menu;
import com.yh.common.model.user.manage.vo.MenuNodeVO;
import com.yh.common.model.user.manage.service.IMenuManageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @author Alan Chen
 * @description 功能菜单
 * @date 2020-01-09
 */
@Api(tags = "功能菜单管理")
@TRestController(value = ModulePrePath.MANAGE +"/menus")
public class MenuManageController {

    @Autowired
    IMenuManageService menuManageServiceImpl;

    @ApiOperation("新增菜单")
    @PostMapping
    public void addMenu(@RequestBody @Valid Menu menu){
        menuManageServiceImpl.addMenu(menu);
    }

    @ApiOperation("修改菜单")
    @PutMapping
    public void updateMenu(@RequestBody @Valid Menu menu){
        menuManageServiceImpl.updateMenu(menu);
    }

    @ApiOperation("删除菜单")
    @DeleteMapping("/{id}")
    public void deleteMenu(@PathVariable String id){
        menuManageServiceImpl.deleteMenu(id);
    }

    @ApiOperation("菜单树")
    @GetMapping("/tree")
    public List<MenuNodeVO> getMenuTree(@RequestParam("accountId") @NotBlank(message = "账号ID不能为空") String accountId){
        return menuManageServiceImpl.getMenuTree(accountId);
    }

}
