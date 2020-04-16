package com.yh.common.model.user.manage.search;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Alan Chen
 * @description 平台账号
 * @date 2020-01-02
 */
@Data
public class PlatformSysAccountSearch extends Page{

    @ApiModelProperty("登录账号")
    private String account;

    @ApiModelProperty("真实姓名")
    private String realName;

}
