package com.yh.common.model.user.common.config;

import com.smm.framework.config.swagger.SwaggerApiInfo;
import com.yh.common.model.user.common.constant.SysConstants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



/**
 * @author Alan Chen
 * @description Swagger文档配置
 * @date 2019/5/15
 */
@Configuration
@EnableSwagger2
public class UserSwaggerConfig extends GlobalSwaggerConfig2 {


    static {
        addSwaggerApiInfos(new SwaggerApiInfo("user_后台管理系统API接口文档", SysConstants.MANAGE_CONTROLLER, "V1.0.0"));
        addSwaggerApiInfos(new SwaggerApiInfo("user_app API接口文档", SysConstants.APP_CONTROLLER, "V1.0.0"));
    }

    @Value("${swagger.enable}")
    private boolean enable;

    @Override
    public boolean swaggerEnable() {

        return enable;
    }

}
