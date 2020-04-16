package com.yh.common.model.user.manage.search;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author Alan Chen
 * @description App用户
 * @date 2020-01-02
 */
@Data
public class SysAccountSearch extends Page{

    @NotBlank(message = "merchant_id_not_empty")
    @ApiModelProperty("商户ID")
    private String merchantId;

    @ApiModelProperty("登录账号")
    private String account;

    @ApiModelProperty("真实姓名")
    private String realName;

}
