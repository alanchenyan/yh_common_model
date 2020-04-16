package com.yh.common.model.user.common.config;

import com.smm.framework.config.GlobalReturnConfig;

import com.yh.common.model.user.common.constant.SysConstants;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;



/**
 * @author Alan Chen
 * @description Controller返回参数全局包装成ResponseResult对象.只拦截controller包下的类；否则swagger也会拦截影响swagger正常使用
 * @date 2019-10-11
 */
@EnableWebMvc
@Configuration
@RestControllerAdvice({SysConstants.APP_CONTROLLER,SysConstants.MANAGE_CONTROLLER})
public class UserControllerReturnConfig extends GlobalReturnConfig {

}