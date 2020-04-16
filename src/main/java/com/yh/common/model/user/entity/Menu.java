package com.yh.common.model.user.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.yh.common.model.user.entity.base.BaseEntity;
import com.yh.common.model.user.entity.enums.YesNoEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Alan Chen
 * @description 功能菜单
 * @date 2020-01-09
 */
@Data
public class Menu extends BaseEntity {

    @ApiModelProperty("菜单名称")
    private String menuName;

    @ApiModelProperty("菜单路径")
    private String menuUrl;

    @ApiModelProperty("优先级（排序）")
    private Integer sort;

    @ApiModelProperty("上级菜单")
    private String parentId;

    @JSONField(serialzeFeatures= SerializerFeature.WriteEnumUsingToString)
    @ApiModelProperty("仅IT人员可见")
    private YesNoEnum onlyForIt;

}
