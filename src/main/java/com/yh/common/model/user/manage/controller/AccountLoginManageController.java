package com.yh.common.model.user.manage.controller;

import com.smm.framework.annotation.TRestController;
import com.yh.common.model.user.common.constant.ModulePrePath;
import com.yh.common.model.user.manage.vo.AccountLoginResponseVO;
import com.yh.common.model.user.manage.service.IAccountLoginManageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotBlank;


/**
 * @author Alan Chen
 * @description 账号登录
 * @date 2020-01-10
 */
@Api(tags = "账号登录")
@TRestController(value = ModulePrePath.MANAGE +"/account_auth")
public class AccountLoginManageController {

    @Autowired
    IAccountLoginManageService accountLoginManageServiceImpl;

    @ApiOperation("获取登录返回的数据")
    @GetMapping("/login_response_data")
    public AccountLoginResponseVO getLoginResponseData(@RequestParam @NotBlank(message = "账号不能为空") String account){
        return accountLoginManageServiceImpl.getLoginResponseData(account);
    }
}
