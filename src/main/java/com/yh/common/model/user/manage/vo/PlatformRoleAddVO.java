package com.yh.common.model.user.manage.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author Alan Chen
 * @description 新增平台角色VO
 * @date 2020-01-09
 */
@Data
public class PlatformRoleAddVO {

    @NotBlank(message = "role_name_not_empty")
    @ApiModelProperty("角色名称")
    private String roleName;

    @Size(min = 1,message = "menu_id_list_not_empty")
    @NotNull(message = "menu_id_list_not_empty")
    @ApiModelProperty("新建角色所拥有的菜单权限（菜单）")
    private List<String> menuIdList;

}
