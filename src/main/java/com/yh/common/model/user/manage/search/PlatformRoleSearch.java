package com.yh.common.model.user.manage.search;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Alan Chen
 * @description 平台角色
 * @date 2020-04-07
 */
@Data
public class PlatformRoleSearch extends Page {

    @ApiModelProperty("角色名称")
    private String roleName;
}
