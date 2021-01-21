package com.gx.springbootshiro.controller;

import com.gx.springbootshiro.service.IUserInfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author guoxing
 * @version V1.0
 * @Package com.gx.springbootshiro.controller
 * @date 2021/1/20 16:13
 */
@Controller
@RequestMapping("userinfo")
public class UserInfoController {

    @Autowired
    IUserInfoService userInfoService ;

    @RequestMapping("/user")
    @ResponseBody
    public String findUserByUsername(){

        return userInfoService.findUserWithRoleListByUsername("admin").toString();
    }


    /**
     * 用户查询.
     * @return
     */
    @RequestMapping("/userList")
    @RequiresPermissions("userInfo:view")//权限管理;
    public String userInfo(){
        return "userInfo";
    }

    /**
     * 用户添加;
     * @return
     */
    @RequestMapping("/userAdd")
    @RequiresPermissions("userInfo:add")//权限管理;
    public String userInfoAdd(){
        return "userInfoAdd";
    }
    /**
     * 用户删除;
     * @return
     */
    @RequestMapping("/userDel")
    @RequiresPermissions("userInfo:del")//权限管理;
    public String userDel(){
        return "userInfoDel";
    }
}
