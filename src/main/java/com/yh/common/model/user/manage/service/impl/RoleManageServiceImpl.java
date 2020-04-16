package com.yh.common.model.user.manage.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.smm.framework.exception.ServiceException;
import com.yh.common.model.user.common.vo.SelectOption;
import com.yh.common.model.user.entity.Role;
import com.yh.common.model.user.entity.RoleMenuRelation;
import com.yh.common.model.user.entity.enums.YesNoEnum;
import com.yh.common.model.user.manage.dao.RoleManageDao;
import com.yh.common.model.user.manage.search.PlatformRoleSearch;
import com.yh.common.model.user.manage.search.RoleSearch;
import com.yh.common.model.user.manage.service.IRoleManageService;
import com.yh.common.model.user.manage.service.IRoleMenuRelationManageService;
import com.yh.common.model.user.manage.service.ISysAccountManageService;
import com.yh.common.model.user.manage.vo.PlatformRoleAddVO;
import com.yh.common.model.user.manage.vo.PlatformRoleUpdateVO;
import com.yh.common.model.user.manage.vo.RoleAddVO;
import com.yh.common.model.user.manage.vo.RoleUpdateVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Alan Chen
 * @description 角色
 * @date 2020-01-09
 */
@Service
public class RoleManageServiceImpl implements IRoleManageService {

    @Autowired
    RoleManageDao roleDao;

    @Autowired
    IRoleMenuRelationManageService roleMenuRelationServiceImpl;

    @Autowired
    ISysAccountManageService sysAccountManageServiceImpl;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addRole(RoleAddVO roleAddVO) {

        if(StringUtils.isBlank(roleAddVO.getMerchantId())){
            throw new ServiceException("商户ID不能为空");
        }

        Role role = new Role();

        role.setPlatformState(YesNoEnum.NO);
        role.setMerchantId(roleAddVO.getMerchantId());
        role.setRoleName(roleAddVO.getRoleName());
        roleDao.insert(role);

        saveRoleMenuRelation(role.getId(),roleAddVO.getMenuIdList());
    }

    @Override
    public void addPlatformRole(PlatformRoleAddVO roleAddVO) {
        Role role = new Role();

        role.setPlatformState(YesNoEnum.YES);
        role.setRoleName(roleAddVO.getRoleName());
        roleDao.insert(role);

        saveRoleMenuRelation(role.getId(),roleAddVO.getMenuIdList());
    }

    /**
     * 获取需要修改的角色信息
     * @param roleId
     * @return
     */
    @Override
    public RoleUpdateVO getRoleForUpdate(String roleId){
        RoleUpdateVO updateVO = new RoleUpdateVO();
        Role role =  getRole(roleId);

        updateVO.setId(roleId);
        updateVO.setRoleName(role.getRoleName());
        updateVO.setMerchantId(role.getMerchantId());

        List<String> menuIds =roleDao.getMenuIdsByRole(roleId);
        updateVO.setMenuIdList(menuIds);

        return updateVO;
    }

    @Override
    public PlatformRoleUpdateVO getPlatformRoleForUpdate(String roleId) {
        PlatformRoleUpdateVO updateVO = new PlatformRoleUpdateVO();
        Role role =  getRole(roleId);

        updateVO.setId(roleId);
        updateVO.setRoleName(role.getRoleName());

        List<String> menuIds =roleDao.getMenuIdsByRole(roleId);
        updateVO.setMenuIdList(menuIds);

        return updateVO;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateRole(RoleUpdateVO roleUpdateVO) {
        Role role =  getRole(roleUpdateVO.getId());
        role.setRoleName(roleUpdateVO.getRoleName());
        roleDao.updateById(role);

        // 清空关系 全部重新设置过
        roleMenuRelationServiceImpl.deleteRoleMenuRelation(roleUpdateVO.getId());
        saveRoleMenuRelation(role.getId(),roleUpdateVO.getMenuIdList());
    }

    @Override
    public void updatePlatformRole(PlatformRoleUpdateVO roleUpdateVO) {
        Role role =  getRole(roleUpdateVO.getId());
        role.setRoleName(roleUpdateVO.getRoleName());
        roleDao.updateById(role);

        // 清空关系 全部重新设置过
        roleMenuRelationServiceImpl.deleteRoleMenuRelation(roleUpdateVO.getId());
        saveRoleMenuRelation(role.getId(),roleUpdateVO.getMenuIdList());
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteRole(String id) {
        int accountCount = sysAccountManageServiceImpl.getAccountCount(id);
        if(accountCount>0){
            throw new ServiceException("delete_role_has_account_tips");
        }
        roleDao.deleteById(id);
    }

    @Override
    public IPage<Role> pageRoles(RoleSearch search) {
        return roleDao.pageRoles(search,search);
    }

    @Override
    public IPage<Role> pagePlatformRoles(PlatformRoleSearch search) {
        return roleDao.pagePlatformRoles(search,search);
    }

    @Override
    public Role getRole(String id){
        Role role = roleDao.selectById(id);
        if(role == null){
            throw new ServiceException("not_fund_data");
        }
        return role;
    }

    @Override
    public List<SelectOption> getRoleOptions(String merchantId) {
        return roleDao.getRoleOptions(merchantId);
    }

    @Override
    public List<SelectOption> getPlatformRoleOptions() {
        return roleDao.getPlatformRoleOptions();
    }

    private void saveRoleMenuRelation(String roleId,List<String> menuIdList){
        for(String menuId : menuIdList){
            RoleMenuRelation roleMenuRelation = new RoleMenuRelation();
            roleMenuRelation.setRoleId(roleId);
            roleMenuRelation.setMenuId(menuId);

            roleMenuRelationServiceImpl.addRoleMenuRelation(roleMenuRelation);
        }
    }

}
