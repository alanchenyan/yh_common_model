package com.yh.common.model.user.common.search;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Alan Chen
 * @description 数据记录数查询
 * @date 2020-02-23
 */
@Data
public class RecordsCountSearch {

    @ApiModelProperty("商户ID")
    private String merchantId;

    @ApiModelProperty("开始时间 yyyy-MM-dd HH:mm:ss")
    private String startTime;

    @ApiModelProperty("结束时间 yyyy-MM-dd HH:mm:ss")
    private String endTime;

    public RecordsCountSearch() {
    }

    public RecordsCountSearch(String merchantId, String startTime, String endTime) {
        this.merchantId = merchantId;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
