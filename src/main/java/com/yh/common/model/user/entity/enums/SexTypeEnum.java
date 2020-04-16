package com.yh.common.model.user.entity.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

/**
 * @author Alan Chen
 * @description 性别
 * @date 2020-01-02
 */
@Getter
public enum SexTypeEnum {

    /**
     * 未知
     */
    UN_KNOWN(0, "未知"),

    /**
     * 男
     */
    MALE(1, "男"),

    /**
     * 女
     */
    FEMALE(2, "女");

    SexTypeEnum(int code, String descp) {
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


