package com.gx.springbootshiro.service;

import com.gx.springbootshiro.domain.UserInfo;

/**
 * @author guoxing
 * @version V1.0
 * @Package com.gx.springbootshiro.service.impl
 * @date 2021/1/20 14:32
 */

public interface IUserInfoService {

    /**
     * 根据username 查询用户和角色
     * @param username
     * @return
     */
    public UserInfo findUserAndRolesByUserName(String username);

    /**
     * 根据username 查询用户和角色、权限
     * @param username
     * @return
     */
    public UserInfo findUserWithRoleListByUsername(String username);
}
