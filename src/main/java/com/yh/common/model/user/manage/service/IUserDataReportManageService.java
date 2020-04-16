package com.yh.common.model.user.manage.service;


import com.yh.common.model.user.manage.vo.UserDataItemVO;

import java.util.List;

/**
 * @author Alan Chen
 * @description 用户画像（报表）
 * @date 2020-01-15
 */
public interface IUserDataReportManageService {

    /**
     * 用户注册途径
     * @return
     */
    List<UserDataItemVO> getUserRegistSourceData();

    /**
     * 用户性别
     * @return
     */
    List<UserDataItemVO> getUserGenderData();

    /**
     * 用户地区
     * @return
     */
    List<UserDataItemVO> getUserAreaData();

}
