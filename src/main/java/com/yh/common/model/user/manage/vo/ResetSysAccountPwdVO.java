package com.yh.common.model.user.manage.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author Alan Chen
 * @description 修改密码
 * @date 2020-01-19
 */
@Data
public class ResetSysAccountPwdVO{

    @NotBlank(message = "update_account_id_not_empt")
    @ApiModelProperty("账号ID")
    private String accountId;

    @NotBlank(message = "update_account_pwd_not_empt")
    @ApiModelProperty("新密码")
    private String newPassword;
}
