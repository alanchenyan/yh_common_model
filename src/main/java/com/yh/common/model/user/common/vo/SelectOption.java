package com.yh.common.model.user.common.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Alan Chen
 * @description 选项
 * @date 2020-01-06
 */
@Data
public class SelectOption {

    @ApiModelProperty("存入数据库的值")
    private String optionKey;

    @ApiModelProperty("选项显示的内容")
    private String  optionValue;

}
