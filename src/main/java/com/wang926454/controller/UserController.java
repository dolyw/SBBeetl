package com.wang926454.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Desc
 * @Author wang926454
 * @Date 2018/5/30 17:46
 */
@Controller
public class UserController {

    @RequestMapping("/helloWorld")
    public String hello(Model model){
        model.addAttribute("message", "HelloWorld");
        return "index.btl";
    }
}
