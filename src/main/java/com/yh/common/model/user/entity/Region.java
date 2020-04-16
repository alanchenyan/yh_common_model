package com.yh.common.model.user.entity;

import com.yh.common.model.user.entity.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @program: wc_hotel
 * @description: 地区
 * @author: David
 * @create: 2020-04-14 15:37
 **/
@Data
public class Region extends BaseEntity {

    @ApiModelProperty("上级ID")
    private String proId;

    @ApiModelProperty("地区名称")
    private String areaName;

    @ApiModelProperty("优先级（排序）")
    private Integer sort;

}
