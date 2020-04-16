package com.yh.common.model.user.app.service;


import com.yh.common.model.user.entity.SmsCodeRecord;
import com.yh.common.model.user.entity.enums.SmsTypeEnum;

/**
 * @author Alan Chen
 * @description 短信发送码记录
 * @date 2020-02-03
 */
public interface ISmsCodeRecordService {

    /**
     * 新增短信发送记录
     * @param smsCodeRecord
     */
    void addSmsCodeRecord(SmsCodeRecord smsCodeRecord);

    /**
     * 验证短信码
     * @param smsCode
     * @param areaCode
     * @param phone
     * @param smsType
     * @return
     */
    boolean verifySmsCode(String smsCode, String areaCode, String phone, SmsTypeEnum smsType);

    /**
     * n 小时内短信发送次数
     * @param areaCode
     * @param phone
     * @param smsType
     * @param hour 小时
     * @return
     */
    int getTimeRangeSmsSendCount(String areaCode, String phone, SmsTypeEnum smsType, int hour);

}
