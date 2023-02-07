package com.greedy.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
public class LoginController {

    //로그인
    @GetMapping("/login")
    public ModelAndView login(ModelAndView mv){

        mv.setViewName("/login/login");

        return mv;
    }

    //아이디 찾기
    @GetMapping("/findid")
    public ModelAndView findid(ModelAndView mv){

        mv.setViewName("/login/findid");

        return mv;
    }

    //비밀번호 찾기
    @GetMapping("/findpw")
    public ModelAndView findpw(ModelAndView mv){

        mv.setViewName("/login/findpw");

        return mv;
    }

    //회원가입
    @GetMapping("/join")
    public ModelAndView join(ModelAndView mv){

        mv.setViewName("/login/join");

        return mv;
    }

    //회원가입
    @GetMapping("/join2")
    public ModelAndView join2(ModelAndView mv) {

        mv.setViewName("/login/join2");

        return mv;
    }

    @GetMapping("/join3")
    public ModelAndView join3(ModelAndView mv) {

        mv.setViewName("/login/join3");

        return mv;
    }

    @GetMapping("/findpwd2")
    public ModelAndView findpwd2(ModelAndView mv) {

        mv.setViewName("/login/findpwd2");

        return mv;
    }

    @GetMapping("/findpwd3")
    public ModelAndView findpwd3(ModelAndView mv) {

        mv.setViewName("/login/findpwd3");

        return mv;
    }
}