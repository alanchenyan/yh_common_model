package com.yh.common.model.user.manage.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Alan Chen
 * @description 修改排序VO
 * @date 2020-01-28
 */
@Data
public class SortUpdateVO {

    @NotBlank(message = "id_not_empty")
    @ApiModelProperty("ID")
    private String id;

    @NotNull(message = "sort_number_not_null")
    @ApiModelProperty("排序序号")
    private Integer sortNumber;

}
