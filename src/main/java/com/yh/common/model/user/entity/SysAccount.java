package com.yh.common.model.user.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.yh.common.model.user.entity.base.BaseEntity;
import com.yh.common.model.user.entity.enums.SexTypeEnum;
import com.yh.common.model.user.entity.enums.SysAccountTypeEnum;
import com.yh.common.model.user.entity.enums.YesNoEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author Alan Chen
 * @description 后台管理系统账号
 * @date 2020-01-02
 */
@Data
public class SysAccount extends BaseEntity {

    @ApiModelProperty("商户ID(平台数据不用传，不是平台数据要传)")
    private String merchantId;

    @ApiModelProperty("角色ID")
    private String roleId;

    @ApiModelProperty("账号")
    private String account;

    @ApiModelProperty("用户类型（前端不需要传，后台自动设置）")
    @JSONField(serialzeFeatures= SerializerFeature.WriteEnumUsingToString)
    private SysAccountTypeEnum accountType;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("电话")
    private String phone;

    @ApiModelProperty("真实姓名")
    private String realName;

    @ApiModelProperty("性别")
    @JSONField(serialzeFeatures= SerializerFeature.WriteEnumUsingToString)
    private SexTypeEnum sex;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("生日")
    private Date birthday;

    @ApiModelProperty("账号是否停用（前端不需要传，后台自动设置）")
    @JSONField(serialzeFeatures= SerializerFeature.WriteEnumUsingToString)
    private YesNoEnum stopState;

}
