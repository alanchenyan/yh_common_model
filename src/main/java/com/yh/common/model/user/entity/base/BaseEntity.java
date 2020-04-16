package com.yh.common.model.user.entity.base;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author Alan Chen
 * @description
 * @date 2019-09-21
 */
@Data
public class BaseEntity {

    @ApiModelProperty("ID（后台自动插入）")
    @TableId(type = IdType.UUID)
    private String id;

    @JsonIgnore
    @ApiModelProperty("创建人ID（后台自动插入）")
    @TableField(fill = FieldFill.INSERT)
    private String createUserId;

    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    @JsonIgnore
    @ApiModelProperty("数据创建时间（后台自动生成）")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @JsonIgnore
    @ApiModelProperty("修改人ID（后台自动插入）")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updateUserId;

    @JSONField(serialize = false)
    @JsonIgnore
    @ApiModelProperty("数据修改时间（后台自动生成）")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @JsonIgnore
    @JSONField(serialize = false)
    @ApiModelProperty("逻辑删除标志 0:未删除；1：已删除（后台自动插入）")
    @TableLogic
    private Integer deleted;
}
