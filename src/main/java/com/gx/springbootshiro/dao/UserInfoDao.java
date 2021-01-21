package com.gx.springbootshiro.dao;

import com.gx.springbootshiro.domain.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author guoxing
 * @version V1.0
 * @Package com.gx.springbootshiro.dao
 * @date 2021/1/20 14:29
 */

@Repository
@Mapper
public interface UserInfoDao {

    /**
     * 根据username 查询用户和角色
     * @param username
     * @return
     */
    public UserInfo findUserAndRolesByUserName(String username);


    /**
     * 根据username 查询用户和角色，以及角色拥有的权限
     * @param username
     * @return
     */
    public UserInfo findUserWithRoleListByUsername(String username);
}
