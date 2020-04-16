package com.yh.common.model.user.app.service;


import com.yh.common.model.user.app.vo.VerificationCodeSendVO;

/**
 * @author Alan Chen
 * @description 发送短信码
 * @date 2020-02-02
 */
public interface ISmsSendService {

  


    /**
     * 发送短信验证码
     *
     * @param verificationCodeSendVO
     */
    void sendVerificationCode(VerificationCodeSendVO verificationCodeSendVO);

}
