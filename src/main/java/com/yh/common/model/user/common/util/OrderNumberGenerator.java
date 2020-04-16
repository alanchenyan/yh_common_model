package com.yh.common.model.user.common.util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Alan Chen
 * @description 订单号生成器
 * @date 2020-01-20
 */
public class OrderNumberGenerator {

    private OrderNumberGenerator(){}

    /**
     * 訂單編號由後台生成  日期+時間+5位數(日計) = 20200219+1035+00001 = 20200219103500001
     * @return
     */
    public static String createOrderNo(int todayOrderCount){

        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmm");
        String today = format.format(date.getTime());

        DecimalFormat df = new DecimalFormat("00000");
        String nextSerial = df.format(todayOrderCount+1);
        return today+nextSerial;
    }

}
