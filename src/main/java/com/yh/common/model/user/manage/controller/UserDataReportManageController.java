package com.yh.common.model.user.manage.controller;

import com.smm.framework.annotation.TRestController;
import com.yh.common.model.user.common.constant.ModulePrePath;
import com.yh.common.model.user.manage.vo.UserDataItemVO;
import com.yh.common.model.user.manage.service.IUserDataReportManageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author Alan Chen
 * @description 用户画像（报表）
 * @date 2020-01-15
 */
@Api(tags = "用户画像（报表）")
@TRestController(value = ModulePrePath.MANAGE +"/user_data_reports")
public class UserDataReportManageController {

    @Autowired
    IUserDataReportManageService userDataReportManageServiceImpl;

    @ApiOperation("用户注册途径")
    @GetMapping("/regist_source")
    public List<UserDataItemVO> getUserRegistSourceData(){
        return userDataReportManageServiceImpl.getUserRegistSourceData();
    }

    @ApiOperation("用户性别")
    @GetMapping("/gender")
    public List<UserDataItemVO> getUserGenderData(){
        return userDataReportManageServiceImpl.getUserGenderData();
    }

    @ApiOperation("用户地区")
    @GetMapping("/area")
    public List<UserDataItemVO> getUserAreaData(){
        return userDataReportManageServiceImpl.getUserAreaData();
    }

}
