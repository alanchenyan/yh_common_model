package com.yh.common.model.user.manage.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.smm.framework.annotation.TRestController;
import com.yh.common.model.user.common.constant.ModulePrePath;
import com.yh.common.model.user.entity.User;
import com.yh.common.model.user.manage.vo.UserManageVO;
import com.yh.common.model.user.manage.search.UserManageSearch;
import com.yh.common.model.user.manage.service.IUserManageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Alan Chen
 * @description 用户管理
 * @date 2020-01-11
 */
@Api(tags = "用户管理")
@TRestController(value = ModulePrePath.MANAGE +"/users")
public class UserManageController {

    @Autowired
    IUserManageService userManageServiceImpl;

    @ApiOperation("查询用户列表")
    @GetMapping("/list")
    public IPage<UserManageVO> pageUsers(@Valid UserManageSearch search){
        return userManageServiceImpl.pageUsers(search);
    }

    @ApiOperation("获取用户详情")
    @GetMapping("/detail/{id}")
    public User getUserDetail(@PathVariable String id){
        return userManageServiceImpl.getUser(id);
    }
  
}
