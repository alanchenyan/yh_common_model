package com.yh.common.model.user.manage.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.smm.framework.exception.ServiceException;
import com.yh.common.model.user.common.util.PasswordEncodeTool;
import com.yh.common.model.user.entity.SysAccount;
import com.yh.common.model.user.entity.enums.SysAccountTypeEnum;
import com.yh.common.model.user.entity.enums.YesNoEnum;
import com.yh.common.model.user.manage.dao.SysAccountManageDao;
import com.yh.common.model.user.manage.service.ISysAccountManageService;
import com.yh.common.model.user.manage.vo.ResetSysAccountPwdAndAccountVO;
import com.yh.common.model.user.manage.vo.ResetSysAccountPwdVO;
import com.yh.common.model.user.manage.search.PlatformSysAccountSearch;
import com.yh.common.model.user.manage.search.SysAccountSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Alan Chen
 * @description
 * @date 2020-01-02
 */
@Service
public class SysAccountManageServiceImpl implements ISysAccountManageService {

    @Autowired
    SysAccountManageDao sysAccountManageDao;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addSysAccount(SysAccount sysAccount) {
        sysAccount.setAccountType(SysAccountTypeEnum.MERCHANT_ORDINARY_USER);
        encodePassword(sysAccount);
        sysAccountManageDao.insert(sysAccount);
    }

    @Override
    public void addPlatformSysAccount(SysAccount sysAccount) {
        sysAccount.setAccountType(SysAccountTypeEnum.PLATFORM_ACOUNT);
        encodePassword(sysAccount);
        sysAccountManageDao.insert(sysAccount);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateSysAccountBaseInfo(SysAccount sysAccount) {
        // 字段设置为空表示该字段不用修改
        sysAccount.setMerchantId(null);
        sysAccount.setAccountType(null);
        sysAccount.setAccount(null);
        sysAccount.setPassword(null);
        sysAccount.setStopState(null);

        sysAccountManageDao.updateById(sysAccount);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void resetAccountAndPassword(ResetSysAccountPwdAndAccountVO resetSysAccountPwdAndAccountVO){
        SysAccount sysAccount = getSysAccount(resetSysAccountPwdAndAccountVO.getAccountId());
        sysAccount.setAccount(resetSysAccountPwdAndAccountVO.getAccount());
        sysAccount.setPassword(resetSysAccountPwdAndAccountVO.getNewPassword());
        encodePassword(sysAccount);

        sysAccountManageDao.updateById(sysAccount);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void resetPassword(ResetSysAccountPwdVO resetSysAccountPwdVO) {
        SysAccount sysAccount = getSysAccount(resetSysAccountPwdVO.getAccountId());
        sysAccount.setPassword(resetSysAccountPwdVO.getNewPassword());
        encodePassword(sysAccount);

        sysAccountManageDao.updateById(sysAccount);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addSysAccountAdmin(SysAccount sysAccount){
        encodePassword(sysAccount);
        sysAccount.setAccountType(SysAccountTypeEnum.MERCHANT_ADMIN);
        sysAccountManageDao.insert(sysAccount);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateSysAccountAdmin(SysAccount sysAccount) {
        encodePassword(sysAccount);
        sysAccount.setAccountType(SysAccountTypeEnum.MERCHANT_ADMIN);
        sysAccountManageDao.updateById(sysAccount);
    }

    @Override
    public SysAccount getSysAccount(String id) {
        SysAccount sysAccount = sysAccountManageDao.selectById(id);
        if(sysAccount == null){
            throw new ServiceException("not_fund_data");
        }

        if(sysAccount.getStopState() == YesNoEnum.YES){
            throw new ServiceException("account_stoped_tips");
        }

        return sysAccount;
    }

    @Override
    public SysAccount getSysAccountByAccount(String account) {
        SysAccount sysAccount = sysAccountManageDao.getSysAccountByAccount(account);
        if(sysAccount == null){
            throw new ServiceException("login_user_not_fund");
        }

        if(sysAccount.getStopState() == YesNoEnum.YES){
            throw new ServiceException("account_stoped_tips");
        }
        return sysAccount;
    }

    @Override
    public SysAccount getSysAccountAdmin(String merchantId) {
        SysAccount sysAccount =  sysAccountManageDao.getSysAccount(merchantId);
        if(sysAccount == null){
            throw new ServiceException("not_fund_data");
        }

        if(sysAccount.getStopState() == YesNoEnum.YES){
            throw new ServiceException("account_stoped_tips");
        }
        return sysAccount;
    }

    @Override
    public IPage<SysAccount> pageSysAccounts(SysAccountSearch search) {
        return sysAccountManageDao.pageSysAccounts(search,search);
    }

    @Override
    public IPage<SysAccount> pagePlatformSysAccounts(PlatformSysAccountSearch search) {
        return sysAccountManageDao.pagePlatformSysAccounts(search,search);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void disableSysAccount(String id) {
        SysAccount sysAccount = sysAccountManageDao.selectById(id);
        sysAccount.setStopState(YesNoEnum.YES);
        sysAccountManageDao.updateById(sysAccount);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void enableSysAccount(String id) {
        SysAccount sysAccount = sysAccountManageDao.selectById(id);
        sysAccount.setStopState(YesNoEnum.NO);
        sysAccountManageDao.updateById(sysAccount);
    }

    @Override
    public int getAccountCount(String roleId) {
        return sysAccountManageDao.getAccountCount(roleId);
    }

    /**
     * 密码加密
     * @param sysAccount
     */
    private void encodePassword(SysAccount sysAccount){
        String encodedPassword =  PasswordEncodeTool.encodePassword(sysAccount.getPassword());
        sysAccount.setPassword(encodedPassword);
    }
}
