package com.jd.popc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 登录控制器
 *
 * @author yangsong on 2018/12/9.
 */
@Controller
@Slf4j
public class LoginController {

    @RequestMapping("/")
    public String index() {
        return "forward:/index.html";
    }

    @RequestMapping("/index")
    public String indexHome() {
        return "forward:/static/index.html";
    }

    @RequestMapping("/user/login")
    public String login(HttpServletRequest request) {
        return "forward:/index.html";
    }

    @RequestMapping("/user/logout")
    public String logout(HttpServletRequest request) {
        return "forward:/index.html";
    }
}
