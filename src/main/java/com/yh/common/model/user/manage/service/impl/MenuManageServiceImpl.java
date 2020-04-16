package com.yh.common.model.user.manage.service.impl;

import com.yh.common.model.user.entity.Menu;
import com.yh.common.model.user.entity.SysAccount;
import com.yh.common.model.user.entity.enums.SysAccountTypeEnum;
import com.yh.common.model.user.manage.dao.MenuManageDao;
import com.yh.common.model.user.manage.service.IMenuManageService;
import com.yh.common.model.user.manage.service.ISysAccountManageService;
import com.yh.common.model.user.manage.vo.MenuNodeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alan Chen
 * @description 功能菜单
 * @date 2020-01-09
 */
@Service
public class MenuManageServiceImpl implements IMenuManageService {

    @Autowired
    MenuManageDao menuDao;

    @Autowired
    ISysAccountManageService sysAccountManageServiceImpl;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addMenu(Menu menu) {
        menuDao.insert(menu);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateMenu(Menu menu) {
        menuDao.updateById(menu);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteMenu(String id) {
        menuDao.deleteChildMenus(id);
        menuDao.deleteById(id);
    }

    @Override
    public List<MenuNodeVO> getMenuTree(String accountId) {

        SysAccount sysAccount = sysAccountManageServiceImpl.getSysAccount(accountId);

        List<MenuNodeVO> allMenu = new ArrayList<>();

        if(SysAccountTypeEnum.IT == sysAccount.getAccountType()){
            List<MenuNodeVO> firstLevelMenu = menuDao.getFirstLevelMenusForIt();
            for (MenuNodeVO menuVO : firstLevelMenu) {
                menuVO.setChildrens(menuDao.getSecondMenusForIt(menuVO.getId()));
                allMenu.add(menuVO);
            }
        }else{
            List<MenuNodeVO> firstLevelMenu = menuDao.getFirstLevelMenus();
            for (MenuNodeVO menuVO : firstLevelMenu) {
                menuVO.setChildrens(menuDao.getSecondMenus(menuVO.getId()));
                allMenu.add(menuVO);
            }
        }

        return allMenu;
    }
}
