package com.yh.common.model.user.manage.controller;

import com.smm.framework.annotation.TRestController;
import com.yh.common.model.user.common.constant.ModulePrePath;
import com.yh.common.model.user.common.service.IFileUpload;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Alan Chen
 * @description
 * @date 2020-01-07
 */
@Api(tags = "文件上传")
@TRestController(value = ModulePrePath.MANAGE +"/files")
public class FileUploadManageController {

    @Autowired
    IFileUpload fileUploadImpl;

    @ApiOperation("上传文件")
    @PostMapping("/upload")
    public String uploadFile(MultipartFile file){
        return fileUploadImpl.uploadFile(file);
    }
}
