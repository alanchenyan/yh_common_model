package com.yh.common.model.user.app.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author Alan Chen
 * @description 重置密码
 * @date 2020-01-02
 */
@Data
public class ResetPasswordVO {

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

}
