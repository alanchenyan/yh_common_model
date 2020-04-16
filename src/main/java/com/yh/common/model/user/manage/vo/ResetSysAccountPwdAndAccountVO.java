package com.yh.common.model.user.manage.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author Alan Chen
 * @description 修改账号密码
 * @date 2020-01-19
 */
@Data
public class ResetSysAccountPwdAndAccountVO extends ResetSysAccountPwdVO{

    @NotBlank(message = "update_account_not_empt")
    @ApiModelProperty("账号")
    private String account;

}
