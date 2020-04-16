package com.yh.common.model.user.entity;

import com.yh.common.model.user.entity.base.BaseEntity;
import com.yh.common.model.user.entity.enums.YesNoEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author Alan Chen
 * @description 角色
 * @date 2020-01-09
 */
@Data
public class Role extends BaseEntity {

    @NotBlank(message = "merchant_id_not_empty")
    @ApiModelProperty("商户ID")
    private String merchantId;

    @ApiModelProperty("角色名称")
    private String roleName;

     @ApiModelProperty("是否为平台角色（前端不需要传值，仅后台使用）")
    private YesNoEnum platformState;
}
