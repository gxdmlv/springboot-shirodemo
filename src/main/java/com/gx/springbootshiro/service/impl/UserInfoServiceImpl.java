package com.gx.springbootshiro.service.impl;

import com.gx.springbootshiro.dao.UserInfoDao;
import com.gx.springbootshiro.domain.UserInfo;
import com.gx.springbootshiro.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author guoxing
 * @version V1.0
 * @Package com.gx.springbootshiro.service.impl
 * @date 2021/1/20 14:33
 */
@Service
public class UserInfoServiceImpl implements IUserInfoService {


    @Autowired
    UserInfoDao userInfoDao;
    @Override
    public UserInfo findUserAndRolesByUserName(String username) {



        return userInfoDao.findUserAndRolesByUserName(username);
    }

    @Override
    public UserInfo findUserWithRoleListByUsername(String username) {
        return userInfoDao.findUserWithRoleListByUsername(username);

    }
}
