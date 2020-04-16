package com.yh.common.model.user.app.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.yh.common.model.user.entity.enums.ClientSourceEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author Alan Chen
 * @description App用户注册信息
 * @date 2020-01-02
 */
@Data
public class UserRegistVO {

    @NotBlank(message = "app_user_input_areacode")
    @ApiModelProperty("区号")
    private String areaCode;

    @NotBlank(message = "app_user_input_phone")
    @ApiModelProperty("手机号")
    private String phone;

    @NotBlank(message = "app_user_input_verificationcode")
    @ApiModelProperty("短信验证码")
    private String verificationCode;

    @NotBlank(message = "app_user_input_pwd")
    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("注册途径")
    @JSONField(serialzeFeatures= SerializerFeature.WriteEnumUsingToString)
    private ClientSourceEnum registSource;
}
