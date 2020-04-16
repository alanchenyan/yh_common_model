package com.yh.common.model.user.manage.service.impl;

import com.smm.framework.exception.ServiceException;
import com.yh.common.model.user.entity.SysAccount;
import com.yh.common.model.user.entity.enums.SysAccountTypeEnum;
import com.yh.common.model.user.manage.dao.AccountLoginManageDao;
import com.yh.common.model.user.manage.service.IAccountLoginManageService;
import com.yh.common.model.user.manage.service.ISysAccountManageService;
import com.yh.common.model.user.manage.vo.AccountLoginResponseVO;
import com.yh.common.model.user.manage.vo.AccountRoleMenusVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alan Chen
 * @description 账号登录
 * @date 2020-01-10
 */
@Service
public class AccountLoginManageServiceImpl implements IAccountLoginManageService {

    @Autowired
    AccountLoginManageDao accountLoginDao;

    @Autowired
    ISysAccountManageService sysAccountManageServiceImpl;

   

    @Override
    public AccountLoginResponseVO getLoginResponseData(String account) {

        AccountLoginResponseVO responseVO = new AccountLoginResponseVO();

        SysAccount sysAccount = sysAccountManageServiceImpl.getSysAccountByAccount(account);

        responseVO.setAccountId(sysAccount.getId());
        responseVO.setAccount(sysAccount.getAccount());
        responseVO.setAccountType(sysAccount.getAccountType());


        if(SysAccountTypeEnum.IT == sysAccount.getAccountType()){
            List<AccountRoleMenusVO> itAllMeus = accountLoginDao.getAllMenusForIt();
            List<String> itAllMenusUrl = new ArrayList<>();
            for(AccountRoleMenusVO menusVO : itAllMeus){
                itAllMenusUrl.add(menusVO.getMenuUrl());
            }
            responseVO.setMenus(itAllMenusUrl);
            return responseVO;
        }else if(SysAccountTypeEnum.MERCHANT_ADMIN == sysAccount.getAccountType()){
            List<AccountRoleMenusVO> merchantAdminMeus = accountLoginDao.getMenusForMerchantAdmin();
            List<String> merchantAdminMenusUrl = new ArrayList<>();
            for(AccountRoleMenusVO menusVO : merchantAdminMeus){
                merchantAdminMenusUrl.add(menusVO.getMenuUrl());
            }
            responseVO.setMenus(merchantAdminMenusUrl);
            return responseVO;
        }

        List<AccountRoleMenusVO> roleMenus = accountLoginDao.getMenusByAccountRole(sysAccount.getRoleId());

        List<String> allMenusUrl = new ArrayList<>();
        List<String> parentIds = new ArrayList<>();

        for(AccountRoleMenusVO roleMenusVO : roleMenus){
            allMenusUrl.add(roleMenusVO.getMenuUrl());
            parentIds.add(roleMenusVO.getParentId());
        }

        if(parentIds.size()>0){
            List<AccountRoleMenusVO> parentsMenus = accountLoginDao.getMenusByParentIds(parentIds);
            List<String> parentMenusUrl = new ArrayList<>();
            for(AccountRoleMenusVO roleMenusVO : parentsMenus){
                parentMenusUrl.add(roleMenusVO.getMenuUrl());
            }

            allMenusUrl.addAll(parentMenusUrl);
        }

        if(allMenusUrl.size()==0){
            throw new ServiceException("account_no_menu_auth");
        }

        responseVO.setMenus(allMenusUrl);

        return responseVO;
    }
}
