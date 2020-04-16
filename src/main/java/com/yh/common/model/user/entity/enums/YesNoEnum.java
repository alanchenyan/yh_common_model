package com.yh.common.model.user.entity.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

/**
 * @author Alan Chen
 * @description 是/否
 * @date 2020-01-02
 */
@Getter
public enum YesNoEnum implements IEnum<Integer> {

    /**
     * 否
     */
    NO(0, "否"),

    /**
     * 是
     */
    YES(1, "是");

    YesNoEnum(int code, String descp) {
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

    @Override
    public Integer getValue() {
        return code;
    }
}


