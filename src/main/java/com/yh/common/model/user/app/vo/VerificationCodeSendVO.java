package com.yh.common.model.user.app.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.yh.common.model.user.entity.enums.SmsTypeEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author Alan Chen
 * @description 短信验证码
 * @date 2020-02-02
 */
@Data
public class VerificationCodeSendVO {

    @NotBlank(message = "area_code_not_empty")
    @ApiModelProperty("区号")
    private String areaCode;

    @NotBlank(message = "phone_not_empty")
    @ApiModelProperty("电话")
    private String phone;

    @ApiModelProperty("短信类型")
    @JSONField(serialzeFeatures= SerializerFeature.WriteEnumUsingToString)
    private SmsTypeEnum smsType;

}
