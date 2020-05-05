package com.pipichao.helloword.controller;

import com.pipichao.helloword.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @Autowired
    private User user;


    @RequestMapping("hello")
    @ResponseBody
    public String hello(){
        System.out.println(user);
        return "hello world";
    }
}
