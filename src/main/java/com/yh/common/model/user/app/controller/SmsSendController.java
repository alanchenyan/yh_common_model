package com.yh.common.model.user.app.controller;

import com.smm.framework.annotation.TRestController;
import com.yh.common.model.user.app.service.ISmsSendService;
import com.yh.common.model.user.app.vo.VerificationCodeSendVO;
import com.yh.common.model.user.common.constant.ModulePrePath;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

/**
 * @author Alan Chen
 * @description 发送短信码
 * @date 2020-02-02
 */
@Api(tags = "发送短信验证码")
@TRestController(value = ModulePrePath.APP+"/sms")
public class SmsSendController {

    @Autowired
    ISmsSendService smsSendServiceImpl;

    @ApiOperation("发送短信验证码")
    @PostMapping("/verification_code")
    public void sendVerificationCode(@RequestBody @Valid VerificationCodeSendVO verificationCodeSendVO){
        smsSendServiceImpl.sendVerificationCode(verificationCodeSendVO);
    }
}
