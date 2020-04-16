package com.yh.common.model.user.app.search;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @program: real_estate
 * @description: 留言与回复
 * @author: David
 * @create: 2020-04-07 16:32
 **/
@Data
public class LeaveMessageSearch extends Page {

    @ApiModelProperty("求租表ID")
    private String solicitMessageId;

    @ApiModelProperty("用户id")
    private String userId;

    @ApiModelProperty("用户留言id")
    private String messageUserId;

}
