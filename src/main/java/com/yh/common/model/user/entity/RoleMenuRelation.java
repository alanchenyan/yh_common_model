package com.yh.common.model.user.entity;

import com.yh.common.model.user.entity.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Alan Chen
 * @description 角色-菜单-关联表
 * @date 2020-01-09
 */
@Data
public class RoleMenuRelation extends BaseEntity {

    @ApiModelProperty("角色ID")
    private String roleId;

    @ApiModelProperty("菜单ID")
    private String menuId;

}
