package com.sj.controll;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


@RestController
@RequestMapping("/login")
public class helloword {
    @RequestMapping("/helloWorld")
    public String hello(HttpSession session){
        session.setAttribute("user",session.getId());
        return "成功";
    }
}


