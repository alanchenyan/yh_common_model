package com.yh.common.model.user.manage.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yh.common.model.user.entity.Menu;
import com.yh.common.model.user.manage.vo.MenuNodeVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Alan Chen
 * @description 功能菜单
 * @date 2020-01-02
 */
@Mapper
@Repository
public interface MenuManageDao extends BaseMapper<Menu> {

    /**
     * 获取一级菜单
     * @return
     */
    List<MenuNodeVO> getFirstLevelMenus();

    /**
     * IT用户获得所有一级菜单
     * @return
     */
    List<MenuNodeVO> getFirstLevelMenusForIt();

    /**
     * 获取二级菜单
     * @param parentId
     * @return
     */
    List<MenuNodeVO> getSecondMenus(String parentId);

    /**
     * IT用户获得所有二级菜单
     * @param parentId
     * @return
     */
    List<MenuNodeVO> getSecondMenusForIt(@Param("parentId") String parentId);

    /**
     * 删除当前菜单时，同步删除子菜单
     * @param parentId
     */
    void deleteChildMenus(@Param("parentId") String parentId);
}
