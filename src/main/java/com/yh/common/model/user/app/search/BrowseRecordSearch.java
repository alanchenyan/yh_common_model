package com.yh.common.model.user.app.search;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * @author Alan Chen
 * @description 订单数据导出查询条件
 * @date 2020-02-25
 */
@Data
public class BrowseRecordSearch {

    @ApiModelProperty("用户ID")
    private String userId;

    @ApiModelProperty("开始时间")
    private String startTime;

    @ApiModelProperty("结束时间")
    private String endTime;
}
