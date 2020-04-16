package com.yh.common.model.user.app.service.impl;

import com.smm.framework.exception.ServiceException;
import com.smm.framework.util.DateTool;
import com.yh.common.model.user.app.service.ISmsCodeRecordService;
import com.yh.common.model.user.app.service.ISmsSendService;
import com.yh.common.model.user.app.vo.VerificationCodeSendVO;
import com.yh.common.model.user.entity.SmsCodeRecord;
import com.yh.common.model.user.entity.enums.SmsTypeEnum;
import com.yh.common.model.user.entity.enums.YesNoEnum;
import com.yunpian.sdk.YunpianClient;
import com.yunpian.sdk.model.Result;
import com.yunpian.sdk.model.SmsSingleSend;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Alan Chen
 * @description 短信码
 * @date 2020-02-02
 */
@Service
public class SmsSendServiceImpl implements ISmsSendService {

    @Autowired
    ISmsCodeRecordService smsCodeRecordServiceImpl;

    static final int MAX_SEND_COUNT = 2;

    final static String SMS_API_KEY = "0e8938fa4822ba91a854df35b667f4aa";

    final static int SMS_CODE_EXPIRATION_HOUR = 24;


    @Value("${sms-msg.registration}")
    private  String registration;

    @Value("${sms-msg.reset-pwd}")
    private  String reset;
   


    @Transactional(rollbackFor = Exception.class)
    @Override
    public void sendVerificationCode(VerificationCodeSendVO smsSendVO) {

        int sendCount = smsCodeRecordServiceImpl.getTimeRangeSmsSendCount(smsSendVO.getAreaCode(), smsSendVO.getPhone(), smsSendVO.getSmsType(), 24);

        if (sendCount >= MAX_SEND_COUNT) {
            throw new ServiceException("use_previous_verification_code");
        }

        String verificationCode = (int) ((Math.random() * 9 + 1) * 100000) + "";
        String sendMobile = "+" + smsSendVO.getAreaCode() + smsSendVO.getPhone();

        //发送短信API
        YunpianClient clnt = new YunpianClient(SMS_API_KEY).init();
        Map<String, String> param = clnt.newParam(2);
        param.put(YunpianClient.MOBILE, sendMobile);
        
        String textTemplate ;
        if (smsSendVO.getSmsType() == SmsTypeEnum.USER_REGISTRATION){
            textTemplate = registration;
        }else {
            textTemplate = reset;
        }
        
        String smsMsg = textTemplate.replace("#code#", verificationCode);
        param.put(YunpianClient.TEXT, smsMsg);

        Result<SmsSingleSend> result = clnt.sms().single_send(param);
        clnt.close();

        if (result.getCode() != 0) {
            throw new ServiceException(result.getMsg());
        }

        SmsCodeRecord smsCodeRecord = new SmsCodeRecord();
        smsCodeRecord.setAreaCode(smsSendVO.getAreaCode());
        smsCodeRecord.setPhone(smsSendVO.getPhone());
        smsCodeRecord.setSmsCode(verificationCode);
        smsCodeRecord.setSmsMsg(smsMsg);
        smsCodeRecord.setSmsType(smsSendVO.getSmsType());
        smsCodeRecord.setUsedState(YesNoEnum.NO);
        smsCodeRecord.setExpirationDate(DateTool.dateRollHour(SMS_CODE_EXPIRATION_HOUR));
        smsCodeRecord.setSendResultCode(result.getCode() + "");
        if (StringUtils.isNotBlank(result.getDetail())) {
            smsCodeRecord.setSendResultMsg(result.getMsg() + ";" + result.getDetail());
        } else {
            smsCodeRecord.setSendResultMsg(result.getMsg());
        }

        smsCodeRecordServiceImpl.addSmsCodeRecord(smsCodeRecord);
    }

}
