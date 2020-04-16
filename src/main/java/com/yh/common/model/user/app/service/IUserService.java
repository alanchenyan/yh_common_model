package com.yh.common.model.user.app.service;


import com.yh.common.model.user.app.vo.ResetPasswordVO;
import com.yh.common.model.user.app.vo.UserRegistVO;
import com.yh.common.model.user.entity.User;

/**
 * @author Alan Chen
 * @description
 * @date 2020-01-02
 */
public interface IUserService {

    /**
     * App用户注册
     * @param userRegistVO
     * @return
     */
    User userRegist(UserRegistVO userRegistVO);

    /**
     * 重置密码
     * @param resetPasswordVO
     * @return
     */
    User resetPassword(ResetPasswordVO resetPasswordVO);

    /**
     * 获取用户信息
     * @param id
     * @return
     */
    User getUser(String id);

    /**
     * 获取用户信息
     * @param phone
     * @return
     */
    User getUserByPhone(String phone);

    /**
     * 修改用户信息
     * @param user
     */
    void updateUser(User user);

}
