package com.gx.springbootshiro.commen.config;

import com.gx.springbootshiro.domain.SysPermission;
import com.gx.springbootshiro.domain.SysRole;
import com.gx.springbootshiro.domain.UserInfo;
import com.gx.springbootshiro.service.IUserInfoService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

/**
 * @author guoxing
 * @version V1.0
 * @Package com.gx.springbootshiro.commen.config
 * @date 2021/1/20 19:52
 *
 *
 *
 */

/**
 * Shiro授权和验证
 */
public class ShiroRealm extends AuthorizingRealm {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    IUserInfoService userInfoService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        logger.info("权限认证doGetAuthorizationInfo()");

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        UserInfo userInfo = (UserInfo) principalCollection.getPrimaryPrincipal();

        for(SysRole role:userInfo.getRoleList()){

            authorizationInfo.addRole(role.getRole());
            logger.info(role.getPermissions().toString());

            for(SysPermission p:role.getPermissions()){
                authorizationInfo.addStringPermission(p.getPermission());
            }
        }


        return null;
    }


    /**
     * 认证信息(身份验证) Authentication 是用来验证用户身份
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        logger.info("登陆认证doGetAuthenticationInfo()");
        // 获取用户的输入帐号
        String username = (String) authenticationToken.getPrincipal();

        UserInfo user = userInfoService.findUserWithRoleListByUsername(username);

        if (user == null) {
            return null;
        }

        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user,
                user.getPassword(),
                ByteSource.Util.bytes(user.getCredentialsSalt()),
                getName());

        return simpleAuthenticationInfo;
    }



}
