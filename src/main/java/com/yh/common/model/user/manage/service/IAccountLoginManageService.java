package com.yh.common.model.user.manage.service;


import com.yh.common.model.user.manage.vo.AccountLoginResponseVO;

/**
 * @author Alan Chen
 * @description  账号登录
 * @date 2020-01-10
 */
public interface IAccountLoginManageService {

    /**
     * 获取登录账号的功能菜单权限
     * @param account
     * @return
     */
    AccountLoginResponseVO getLoginResponseData(String account);
}
