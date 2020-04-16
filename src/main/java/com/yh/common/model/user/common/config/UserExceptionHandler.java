package com.yh.common.model.user.common.config;

import com.smm.framework.exception.GlobalExceptionHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;


/**
 * @author Alan Chen
 * @description 全局异常处理
 * @date 2019-09-24
 */
@ControllerAdvice
@Component
public class UserExceptionHandler extends GlobalExceptionHandler {

    @Override
    protected boolean enableValidationI18n() {
        return true;
    }

    @Override
    protected boolean enableResponseMessageI18n() {
        return true;
    }
}

