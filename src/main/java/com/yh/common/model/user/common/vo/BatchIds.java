package com.yh.common.model.user.common.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author Alan Chen
 * @description ID集合
 * @date 2020-02-22
 */
@Data
public class BatchIds {

    @ApiModelProperty("ID集合")
    List<String> ids;
}
