package com.yh.common.model.user.manage.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yh.common.model.user.manage.vo.ResetSysAccountPwdAndAccountVO;
import com.yh.common.model.user.manage.vo.ResetSysAccountPwdVO;
import com.yh.common.model.user.entity.SysAccount;
import com.yh.common.model.user.manage.search.PlatformSysAccountSearch;
import com.yh.common.model.user.manage.search.SysAccountSearch;

/**
 * @author Alan Chen
 * @description
 * @date 2020-01-02
 */
public interface ISysAccountManageService {

    /**
     * 新增用户
     * @param sysAccount
     */
    void addSysAccount(SysAccount sysAccount);

    /**
     * 新增平台用户
     * @param sysAccount
     */
    void addPlatformSysAccount(SysAccount sysAccount);

    /**
     * 修改用户基本信息
     * @param sysAccount
     */
    void updateSysAccountBaseInfo(SysAccount sysAccount);

    /**
     * 重置账号密码
     * @param resetSysAccountPwdAndAccountVO
     */
    void resetAccountAndPassword(ResetSysAccountPwdAndAccountVO resetSysAccountPwdAndAccountVO);

    /**
     * 修改密码
     * @param resetSysAccountPwdVO
     */
    void resetPassword(ResetSysAccountPwdVO resetSysAccountPwdVO);

    /**
     * 新增管理员用户
     * @param sysAccount
     */
    void addSysAccountAdmin(SysAccount sysAccount);

    /**
     * 修改商户管理员
     * @param sysAccount
     */
    void updateSysAccountAdmin(SysAccount sysAccount);

    /**
     * 获取商户用户
     * @param id
     * @return
     */
    SysAccount getSysAccount(String id);

    /**
     * 获取账号
     * @param account
     * @return
     */
    SysAccount getSysAccountByAccount(String account);


    /**
     * 获取商户管理员
     * @param merchantId
     * @return
     */
    SysAccount getSysAccountAdmin(String merchantId);

    /**
     * 分页查询用户列表
     * @param search
     * @return
     */
    IPage<SysAccount> pageSysAccounts(SysAccountSearch search);

    /**
     * 分页查询用户列表
     * @param search
     * @return
     */
    IPage<SysAccount> pagePlatformSysAccounts(PlatformSysAccountSearch search);

    /**
     * 停用账号
     * @param id
     */
    void disableSysAccount(String id);

    /**
     * 启用账号
     * @param id
     */
    void enableSysAccount(String id);

    /**
     * 获取账号数量(删除角色前要先判断该角色下是否有账号)
     * @param roleId
     * @return
     */
    int getAccountCount(String roleId);
}
