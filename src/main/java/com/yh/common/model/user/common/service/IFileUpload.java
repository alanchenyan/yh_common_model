package com.yh.common.model.user.common.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author Alan Chen
 * @description 文件上传服务
 * @date 2020-01-02
 */
public interface IFileUpload {

    /**
     * 文件上传
     * @param file
     * @return
     */
    String uploadFile(MultipartFile file);
}
