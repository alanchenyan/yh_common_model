package com.yh.common.model.user.app.search;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Alan Chen
 * @description 分页查询
 * @date 2020-02-28
 */
@Data
public class Paging {

    @ApiModelProperty("当前页")
    private long currentIndex;

    @ApiModelProperty("每页数据条数")
    private long pageSize;

}
