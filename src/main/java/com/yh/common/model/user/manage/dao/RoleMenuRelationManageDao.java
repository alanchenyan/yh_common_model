package com.yh.common.model.user.manage.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yh.common.model.user.entity.RoleMenuRelation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author Alan Chen
 * @description 角色-菜单关联表
 * @date 2020-01-02
 */
@Mapper
@Repository
public interface RoleMenuRelationManageDao extends BaseMapper<RoleMenuRelation> {

    /**
     * 物理删除角色-菜单
     * @param roleId
     */
    void deleteRoleMenuRelation(@Param("roleId") String roleId);

}
