package com.yh.common.model.user.manage.service;


import com.yh.common.model.user.entity.Menu;
import com.yh.common.model.user.manage.vo.MenuNodeVO;

import java.util.List;

/**
 * @author Alan Chen
 * @description 功能菜单
 * @date 2020-01-09
 */
public interface IMenuManageService {

    /**
     * 新增菜单
     * @param menu
     */
    void addMenu(Menu menu);

    /**
     * 修改菜单
     * @param menu
     */
    void updateMenu(Menu menu);

    /**
     * 删除菜单
     * @param id
     */
    void deleteMenu(String id);

    /**
     * 菜单树
     * @param accountId
     * @return
     */
    List<MenuNodeVO> getMenuTree(String accountId);
}
