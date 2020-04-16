package com.yh.common.model.user.manage.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Alan Chen
 * @description 用户管理
 * @date 2020-01-11
 */
@Data
public class UserManageVO {

    @ApiModelProperty("id")
    private String id;

    @ApiModelProperty("区号")
    private String areaCode;

    @ApiModelProperty("电话")
    private String phone;

    @ApiModelProperty("积分")
    private Integer integral;

    @ApiModelProperty("会员等级ID")
    private String memberGradeId;

    @ApiModelProperty("会员等级")
    private String memberGradeName;


}
