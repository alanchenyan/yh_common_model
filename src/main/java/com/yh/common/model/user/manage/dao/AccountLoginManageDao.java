package com.yh.common.model.user.manage.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yh.common.model.user.manage.vo.AccountRoleMenusVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Alan Chen
 * @description
 * @date 2020-01-10
 */
@Repository
@Mapper
public interface AccountLoginManageDao extends BaseMapper {

    /**
     * 通过用户角色获取所属的菜单
     * @param roleId
     * @return
     */
    List<AccountRoleMenusVO> getMenusByAccountRole(@Param("roleId") String roleId);

    /**
     * 通过父级ID获取菜单
     * @param parentIds
     * @return
     */
    List<AccountRoleMenusVO> getMenusByParentIds(@Param("parentIds") List<String> parentIds);

    /**
     * IT获取所有菜单
     * @return
     */
    List<AccountRoleMenusVO> getAllMenusForIt();

    /**
     * 获取商户管理员菜单
     * @return
     */
    List<AccountRoleMenusVO> getMenusForMerchantAdmin();
}
