package com.yh.common.model.user.common.authority;

import com.smm.framework.authority.GlobalUserDetailsServiceImpl;
import com.yh.common.model.user.app.service.IUserService;
import com.yh.common.model.user.entity.enums.SysAccountTypeEnum;
import com.yh.common.model.user.entity.SysAccount;
import com.yh.common.model.user.manage.service.ISysAccountManageService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Alan Chen
 * @description Spring security 获取校验用户对象
 * @date 2019-10-12
 */
@Service
public class UserDetailServiceImpl extends GlobalUserDetailsServiceImpl {

    @Autowired
    ISysAccountManageService sysAccountManageServiceImpl;


    @Autowired
    IUserService userServiceImpl;

    final List EMPTY_LIST = new ArrayList<>();

    final static String MANAGE = "MANAGE";

    final static String APP = "APP";

    @Override
    public UserDetails loadUserByUsername(String userName)  {

        String clientType = request.getHeader("Client-Type");
        if(StringUtils.isNotBlank(clientType)){

            clientType = clientType.toUpperCase();

            if(APP.equals(clientType)){
                return dealAppLogin(userName);
            }else if(MANAGE.equals(clientType)){
                return dealManageLogin(userName);
            }
        }

        return dealManageLogin(userName);
    }

    /**
     * 后台管理系统登录
     * @param userName
     * @return
     */
    private UserDetails dealManageLogin(String userName){
        SysAccount sysAccount = sysAccountManageServiceImpl.getSysAccountByAccount(userName);
        //如果是商户的账号，则要判断该商户是否被停用了
        if(sysAccount.getAccountType() == SysAccountTypeEnum.MERCHANT_ADMIN
                || sysAccount.getAccountType() == SysAccountTypeEnum.MERCHANT_ORDINARY_USER){
            
            
        }

        return new User(userName, sysAccount.getPassword(), EMPTY_LIST);
    }

    /**
     * App登录
     * @param userName
     * @return
     */
    private UserDetails dealAppLogin(String userName){
        com.yh.common.model.user.entity.User user = userServiceImpl.getUserByPhone(userName);
        return new User(userName, user.getPassword(), EMPTY_LIST);
    }
}