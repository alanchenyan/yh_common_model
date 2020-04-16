package com.yh.common.model.user.common.config;


import com.smm.framework.config.GlobalCorsConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author Alan Chen
 * @description 跨域请求
 * @date 2019/5/15
 */
@Configuration
@EnableWebMvc
public class UserCorsConfig extends GlobalCorsConfig {

}

