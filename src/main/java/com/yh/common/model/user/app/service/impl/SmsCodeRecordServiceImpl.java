package com.yh.common.model.user.app.service.impl;

import com.smm.framework.exception.ServiceException;
import com.smm.framework.util.DateTool;
import com.yh.common.model.user.app.dao.SmsCodeRecordDao;
import com.yh.common.model.user.app.service.ISmsCodeRecordService;
import com.yh.common.model.user.entity.SmsCodeRecord;
import com.yh.common.model.user.entity.enums.SmsTypeEnum;
import com.yh.common.model.user.entity.enums.YesNoEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author Alan Chen
 * @description 短信发送码
 * @date 2020-02-03
 */
@Service
public class SmsCodeRecordServiceImpl implements ISmsCodeRecordService {

    @Autowired
    SmsCodeRecordDao smsSendCodeDao;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addSmsCodeRecord(SmsCodeRecord smsCodeRecord) {
        smsSendCodeDao.insert(smsCodeRecord);
    }

    @Override
    public boolean verifySmsCode(String smsCode,String areaCode, String phone, SmsTypeEnum smsType) {
        SmsCodeRecord smsCodeRecord =  smsSendCodeDao.getLatestSmsCodeRecord(areaCode,phone,smsType);
        if(smsCodeRecord == null){
            throw new ServiceException("verification_code_error");
        }

        if(!smsCodeRecord.getSmsCode().equals(smsCode)){
            throw new ServiceException("verification_code_error");
        }

        if(smsCodeRecord.getExpirationDate().before(new Date())){
            throw new ServiceException("verification_code_expiration");
        }

        smsCodeRecord.setUsedState(YesNoEnum.YES);
        smsSendCodeDao.updateById(smsCodeRecord);

        return true;
    }

    @Override
    public int getTimeRangeSmsSendCount(String areaCode, String phone, SmsTypeEnum smsType, int hour) {
        String startDate = DateTool.getFormatDate(DateTool.dateRollHour(-hour));
        String endDate = DateTool.getFormatDate(new Date());
        return smsSendCodeDao.getTimeRangeSmsSendCount(areaCode,phone,smsType,startDate,endDate);
    }
}
