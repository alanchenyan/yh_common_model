package com.yh.common.model.user.manage.search;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author Alan Chen
 * @description 角色
 * @date 2020-01-03
 */
@Data
public class RoleSearch extends Page{

    @NotBlank(message = "merchant_id_not_empty")
    @ApiModelProperty("商户ID")
    private String merchantId;

    @ApiModelProperty("角色名称")
    private String roleName;

}
