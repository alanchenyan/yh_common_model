package com.yh.common.model.user.manage.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.yh.common.model.user.common.vo.SelectOption;
import com.yh.common.model.user.entity.enums.SysAccountTypeEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author Alan Chen
 * @description 账号登录返回的数据
 * @date 2020-01-10
 */
@Data
public class AccountLoginResponseVO {

    @ApiModelProperty("账号ID")
    private String accountId;

    @ApiModelProperty("账号")
    private String account;

    @ApiModelProperty("用户类型")
    @JSONField(serialzeFeatures= SerializerFeature.WriteEnumUsingToString)
    private SysAccountTypeEnum accountType;

    @ApiModelProperty("菜单列表")
    private List<String> menus;

    @ApiModelProperty("餐厅列表")
    private List<SelectOption> merchants;

}
