package com.yh.common.model.user.common.config;

import com.smm.framework.config.GlobalUploadFileAccessConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author Alan Chen
 * @description 文件上传访问路径配置
 * @date 2020-01-08
 */
@Configuration
@EnableWebMvc
public class UploadFileAccessConfig extends GlobalUploadFileAccessConfig {
}
