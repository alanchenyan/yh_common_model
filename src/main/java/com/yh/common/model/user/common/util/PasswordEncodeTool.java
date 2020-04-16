package com.yh.common.model.user.common.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author Alan Chen
 * @description 密码加密
 * @date 2020-01-29
 */
public class PasswordEncodeTool {

    private PasswordEncodeTool(){}

    public static String encodePassword(String rawPassword){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(rawPassword);
    }
}
