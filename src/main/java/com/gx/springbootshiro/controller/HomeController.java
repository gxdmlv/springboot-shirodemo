package com.gx.springbootshiro.controller;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sun.security.pkcs11.Secmod;

import javax.servlet.http.HttpServletRequest;

/**
 * @author guoxing
 * @version V1.0
 * @Package com.gx.springbootshiro.controller
 * @date 2021/1/20 10:58
 */
@Controller
public class HomeController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/index")
    public String home(){

        return "/index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "/login";
    }


    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(HttpServletRequest request, Model model){

        logger.info("login......");
        // 登录失败从request中获取shiro处理的异常信息
        // shiroLoginFailure:就是shiro异常类的全类名
        String exception = (String) request.getAttribute("shiroLoginFailure");

        String msg = "";

        if (exception != null) {
            if (UnknownAccountException.class.getName().equals(exception)) {
                logger.error("UnknownAccountException -->帐号不存在：");
                msg = "UnknownAccountException -->帐号不存在：";
            } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
                logger.error("IncorrectCredentialsException -- > 密码不正确：");
                msg = "IncorrectCredentialsException -- > 密码不正确：";
            } else if ("kaptchaValidateFailed".equals(exception)) {
                logger.error("kaptchaValidateFailed -- > 验证码错误");
                msg = "kaptchaValidateFailed -- > 验证码错误";
            } else {
                msg = "else >> " + exception;
                logger.error("else -- >" + exception);
            }
        }
        model.addAttribute("msg", msg);
        // 此方法不处理登录成功,由shiro进行处理.
        return "/login";
    }
}
