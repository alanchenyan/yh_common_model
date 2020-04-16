package com.yh.common.model.user.manage.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.smm.framework.annotation.TRestController;
import com.yh.common.model.user.common.constant.ModulePrePath;
import com.yh.common.model.user.manage.vo.ResetSysAccountPwdAndAccountVO;
import com.yh.common.model.user.manage.vo.ResetSysAccountPwdVO;
import com.yh.common.model.user.entity.SysAccount;
import com.yh.common.model.user.manage.search.SysAccountSearch;
import com.yh.common.model.user.manage.service.ISysAccountManageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Alan Chen
 * @description 后台管理系统用户
 * @date 2020-01-02
 */
@Api(tags = "后台管理系统用户")
@TRestController(value = ModulePrePath.MANAGE +"/sys_accounts")
public class SysAccountManageController {

    @Autowired
    ISysAccountManageService sysAccountManageService;

    @ApiOperation("新增用户")
    @PostMapping
    public void addSysAccount(@RequestBody @Valid SysAccount sysAccount){
        sysAccountManageService.addSysAccount(sysAccount);
    }

    @ApiOperation("获取用户信息")
    @GetMapping("/{id}")
    public SysAccount getSysAccount(@PathVariable String id){
        return sysAccountManageService.getSysAccount(id);
    }

    @ApiOperation("修改用户基本信息")
    @PutMapping("/base_info")
    public void updateSysAccountBaseInfo(@RequestBody @Valid SysAccount sysAccount){
        sysAccountManageService.updateSysAccountBaseInfo(sysAccount);
    }

    @ApiOperation("重置账号密码")
    @PutMapping("/account_pwd")
    public void resetAccountAndPassword(@RequestBody @Valid ResetSysAccountPwdAndAccountVO resetSysAccountPwdAndAccountVO){
        sysAccountManageService.resetAccountAndPassword(resetSysAccountPwdAndAccountVO);
    }

    @ApiOperation("修改密码")
    @PutMapping("/pwd")
    public void resetPassword(@RequestBody @Valid ResetSysAccountPwdVO resetSysAccountPwdVO){
        sysAccountManageService.resetPassword(resetSysAccountPwdVO);
    }

    @ApiOperation("查询用户列表")
    @GetMapping("/list")
    public IPage<SysAccount> pageSysAccount(@Valid SysAccountSearch search){
        return sysAccountManageService.pageSysAccounts(search);
    }

    @ApiOperation("停用账号")
    @PutMapping("/disable/{id}")
    public void disableSysAccount(@PathVariable String id){
        sysAccountManageService.disableSysAccount(id);
    }

    @ApiOperation("启用账号")
    @PutMapping("/enable/{id}")
    public void enableSysAccount(@PathVariable String id){
        sysAccountManageService.enableSysAccount(id);
    }

}
