package com.yh.common.model.user.manage.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Alan Chen
 * @description 用户画像
 * @date 2020-01-15
 */
@Data
public class UserDataItemVO {

    @ApiModelProperty("数据项")
    private String itemName;

    @ApiModelProperty("数据项")
    private String itemData;

    public UserDataItemVO(String itemName, String itemData) {
        this.itemName = itemName;
        this.itemData = itemData;
    }
}
