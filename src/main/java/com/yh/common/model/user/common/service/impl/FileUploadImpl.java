package com.yh.common.model.user.common.service.impl;

import com.smm.framework.util.FileUpLoadTool;
import com.yh.common.model.user.common.service.IFileUpload;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Alan Chen
 * @description
 * @date 2020-01-07
 */
@Service
public class FileUploadImpl implements IFileUpload {

    @Override
    public String uploadFile(MultipartFile file) {
        if(file!=null){
            return FileUpLoadTool.uploadFile(file);
        }
        return null;
    }
}
