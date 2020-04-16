//package com.yh.common.model.user.common.authority;
//
//import com.smm.framework.authority.CloseAuthorityEvironment;
//import com.smm.framework.authority.GlobalWebSecurityConfigurer;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.autoconfigure.security.SecurityProperties;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//
///**
// * @author Alan Chen
// * @description Spring security配置
// * @date 2019-10-12
// */
//@Configuration
//@Order(SecurityProperties.BASIC_AUTH_ORDER)
//public class WebSecurityConfigurer extends GlobalWebSecurityConfigurer {
//
//
//    @Value("${spring.profiles.active}")
//    private String currentRunEnvironment;
//
//    /**
//     * JWT Token 永不失效
//     * @return
//     */
//    @Override
//    protected boolean tokenNeverExpires(){
//        return true;
//    }
//
//    /**
//     * 指定某种运行环境下关闭权限校验；为了方便开发，一般我们的dev环境会关闭接口权限校验
//     * @return
//     */
//    @Override
//    public CloseAuthorityEvironment customCloseAuthorityEvironment(){
//        return new CloseAuthorityEvironment(currentRunEnvironment,"dev");
//    }
//
//    @Override
//    protected HttpSecurity customConfigure(HttpSecurity http) throws Exception {
//
//        http.cors().and().csrf().disable().authorizeRequests()
//                .antMatchers("/files/**").permitAll()
//                .antMatchers("/web_socket/**").permitAll()
//                .antMatchers("/manage/files/upload").permitAll()
//                .antMatchers("/app/files/upload").permitAll()
//                .antMatchers("/app/sms/verification_code").permitAll()
//                .antMatchers("/app/users/regist").permitAll()
//                .antMatchers("/app/users/forget_password").permitAll()
//                .antMatchers("/app/home_page/**").permitAll()
//                .antMatchers("/app/products/**").permitAll()
//                .antMatchers("/manage/notification/**").permitAll()
//                .anyRequest().authenticated();
//        return http;
//
//    }
//
//}
