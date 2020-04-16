package com.yh.common.model.user.manage.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Alan Chen
 * @description 用户人数汇总
 * @date 2020-02-28
 */
@Data
public class UserCountSummary {

    @ApiModelProperty(value = "总人数")
    private String totalCount;

    @ApiModelProperty(value = "本月新增人数")
    private String increasedThisMonth;

    @ApiModelProperty(value = "本周新增人数")
    private String increasedThisWeek;

    @ApiModelProperty(value = "今日新增人数")
    private String increasedToday;
}
