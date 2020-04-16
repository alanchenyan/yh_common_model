package com.yh.common.model.user.app.service.impl;

import com.smm.framework.exception.ServiceException;
import com.yh.common.model.user.app.dao.UserDao;
import com.yh.common.model.user.app.service.ISmsCodeRecordService;
import com.yh.common.model.user.app.service.IUserService;
import com.yh.common.model.user.app.vo.ResetPasswordVO;
import com.yh.common.model.user.app.vo.UserRegistVO;
import com.yh.common.model.user.entity.User;
import com.yh.common.model.user.entity.enums.SmsTypeEnum;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;

/**
 * @author Alan Chen
 * @description
 * @date 2020-01-02
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserDao userDao;

    @Autowired
    ISmsCodeRecordService smsCodeRecordServiceImpl;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public User userRegist(@Valid UserRegistVO userRegistVO) {

        User dbUser = userDao.getUser(userRegistVO.getAreaCode(),userRegistVO.getPhone());
        if(dbUser !=null ){
            throw new ServiceException("phone_had_registed");
        }

        boolean smsCodeVerify =  smsCodeRecordServiceImpl.verifySmsCode(userRegistVO.getVerificationCode(),userRegistVO.getAreaCode(),userRegistVO.getPhone(), SmsTypeEnum.USER_REGISTRATION);

        if(smsCodeVerify == true){
            User user = new User();
            user.setAreaCode(userRegistVO.getAreaCode());
            user.setPhone(userRegistVO.getPhone());
            user.setNickName("nickName");
            user.setRegistSource(userRegistVO.getRegistSource());

            if(StringUtils.isNotBlank(userRegistVO.getPassword())){
                BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
                String encodedPassword = passwordEncoder.encode(userRegistVO.getPassword());
                user.setPassword(encodedPassword);
            }
            userDao.insert(user);
            return user;
        }
        return null;
    }

    @Override
    public User resetPassword(ResetPasswordVO resetPasswordVO) {
        User user = userDao.getUser(resetPasswordVO.getAreaCode(), resetPasswordVO.getPhone());
        if(user ==null ){
            throw new ServiceException("phone_has_not_been_registered");
        }
        boolean smsCodeVerify =  smsCodeRecordServiceImpl.verifySmsCode(resetPasswordVO.getVerificationCode(),resetPasswordVO.getAreaCode(), resetPasswordVO.getPhone(), SmsTypeEnum.USER_RESET_PWD);
        if(smsCodeVerify == true){
            if(StringUtils.isNotBlank(resetPasswordVO.getPassword())){
                BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
                String encodedPassword = passwordEncoder.encode(resetPasswordVO.getPassword());
                user.setPassword(encodedPassword);
                userDao.updateById(user);
            }
        }
        return user;
    }

    @Override
    public User getUser(String id) {
        User user = userDao.selectById(id);
        if(user == null){
            throw new ServiceException("not_fund_data");
        }
        return user;
    }

    @Override
    public User getUserByPhone(String phone) {
        User user = userDao.getUserByPhone(phone);
        if(user == null){
            throw new ServiceException("user_does_not_exist");
        }
        return user;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateUser(User user) {
        //设置为null表示不进行修改
        user.setPhone(null);
        user.setAreaCode(null);
        user.setPassword(null);
        user.setMemberGradeId(null);
        user.setIntegral(null);
        user.setRegistSource(null);

        userDao.updateById(user);
    }

}
