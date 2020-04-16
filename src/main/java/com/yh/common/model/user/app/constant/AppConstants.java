package com.yh.common.model.user.app.constant;

/**
 * @author Alan Chen
 * @description
 * @date 2020-03-16
 */
public class AppConstants {

    /**
     * 下单后N小时内可退单
     */
    public static final int AVLIAD_CHARGEBACK_HOUR = 48;

    /**
     * 7天
     */
    public static final int SERVEN_DAY = 7;


    //    public static String USER_REGISTRATION = "【珠海金信软件】驗證碼#code#，您正在注册成為新用戶，感謝您的支持！";
//
//    public static String USER_RESET_PWD = "【珠海金信软件】驗證碼#code#，您正在嘗試修改登入密碼，請妥善保管帳戶資訊。";
//    
    public static String USER_REGISTRATION = "感謝您的支持！";

    public static String USER_RESET_PWD = "請妥善保管帳戶資訊。";

    public static void setUserRegistration(String userRegistration) {

        USER_REGISTRATION = userRegistration;
    }

    public static void setUserResetPwd(String userResetPwd) {

        USER_RESET_PWD = userResetPwd;
    }

}
