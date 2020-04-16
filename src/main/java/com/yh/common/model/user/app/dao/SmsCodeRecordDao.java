package com.yh.common.model.user.app.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yh.common.model.user.entity.SmsCodeRecord;
import com.yh.common.model.user.entity.enums.SmsTypeEnum;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Alan Chen
 * @description 短信发送码
 * @date 2020-02-03
 */
@Mapper
@Repository
public interface SmsCodeRecordDao extends BaseMapper<SmsCodeRecord> {

    /**
     * 获取短信验证码
     * @param areaCode
     * @param phone
     * @param smsType
     * @return
     */
    default SmsCodeRecord getLatestSmsCodeRecord(String areaCode, String phone, SmsTypeEnum smsType){
        QueryWrapper<SmsCodeRecord> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("area_code", areaCode)
                .eq("phone", phone)
                .eq("send_result_code", 0)
                .eq("sms_type",smsType.getCode());

        queryWrapper.orderByDesc("create_time");

        List<SmsCodeRecord> list = selectList(queryWrapper);
        if(list!=null && list.size()>0){
           return list.get(0);
        }
        return null;
    }


    /**
     * 一段时间内短信发送次数
     * @param areaCode
     * @param phone
     * @param smsType
     * @param startTime
     * @param endTime
     * @return
     */
    default int getTimeRangeSmsSendCount(String areaCode, String phone, SmsTypeEnum smsType, String startTime, String endTime){
        QueryWrapper<SmsCodeRecord> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("area_code", areaCode)
                .eq("phone", phone)
                .eq("sms_type",smsType.getCode())
                .ge("create_time",startTime)
                .le("create_time",endTime);

        Integer count = selectCount(queryWrapper);
        if(count == null){
            return 0;
        }
        return count.intValue();
    }
}
