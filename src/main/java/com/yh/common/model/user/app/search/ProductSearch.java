package com.yh.common.model.user.app.search;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author Alan Chen
 * @description 商品查询
 * @date 2020-02-28
 */
@Data
public class ProductSearch extends Paging {

    @NotBlank(message = "search_product_name_not_mepty")
    @ApiModelProperty("商品名称")
    private String productName;

}
