package com.yh.common.model.user.manage.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author Alan Chen
 * @description 修改平台角色VO
 * @date 2020-01-09
 */
@Data
public class PlatformRoleUpdateVO extends PlatformRoleAddVO {

    @NotBlank(message = "role_id_not_empty")
    @ApiModelProperty(value = "角色ID")
    private String id;
}
