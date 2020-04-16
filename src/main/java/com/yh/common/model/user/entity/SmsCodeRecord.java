package com.yh.common.model.user.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yh.common.model.user.entity.base.BaseEntity;
import com.yh.common.model.user.entity.enums.SmsTypeEnum;
import com.yh.common.model.user.entity.enums.YesNoEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author Alan Chen
 * @description 短信发送码
 * @date 2020-02-03
 */
@Data
public class SmsCodeRecord extends BaseEntity {

    @ApiModelProperty("区号")
    private String areaCode;

    @ApiModelProperty("电话")
    private String phone;

    @ApiModelProperty("短信码")
    private String smsCode;

    @ApiModelProperty("短信内容")
    private String smsMsg;

    @ApiModelProperty("短信类型")
    @JSONField(serialzeFeatures= SerializerFeature.WriteEnumUsingToString)
    private SmsTypeEnum smsType;

    @ApiModelProperty("被使用状态（前端不需要传，后台自动设置）")
    @JSONField(serialzeFeatures= SerializerFeature.WriteEnumUsingToString)
    private YesNoEnum usedState;

    @JSONField(serialize = false)
    @JsonIgnore
    @ApiModelProperty("短信码过期时间（前端不需要传，后台自动生成）")
    private Date expirationDate;

    @ApiModelProperty("短信发送结果code (0:成功)")
    private String sendResultCode;

    @ApiModelProperty("短信发送结果描述信息")
    private String sendResultMsg;

}
