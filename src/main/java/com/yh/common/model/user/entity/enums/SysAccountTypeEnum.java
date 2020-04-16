package com.yh.common.model.user.entity.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

/**
 * @author Alan Chen
 * @description 后台管理系统登录用户类型
 * @date 2020-01-02
 */
@Getter
public enum SysAccountTypeEnum {

    /**
     * 商户普通用户
     */
    MERCHANT_ORDINARY_USER(0, "商户普通用户"),

    /**
     * 商户管理员,有新建商户角色、分配菜单的权限
     */
    MERCHANT_ADMIN(1, "商户管理员"),

    /**
     * 平台账号
     */
    PLATFORM_ACOUNT(2, "平台账号"),

    /**
     * IT人员
     */
    IT(3, "IT人员");


    SysAccountTypeEnum(int code, String descp) {
        this.code = code;
        this.descp = descp;
    }

    /**
     * 将值映射为数据的值
     */
    @JsonValue
    @EnumValue
    private final int code;

    private final String descp;

    /**
     * 将数据的值映射为枚举值
      * @return
     */
    @Override
    public String toString() {
        return String.valueOf(this.code);
    }

    /**
     * 映射为Swagger文档内容
     * @return
     */
    @JsonValue
    public String mapForSwagger(){
        return this.code+":"+this.descp;
    }
}


