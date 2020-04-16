package com.yh.common.model.user.app.controller;

import com.smm.framework.annotation.TRestController;
import com.yh.common.model.user.app.service.IUserService;
import com.yh.common.model.user.app.vo.ResetPasswordVO;
import com.yh.common.model.user.app.vo.UserRegistVO;
import com.yh.common.model.user.entity.User;
import com.yh.common.model.user.common.constant.ModulePrePath;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Alan Chen
 * @description App用户
 * @date 2020-01-02
 */
@Api(tags = "App用户")
@TRestController(value = ModulePrePath.APP+"/users")
public class UserController {

    @Autowired
    IUserService userServiceImpl;

    @ApiOperation("App用户注册")
    @PostMapping("/regist")
    public User userRegist(@RequestBody @Valid UserRegistVO userRegistVO){
        return userServiceImpl.userRegist(userRegistVO);
    }

    @ApiOperation("忘记密码")
    @PutMapping("/forget_password")
    public User forgetPassword(@RequestBody @Valid ResetPasswordVO resetPasswordVO){
        return userServiceImpl.resetPassword(resetPasswordVO);
    }

    @ApiOperation("修改密码")
    @PutMapping("/reset_password")
    public User resetPassword(@RequestBody @Valid ResetPasswordVO resetPasswordVO){
        return userServiceImpl.resetPassword(resetPasswordVO);
    }

    @ApiOperation("获取用户信息")
    @GetMapping
    public User getUserByPhone(@RequestParam String phone){
        return userServiceImpl.getUserByPhone(phone);
    }

    @ApiOperation("获取用户信息")
    @GetMapping("/{id}")
    public User getUser(@PathVariable String id){
        return userServiceImpl.getUser(id);
    }

    @ApiOperation("修改用户信息")
    @PutMapping
    public void updateUser(@RequestBody User user) {
        userServiceImpl.updateUser(user);
    }

}
