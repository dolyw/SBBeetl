package com.wang926454.controller;

import com.wang926454.dao.UserDao;
import com.wang926454.model.User;
import com.wang926454.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Desc
 * @Author wang926454
 * @Date 2018/5/30 17:46
 */
@Controller
public class UserController {

    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String index(Model model) {
        List<User> userList = userService.selectAll();
        model.addAttribute("userList", userList);
        return "index.html";
    }
}
