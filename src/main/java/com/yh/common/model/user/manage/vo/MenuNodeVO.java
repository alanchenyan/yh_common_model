package com.yh.common.model.user.manage.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.yh.common.model.user.entity.enums.YesNoEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author Alan Chen
 * @description 菜单树节点
 * @date 2020-01-10
 */
@Data
public class MenuNodeVO {

    @ApiModelProperty("id")
    private String id;

    @ApiModelProperty("菜单名字")
    private String menuName;

    @ApiModelProperty("菜单url")
    private String menuUrl;

    @JSONField(serialzeFeatures= SerializerFeature.WriteEnumUsingToString)
    @ApiModelProperty("仅IT人员可见")
    private YesNoEnum onlyForIt;

    @ApiModelProperty("子节点")
    private List<MenuNodeVO> childrens;
}
