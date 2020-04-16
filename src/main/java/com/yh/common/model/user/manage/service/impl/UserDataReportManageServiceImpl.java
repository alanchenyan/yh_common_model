package com.yh.common.model.user.manage.service.impl;

import com.yh.common.model.user.entity.enums.ClientSourceEnum;
import com.yh.common.model.user.entity.enums.SexTypeEnum;
import com.yh.common.model.user.manage.constant.ManageConstants;
import com.yh.common.model.user.manage.dao.UserDataReportManageDao;
import com.yh.common.model.user.manage.service.IUserDataReportManageService;
import com.yh.common.model.user.manage.vo.UserDataItemVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Alan Chen
 * @description 用户画像（报表）
 * @date 2020-01-15
 */
@Service
public class UserDataReportManageServiceImpl implements IUserDataReportManageService {

    @Autowired
    UserDataReportManageDao userDataReportManageDao;

    @Override
    public List<UserDataItemVO> getUserRegistSourceData() {

        List<UserDataItemVO> userRegistSourceDatas = new ArrayList<>();

        int userCount = userDataReportManageDao.getUserCount();

        int androidCount = userDataReportManageDao.getUserRegistSourceData(ClientSourceEnum.ANDROID);
        String androidCountPercent = calcPercent(androidCount,userCount);
        UserDataItemVO androidCountVO = new UserDataItemVO("Android",androidCountPercent);
        userRegistSourceDatas.add(androidCountVO);

        int iosCount = userDataReportManageDao.getUserRegistSourceData(ClientSourceEnum.IOS);
        String iosCountPercent = calcPercent(iosCount,userCount);
        UserDataItemVO iosCountVO = new UserDataItemVO("iOS",iosCountPercent);
        userRegistSourceDatas.add(iosCountVO);

        int webCount = userDataReportManageDao.getUserRegistSourceData(ClientSourceEnum.WEB);
        String webCountPercent = calcPercent(webCount,userCount);
        UserDataItemVO webCountVO = new UserDataItemVO("WEB",webCountPercent);
        userRegistSourceDatas.add(webCountVO);

        return userRegistSourceDatas;
    }

    @Override
    public List<UserDataItemVO> getUserGenderData() {

        List<UserDataItemVO> userGenderDatas = new ArrayList<>();

        int userCount = userDataReportManageDao.getUserCount();

        int unKnownCount = userDataReportManageDao.getUserGenderData(SexTypeEnum.UN_KNOWN);
        String unKnownCountPercent = calcPercent(unKnownCount,userCount);
        UserDataItemVO unKnownCountVO = new UserDataItemVO("未知",unKnownCountPercent);
        userGenderDatas.add(unKnownCountVO);

        int maleCount = userDataReportManageDao.getUserGenderData(SexTypeEnum.MALE);
        String maleCountPercent = calcPercent(maleCount,userCount);
        UserDataItemVO maleCountVO = new UserDataItemVO("男",maleCountPercent);
        userGenderDatas.add(maleCountVO);

        int femaleCount = userDataReportManageDao.getUserGenderData(SexTypeEnum.FEMALE);
        String femaleCountPercent = calcPercent(femaleCount,userCount);
        UserDataItemVO femaleCountVO = new UserDataItemVO("女",femaleCountPercent);
        userGenderDatas.add(femaleCountVO);

        return userGenderDatas;
    }

    @Override
    public List<UserDataItemVO> getUserAreaData() {

        List<UserDataItemVO> userAreaDatas = new ArrayList<>();

        int userCount = userDataReportManageDao.getUserCount();

        int chineseMainlandCount = userDataReportManageDao.getUserAreaData(ManageConstants.CHINESE_MAINLAND);
        UserDataItemVO chineseMainlandCountVO = new UserDataItemVO("中國大陸",chineseMainlandCount+"");
        userAreaDatas.add(chineseMainlandCountVO);

        int hongKongCount = userDataReportManageDao.getUserAreaData(ManageConstants.HONG_KONG);
        UserDataItemVO hongKongCountVO = new UserDataItemVO("香港",hongKongCount+"");
        userAreaDatas.add(hongKongCountVO);

        int macaoCount = userDataReportManageDao.getUserAreaData(ManageConstants.MACAO);
        UserDataItemVO macaoCountVO = new UserDataItemVO("澳門",macaoCount+"");
        userAreaDatas.add(macaoCountVO);

        int otherCount = userCount - chineseMainlandCount - hongKongCount - macaoCount;
        UserDataItemVO otherCountVO = new UserDataItemVO("其他",otherCount+"");
        userAreaDatas.add(otherCountVO);

        return userAreaDatas;
    }


    /**
     * 计算百分比
     * @param diliverNum 分子
     * @param queryMailNum 分母
     * @return
     */
    private String calcPercent(int diliverNum,int queryMailNum){
        if(queryMailNum == 0){
            return "0";
        }
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(0);
        String result = numberFormat.format((float)diliverNum/(float)queryMailNum*100);
        return result;
    }
}
