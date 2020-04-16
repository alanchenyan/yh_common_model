package com.yh.common.model.user.common.config;

import com.smm.framework.config.enumconvert.GlobalEnumconvertWebConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author Alan Chen
 * @description 枚举类型转换配置
 * @date 2020-02-06
 */
@Configuration
@EnableWebMvc
public class UserEnumconvertWebConfig extends GlobalEnumconvertWebConfig {
}
