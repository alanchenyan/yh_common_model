package com.yh.common.model.user.entity.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

/**
 * @author Alan Chen
 * @description 短信码类型
 * @date 2020-02-03
 */
@Getter
public enum SmsTypeEnum {

    /**
     * 用户注册
     */
    USER_REGISTRATION(0, "用户注册"),

    /**
     * 用户重置密码
     */
    USER_RESET_PWD(1, "用户重置密码");

    SmsTypeEnum(int code, String descp) {
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
