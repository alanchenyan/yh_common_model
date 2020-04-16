package com.yh.common.model.user.manage.search;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Alan Chen
 * @description 用户列表查询条件
 * @date 2020-01-11
 */
@Data
public class UserManageSearch extends Page{

    @ApiModelProperty("电话")
    private String phone;
}
