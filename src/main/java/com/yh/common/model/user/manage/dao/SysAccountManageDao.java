package com.yh.common.model.user.manage.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yh.common.model.user.entity.SysAccount;
import com.yh.common.model.user.entity.enums.SysAccountTypeEnum;
import com.yh.common.model.user.manage.search.PlatformSysAccountSearch;
import com.yh.common.model.user.manage.search.SysAccountSearch;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author Alan Chen
 * @description
 * @date 2020-01-02
 */
@Mapper
@Repository
public interface SysAccountManageDao extends BaseMapper<SysAccount> {

    /**
     * 查询用户列表
     * @param page 分页查询参数
     * @param search 查询参数
     * @return
     */
    IPage<SysAccount> pageSysAccounts(Page page, @Param("search") SysAccountSearch search);

    /**
     * 查询平台用户列表
     * @param page 分页查询参数
     * @param search 查询参数
     * @return
     */
    IPage<SysAccount> pagePlatformSysAccounts(Page page, @Param("search") PlatformSysAccountSearch search);

    /**
     * 获取商户管理员
     * @param merchantId 商户ID
     * @return 商户管理员
     */
    default SysAccount getSysAccount(String merchantId){
        QueryWrapper<SysAccount> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("merchant_id",merchantId).eq("account_type", SysAccountTypeEnum.MERCHANT_ADMIN.getCode());
        return selectOne(queryWrapper);
    }

    /**
     * 通过登录名获取账号（登录获取token时用）
     * @param account
     * @return
     */
    default SysAccount getSysAccountByAccount(String account){
        QueryWrapper<SysAccount> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("account",account);
        return selectOne(queryWrapper);
    }

    /**
     * 获取账号数量(删除角色前要先判断该角色下是否有账号)
     * @param roleId
     * @return
     */
    default int getAccountCount(String roleId){
        QueryWrapper<SysAccount> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("role_id",roleId);
        return selectCount(queryWrapper);
    }
}
