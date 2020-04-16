package com.yh.common.model.user.manage.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author Alan Chen
 * @description 商户管理员
 * @date 2020-01-03
 */
@Data
public class SysAccountAdminVO {

    @NotBlank(message = "sys_account_id_not_empty")
    @ApiModelProperty("商户管理员ID")
    private String id;

    @NotBlank(message = "admin_account_not_empty")
    @ApiModelProperty("商户管理员账号")
    private String adminAccount;

    @NotBlank(message = "admin_password_not_empty")
    @ApiModelProperty("商户管理员密码")
    private String adminPassword;


}
